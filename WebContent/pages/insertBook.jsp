<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top: 100px;margin-left: 680px;">
<form action="${pageContext.request.contextPath }/BookServlet?status=insertBook" method="post">
		名称：<input type="text" name="name" ><br>
		作者：<input type="text" name="author"  ><br>
		购书时间：<input type="text" name="time"  ><br>
		书本类型：<select name="type">
				<option value="1">计算机/软件</option>
				<option value="2">小说/文摘</option>
				<option value="3">杂项</option>
		</select>
		<input type="submit" value="提交">
	</form>
</div>
	
	
</body>
</html>