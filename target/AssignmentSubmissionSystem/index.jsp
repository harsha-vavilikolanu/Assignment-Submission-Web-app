<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Assignment Submission</title></head>
<body>
<s:form action="submitAssignment" method="post">
    <s:textfield name="studentName" label="Student Name"/>
    <s:textfield name="studentId" label="Student ID"/>
    <s:textfield name="courseName" label="Course Name"/>
    <s:textfield name="assignmentTitle" label="Assignment Title"/>
    <s:textarea name="content" label="Assignment Content" cols="50" rows="10"/>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
