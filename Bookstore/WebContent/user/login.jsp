<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
</head>
<body>
<p align="center"><a href="#" id="zhlogin">账号登录</a><a  href="#" id="plogin">手机登录</a></p>
<form action="<c:url value='/UserServlet'/>" method="post" id="user" style="display:block"> 
   <input type="hidden" name="method" value ="loginByUsername"/>
   <table  align="center">
       <tr>
          <td colspan="2">用户登录</td>
       </tr>
       <c:if test="${not empty msg}">
         <tr>
             <td colspan="2" align="center"><span style="color:red">${msg}</span></td>
          </tr>
       </c:if>
       <tr>
          <td>账号：</td>
          <td><input type="text" name="username"/></td>
       </tr>
       <tr>
          <td>密码：</td>
          <td><input type="text" name="password"/></td>
       </tr>
       <tr>
           <td><input type="submit" value="登录"/></td>
           <td><input type="button" value="注册"/></td>
       </tr>
   </table>
</form> 


<form action="#" method="post" id="lphone" style="display:none">
<input type="hidden" name="method" value ="loginByPhone"/>
<table  align="center">
       <tr>
          <td colspan="2">用户登录</td>
       </tr>
       <tr>
          <td>手机号：</td>
          <td><input type="text" name="phone" id="phone"/></td>
       </tr>
       <tr>
          <td>验证码：</td>
          <td><input type="text" name="code" id="code"/>
              <input type="button" value="获取验证码" id="getCode"/>
              <span id="message" style="color:red"></span>
          </td>
       </tr>
       <tr>
           <td><input type="button" value="登录" id="login"/></td>
           <td><input type="button" value="注册"/></td>
       </tr>
   </table>
</form> 
</body>
<script type="text/javascript">
var waitTime = 60;
//倒计时定时器
function time(ele) {
    if (waitTime == 0) {
        ele.removeAttr("disabled"); 
        ele.val("获取验证码");
        waitTime = 60;// 恢复计时
    } else {
        ele.attr("disabled",true);
        ele.val(waitTime + "秒后可以重新发送");
        waitTime--;
        setTimeout(function() {
            time(ele)// 关键处-定时循环调用
        }, 1000)
    }
}
$(window).ready(
		function(){
			 $("#getCode").click(function(){
                  time($("#getCode"));
                  //发送验证码
                  $.ajax({
                      "url":"/Bookstore/CodeServlet?method=getCode&phone="+$("#phone").val(),
                      "type":"get"
                      })
			 });
			 $("#zhlogin").click(function(){
				  $("#user").show();
				  $("#lphone").hide();
			 });
			 $("#plogin").click(function(){
				  $("#user").hide();
				  $("#lphone").show();
			 });
			 $("#login").click(function(){
				alert();
                $.ajax({
                    "url":"/Bookstore/UserServlet",
                    "type":"POST",
                    /* "{\"method\":loginByPhone,\"phone\":"+$("#phone").val()+",\"code\":"+$("#code").val()+"}" */
                    "data":"method=loginByPhone&phone="+$("#phone").val()+"&code="+$("#code").val(),
                    "datatype":"text",
                    "success":function(data){
                         $("#msg").val(data);
                         //如果响应的信息为空，则重定向
                         //Loaction.href="";
                     }  
                    });   
			 });
		}
);


</script>
</html>