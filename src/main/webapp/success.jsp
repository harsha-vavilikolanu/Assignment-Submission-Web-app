<html>
<head>
    <title>Success Page</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #56ab2f, #a8e063);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .success-box {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px 40px;
            border-radius: 14px;
            box-shadow: 0px 6px 18px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 400px;
            animation: fadeIn 0.8s ease-out, slideUp 0.8s ease-out;
        }

        h2 {
            margin: 0 0 20px 0;
            color: #2e7d32;
            font-size: 24px;
            text-transform: uppercase;
            letter-spacing: 1px;
            animation: popIn 0.6s ease-in-out;
        }

        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        @keyframes slideUp {
            from { transform: translateY(40px); }
            to { transform: translateY(0); }
        }

        @keyframes popIn {
            0% { transform: scale(0.8); opacity: 0; }
            100% { transform: scale(1); opacity: 1; }
        }

        @keyframes glow {
            from { box-shadow: 0 0 8px rgba(76, 175, 80, 0.4); }
            to { box-shadow: 0 0 16px rgba(76, 175, 80, 0.8); }
        }

        .success-box {
            animation: fadeIn 0.8s ease-out, slideUp 0.8s ease-out;
        }

        .success-box:hover {
            animation: glow 1.2s infinite alternate;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            text-decoration: none;
            color: #fff;
            background: linear-gradient(135deg, #43a047, #66bb6a);
            border-radius: 8px;
            font-weight: bold;
            transition: background 0.4s ease, transform 0.2s ease;
        }

        a:hover {
            background: linear-gradient(135deg, #2e7d32, #388e3c);
            transform: scale(1.08);
        }
    </style>
</head>
<body>
    <div class="success-box">
        <h2>Assignment Submitted Successfully!</h2>
        <a href="index.jsp">Submit Another</a>
    </div>
</body>
</html>
