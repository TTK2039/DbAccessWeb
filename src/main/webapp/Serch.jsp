<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	
  <p>${msg }<br>片方検索。両方入力するとAND検索<br>id,nameを入力してください。<br>
  nameが複数存在する場合は全件出力されます。</p>
  <form action="serch" method="post">
    product_id<input type="text" name="id"><br>
    product_name<input type="text" name="name"><br>
    <button type="submit">検索する！</button>
  <a href="index.jsp">戻る</a>
  </form>
</body>
</html>
