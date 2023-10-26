package com.test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex03data.do")
public class Ex03Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 보내기
		String name = req.getParameter("name");
		
		
		//데이터 가져오기
		AjaxDAO dao = new AjaxDAO();
		
		//int count = dao.getMemoCount();
		int count = dao.getMemoCount(name);
		
		
		try {
			
			//작업에 시간이 걸림..
			//Thread.sleep(10000);
			
		} catch (Exception e) {
			System.out.println("Ex03Data.doGet()");
			e.printStackTrace();
		}
		
		
		PrintWriter writer = resp.getWriter();
		writer.print(count);
		writer.close();
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex03data.jsp");
		//dispatcher.forward(req, resp);
	}

}