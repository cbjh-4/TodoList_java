<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            color: #333;
        }
        .header {
            background-color: #2980b9;
            color: white;
            padding: 20px 10px;
            text-align: center;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .header img {
            height: 80px;
            width: auto;
        }
        .header h1 {
            text-align: center;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="number"],
        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-top: 6px;
            box-sizing: border-box;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="checkbox"] {
            margin-top: 6px;
        }
        button {
            background-color: #2980b9;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Todo 수정</h1>
</div>
<div class="form-container">
    <form action="/todo/modify" method="post">
        <label for="tno">Tno:</label>
        <input type="number" id="tno" name="tno" value="${todoDTO.tno}" readonly><br><br>
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${todoDTO.title}"><br><br>
        <label for="dueDate">Due Date (yyyy-MM-dd):</label>
        <input type="date" id="dueDate" name="dueDate" value="${todoDTO.dueDate}" readonly><br><br>
        <label for="finished">Finished:</label>
        <input type="checkbox" id="finished" name="finished" value="true" ${todoDTO.finished ? 'checked' : ''}>
        <input type="hidden" name="finished" value="false">
        <button type="submit">수정</button>
    </form>
</div>
</body>
</html>
