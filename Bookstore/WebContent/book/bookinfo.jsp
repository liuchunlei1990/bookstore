<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书详细</title>
<style type="text/css">
  #info{
     height:320px,
     width:400px，
     margin:0px auto  
  }
  ul{
  list-style:none;}
</style>
</head>
<body>
<div id="info">
  <form action="<c:url value="/cart/CartServlet"/>" method="post">
  <c:if test="${not empty book}">
  <input type="hidden" name="method" value="addCart"/>
  <input type="hidden" name="bid" value="${book.bid}"/>
  <ul>
     <li><img src="<c:url value='/book/${book.image}'/>" width="180" height="230"></li>
     <li>作者：${book.author}</li>
     <li>价格：${book.price}</li>
     <li>书名：${book.bname}</li>
     <li>购买数量：<input type="text" name="count"/></li>
     <li><input type="submit" value="加入购物车"></li>
  </ul>
  </c:if>
  </form>
</div>
</body>
</html>