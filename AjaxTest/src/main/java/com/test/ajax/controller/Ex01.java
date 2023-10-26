package com.test.ajax.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01.do")
public class Ex01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ex01.do?count=0
		
		String count = req.getParameter("count");
		
		req.setAttribute("count", count);
		
		//count값을 받은 다음에 눈에 보이는 jsp에서 써야 하기 때문에 request에 담아서 넣는다.
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex01.jsp");
		dispatcher.forward(req, resp);
	}

}