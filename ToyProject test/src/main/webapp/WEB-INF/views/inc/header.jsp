<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- inc > header.jsp -->
<header id="header">
	<h1>
		<!-- 로그아웃 상태 -->
		<c:if test="${empty id}">
		<span>Toy</span>
		</c:if>
		
		<!-- 로그인 상태 -->
		<c:if test="${not empty id}">
		<span>
		<span class="material-symbols-outlined">toys</span>
		Toy</span>
		</c:if>
		<span>Project</span>
	</h1>
	<nav>
		<a href="/toy/index.do">Home</a> <!-- 처음 시작 페이지 -->
		
		<!-- 로그아웃 상태 -->
		<c:if test="${empty id}">
		<a href="/toy/user/register.do">Register</a> <!-- 가상 주소 구분을 위해 유저 관련 된 것은 'user.'를 추가 -->
		<a href="/toy/user/login.do">Login</a>
		</c:if>
		
		<!-- 로그인 상태 -->
		<c:if test="${not empty id}">
		<a href="/toy/user/logout.do">Logout</a>
		<a href="/toy/board/list.do">Board</a>
		</c:if>
	</nav>
</header>