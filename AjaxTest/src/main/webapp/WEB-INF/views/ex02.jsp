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

	<div id="msg" class="message"></div>
	
	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$('#btn1').click(function() {
			const ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function() {
				
				//readystate change
				
				//$('#msg').html(ajax.responseText);
				
				if (ajax.readyState == 4 && ajax.status == 200) {
					
					$('#msg').append('<div>readyState: ' + ajax.readyState + '</div>');
	
					$('#msg').append('<div>status: ' + ajax.status + '</div>');
	
					$('#msg').append('<div>responseText: ' + ajax.responseText + '</div>');
						
					$('#msg').append('<hr>');
					
					$('#txt1').val(ajax.responseText);
				} else {
					if (ajax.readyState == 4) {
						alert('서버와 통신이 불안정합니다.');
					}
				}
			};
			
			//<form method="GET" action="주소">
			//ajax.open('GET', '/ajax/ex02.txt');
			ajax.open('GET', '/ajax/ex02data.do');
			
			ajax.send();
		});
	</script>
</body>
</html>