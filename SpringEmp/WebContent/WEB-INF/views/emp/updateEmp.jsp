<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
//이메일 중복체크
$(function(){
$("#btnEmail").on("click", function(){
		var param= "email=" + $("[name=email]").val()
	$.ajax({
		url : "../EmailCheck",
		data: param,                     //서버에 보낼 파라미터
		dataType : "xml",               // 결과 타입
		success : function(response) { 
			//span 태그에 출력
			/*
			if (response.email == "true") {
			$("#emailResult").html("<font color='blue'>사용 가능</font>"); 
			}else {
			$("#emailResult").html("<font color='blue'>사용 불가능</font>"); 	
			}*/
			//xml
			$("#emailResult").html($(response).find("email").text());
		  } 	
	  })
   });	
});
</script>
</head>
<body>
<h3 id="top">사원수정</h3>
<c:set var="url" value="./empInsert"/>
<c:if test="${not empty empVO.employee_id}">
<c:set var="url" value="empUpdate"/>
</c:if>
<form:form modelAttribute="empVO" action="updateEmp" method="post" name="frm">
  employee_id <form:input path="employee_id" /><br>
   first_name  <form:input path="first_name" /><br>
   last_name   <form:input path="last_name" /><br>
   email       <form:input type="email" path="email" />
               <form:button type="button" id="btnEmail" >중복체크</form:button>
               <span id="emailResult"></span><br>
   phone_number<form:input type="text" path="phone_number" /><br>
   hire_date   <form:input type="date" path="hire_date" /><br>
   
   job_id       <form:select path="job_id">
                <option value="">선택</option>
                <form:options items="${jobList}" itemLabel="job_title" itemValue="job_id" />
                </form:select>
                <br>
   department_id 
                <form:radiobuttons items="${deptList}" path="department_id"
                itemLabel="department_name" 
                itemValue="department_id"/>
                <br>
   manager_id 
   <form:input path="manager_id" />
   <input type="text" name="name"> <!-- 얘는 VO에 없기 때문에 form:input말고 걍 input으로.. -->
   <button type="button" 
    onclick="window.open('empSearch', 'emp', 'width=400, height=400')">
    사원검색</button><br>   

   <button type="submit">등록 </button>
   <button type="reset">초기화 </button>
</form:form>


</body>
</html>
