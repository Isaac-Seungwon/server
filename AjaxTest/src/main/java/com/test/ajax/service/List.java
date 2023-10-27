package com.test.ajax.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.test.ajax.model.AddressDTO;
import com.test.ajax.repository.AjaxDAO;

@WebServlet("/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//요청을 받으면 업무를 보기 때문에 service 패키지에 많이 작성하는 편이다.

		//1. DB 작업 > select
		//2. 반환 > json 변환 > ajax에게 반환

		//1.
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<AddressDTO> list = dao.listAddress();
		
		//2.
		//list > json 변환
		/*
			[
				{
					"seq": "1",
					"name": "Isaac",
					"age": "24"
				},
				{
					"seq": "2",
					"name": "Sopia",
					"age": "25"
				},
			]
		*/
		//위의 json 변환 작업을 편하게 하는 jackson 라이브러리를 사용한다.
		
		//HashMap 성질
		/*
		JSONObject obj1 = new JSONObject();
		
		obj1.put("name", "Isaac");
		obj1.put("age", "24");
		
		//{"name":"Isaac","age":"24"}
		System.out.println(obj1.toString());
		
		JSONObject obj2 = new JSONObject();

		obj2.put("name", "Sopia");
		obj2.put("age", "25");
		
		JSONArray arr = new JSONArray();
		arr.add(obj1);
		arr.add(obj2);
		
		System.out.println(arr.toString());
		*/
		
		
		//ArrayList<AddressDTO> list -> JSONArray
		//AddressDTO -> JSONObject
		
		JSONArray arr = new JSONArray();
		
		for (AddressDTO dto : list) {
			
			//AddressDTO 1개 > JSONObject 1개
			JSONObject item = new JSONObject();
			
			item.put("seq", dto.getSeq());
			item.put("name", dto.getName());
			item.put("age", dto.getAge());
			item.put("gender", dto.getGender());
			item.put("address", dto.getAddress());
			item.put("regdate", dto.getRegdate());
			
			arr.add(item);
		}
		
		//System.out.println(arr.toString());

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(arr.toString());
		
		writer.close();
		
		//현재는 필요하지 않은 코드
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
		//dispatcher.forward(req, resp);
	}

}