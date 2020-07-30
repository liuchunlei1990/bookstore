<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">购物车</h3>
<p><a href="<c:url value='/cart/CartServlet?method=clear'/>">清空购物车</a></p>
<table border="1" width="100%" cellspacing="0">
<tr>
   <td>图书</td>
   <td>书名</td>
   <td>单价</td>
   <td>作者</td>
   <td>数量</td>
   <td>小计</td>
   <td>加|减</td>
   <td>操作</td>
</tr>
<c:if test="${not empty sessionScope.cart}">
    <!-- 遍历cart成员变量map映射里面的CartItem集合（value），getCartItems() -->
    <c:if test="${not empty sessionScope.cart.cartItems}">
       <c:forEach items="${sessionScope.cart.cartItems}" var="item">
       <tr>
          <td><img src="<c:url value='/book/${item.book.image}'/>" width="100" height="120"/></td>
          <td>${item.book.bname}</td>
          <td>${item.book.price}</td>
          <td>${item.book.author}</td>
          <td>${item.count}</td>
          <td>${item.subtotal}</td>
          <td>
             <a href="<c:url value='/cart/CartServlet?method=changeCount&count=1&bid=${item.book.bid}'/>">+</a>&nbsp;&nbsp;
             <a href="<c:url value='/cart/CartServlet?method=changeCount&count=-1&bid=${item.book.bid}'/>">-</a>
          </td>
          <td>
             <a href="<c:url value='/cart/CartServlet?method=removeItem&bid=${item.book.bid}'/>">删除</a>
          </td>
       </tr>
       </c:forEach>
    </c:if>
    <tr>
        <td colspan="7">总计：<span style="color:red;font-size:18px">${sessionScope.cart.total}</span>
            <span><a href="<c:url value='/Order/OrderServlet?method=addOrder'/>">生成订单</a></span>
        </td>
    </tr>
</c:if>
</table>
</body>
</html>