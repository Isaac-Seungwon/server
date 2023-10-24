<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 지역 변수 > 실패
	int a = 10;

	/* 자바로 페이지 이동 */
	//response.sendRedirect("ex19_scope_2.jsp?a=" + a);
	
	//3. pageContext객체 > 실패
	pageContext.setAttribute("c", 30);
	
	//4. requesst 객체
	request.setAttribute("d", 40);

	//5. session 객체
	session.setAttribute("e", 50);
	
	//6. application 객체
	application.setAttribute("f", 60);
	
	//response.sendRedirect("ex19_scope_2.jsp");
	
	pageContext.forward("ex19_scope_2.jsp?");
%>

<%!
	//2. 멤버 변수 > 실패
	int b = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	
</style>
</head>
<body>
	<h1>첫 번째 페이지</h1>
	
	<!-- 클라이언트 코드로 페이지 이동 -->
	<!-- 1 링크로 이동 -->
	<a href="ex19_scope_2.jsp?a=<%= a %>">두 번째 페이지</a>
	<hr>
	
	<!-- 2 자바스크립트로 이동 -->
	<input type="button" value="두 번째 페이지" id="btn1">
	<hr>
	
	<!-- 3 폼을 통한 이동 -->
	<form method="GET" action="ex19_scope_2.jsp">
		<input type="hidden" name="a" value="<%= a %>">
		<input type="submit" value="두 번째 페이지">
	</form>

	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$('#btn1').click(function() {
			location.href = 'ex19_scope_2.jsp?a=<%= a %>';
		});
	</script>
</body>
</html>