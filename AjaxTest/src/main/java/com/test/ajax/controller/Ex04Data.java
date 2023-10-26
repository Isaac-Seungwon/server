package com.test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ajax.model.MemoDTO;
import com.test.ajax.repository.AjaxDAO;

@WebServlet("/ex04data.do")
public class Ex04Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Ex04Data.java

		// ex04data.do?type=1

		String type = req.getParameter("type");

		if (type.equals("1")) {
			m1(req, resp);
		} else if (type.equals("2")) {
			m2(req, resp);
		} else if (type.equals("3")) {
			m3(req, resp);
		} else if (type.equals("4")) {
			m4(req, resp);
		} else if (type.equals("5")) {
			m5(req, resp);
		} else if (type.equals("6")) {
			m6(req, resp);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex04data.jsp");

		dispatcher.forward(req, resp);
	}
	
	private void m6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		JSON 객체
		{
			"seq": "5"
			"name": "Isaac",
			"pw": "1111",
			"memo": "메모입니다.",
			"regdate": "2023-10-26 09:40:00"
		}
		
		자바스크립트 배열
		[
			10
			,
			20
		]
		
		{
			"seq": "5"
			"name": "Isaac",
			"pw": "1111",
			"memo": "메모입니다.",
			"regdate": "2023-10-26 09:40:00"
		}
		*/
		
		
		AjaxDAO dao = new AjaxDAO();
		ArrayList<MemoDTO> list = dao.listMemo();

		resp.setContentType("application/json"); //MIME
		resp.setCharacterEncoding("UTF-8");

		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		
		temp += "[";
		
		for (MemoDTO dto : list) {
			temp += "{";
			temp += String.format("\"seq\":\"%s\",", dto.getSeq());
			temp += String.format("\"name\":\"%s\",", dto.getName());
			temp += String.format("\"pw\":\"%s\",", dto.getPw());
			temp += String.format("\"memo\":\"%s\",", dto.getMemo().replace("\r\n", "\\r\\n"));
			temp += String.format("\"regdate\":\"%s\"", dto.getRegdate());
			temp += "}";
			temp += ",";
		}

		temp = temp.substring(0, temp.length() - 1);
		
		temp += "]";
		
		writer.print(temp);
		
		writer.close();
	}

	private void m5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		JSON 객체
		{
			"seq": "5"
			"name": "Isaac",
			"pw": "1111",
			"memo": "메모입니다.",
			"regdate": "2023-10-26 09:40:00"
		}
		
		*/
		
		AjaxDAO dao = new AjaxDAO();
		MemoDTO dto = dao.get(1);
		//데이터베이스에서 데이터를 가져오고, 미리 만들어 둔 get 메서드로 메모를 하나 출력한다.
		//이제 메모를 JSON 객체로 만들어서 돌려주도록 하자.
		
		resp.setContentType("application/json"); //MIME
		resp.setCharacterEncoding("UTF-8");
		//이 데이터가 JSON이라는 것을 알려 주어야 한다.
		//그리고 인코딩 타입을 UTF-8로 지정해준다.
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("{");
		writer.printf("\"seq\":\"%s\",", dto.getSeq());
		writer.printf("\"name\":\"%s\",", dto.getName());
		writer.printf("\"pw\":\"%s\",", dto.getPw());
		writer.printf("\"memo\":\"%s\",", dto.getMemo());
		writer.printf("\"regdate\":\"%s\"", dto.getRegdate());
		writer.println("}");
		
		writer.close();
		
	}
	
	private void m4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//XML > 여러 개의 메모 > MemoDTO x 3개
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<MemoDTO> list = dao.listMemo();
		
		resp.setContentType("text/xml");
		//브라우저는 ContentType으로 데이터를 믿기 때문에 XML이라는 것을 알려 주어야한다.
		
		resp.setCharacterEncoding("UTF-8");
		//한글이 꺠지지 않도록 한다.
		
		PrintWriter writer = resp.getWriter();
		//XML을 동적으로 만드는 작업이기 때문에 Wrtier를 가지고 만든다.
		
		//list를 XML 형식의 문자열로 출력 작업을 한다.
		writer.print("<?xml version='1.0' encoding='UTF-8'?>");//XML 선언문을 만든다. //그리고 내가 만들고 싶은 태그 작업을 한다.
		/*
		writer.println("<memo>");
		writer.printf("<seq>%s</seq>", 10);
		writer.println("</memo>");
		*/
		//메모라는 루트 태그를 만들고, 그 안에 집어 넣어야 할 값들을 하위 태그로 만들어서 그 태그에 해시 데이터를 넣었었다.

		writer.println("<list>");
		
		for (MemoDTO dto: list) {
			writer.println("<memo>");
			writer.printf("<seq>%s</seq>", dto.getSeq());
			writer.printf("<name>%s</name>", dto.getName());
			writer.printf("<pw>%s</pw>", dto.getPw());
			writer.printf("<memo>%s</memo>", dto.getMemo());
			writer.printf("<regdate>%s</regdate>", dto.getRegdate());
			writer.println("</memo>");
		}

		writer.println("</list>");
		//이번에는 이 작업을 여러 개를 해야 한다. for문으로 루프를 돌려서 메모를 하나 출력하는 작업을 여러 번 할 수 있다.
		//그런데 그냥 실행하면 오류가 발생한다. 모든 마크업 언어(ML)은 최상위 태그가 유일해야 하는데, 루트 Element가 여러 개 이기 때문이다.
		//그래서 바깥에 루트가 되어 전체를 감싸는 <list> 태그를 만들어 주어야 한다. 이러면 XML로써 문제가 전혀 없다.
		
		writer.close();
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AjaxDAO dao = new AjaxDAO();

		MemoDTO dto = dao.get(1);

		// MemoDTO > (XML 형식) > ajax

		// resp.setContentType("text/html");
		// resp.setContentType("application/zip");
		// resp.setContentType("text/plane");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");

		PrintWriter writer = resp.getWriter();

		writer.print("<?xml version='1.0' encoding='UTF-8'?>");
		writer.print("<memo>");
		writer.printf("<seq>%s</seq>", dto.getSeq());
		writer.printf("<name>%s</name>", dto.getName());
		writer.printf("<pw>%s</pw>", dto.getPw());
		writer.printf("<memo>%s</memo>", dto.getMemo());
		writer.printf("<regdate>%s</regdate>", dto.getRegdate());
		writer.print("</memo>");

		writer.close();
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    AjaxDAO dao = new AjaxDAO();
	    ArrayList<MemoDTO> list = dao.listMemo();
	    
	    // CSV
	    StringBuilder csv = new StringBuilder();
	    for (MemoDTO dto : list) {
	        csv.append(String.format("%s,%s,%s,%s,%s\r\n", dto.getSeq(), dto.getName(), dto.getPw(),
	                dto.getMemo().replace("\r\n", "\n"), dto.getRegdate()));
	    }
	    
	    resp.setContentType("text/plain");
	    resp.setCharacterEncoding("UTF-8");
	    
	    PrintWriter writer = resp.getWriter();
	    writer.print(csv.toString());
	    writer.close();
	}

	/*
	 * private void m2(HttpServletRequest req, HttpServletResponse resp) throws
	 * ServletException, IOException {
	 * 
	 * AjaxDAO dao = new AjaxDAO();
	 * 
	 * ArrayList<MemoDTO> list = dao.listMemo();
	 * 
	 * // CSV String temp = "";
	 * 
	 * for (MemoDTO dto : list) { temp += String.format("%s,%s,%s,%s,%s\r\n",
	 * dto.getSeq(), dto.getName(), dto.getPw(), dto.getMemo().replace("\r\n",
	 * "\n"), dto.getRegdate()); }
	 * 
	 * // System.out.println(temp);
	 * 
	 * resp.setContentType("text/plain"); resp.setCharacterEncoding("UTF-8");
	 * 
	 * PrintWriter writer = resp.getWriter(); writer.print(temp); writer.close();
	 * 
	 * }
	 */
	
	private void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 텍스트 반환(단일값)
		AjaxDAO dao = new AjaxDAO();
		int count = dao.getMemoCount();

		// MIME > 브라우저(or ajax객체)에게 네가 돌려받는 데이터가 이런 형식의 데이터다.. 라고 알려주는 표시
		resp.setContentType("text/plain"); // 순수 텍스트 데이터
		resp.setCharacterEncoding("UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.print(count);
		writer.close();

	}
}