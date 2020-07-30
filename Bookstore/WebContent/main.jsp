<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>网上书店</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<style type="text/css">
#nav{
	text-align: center;
	height: 120px;
}
#cate{
  padding:0px;
}
#cate>ul{
  list-style:none;
  
}
</style>
</head>
<body>
	<table width="1000" height="700" border="1" align="center">
		<tr>
			<td colspan="2" height="150">
				<div id="nav">
					<h3 align="center">虹猫网上书店</h3>
				     <c:choose>
				         <c:when test="${not empty user}">
							<p>
								您好：${user.username}|<a href="<c:url value='/cart/mycart.jsp'/>">我的购物车</a>|
								<a href="<c:url value='/Order/OrderServlet?method=myOrder'/>">我的订单</a>|
								<a href="#">退出</a>
							</p>
						 </c:when>
						<c:otherwise>
							<p>
								<a href="">登录</a> 
								<a href="">注册</a>
							</p>
						</c:otherwise>	
                     </c:choose>
				</div>
			</td>
		</tr>
		<tr>
		    <!-- 显示分类信息： 查询所有分类
		       *1.bean: Category:  cid,cname
		       *2.dao:  findAll()
		       *3.server:findAll()
		       *4.controller: CategoryServlet: findAll()
		     -->
		    <!-- 图书类别的列表  -->
			<td width="240" id="cate">
			   <ul id="cateul">
			      
			   </ul>
			</td>
			<td id="all">
			   <jsp:include page="book/bookall.jsp"></jsp:include>
			  
			</td>
		</tr>

	</table>
</body>
<script type="text/javascript">
     $(window).ready(function(){
          $.ajax({
           "url":"/Bookstore/CategoryServlet?method=getAllCate", 
           "type":"get", 
           "datatype":"json",
           "success": function(data){
                 var arr = eval('('+data+')');
                 
                 for(var i = 0 ; i < arr.length;i++){
                	 $("#cateul").append("<li><a href='<c:url value='/BookServlet?method=gorybook&pagesize=9&currentPageNo=1&cid="+arr[i].cid+"'/>' target='content'>"+arr[i].cname+"</a></li>");
                 }
           }   
          });   
         
      });
</script>
</html>