<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Assignment Submission</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: url('im1.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }

        header {
            background: rgba(0, 0, 0, 0.7);
            color: #fff;
            padding: 20px;
            text-align: center;
            font-size: 28px;
            font-weight: bold;
            letter-spacing: 2px;
            text-transform: uppercase;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.85);
            width: 500px;
            margin: 50px auto;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 6px 18px rgba(0, 0, 0, 0.4);
            transition: transform 0.4s ease, box-shadow 0.4s ease;
        }

        .form-container:hover {
            transform: scale(1.02);
            box-shadow: 0px 10px 24px rgba(0, 0, 0, 0.6);
        }

        label {
            display: block;
            margin-top: 12px;
            font-weight: bold;
            color: #444;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #aaa;
            border-radius: 8px;
            font-size: 14px;
            transition: border 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus, textarea:focus {
            border-color: #0078d7;
            box-shadow: 0 0 8px rgba(0, 120, 215, 0.5);
            outline: none;
        }

        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background: linear-gradient(135deg, #0078d7, #00bfa6);
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.4s ease, transform 0.2s ease;
        }

        input[type="submit"]:hover {
            background: linear-gradient(135deg, #005bb5, #009b8b);
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <header>Assignment Submission Portal</header>
    <div class="form-container">
        <s:form action="submitAssignment" method="post">
            <s:textfield name="studentName" label="Student Name"/>
            <s:textfield name="studentId" label="Student ID"/>
            <s:textfield name="courseName" label="Course Name"/>
            <s:textfield name="assignmentTitle" label="Assignment Title"/>
            <s:textarea name="content" label="Assignment Content" cols="50" rows="10"/>
            <s:submit value="Submit"/>
        </s:form>
    </div>
</body>
</html>
