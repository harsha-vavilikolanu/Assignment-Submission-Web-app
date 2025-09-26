package com.assignment;


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
        if(studentName.isEmpty() || studentId.isEmpty() || courseName.isEmpty() 
            || assignmentTitle.isEmpty() || content.length() < 300) {
            addActionError("All fields are required and content must be at least 300 words.");
            return ERROR;
        }

        if(!studentId.matches("S\\d+")) {
            addActionError("Student ID must follow the format S12345.");
            return ERROR;
        }

        // Save to DB
        Assignment assignment = new Assignment();
        assignment.setStudentName(studentName);
        assignment.setStudentId(studentId);
        assignment.setCourseName(courseName);
        assignment.setAssignmentTitle(assignmentTitle);
        assignment.setContent(content);

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(assignment);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            addActionError("Database error: " + e.getMessage());
            return ERROR;
        }

        return SUCCESS;
    }
}

