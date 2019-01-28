<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新学生</title>
    
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
     <%@include file="navigation.jsp" %>
     <% 
         String sno=request.getParameter("sno");
      %>
     <form id="myform">
       <div class="form-group" hidden>
          <label class="control-label" for="sno">sno:</label>
          <input class="form-control" type="text" id="sno" name="sno">
       </div>
       <div class="form-group">
          <label class="control-label" for="dno">dno:</label>
          <input class="form-control" type="text" id="dno" name="dno">
       </div>
       <div class="form-group">
          <label class="control-label" for="sname">sname:</label>
          <input class="form-control" type="text" id="sname" name="sname">
       </div> 
       <div class="form-group">
          <label class="control-label" for="sex">sex:</label>
          <input class="form-control" type="text" id="sex" name="sex">
       </div>
       <div class="form-group">
          <label class="control-label" for="major">major:</label>
          <input class="form-control" type="text" id="major" name="major">
       </div>
       <div class="form-group">
          <label class="control-label" for="mobilephone">mobilephone:</label>
          <input class="form-control" type="text" id="mobilephone" name="mobilephone">
       </div>
       <button class="btn btn-primary" id="mybtn">submit</button>
    </form>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script>
             $(document).ready(function(){
                $.ajax({
                   url:"Returnstudent",
                   data:"sno=<%=sno%>",
                   type:"get",
                   dataType:"json",
                   async:false,
                   success:function(msg){
                       console.log(msg);
                       $("#sno").val(msg[0].sno);
                       $("#dno").val(msg[0].dno);
                       $("#sname").val(msg[0].sname);
                       $("#sex").val(msg[0].sex);
                       $("#major").val(msg[0].major);
                       $("#mobilephone").val(msg[0].mobilephone);
                   }
                });
           });
       </script>
    <script>
         $(document).ready(function(){
             $("#mybtn").click(function(){
                   $.ajax({
                       url:"Updatestudent",
                       type:"get",
                       data:$("#myform").serialize(),
                       success:function(msg){
                            console.log(msg);
                            if(msg==0)
                               window.alert("修改学生失败");
                            else
                               window.alert("修改学生成功");
                       },
                       error:function(msg){
                          if(msg==0)
                               window.alert("修改学生失败");
                            else
                               window.alert("修改学生成功");
                      }
                   });
             });
         });
    </script>
  </body>
</html>
