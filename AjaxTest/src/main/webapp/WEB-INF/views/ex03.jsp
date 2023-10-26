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
	<div>
		<input type="text" id="txt1" value="${count}">
		<input type="button" value="버튼1" id="btn1">
	</div>
	
	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$('#btn1').click(function() {
			
			const isaac = {
				name: 'Isaac',
				age: 24,
				hello: function() {
					
				}
			};
			
			$.ajax({
				//페이지 요청 정보
				//ajax.open('GET', 'do')
				type: 'GET',
				url: '/ajax/ex03data.do',
				
				//통신 방식 변경
				async: true, //true(비동기), false(동기)
				
				//ex03data.do?name=Isaac
				data: 'name=Isaac',
				
				//onreadystatechange + readyState(4) + status(200)
				success: function(result) {
					//result == ajax.responseText
					$('#txt1').val(result);
				},
				
				//에러 발생 시 호출(이벤트)
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});
		});
	</script>
</body>
</html>