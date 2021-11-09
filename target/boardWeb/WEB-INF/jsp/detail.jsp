<%@ page import="com.koreait.board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BoardVO vo = (BoardVO)request.getAttribute("data");
%>



<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <table>
        <div>제목 : <%= vo.getTitle()%></div>
        <div>작성자 : <%= vo.getWriter()%></div>
        <div>작성일시 : <%= vo.getRdt()%></div>
        <div>내용 : <%= vo.getCtnt()%> </div>
    </table>

</body>
</html>
