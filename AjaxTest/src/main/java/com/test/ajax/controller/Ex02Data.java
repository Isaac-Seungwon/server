package com.test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex02data.do")
public class Ex02Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int n = 0;
		
		System.out.println(100 / n);
		
		AjaxDAO dao = new AjaxDAO();
		
		int count = dao.getMemoCount();
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(count);
		
		writer.close();
		
		//req.setAttribute("count", count);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex02data.jsp");
		//dispatcher.forward(req, resp);
	}

}