<%@page import="com.koreait.mvclegacy.model.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	List<Notice> noticeList = (List)request.getAttribute("noticeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>

	<%for(Notice notice:noticeList){ %>
	<tr>
		<td>1</td>
		<td><a href="/client/notice/detail?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
		<td><%=notice.getWriter() %></td>
		<td><%=notice.getRegdate() %></td>
		<td><%=notice.getHit() %></td>
	</tr>
	<%} %>

  <tr>
  	<td colspan="5" style="text-align:center">
  		[1][2][3]
  	</td>
  </tr>
   <tr>
  	<td colspan="5">
  		<button onClick="location.href='/client/notice/registform'">글등록</button>
  	</td>
  </tr>
</table>

</body>
</html>
