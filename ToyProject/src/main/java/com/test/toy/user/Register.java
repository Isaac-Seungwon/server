package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/register.do")
public class Register extends HttpServlet {

	//Get 방식과 Post 방식을 함께 만들어서 서블릿 파일 하나로도 두 개의 연결이 가능하다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Register.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//RegisterOk.java 역할
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 피드백
		
		//req.getParameter() 동작 불가능 > MultipartRequest 대체
		//multipart/form-data로 호출했기 떄문에 req.getParameter()가 동작하지 않는다.
		//대신에 cos.jar 안에 들어있는 MultipartRequest로 대체한다.
		try {
			
			MultipartRequest multi = new MultipartRequest(
										req, //Request
										req.getRealPath("/asset/pic"), //업로드 폴더 경로
										1024 * 1024 * 10, //파일의 크기
										"UTF-8", //인코딩 방식을 바꾸기 때문에 따로 한글 처리를 하지 않아도 된다.
										new DefaultFileRenamePolicy()
									);
			//System.out.println(req.getRealPath("/asset/pic"));
			//사진 저장 경로 확인
			
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String pic = multi.getFilesystemName("pic"); //사진은 geteParameter로 가져오지 않으며, 파일 이름으로 가져와야 한다.
			String intro = multi.getParameter("intro");
			
			//System.out.println(intro);
			
			UserDTO dto = new UserDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setEmail(email);
			
			//사진
			if (pic != null && !pic.equals("")) {
				dto.setPic(pic);
			} else {
				dto.setPic("pic.png");
			}
			
			dto.setIntro(intro);
			
			UserDAO dao = new UserDAO();
			
			int result = dao.register(dto);
			
			if (result == 1) {
				resp.sendRedirect("/toy/index.do");
			}			
			
		} catch (Exception e) {
			System.out.println("Register.doPost()");
			e.printStackTrace();
		}
		
		//0 또는 에러
		PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();		
		
	}

}


























