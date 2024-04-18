<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Todo List</title>
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
            justify-content: space-around;
        }
        .header img {
            height: 80px;
            width: auto;
        }
        .header h1 {
            flex-grow: 1;
            text-align: center;
        }
        .todo-list {
            margin-top: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        li:last-child {
            border-bottom: none;
        }
        a {
            text-decoration: none;
            color: #333;
        }
        a:hover {
            color: #3498db;
        }
        .add-button {
            display: block;
            width: 100%;
            padding: 10px 20px;
            margin: 20px 0;
            font-size: 16px;
            text-align: center;
            background-color: #2980b9;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="https://media.tumblr.com/256818ef271ba289ec26c1290134cfd0/tumblr_inline_mksgcxfFQE1qz4rgp.png" alt="Logo">
    <h1>Todo List</h1>
    <img src="https://i.namu.wiki/i/nrT8LpGyGkb8BsMkTjIg25iusn4miTzMulMgtRMcagNpNrcqsUtr6u0NIaSlao64oxmPSgYvuBj6qLa8rh-rGaRSRLdmqzr5FNI5aOQoikJVKmzrWIh3dtlTLqb2VAK2RcGVVpjT5GEfxESOP-PWeQ.webp" alt="앵그리버드">
    <img src="https://img2.quasarzone.com/editor/2023/01/30/d07312b796c3828ac1a0a34222829817.jpg" alt="수달">
</div>
<div class="todo-list">
    <ul>
        <c:forEach var="dto" items="${list}">
            <li>
                <a href="/todo/read?tno=${dto.tno}">${dto.tno} - ${dto.title}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<a href="/todo/register" class="add-button">글 등록</a>
</body>
</html>
