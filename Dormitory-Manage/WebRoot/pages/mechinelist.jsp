<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>租赁设备列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./css/DT_bootstrap.css">
  </head>
  
  <body>
    <%@include file="navigation.jsp" %>
    <h1 class="text-center"><b>租赁设备列表</b></h1>
    <button class="btn btn-primary" id="gotobtn">添加租赁设备信息</button>
    <table class="table table-bordered" id="mytable"></table>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./js/jquery.dataTables.js"></script>
    <script src="./js/dtInit.js"></script>
    <script>
         $(document).ready(function(){
               $("#gotobtn").click(function(){
                     location.href="./pages/addmechine.jsp";
               });
         });
         function todelete(mno){
               $.ajax({
                   url:"Deletemechine",
                   type:"get",
                   data:"mno="+mno,
                   async:false,
                   success:function(msg){
                        location.reload();
                   },
                   error:function(msg){
                        location.reload();
                   }
               });
         };
         function toupdate(mno){
               location.href="./pages/updatemechine.jsp?mno="+mno;
         };
    </script>
    <script>
         var tbody="";
         tbody+="<thead>";
         tbody+="<tr>";
         tbody+="<th>mno</th>";
         tbody+="<th>mname</th>";
         tbody+="<th>sdate</th>";
         tbody+="<th>fdate</th>";
         tbody+="<th>cost</th>";
         tbody+="<th>操作</th>";
         tbody+="</tr>";
         tbody+="</thead>";
         $(document).ready(function(){
              $.ajax({
                 url:"Returnmechinelist",
                 type:"get",
                 dataType:"json",
                 async:false,
                 success:function(msg){
                    console.log(msg);
                    tbody+="<tbody>";
                    for(var i=0;i<msg.length;i++){
                          tbody+="<tr>";
                          tbody+="<td>"+msg[i].mno+"</td>";
                          tbody+="<td>"+msg[i].mname+"</td>";
                          tbody+="<td>"+msg[i].sdate+"</td>";
                          tbody+="<td>"+msg[i].fdate+"</td>";
                          tbody+="<td>"+msg[i].cost+"</td>";
                          tbody+="<td><button class='btn btn-info' onclick='toupdate("+msg[i].mno+")'>修改</button>"
                          tbody+="<button class='btn btn-danger' onclick='todelete("+msg[i].mno+")'>删除</button></td>";
                          tbody+="</tr>";
                    }
                    tbody+="</tbody>";
                    $("#mytable").html(tbody);
                 }
              });
         });
         $(function () {
				$("#mytable").dataTable();  
			});
    </script>
  </body>
</html>
