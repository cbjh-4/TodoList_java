<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo 세부 정보</title>
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
        .header h1 {
            flex-grow: 1;
            text-align: center;
        }
        .details-container {
            margin-top: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .detail {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .detail:last-child {
            border-bottom: none;
        }
        .buttons {
            display: flex; /* 여기를 추가해주면 가로로 배열됩니다 */
            justify-content: center; /* 버튼들을 중앙 정렬합니다 */
            margin-top: 20px;
            text-align: center;
        }
        button {
            padding: 10px 20px;
            margin: 0 10px;
            font-size: 16px;
            background-color: #2980b9;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #3498db;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Todo 세부 정보</h1>
</div>
<div class="details-container">
    <div class="detail">tno: ${dto.tno}</div>
    <div class="detail">title: ${dto.title}</div>
    <div class="detail">dueDate: ${dto.dueDate}</div>
    <div class="detail">finished: ${dto.finished}</div>
</div>
<div class="buttons">
    <form action="/todo/modify" method="get">
        <input type="hidden" name="tno" value="${dto.tno}">
        <button type="submit">수정</button>
    </form>
    <form action="/todo/delete" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
        <input type="hidden" name="tno" value="${dto.tno}">
        <button type="submit">삭제</button>
    </form>
    <a href="/todo/list"><button>목록으로</button></a>
</div>
</body>
</html>
