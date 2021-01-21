<%@page import="com.koreait.fashionshop.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=button]:hover {
  background-color: #45a049;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
/* 드래그 영역 관련 */
#dragArea{
	width:100%;
	height:300px;
	overflow:scroll;
	border:1px solid #ccc;
	float:left;
}
.dragBorder{
	background:#ffffff;
}
.box{
	width:100px;
	float:left;
	padding:5px;
}
.box > img{
	width:100%;
}

.close{
	color:red;
	cursor:pointer;
}
</style>
<script type="text/javascript">

//상품 등록
function regist(){
	var formData = new FormData($("form")[0]);	//<form>태그와는 다르다... 
				
	/* 비동기 업로드 */
	$.ajax({
		url:"/admin/product/excel/regist",
		data:formData,	//json으로 쓸 필요가 없다!!! 편하다
		contentType:false,	//false일 경우 multipart/form-data 로 간주
		processData:false,	//false일 경우 query-string으로 전송하지 않음
		type:"post",
		success:function(responseData){
			alert(responseData);
			//var json = JSON.parse(responseData);	//string --> json으로 파싱
			//alert(json.msg);
		}
	});
}
</script>
</head>
<body>
<%@ include file="../inc/main_navi.jsp" %>

<h3>Contact Form</h3>
<div class="container">
  <form>
	<!-- 파일 최대 4개까지 지원 -->
	<p>엑셀파일 선택: <input type="file"  name="dump"></p>
    <input type="button" value="데이터 등록" onClick="regist()">
    <input type="button" value="상품 목록" onClick="location.href='/client/notice/list'">
  </form>
</div>

</body>
</html>