package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/view.do")
public class View extends HttpServlet {

	//View.java
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(); //세션 꺼내기
		
		//1. 글번호 가져오기
		String seq = req.getParameter("seq");
		
		
		//2. DB작업
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.get(seq);
		
		if (session.getAttribute("read") != null
				&& session.getAttribute("read").toString().equals("n")) {
			//2.3 조회수 증가
			dao.updateReadcount(seq);
			
			//F5를 눌러도 session이 만료되지 않았기 때문에 조회수가 증가하지 않음
			session.setAttribute("read", "y");
		}
		
		//2.5 데이터 조작
		String content = dto.getContent();
		
		//태그 비활성화
		//<div> -> &lt;div&gt;
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		
		//개행 문자 처리
		content = content.replace("\r\n", "<br>");
			
		dto.setContent(content);
		
		//view 처리
		String subject = dto.getSubject();

		subject = subject.replace("<", "&lt;");
		subject = subject.replace(">", "&gt;");

		dto.setSubject(subject);
		
		
		//3. 데이터 넘겨주기
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
		dispatcher.forward(req, resp);
	}

}