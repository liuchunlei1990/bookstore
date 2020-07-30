<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<script type="text/javascript" src="../js/ajax-lib.js"></script>
</head>
<body>
<form action="<c:url value='/UserServlet'/>" method="post" align="center">
   <p><input type="hidden" name="method" value="register"/>${msg}<p>
   <p>账号：<input type="text" name="username" id="username"/><span id="zms"></span></p>
   <p>密码：<input type="password" name="password" id="password"/><span id="error1"></span></p>
   <p>确认密码：<input type="password" name="apassword" id="apassword"/><span id="error2"></p>
   <p>电话号码：<input type="text" name="phone" id="phone"/><span id="zph"></span></p>
   <p>验证码：
        <input type="text" name="verificode"/>
        <input type="button" value="获取验证码" id="vCode"/>
         <span id="message" style="color:red"></span>
   </p>
   <p>
      <input type="submit" value="注册"/>
      <input type="button" value="返回" onclick="javascript:history.back()"/>
   </p>
</form>
</body>
<script type="text/javascript">
//倒计时定时器
function time(ele) {
    if (waitTime == 0) {
        ele.disabled=false; 
        ele.value = "获取验证码";
        waitTime = 60;// 恢复计时
    } else {
        ele.disabled=true;
        ele.value = waitTime + "秒后可以重新发送";
        waitTime--;
        setTimeout(function() {
            time(ele)// 关键处-定时循环调用
        }, 1000)
    }
}


</script>
</html>