package com.example.struts;

import jakarta.persistence.*;

@Entity
@Table(name="assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String studentName;

    @Column(nullable=false, unique=true)
    private String studentId;

    @Column(nullable=false)
    private String courseName;

    @Column(nullable=false)
    private String assignmentTitle;

    @Column(length=5000, nullable=false)
    private String content;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
}
