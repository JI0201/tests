<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
	
	}
	td{
	width:80px;
	text-align:center;
	border: 1px solid black;
	}
	table tr:nth-child(odd) {
	background-color: lightyellow;
	}
	table tr:nth-child(even) {
	background-color: lightblue;
	}

</style>
<body>
<div style="margin-top: 100px;margin-left: 530px;">

<table cellpadding="0" cellspacing="0">
	<tr style="background-color: lightgreen;">
		<td>书籍</td>
		<td>作者</td>
		<td>购买时间</td>
		<td>类型</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="i">
		<tr>
			<td>${i.name }</td>
			<td>${i.author }</td>
			<td>${i.time }</td>
			<c:choose>
				<c:when test="${i.type==1 }">
					<td>计算机/软件</td>
				</c:when>
				<c:when test="${i.type==2 }">
					<td>小说/文摘</td>
				</c:when>
				<c:otherwise>
					<td>杂项</td>
				</c:otherwise>
			</c:choose>
			<td><a href="${pageContext.request.contextPath }/BookServlet?status=deleteBook&id=${i.id}">删除</a></td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/pages/insertBook.jsp">添加图书</a>
</div>


</body>
</html>