<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<script>
	$(function(){
		$("button").click(function(){
			location.href="/admin/product/registform";	//글쓰기 폼 요청
		});
	});
</script>
</head>
<body>

<%@ include file="../inc/main_navi.jsp" %>

<h3>상품목록</h3>
<p>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Points</th>
			<th>Points</th>
			<th>Points</th>
		</tr>
		<tr>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
			<td>50</td>
			<td>50</td>
		</tr>
		<tr>
			<td colspan="5">
				<button>상품등록</button>
			</td>
		</tr>
	</table>
</p>

</body>
</html>

