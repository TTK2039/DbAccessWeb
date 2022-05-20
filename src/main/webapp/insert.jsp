<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	
  <p>${msg }<br>ユーザーを登録します。  <br>NAME、PASSを入力してください。  </p>
  <form action="akachan" method="post">
    NAME <input type="text" name="userName"><br>
    PASS <input type="password" name="userPass" maxlength="20"><br>
    <button type="submit">ユーザー登録！</button>
  <a href="index.jsp">戻る</a>
  </form>
</body>
</html>
