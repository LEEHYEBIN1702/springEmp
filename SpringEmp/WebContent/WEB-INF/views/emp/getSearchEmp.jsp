<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %> <!-- 커스터마이징한 태그 쓸 수 있게 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
</head>
<body>
<h3>사원목록</h3>
<form action="getSearchEmp" name="searchFrm">
    <input type="hidden" name="page" value="1">
    부서 <input name="department_id" value="${empSearchVO.department_id}">
    Job <input name="job_id" value="${empSearchVO.job_id}">
    NAME <input name="first_name" value="${empSearchVO.first_name}">  
    <button>검색</button>
</form>
<c:forEach items="${list }" var="emp">
    <a href="getEmp?employee_id=${emp.employee_id}">${emp.employee_id}</a> ${emp.first_name} ${emp.email} ${emp.job_id} ${emp.department_id} ${emp.department_name} ${emp.job_title}<br>
</c:forEach>
<a href="insertEmp">사원등록</a>
<my:paging paging="${paging}" jsFunc="goPage" />
<script>
    function goPage(p) {
    	//location.href="getSearchEmp?page=" +p;
    	searchFrm.page.value= p;
    	searchFrm.submit();
    }
</script>
</body>
</html>