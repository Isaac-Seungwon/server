<%@page import="com.test.jsp.Score"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>EL</h1>
	
	<%
		int a = 10;
		pageContext.setAttribute("b", 20);
		request.setAttribute("c", 30);
	%>
	
	<%-- <h2>표현식</h2>
	<div>a: <%= a %></div>
	<div>b: <%= pageContext.getAttribute("b") %></div>
	<div>c: <%= request.getAttribute("c") %></div>
	
	<h2>EL</h2>
	<div>a: ${a}</div>
	<div>b: ${b}</div>
	<div>c: ${c}</div> --%>
	
	<%-- <div>b: ${pageContext.getAttribute("b")}</div> --%>
	<%-- <div>c: ${request.getAttribute("c")}</div> --%>
	
	<!-- <h3>EL 연산 기능</h3> -->
	<%-- <%-- <div>b + 10 = ?</div>
	<div>b + 10 = <%= (int)pageContext.getAttribute("b") + 10 %></div>
	<div>b + 10 = ${b} + 10</div>
	<div>b + 10 = ${b + 10}</div>
	<div>b + 10 = ${b + 10}</div>
	<div>b - 10 = ${b - 10}</div>
	<div>b * 10 = ${b * 10}</div>
	<div>b / 10 = ${b / 10}</div>
	<div>b % 10 = ${b % 10}</div>
	<div>b mod 10 = ${b mod 10}</div>
	
	<hr>
	
	<div>b &gt; 10 = ${b > 10}</div>
	<div>b &gt; 10 = ${b gt 10}</div>
	<div>b &lt; 10 = ${b < 10}</div>
	<div>b &lt; 10 = ${b lt 10}</div>
	<div>b &gt;= 10 = ${b >= 10}</div>
	<div>b &gt;= 10 = ${b ge 10}</div>
	<div>b == 20 = ${b == 20}</div>
	<div>b == 20 = ${b eq 20}</div>
	<div>b != 20 = ${b != 20}</div>
	<div>b != 20 = ${b ne 20}</div>
 --%>
 	
	<%-- <div>${true && true}</div>
	<div>${false || true}</div>
	<div>${!true}</div>
	
	<div>${true and true}</div>
	<div>${false or true}</div>
	<div>${not true}</div>
 	<hr>
 	<div>${b > 0 ? "양수" : "음수"}</div>
 	<hr>
 	<div>${"문자열".equals("문자열")}</div>
 	<div>${"문자열" == "문자열"}</div>
 	<div>${"문자열" == '문자열'}</div> --%>
 	
	<%-- <%
		HashMap<String,Integer> score = new HashMap<String,Integer>();
		score.put("kor", 100);
		score.put("eng", 90);
		score.put("math", 80);
		
		pageContext.setAttribute("score", score);
	%>
	
	<h3>객체 출력 (HashMap)</h3>
	<div>국어: <%= score.get("kor") %></div>
	<div>영어: <%= score.get("eng") %></div>
	<div>수학: <%= score.get("math") %></div>
	
	<div>국어: ${score.get("kor")}</div> <!-- 사용X -->
	<div>영어: ${score["eng"]}</div>
	<div>수학: ${score.math}</div>
 	
 	<hr> --%>
 	
 	<%-- <%
 		Score score = new Score();
 	
 		score.setKor(95);
 		score.setEng(80);
 		score.setMath(90);
 		
		pageContext.setAttribute("score", score);
 	%>
 	
 	<h3>객체 출력 (일반 객체)</h3>
 	<div>국어: <% %></div>
 	<div>국어: ${score.getKor()}</div>
 	<div>영어: ${score.["eng"]}</div>
 	<div>수학: ${score.math}</div>
 	
 	<div>총점: ${score.kor + score.eng + score.math}</div> --%>
 	
 	<%
 		pageContext.setAttribute("color", "tomato");
		request.setAttribute("color", "gold");
 		session.setAttribute("color", "cornflowerblue");
 		application.setAttribute("color", "yellowgreen");
 	%>
 	
 	<div style="background-color:${color};">${color}</div>
 	<div style="background-color:${requestScope.color};">${color}</div>
 	<div style="background-color:${sessionScope.color};">${color}</div>
 	<div style="background-color:${applicationScope.color};">${color}</div>
 	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
	</script>
</body>
</html>