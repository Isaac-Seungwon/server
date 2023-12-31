<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
		
		String sql = "";
		
		//state에 y가 들어있는지 n가 들어있는지 확인
		sql = "SELECT state FROM tblTodo WHERE seq = ?";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, seq);
		
		ResultSet rs = stat.executeQuery();
		String state = "";
		
		if (rs.next()) {
			state = rs.getString("state");
		}

		//토글 버튼
		//n 이면 y로 변경
		//y 이면 n로 변경
		if (state.equals("n")) {
			state = "y";
		} else {
			state = "n";
		}
		
		sql = "UPDATE tblTodo SET state = ? WHERE seq = ?";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, state); //첫 번째 ?에 state 삽입
		stat.setString(2, seq); //두 번째 ?에 seq 삽입
		
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