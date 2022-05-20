<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>InsertResult</title>
</head>
<body>
  <p>${msg }登録情報は以下の通りです。</p>
  ID <input type="text" name="id" value="${fn:escapeXml(user.userId)}" readonly><br>
  NAME <input type="text" name="name" value="${fn:escapeXml(user.userName)}" disabled><br>
  PASS <input type="text" name="pass" value="${fn:escapeXml(user.password)}"><br>
  <a href="index.jsp">戻る</a>
</body>
</html>

