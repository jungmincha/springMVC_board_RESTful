<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

p{
   		text-align:center;
     	 font-weight:bold; 	
    }
    
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function (){
		$('#a-delete').click(function(event){
			//prevendDefault()는 href로 연결해 주지 않고 단순히 click에 대한 처리를 하도록 해준다.
			event.preventDefault();
			console.log("ajax 호출전"); 
			 
			$.ajax({
			    type : "DELETE",
			    url : "${pageContext.request.contextPath}/board/delete/" + "${content_view.bId}",
			    data:{"bId":"${content_view.bId}"},
			    success: function (result) {       
			           console.log(result); 
			           getList();               
			    },
			    error: function (e) {
			        console.log(e);
			    }
			})
			 
		});
	});	
</script>




</head>
<body>
	
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<tr>
			
			<td><p>번호</p></td>
			<td><p>이름</p></td>
			<td><p>제목</p></td>
			<td><p>날짜</p></td>
			<td><p>히트</p></td>
			
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">(re)</c:forEach>
				<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		 <td><a id="a-delete" href="${pageContext.request.contextPath}/board/delete?bId=${dto.bId}">삭제</a><td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view">글작성</a> </td>
		</tr>
		
		
		
	</table>
	
</body>
</html>