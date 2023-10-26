<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	
</style>
</head>
<body>
	<h1>Ajax 데이터 보내는 방법</h1>

	<form id="form1">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" value="Isaac"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" value="24"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" id="gender1" value="m" checked> 남자
				<input type="radio" name="gender" id="gender2" value="f"> 여자
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" value="서울시 강남구 역삼동"></td>
		</tr>
		<tr>
			<th>전화</th>
			<td><input type="text" name="tel" id="tel" value="010-1234-5678"></td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="확인" id="btn">
	</div>
	</form>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		/*
		$('#btn').click(function() {
			
			//1. 단일 데이터 전송
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'name=' + $('#name').val(),
				//success: function(result) {
					//데이터 수신
				//}
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		*/
		
		/*
		$('#btn').click(function() {
			
			alert('name=' + $('#name').val() + '&age=' + $('#age').val());
			
			//2. 다중 데이터 전송
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'name=' + $('#name').val() + '&age=' + $('#age').val(),
				//success: function(result) {
					//데이터 수신
				//}
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		*/
		
		//$('input[name=gender]').hide();
		//$('input[name=gender]:checked').val();
		
		/*
		$('#btn').click(function() {
			
			//3. 모든 데이터 전송
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'name=' + $('#name').val() + '&age=' + $('#age').val() + '&gender=' + $('input[name=gender]:checked').val() + '&address=' + $('#address').val() + '&tel=' + $('#tel').val(),
				//success: function(result) {
					//데이터 수신
				//}
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		*/
		
		/*
		$('#btn').click(function() {
			
			//4. 객체로 데이터 전송
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: {
					name: $('#name').val(),
					age: $('#age').val(),
					gender: $('#gender').val(),
					address: $('#address').val(),
					tel: $('#tel').val()
				},
				//success: function(result) {
					//데이터 수신
				//}
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		*/
		
		//alert($('#form1').serialize());
		
		$('#btn').click(function() {
			
			//5. 폼 태그를 활용하여 데이터 전송
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: $('#form1').serialize(),
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
	</script>
</body>
</html>