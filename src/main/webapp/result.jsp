<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
  ログインできました。  <br>
  <br>
  ユーザーの一覧を表示します。  <br>
  <table border="1">
    <tr>
      <th>user_id</th>
      <th>user_name</th>
      <th>password</th>
    </tr>
    <c:forEach var="user" items="${userList}">
      <tr>
        <td>${fn:escapeXml(user.userId)}</td>
        <td>${fn:escapeXml(user.userName)}</td>
        <td>${fn:escapeXml(user.password)}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
