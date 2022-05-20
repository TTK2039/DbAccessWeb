<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	
  <p>${msg }<br>商品を登録します。  <br>NAME、PRICEを入力してください。  </p>
  <form action="registerchan" method="post">
    product_name登録欄 <input type="text" name="registerName"><br>
	price登録欄 <input type="number" name="registerprice"><br>
    <button type="submit">商品を登録！</button>

  </form>
    <a href="index.jsp">戻る</a>
</body>
</html>
