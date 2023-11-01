package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/unregister.do")
public class Unregister extends HttpServlet {

	//Unregister.java
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/unregister.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//UnregisterOk.java
		
		//회원 탈퇴
		//회원 탈퇴는 delete가 아니라 update이다.
		//어떤 사람이 구매한 구매 이력을 지우는 것과 같다. 어떤 사람이 생산해낸 모든 산출물은 그 사람이 나간다고 해서 반드시 없애야 하는 게 아니다.
		//어떤 데이터고, 사이트의 정책이 어떻게 되어 있고, 사용자에게 어떤 동의, 약관을 받았는지에 따라서 달라진다.
		
		//1.
		String id = req.getSession().getAttribute("id").toString();
		//인증 티켓은 세션 안에 있다. 이 사람을 탈퇴시키면 된다.
		//이제 DB 작업을 한다.
		
		//2.
		UserDAO dao = new UserDAO();
		
		int result = dao.unregister(id);
		
		//3.
		if (result == 1) {
			//회원 탈퇴 + 로그아웃

			//물리적인 회원 탈퇴는 끝난 상태이다.
			//탈퇴를 하면 세션을 뒤져서 주었던 인증 티켓을 회수한다. (로그아웃 시킨다)
			req.getSession().removeAttribute("id");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("lv");
			
			resp.sendRedirect("/toy/index.do");
		} else {
			//회원 탈퇴 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();		
		}
		
	}
}