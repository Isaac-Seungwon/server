package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_Send extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Insert title here</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>데이터 전송</h1>"
				+ "	"
				+ "	<form method=\"POST\" action='/servlet/receive.do'> <!-- action: 데이터를 수신할 프로그램 URL -->"
				+ "		<div>"
				+ "			이름: <input type=\"text\" name=\"name\">"
				+ "		</div>"
				+ "		<div>"
				+ "			나이: <input type=\"text\" name=\"age\">"
				+ "		</div>"
				+ "		<input type=\"submit\" value=\"보내기\">"
				+ "	</form>"
				+ "</body>"
				+ "</html>");
		
		writer.close();
	}
}
