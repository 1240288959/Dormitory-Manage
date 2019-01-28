<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新租赁信息</title>
    
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
    <% 
         String mno=request.getParameter("mno"); 
     %>
    <form id="myform">
       <div class="form-group" hidden>
          <label class="control-label" for="mno">mno:</label>
          <input class="form-control" type="text" id="mno" name="mno">
       </div>
       <div class="form-group">
          <label class="control-label" for="mname">mname:</label>
          <input class="form-control" type="text" id="mname" name="mname">
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
                $.ajax({
                   url:"Returnmechine",
                   data:"mno=<%=mno%>",
                   type:"get",
                   dataType:"json",
                   async:false,
                   success:function(msg){
                       console.log(msg);
                       $("#mno").val(msg[0].mno);
                       $("#mname").val(msg[0].mname);
                       $("#sdate").val(msg[0].sdate);
                       $("#fdate").val(msg[0].fdate);
                       $("#cost").val(msg[0].cost);
                   }
                });
           });
       </script>
    <script>
         $(document).ready(function(){
               $("#mybtn").click(function(){
                   $.ajax({
                      url:"Updatemechine",
                      data:$("#myform").serialize(),
                      type:"get",
                      success:function(msg){
                            console.log(msg);
                         if(msg==0)
                            window.alert("修改租赁信息失败");
                         else
                            window.alert("修改租赁信息成功");
                      },
                      error:function(msg){
                          if(msg==0)
                            window.alert("修改租赁信息失败");
                         else
                            window.alert("修改租赁信息成功");
                      }
                   });
               });
           });
    </script>
  </body>
</html>
