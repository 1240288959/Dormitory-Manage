<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工列表</title>
    
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
    <h1 class="text-center"><b>员工列表</b></h1>
    <button class="btn btn-primary" id="gotobtn">添加员工信息</button>
    <table class="table table-bordered" id="mytable"></table>
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./js/jquery.dataTables.js"></script>
    <script src="./js/dtInit.js"></script>
    <script>
         $(document).ready(function(){
               $("#gotobtn").click(function(){
                     location.href="./pages/addstaff.jsp";
               });
         });
          function todelete(staffno){
               $.ajax({
                   url:"Deletestaff",
                   type:"get",
                   data:"staffno="+staffno,
                   async:false,
                   success:function(msg){
                        location.reload();
                   },
                   error:function(msg){
                        location.reload();
                   }
               });
         };

         function toupdate(staffno){
               location.href="./pages/updatestaff.jsp?staffno="+staffno;
         };
    </script>
    <script>
          var tbody="";
          tbody+="<thead>";
          tbody+="<tr>";
          tbody+="<th>staffno</th>";
          tbody+="<th>dno</th>";
          tbody+="<th>staffname</th>";
          tbody+="<th>sex</th>";
          tbody+="<th>duty</th>";
          tbody+="<th>mobilephone</th>";
          tbody+="<th>sex</th>";
          tbody+="<th>操作</th>";
          tbody+="</tr>";
          tbody+="</thead>";
          
          $(document).ready(function(){
               $.ajax({
                  url:"Returnstafflist",
                  type:"get",
                  dataType:"json",
                  async:false,
                  success:function(msg){
                     console.log(msg);
                     tbody+="<tbody>";
                     for(var i=0;i<msg.length;i++){
                        tbody+="<tr>";
                        tbody+="<td>"+msg[i].staffno+"</td>";
                        tbody+="<td>"+msg[i].dno+"</td>";
                        tbody+="<td>"+msg[i].staffname+"</td>";
                        tbody+="<td>"+msg[i].sex+"</td>";
                        tbody+="<td>"+msg[i].duty+"</td>";
                        tbody+="<td>"+msg[i].mobilephone+"</td>";
                        tbody+="<td>"+msg[i].age+"</td>";
                        tbody+="<td><button class='btn btn-info' onclick='toupdate("+msg[i].staffno+")'>修改</button>"
                        tbody+="<button class='btn btn-danger' onclick='todelete("+msg[i].staffno+")'>删除</button></td>";
                        tbody+="</tr>"
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
