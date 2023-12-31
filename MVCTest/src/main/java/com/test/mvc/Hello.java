package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Servlet을 호출해서 업무를 처리한다
		//HTML에서 페이지를 생산하는 게 불편하기 때문에 JSP에 위임한다.
		//resp.sendRedirect("/mvc/hello.jsp");
		
		//DB작업에서 select count(*)
		int count=100;
		
		//서블릿이 자신의 업무를 완료하고 산출물의 일부를 출력하는데 JSP 페이지 전달한다.
		req.setAttribute("count", count);
		
		//resp.sendRedirect("/mvc/hello.jsp");
		//pageContext.forward("/mvc/hello.jsp");
		
		//'/'는 webapp를 의미한다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp); //pageContext.forward();
	}
}
