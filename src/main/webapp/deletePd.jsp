<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	
  <p>${msg }<br>商品を削除します。 <br>削除したい商品名を入力してください。  </p>
  <form action="deleteFromName" method="post">
    product_name欄 <input type="text" name="name"><br>
    <button type="submit">商品を削除！</button>
  <a href="index.jsp">戻る</a>
  </form>
</body>
</html>
