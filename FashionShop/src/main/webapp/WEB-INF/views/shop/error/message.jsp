<%@page import="com.koreait.fashionshop.common.MessageData"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	MessageData messageData = (MessageData)request.getAttribute("messageData");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<script>
	alert("<%=messageData.getMsg()%>");
	<%if(messageData.getResultCode()==1){%>
		location.href="<%=messageData.getUrl()%>";
	<%}else{%>
		history.back();
	<%}%>
</script>
</head>
<body>
</body>
</html>