<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REST Delete</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

 
    $(document).ready(function() { //는 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미 , 
    	//1. 실행 순서 $(document).ready() = $(function(){}) 2. window.onload
//하나의 id는 한 문서에 한번만 사용된다.
//허나의 클래스는 한 문서에 여러번 사용이 가능하다.
    
      $(".a-delete").click(function(event) {
         event.preventDefault(); //기존의 작동하던 것을 멈추라는 의미이다.
         //alert("a-delete click");
         console.log("a-delete click");

         var tr = $(this).parent().parent(); //this는 클릭했을 때 a , a의 부모의 부모 <tr>을 remove시킨다. 클로저 개념

         $.ajax({
            type : 'DELETE', //method
            url : $(this).attr("href"),//href="${pageContext.request.contextPath}/restful/board/${vo.bId}
            cache : false,
            success : function(result) {
            //   alert("result: " + result)
               console.log("result: " + result);
               if (result == "SUCCESS") {
                  $(tr).remove();//클로저 개념
                  //alert("삭제되었습니다.");
               }
            },
            errer : function(e) {
               console.log(e);
            }
         }); //end of ajax
      }); //end of $().click

   });
</script>

</head>
<body>
   
   <table width="500" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>번호</td>
         <td>이름</td>
         <td>제목</td>
         <td>날짜</td>
         <td>히트</td>
         <td>삭제</td>
      </tr>
      <c:forEach items="${list}" var="vo">
         <tr>
            <td>${vo.bId}</td>
            <td>${vo.bName}</td>
            <td><c:forEach begin="1" end="${vo.bIndent}">-</c:forEach> <a
               id="a-content"
               href="${pageContext.request.contextPath}/restful/board/${vo.bId}">${vo.bTitle}</a></td>
            <td>${vo.bDate}</td>
            <td>${vo.bHit}</td>
            <td><a class="a-delete" href="${pageContext.request.contextPath}/restful/board/${vo.bId}">삭제</a></td>
         </tr>
      </c:forEach>
      <tr>
         <td colspan="5"><a href="write_view">글작성</a></td>
      </tr>
   </table>
</body>
</html>