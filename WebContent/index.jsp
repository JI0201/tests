<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(location).attr('href', '/JavaWebTest2/BookServlet?status=findBookAll')
	})
		
	

</script>
<body>

</body>
</html>