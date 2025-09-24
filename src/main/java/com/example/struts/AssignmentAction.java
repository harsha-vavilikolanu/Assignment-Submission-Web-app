package com.example.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            content == null ) {
            
            addActionError("All fields are required and content");
            return ERROR;
        }

        if (!studentId.matches("S\\d+")) {
            addActionError("Student ID must follow the format S12345.");
            return ERROR;
        }

        // Create entity object
        Assignment assignment = new Assignment();
        assignment.setStudentName(studentName);
        assignment.setStudentId(studentId);
        assignment.setCourseName(courseName);
        assignment.setAssignmentTitle(assignmentTitle);
        assignment.setContent(content);

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

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
}
