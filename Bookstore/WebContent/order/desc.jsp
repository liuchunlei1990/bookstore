<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>当前订单</title>
</head>
<body>
	<h1 align="center">当前订单</h1>
	<table border="1" width="100%" cellspacing="0">
		<c:if test="${not empty order}">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="6">订单编号：${order.oid} 
				成交时间：
				<!-- 格式化标签 -->
				<fm:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd hh:mm:ss"/>
				金额：<b
					style="color: red">${order.total}</b>
				</td>
			</tr>
			<c:if test="${not empty order.orderitemlist}">
				<c:forEach items="${order.orderitemlist}" var="item">
					<tr bordercolor="gray" align="center">
						<td width="15%">
							<div>
								<img src="<c:url value='/book/${item.book.image}'/>" height="75">
							</div>
						</td>
						<td>书名：${item.book.bname}</td>
						<td>单价：${item.book.price}</td>
						<td>作者：${item.book.author}</td>
						<td>数量：${item.count}</td>
						<td>小计：${item.subtotal}</td>
					</tr>
				</c:forEach>
			</c:if>
		</c:if>
	</table>
	<form action="">
	<p>收货地址：<input type="text" name="address" size="50"/></p>
	<p>
	  支付方式：
	     <li></li>
	</p>
	<p><input type="submit" value="支付"/></p>
	</form>
</body>
</html>