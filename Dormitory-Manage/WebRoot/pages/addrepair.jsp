<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加报修单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./datetimepicker/css/bootstrap-datetimepicker.css">
  </head>
  
  <body>
    <%@include file="navigation.jsp" %>
    <form id="myform">
       <div class="form-group">
          <label class="control-label" for="dno">dno:</label>
          <input class="form-control" type="text" id="dno" name="dno">
       </div>
       <div class="form-group">
          <label class="control-label" for="sdate">sdate:</label>
          <input class="form-control" type="text" id="sdate" name="sdate">
       </div>
       <div class="form-group">
          <label class="control-label" for="fdate">fdate:</label>
          <input class="form-control" type="text" id="fdate" name="fdate">
       </div> 
       <div class="form-group">
          <label class="control-label" for="cost">cost:</label>
          <input class="form-control" type="text" id="cost" name="cost">
       </div>
       <div class="form-group">
          <label class="control-label" for="cost">reason:</label>
          <textarea rows="5" cols="30" class="form-control"  id="reason" name="reason"></textarea>
       </div>
       <button class="btn btn-primary" id="mybtn">submit</button>
    </form>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script>
        $("#sdate").datetimepicker({
             lang:"ch", //语言选择中文 注：旧版本 新版方法：$.datetimepicker.setLocale('ch');
             format:"yyyy-mm-dd",      //格式化日期
             autoclose:true,    
             minView:2
        });
        $("#fdate").datetimepicker({
             lang:"ch", //语言选择中文 注：旧版本 新版方法：$.datetimepicker.setLocale('ch');
             format:"yyyy-mm-dd",      //格式化日期
             autoclose:true,    
             minView:2
        });
    </script>
    <script>
         $(document).ready(function(){
             $("#mybtn").click(function(){
                   $.ajax({
                       url:"Addrepair",
                       type:"get",
                       data:$("#myform").serialize(),
                       success:function(msg){
                            console.log(msg);
                            if(msg==0)
                               window.alert("添加报修单信息失败");
                            else
                               window.alert("添加报修单信息成功");
                       },
                       error:function(msg){
                            if(msg==0)
                               window.alert("添加报修单信息失败");
                            else
                               window.alert("添加报修单信息成功");
                      }
                   });
             });
         });
    </script>
  </body>
</html>
