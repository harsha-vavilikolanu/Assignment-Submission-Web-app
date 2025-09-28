package com.example.struts;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class AssignmentAction extends ActionSupport {

    private String studentName;
    private String studentId;
    private String courseName;
    private String assignmentTitle;
    private String content;

    // Getters and Setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getAssignmentTitle() { return assignmentTitle; }
    public void setAssignmentTitle(String assignmentTitle) { this.assignmentTitle = assignmentTitle; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String execute() {
        // Validation
        if (studentName == null || studentName.isEmpty() ||
            studentId == null || studentId.isEmpty() ||
            courseName == null || courseName.isEmpty() ||
            assignmentTitle == null || assignmentTitle.isEmpty() ||
            content == null || content.isEmpty()) {

            addActionError("All fields are required.");
            return ERROR;
        }

        if (!studentId.matches("S\\d+")) {
            addActionError("Student ID must follow the format S12345.");
            return ERROR;
        }

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // --- plagiarism check ---
            List<Assignment> assignments = session.createQuery("from Assignment", Assignment.class).list();
            for (Assignment existing : assignments) {
                double score = calculateSimilarity(content, existing.getContent());
                if (score >= 0.75) {
                    addActionError("Plagiarism detected: " + (int)(score * 100) + "% match with existing work.");
                    return ERROR;
                }
            }

            // No plagiarism -> Save new assignment
            tx = session.beginTransaction();

            Assignment assignment = new Assignment();
            assignment.setStudentName(studentName);
            assignment.setStudentId(studentId);
            assignment.setCourseName(courseName);
            assignment.setAssignmentTitle(assignmentTitle);
            assignment.setContent(content);

            session.save(assignment);

            tx.commit();
            return SUCCESS;

        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            addActionError("Database error: " + e.getMessage());
            return ERROR;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

   
    private double calculateSimilarity(String text1, String text2) {
        Set<String> words1 = new HashSet<>(Arrays.asList(text1.toLowerCase().split("\\s+")));
        Set<String> words2 = new HashSet<>(Arrays.asList(text2.toLowerCase().split("\\s+")));

        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);

        Set<String> union = new HashSet<>(words1);
        union.addAll(words2);

        if (union.isEmpty()) return 0.0;
        return (double) intersection.size() / union.size();
    }
}

