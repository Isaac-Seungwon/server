package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	//List.java
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. DB 작업 > select
		//2. 반환 > JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//조회수 티켓
		session.setAttribute("read", "n");
		
		
		//1.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list();
		//java.util.List<BoardDTO> list = dao.list();
		//게시판 목록을 달라고 호출을 하는데, 이를 ArrayList의 <BoardDTO>로 받아온다.
		//계층과 계층간의 데이터를 주고받을 때 interface 타입을 쓰는 게 좋아서 List를 사용했었다.
		//List를 사용해도 제네릭 클래스(인터페이스)를 의미하기 때문에 상관은 없지만, 클래스 이름이 List인 경우 혼동할 수 있다
		//가장 나은 방법은 ArrayList를 사용하는 방법이다. 처음에 클래스 이름을 List로 하지 않는 것이 좋았다.
		
		//1.5 데이터 가공
		//데이터 가공을 위해서 dto를 하나씩 다시 꺼낸다.
		for (BoardDTO dto : list) {
			
			//날짜 자르기 (년월일)
			//String regdate = dto.getRegdate();
			
			//regdate.substring(0, 10); //2023-10-31 10글자를 가져온다.
			//dto.setRegdate(regdate.substring(0, 10)); //덮어쓰기
		
			String subject = dto.getSubject();

			//제목 길이 자르기
			if (subject.length() > 23) {
				subject = subject.substring(0, 23) + "..";
			}
			
			subject = subject.replace("<", "&lt;");
			subject = subject.replace(">", "&gt;");

			dto.setSubject(subject);
			
		}
		
		//2.
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}