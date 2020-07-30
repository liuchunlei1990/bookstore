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

   

</ul>
</body>
<script type="text/javascript">
     $(window).ready(
    	     function(){
                $.ajax({
                    "url":"/Bookstore/BookServlet?method=allbook&pagesize=9&currentPageNo=1",
                    "type":"GET",
                    "datatype":"json",
                    "success":function(data){
                           var page = eval('('+data+')');
                           if(page!=null){
                               var books = page.values;
                               //求页码
                               var start = 0;
                               var end = 0;
                               if(page.totalPageCount <= 10){
                                    start = 1;
                                    end = page.totalPageCount;
                               }else{
                            	   start = page.currentPageNo - 5;
                            	   if(start <= 1){
                                	    start = 1;
                                	    end = 10;
                                   }
                            	   end = page.currentPageNo + 4;
                            	   if(end > page.totalPageCount){
                                	   start = page.totalPageCount -9;
                                	   end = page.totalPageCount;
                                   }
                               }
                               for(var i = 0 ; i <books.length;i++){
                            	   $("#booklist").append(
                                    	   "<li>"+"<p><img src='book/"+books[i].image+"' width='120' height='150'/></p>"+"<p>"+books[i].price+"</p>"+" <p><a href='<c:url value='/BookServlet?method=bookinfo&bid="+books[i].bid+"'/>'>"+books[i].bname+"<a/></p>"+"</li>"
                                   );
                               };
                               var $p = $("<p style='text-align:center'></p>");
                               for(var i = start; i <= end; i++){
                                    var $a ="<a href=''>"+i+"</a>&nbsp;&nbsp;";
                                    $p.append($a);
                               }
                               $("#booklist").after($p);
                           }
                     }
                    
                    });  
        	 }
    );
       
</script>
</html>