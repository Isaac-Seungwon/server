package com.test.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.model.ChromiDTO;
import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex07data.do")
public class Ex07Data extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String chromiId = req.getParameter("chromiId");
		
		AjaxDAO dao = new AjaxDAO();
		
		ChromiDTO dto = new ChromiDTO();
		
		dto.setX(x);
		dto.setY(y);
		dto.setChromiId(chromiId);
		
		dao.updatePosition(dto);
	}

}