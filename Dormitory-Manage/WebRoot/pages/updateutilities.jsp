<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改水电费信息</title>
    
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
         String struno=request.getParameter("uno");
         int uno=Integer.parseInt(struno); 
      %>
    <form id="myform" >
          <div class="form-group" hidden>
              <label class="control-label" for="uno">uno:</label>
              <input class="form-control" type="text" id="uno" name="uno">
           </div>
           <div class="form-group">
              <label class="control-label" for="dno">dno:</label>
              <input class="form-control" type="text" id="dno" name="dno">
           </div>
           <div class="form-group">
              <label class="control-label" for="month">month:</label>
              <input class="form-control" type="text" id="month" name="month">
           </div>
           <div class="form-group">
              <label class="control-label" for="wcost">wcost:</label>
              <input class="form-control" type="text" id="wcost" name="wcost">
           </div>
           <div class="form-group">
              <label class="control-label" for="ecost">ecost</label>
              <input class="form-control" type="text" id="ecost" name="ecost">
           </div>
           <button class="btn btn-primary" id="mybtn" type="button">submit</button>
       </form>
       <script type="text/javascript" src="./js/jquery.min.js"></script>
       <script type="text/javascript" src="./bootstrap/js/bootstrap.js"></script>
        <script>
             $(document).ready(function(){
                $.ajax({
                   url:"Returnutilities",
                   data:"uno=<%=uno%>",
                   type:"get",
                   dataType:"json",
                   async:false,
                   success:function(msg){
                       console.log(msg);
                       $("#uno").val(msg[0].uno);
                       $("#dno").val(msg[0].dno);
                       $("#month").val(msg[0].month);
                       $("#wcost").val(msg[0].wcost);
                       $("#ecost").val(msg[0].ecost);
                   }
                });
           });
       </script>
       <script type="text/javascript">
           $(document).ready(function(){
               $("#mybtn").click(function(){
                   $.ajax({
                      url:"Updateutilities",
                      data:$("#myform").serialize(),
                      type:"get",
                      success:function(msg){
                            console.log(msg);
                         if(msg==0)
                            window.alert("修改水电费信息失败");
                         else
                            window.alert("修改水电费信息成功");
                      },
                      error:function(msg){
                         if(msg==0)
                            window.alert("修改水电费信息失败");
                         else
                            window.alert("修改水电费信息成功");
                      }
                   });
               });
           });
       </script>
  </body>
</html>
