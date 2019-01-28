<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
  </head>
  
  <body>
    <br><br><br>
    <h1 class="text-center"><b>Welcome</b></h1><br>
    <h3 class="text-center"><a href="./pages/dormitorylist.jsp" class="text-center">宿舍</a></h3><br>
    <h3 class="text-center"><a href="./pages/studentlist.jsp" class="text-center">学生</a></h3><br>
    <h3 class="text-center"><a href="./pages/stafflist.jsp" class="text-center">职员</a></h3><br>
    <h3 class="text-center"><a href="./pages/repairlist.jsp" class="text-center">报修单</a></h3><br>
    <h3 class="text-center"><a href="./pages/utilitieslist.jsp" class="text-center">水电费</a></h3><br>
    <h3 class="text-center"><a href="./pages/mechinelist.jsp" class="text-center">设备租赁</a></h3><br>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
  </body>
</html>
