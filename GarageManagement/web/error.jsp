<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Lỗi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        .error-container {
            border: 1px solid #ff0000;
            background-color: #ffe6e6;
            padding: 20px;
            display: inline-block;
            border-radius: 5px;
        }
        .error-code {
            font-size: 24px;
            font-weight: bold;
            color: #cc0000;
        }
        .error-message {
            font-size: 18px;
            margin-top: 10px;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-code">Lỗi xảy ra!</div>
        <div class="error-message">Xin lỗi, đã có lỗi trong quá trình xử lý.</div>
        <a href="home">Quay lại trang chủ</a>
    </div>
</body>
</html>
