package com.test.toy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		//System.out.println("필터 생성");

		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		//arg0을 req로 변경, arg1를 resp(response)로 변경 arg2를 chain으로 변경
		
		//System.out.println("필터 동작");
		
		//인코딩 처리
		req.setCharacterEncoding("UTF-8");

		//필터 호출 > 서블릿 호출
		chain.doFilter(req, resp); //forward() 역할
		
	}

	@Override
	public void destroy() {
		
		//System.out.println("필터 소멸");
		
		Filter.super.destroy();
		
	}

}