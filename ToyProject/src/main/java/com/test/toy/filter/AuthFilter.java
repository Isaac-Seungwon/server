package com.test.toy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		//권한 체크
		//System.out.println("권한 체크 필터");
		
		//인증 받지 못한 사용자 내쫓기
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		
		//형변환을 시켜서 HttpServletRequest를 ServletRequest로 가져옴
		//이를 이용해서 세션을 얻어옴
		
		HttpSession session = httpReq.getSession();
		
		/*
		if (session.getAttribute("id") == null) {
			System.out.println("비회원");
		} else {
			System.out.println("회원: " + session.getAttribute("id"));
		}
		System.out.println();
		*/
		
		//익명 사용자 > 배제
		//System.out.println(httpReq.getRequestURI()); //httpReq.getRequestURI(): 지금 호출한 페이지의 주소값
		//필터는 모든 페이지를 부를 때마다 호출이 되기 때문에 자기가 누구를 부를 때 호출되는 상황인지를 알 수 없다.
		//그래서 이런 식으로 불러내어야 한다.
		
		//비회원이면서 add.do로 끝내는 페이지를 들어간 경우
		if (session.getAttribute("id") == null) {
			if (httpReq.getRequestURI().endsWith("add.do")
				|| (httpReq.getRequestURI().endsWith("edit.do"))
				|| (httpReq.getRequestURI().endsWith("del.do"))
				|| (httpReq.getRequestURI().endsWith("input.do"))) {

 				PrintWriter writer = httpResp.getWriter();
				writer.write("<script>alert('unauthorized');location.href='/toy/index.do';</script>");
				writer.close();
				
				return;
				
			}
		}
		
		//필터 > 서블릿 호출
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		
		//System.out.println("필터 소멸");
		
		Filter.super.destroy();
		
	}

}