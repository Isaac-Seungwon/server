package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
//b. javax.servlet.http.HttpServlet
public class Ex01 extends HttpServlet {

	// 메서드 및 매개변수 선언, 예외 미루기
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("<style>");
		writer.println("h1 { color: 'cornflowerblue'; }");
		writer.println("</style>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Hello</h1>");
		writer.println("<p>Servlet으로 페이지 생성</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close(); // 일종의 스트림
	}
}