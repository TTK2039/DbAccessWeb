<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="hogehoge" method="post">
<!--   	演習１４基本 -->
    product_id <input type="text" name="id"><br>
    <button type="submit" formaction = "serch">演習14基本　idで検索ボタン</button>
    <button type="submit" formaction ="deleteFromID">idで削除ボタン</button>
    
    <a href="deletePd.jsp">
    	<button type="button">nameで商品を削除</button>
	</a>
    
    
    <button type="submit" formaction = "findAll">テーブルの中身全部見る</button>
	<button type="submit" formaction = "sumPriceChan">全部の合計値段！</button><br>
	
	<a href="insertPd.jsp">
    	<button type="button">商品を登録</button>
	</a>
<!-- 	ID登録欄 <input type="text" name="userName"><br> -->
<!-- <!-- 	パスワードに数字しか入らないように処理をかく -->
<!-- 	PASS登録欄 <input type="password" name="userPass"><br> -->
<!-- 	<button type="submit" formaction = "akachan">ユーザーを登録</button> -->
	<a href="insert.jsp">
    	<button type="button">ユーザーを登録</button>
	</a>
  </form>
</body>
</html>
