<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
</head>
<body>
	<h1 align="center">我的订单</h1>
	<c:if test="${not empty orderlist}">
		<c:forEach items="${orderlist}" var="myorder">
			<table border="1" width="100%" cellspacing="0">
				<c:if test="${not empty myorder}">
					<tr bgcolor="gray" bordercolor="gray">
						<td colspan="6">订单编号：${myorder.oid} 成交时间：<fm:formatDate
								value="${myorder.ordertime}" pattern="yyyy-MM-dd hh:mm:ss" />
							金额：<b style="color: red"> <fm:formatNumber
									value="${myorder.total}" pattern="0.00"></fm:formatNumber>
						</b> 订单状态：
				<c:if test="${myorder.state eq 1}">
				   待支付
				</c:if> <c:if test="${myorder.state eq 2}">
				   已支付
				</c:if> <c:if test="${myorder.state eq 3}">
				   已发货
				</c:if> <c:if test="${myorder.state eq 4}">
				   已收货
				</c:if>
						</td>
					</tr>
					<c:if test="${not empty myorder.orderitemlist}">
						<c:forEach items="${myorder.orderitemlist}" var="item">
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
								<td>小计：
								<fm:formatNumber
									value="${item.subtotal}" pattern="0.00"></fm:formatNumber>
								
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</c:if>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>