<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新职员信息</title>
    
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
         String staffno=request.getParameter("staffno"); 
      %>
    <form id="myform">
       <div class="form-group" hidden>
          <label class="control-label" for="staffno">staffno:</label>
          <input class="form-control" type="text" id="staffno" name="staffno">
       </div>
       <div class="form-group">
          <label class="control-label" for="dno">dno:</label>
          <input class="form-control" type="text" id="dno" name="dno">
       </div>
       <div class="form-group">
          <label class="control-label" for="sdate">staffname:</label>
          <input class="form-control" type="text" id="staffname" name="staffname">
       </div> 
       <div class="form-group">
          <label class="control-label" for="sex">sex:</label>
          <input class="form-control" type="text" id="sex" name="sex">
       </div>
       <div class="form-group">
          <label class="control-label" for="duty">duty:</label>
          <input class="form-control" type="text" id="duty" name="duty">
       </div>
       <div class="form-group">
          <label class="control-label" for="mobilephone">mobilephone:</label>
          <input class="form-control" type="text" id="mobilephone" name="mobilephone">
       </div>
       <div class="form-group">
          <label class="control-label" for="age">age:</label>
          <input class="form-control" type="text" id="age" name="age">
       </div>
       <button class="btn btn-primary" id="mybtn">submit</button>
    </form>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
     <script>
             $(document).ready(function(){
                $.ajax({
                   url:"Returnstaff",
                   data:"staffno=<%=staffno%>",
                   type:"get",
                   dataType:"json",
                   async:false,
                   success:function(msg){
                       console.log(msg);
                       $("#staffno").val(msg[0].staffno);
                       $("#dno").val(msg[0].dno);
                       $("#staffname").val(msg[0].staffname);
                       $("#sex").val(msg[0].sex);
                       $("#duty").val(msg[0].duty);
                       $("#mobilephone").val(msg[0].mobilephone);
                       $("#age").val(msg[0].age);
                   }
                });
           });
       </script>
    <script>
         $(document).ready(function(){
             $("#mybtn").click(function(){
                   $.ajax({
                       url:"Updatestaff",
                       type:"get",
                       data:$("#myform").serialize(),
                       success:function(msg){
                              console.log(msg);
                            if(msg==0)
                               window.alert("修改职员信息失败"+msg);
                            else
                               window.alert("修改职员信息成功"+msg);
                       },
                       error:function(msg){
                             if(msg==0)
                               window.alert("修改职员信息失败"+msg);
                            else
                               window.alert("修改职员信息成功"+msg);
                      }
                   });
             });
         });
    </script>
  </body>
</html>
