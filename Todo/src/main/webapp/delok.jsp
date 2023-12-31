<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 데이터 가져오기(seq)
	String seq = request.getParameter("seq");

	//2. DB 작업
	Connection conn = null;
	PreparedStatement stat = null;

	try {
		
		conn = DBUtil.open();
		
		String sql = "DELETE FROM tblTodo WHERE seq = ?";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, seq);
		
		int result = stat.executeUpdate();
		
		if (result == 1) {
			response.sendRedirect("list.jsp");
		} else {
			out.println("<script>");
			out.println("alert('실패');");
			out.println("location.href = 'list.jsp';");
			out.println("</script>");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="inc/asset.jsp" %>
</head>
<body class="narrow">
	<%@ include file="inc/header.jsp" %>
</body>
</html>