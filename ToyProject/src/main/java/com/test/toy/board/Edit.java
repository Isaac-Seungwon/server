package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

	//Edit.java

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//view.do에서 수정하기 버튼을 클릭하면 location.href로 edit?do로 가되, seq를 넘긴다. edit?seq=?
		//1. 데이터 가져오기 (seq)
		//2. DB 작업 > select
		//3. 결과 + JSP 호출하기
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.get(seq);
		
		String subject = dto.getSubject();
		
		// " > \ "
		//subject = subject.replace("\"", "\\\"");
		subject = subject.replace("\"", "&quot;");
		dto.setSubject(subject);
		
		//3.
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//EditOk.java 역할
		
		//1. 데이터 가져오기
		//2. DB 작업 > update
		//3. 피드백
		
		HttpSession session = req.getSession(); //사용하기 편하게 세션을 미리 저장해둔다.
		//글 쓸 때 뿐만 아니라 수정할 때도 아이디가 필요하므로 session을 저장한다.
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String seq = req.getParameter("seq"); //수정할 글번호
		
		//2.
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(session.getAttribute("id").toString()); //세션 사용
		dto.setSeq(seq); //수정할 글번호
		
		int result = dao.edit(dto);
		
		//3.
		if (result == 1) {

			//글 작성 성공
			resp.sendRedirect("/toy/board/view.do?seq=" + seq);
			
		} else {
			//글 작성 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}