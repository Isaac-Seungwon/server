<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	.chromi {
		width: 300px;
		height: 250px;
	}
	
	<c:forEach items="${list}" var="dto">
	#${dto.chromiId} {
		left: ${dto.x}px;
		top: ${dto.y}px;
	}
	</c:forEach>
</style>
</head>
<body>
	<h1>chromi + Ajax</h1>

	<img src="/ajax/images/chromi.png" id="chromi1" class="chromi">
	<img src="/ajax/images/chromi.png" id="chromi2" class="chromi">
	<img src="/ajax/images/chromi.png" id="chromi3" class="chromi">
	<img src="/ajax/images/chromi.png" id="chromi4" class="chromi">
	<img src="/ajax/images/chromi.png" id="chromi5" class="chromi">

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js" integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c=" crossorigin="anonymous"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		$('.chromi').draggable({
			
			stop: function(event, ui) {
				//alert(ui.position.left);
				//alert(ui.position.right);
				
				$.ajax({
					type: 'POST',
					url: '/ajax/ex07data.do',
					data: {
						x: ui.position.left,
						y: ui.position.top,
						chromiId: this.id
					},
					error: function(a,b,c) {
						console.log(a,b,c);
					}
				});
			}
		});
	</script>
</body>
</html>