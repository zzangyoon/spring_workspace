<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="./inc/header.jsp" %>
</head>
<body>
<!-- 메인 네비게이션 영역 : jsp는 이제 보안된 폴더에 있으므로, 웹사이트 루트를 기준으로한 경로는 막혀있다
								따라서 상대경로로 접근하자! -->
<!-- 	/admin/inc/main_navi.jsp > WEB-INF에 들어있기때문에 직접 접근 불가
		루트를 이용하지 말고! 
		루트를 살려놓으면 웹사이트의 루트를 말하는것인데, 이것은 WEB-INF에 들어있어서 보안폴더이기 때문에 가져올수가 없다
		절대방식이 막혀있으므로(보안폴더 ) 상대경로로 가져오면 가능하다! -->
<%@ include file="./inc/main_navi.jsp" %>

<h3>Dropdown Menu inside a Navigation Bar</h3>
<p>Hover over the "Dropdown" link to see the dropdown menu.</p>

</body>
</html>

