<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Error Page</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #ff4e50, #f9d423);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .error-box {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px 40px;
            border-radius: 14px;
            box-shadow: 0px 6px 18px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 400px;
            animation: fadeIn 0.8s ease-out, slideDown 0.8s ease-out;
        }

        h2 {
            margin: 0 0 20px 0;
            color: #d8000c;
            font-size: 24px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        /* Fade + Slide animation */
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        @keyframes slideDown {
            from { transform: translateY(-40px); }
            to { transform: translateY(0); }
        }

        .error-messages {
            margin: 20px 0;
            font-size: 15px;
            line-height: 1.6;
            color: #333;
            background: #ffecec;
            padding: 15px;
            border: 1px solid #f5aca6;
            border-radius: 8px;
            animation: pulse 1.2s infinite alternate;
        }

        @keyframes pulse {
            from { box-shadow: 0 0 8px rgba(216, 0, 12, 0.4); }
            to { box-shadow: 0 0 16px rgba(216, 0, 12, 0.8); }
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            text-decoration: none;
            color: #fff;
            background: linear-gradient(135deg, #ff4e50, #fc913a);
            border-radius: 8px;
            font-weight: bold;
            transition: background 0.4s ease, transform 0.2s ease;
        }

        a:hover {
            background: linear-gradient(135deg, #d8000c, #f7797d);
            transform: scale(1.08);
        }
    </style>
</head>
<body>
    <div class="error-box">
        <h2>Errors Occurred</h2>
        <div class="error-messages">
            <s:actionerror/>
        </div>
        <a href="index.jsp">Back to Form</a>
    </div>
</body>
</html>
