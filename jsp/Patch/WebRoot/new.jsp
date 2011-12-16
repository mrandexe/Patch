<%@ page language="java" import="java.util.*, com.ckt.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">

  </head>
  
  <body>
  <center>
  	<form action="newServlet" method="post">
  		<table id="mytb" cellspacing="0" border="0">
  			<tr>
  				<td>Idpatch_deployment</td>
  				<td>Idpatch</td>
  				<td>Project</td>
  				<td>Internal_bug_id</td>
  				<td>状态</td>
  			</tr>
  			<tr>
  				<td><input type="text" name="dep"></input></td>
				<td><input type="text" name="idp"></input></td>
				<td><input type="text" name="pro"></input></td>
				<td><input type="text" name="bug"></input></td>
				<td>
					<select name="sta">
  						<option value="open">开启</option>
  						<option value="close">关闭</option>
  					</select>
  				</td>
  			</tr>
  		</table>
  		
  			<button type="submit">保存</button>
  			<button type="reset">重置</button>
  	</form>
</center>
  </body>
</html>
