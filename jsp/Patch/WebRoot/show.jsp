<%@ page language="java" import="java.util.*,com.ckt.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int pageNo = Query.currPage();
int pageSn = Query.totalPages();
ArrayList<PatchDeployment> ls = (ArrayList<PatchDeployment>) request.getAttribute("list");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="styles.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript"> 
	</script>

  </head>
  <body>
  	<a href="new.jsp"><font size=2>新建</font></a>
  	<center>
  		<table id="mytb" cellspacing="0" border="0" onclick="changeEdit()">
  		<tr>
  			<td>Idpatch_deployment</td>
  			<td>Idpatch</td>
  			<td>Project</td>
  			<td>Internal_bug_id</td>
  			<td>状态</td>
  			<td>修改</td>
  			<td>删除</td>
  			<td>保存</td>
  		</tr>
  		<%
  		for (int i=0; i<ls.size(); i++)
  		{
  		%>
  		<tr>
  			<td><%=ls.get(i).getIdpatch_deployment()%></td>
  			<td><%=ls.get(i).getIdpatch()%></td>
  			<td><%=ls.get(i).getProject()%></td>
  			<td><%=ls.get(i).getInternal_bug_id()%></td>
  			<td>
  				<select name="sta">
  					<option value="open">开启</option>
  					<option value="close">关闭</option>
  				</select>
  			</td>
  			<td><button type="button">修改</button></td>
  			<td><a href="deleteServlet?page=<%=ls.get(i).getIdpatch_deployment()%>">删除</a></td>
  			<td><a href="modifyServlet">保存</a></td>
  		</tr>
  		<%
  		}
  		%>
  		</table>
  		<br>
  		<a href="showServlet?page=<%=pageNo==1?1:pageNo-1 %>"><font size=2>上一页</font></a>
		<a href="showServlet?page=<%=pageNo==pageSn?pageSn:pageNo+1 %>"><font size=2>下一页</font></a>
  	</center>
</body>
</html>
