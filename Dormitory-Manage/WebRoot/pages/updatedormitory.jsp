<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改宿舍</title>
    
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
         String strdno=request.getParameter("dno");
         int dno=Integer.parseInt(strdno); 
      %>
      <form id="myform" >
           <div class="form-group" hidden>
              <label class="control-label" for="dno">dno：</label>
              <input class="form-control" type="text" id="dno" name="dno">
           </div>
           <div class="form-group">
              <label class="control-label" for="dname">dname：</label>
              <input class="form-control" type="text" id="dname" name="dname">
           </div>
           <div class="form-group">
              <label class="control-label" for="dphone">dphone：</label>
              <input class="form-control" type="text" id="dphone" name="dphone">
           </div>
           <div class="form-group">
              <label class="control-label" for="maxpeople">maxpeople：</label>
              <input class="form-control" type="text" id="maxpeople" name="maxpeople">
           </div>
           <div class="form-group">
              <label class="control-label" for="nowpeople">nowpeople：</label>
              <input class="form-control" type="text" id="nowpeople" name="nowpeople">
           </div>
           <button class="btn btn-primary" id="mybtn" type="button">submit</button>
       </form>
       <script src="./js/jquery.min.js"></script>
       <script src="./bootstrap/js/bootstrap.js"></script>
       <script src="./datetimepicker/js/bootstrap-datetimepicker.js"></script>
       <script>
             $(document).ready(function(){
                $.ajax({
                   url:"Returndormitory",
                   data:"dno=<%=dno%>",
                   type:"get",
                   dataType:"json",
                   async:false,
                   success:function(msg){
                       console.log(msg);
                       $("#dno").val(msg[0].dno);
                       $("#dname").val(msg[0].dname);
                       $("#dphone").val(msg[0].dphone);
                       $("#maxpeople").val(msg[0].maxpeople);
                       $("#nowpeople").val(msg[0].nowpeople);
                   }
                });
           });
       </script>
       <script>
           $(document).ready(function(){
               $("#mybtn").click(function(){
                   $.ajax({
                      url:"Updatedormitory",
                      data:$("#myform").serialize(),
                      type:"get",
                      success:function(msg){
                            console.log(msg);
                         if(msg==1)
                            window.alert("修改宿舍成功");
                         else
                            window.alert("修改宿舍失败");
                      },
                      error:function(msg){
                          if(msg==1)
                            window.alert("修改宿舍成功");
                         else
                            window.alert("修改宿舍失败");
                      }
                   });
               });
           });
       </script>
  </body>
</html>
