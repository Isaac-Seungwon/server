package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_Receive extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);

		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Insert title here</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>데이터 수신</h1>"
				+ "	"
				+ "	<p>데이터 처리가 완료되었습니다.</p>"
				+ "</body>"
				+ "</html>");
		
		writer.close();
	}
}
