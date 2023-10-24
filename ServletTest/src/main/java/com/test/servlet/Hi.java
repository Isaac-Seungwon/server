package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hi extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		Calendar now = Calendar.getInstance();
		
		writer.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Insert title here</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>Hello</h1>"
				+ "	<p>안녕하세요</p>"
				+ "	<p id=\"time\">" + String.format("%tT", now)
				+ "</p>"
				+ "</body>"
				+ "</html>");
		
		writer.close();
	}
}