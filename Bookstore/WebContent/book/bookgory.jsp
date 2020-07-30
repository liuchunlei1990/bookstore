<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书信息列表</title>
<style type="text/css">
  ul{
  list-style:none;
  }
  ul>li{
    display:inline-block;
    border：1px solid red;
    padding:5px;
    margin:5px;
   
  }
  li>p{
    text-align:center;
  }
  #booklist>li{
  width:200px;
  }
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
<ul id="booklist">
    <c:if test="${not empty page}">
        <c:if test="${not empty page.values}">
            <c:forEach items="${page.values}" var="book">
                 <li>
                     <p><img src="<c:url value='book/${book.image}'/>" width='120' height='150'/></p>
                     <p>${book.price}</p>
                     <p>${book.bname}</p>
                 <li>
            </c:forEach>
        </c:if>
        <c:choose>
            <c:when test="${page.totalPageCount <= 10}">
                 <c:set var="start" value="1"></c:set>
                 <c:set var="end" value="${page.totalPageCount}"></c:set>
            </c:when>
            <c:otherwise>
                 <c:set var="start" value="${page.currentPageNo-5}"></c:set>
                 <c:if test="${start<=1}">
                        <c:set var="start" value="1"></c:set>
                        <c:set var="end" value="10"></c:set> 
                 </c:if>
                 <c:set var="end" value="${page.currentPageNo+4}"></c:set>
                 <c:if test="${end>page.totalPageCount}">
                        <c:set var="start" value="${page.totalPageCount-9}"></c:set>
                        <c:set var="end" value="${page.totalPageCount}"></c:set> 
                 </c:if>
            </c:otherwise>
        
        </c:choose>
        <p style="text-align:center">
           <c:forEach var="i" begin="${start}" end="${end}">
                <a href="<c:url value='/BookServlet?method=gorybook&pagesize=9&currentPageNo=${i}&cid=${cid}'/>">${i}</a>
        
            </c:forEach>
         <p>
    </c:if>
   

</ul>
</body>
</html>