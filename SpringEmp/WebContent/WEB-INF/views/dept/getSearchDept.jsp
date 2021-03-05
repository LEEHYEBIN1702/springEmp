<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %> <!-- 커스터마이징한 태그 쓸 수 있게 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/getSearchDept.jsp</title>
</head>
<body>
<h3>부서목록</h3>
<form action="getSearchDept" name="searchFrm">
    <input type="hidden" name="page" value="1">
    부서번호 <input name="department_id" value="${deptVO.department_id}">
    매니저 <input name="manager_id" value="${deptVO.manager_id}">
    NAME <input name="department_name" value="${deptVO.department_name}">  
    <button>검색</button>
</form>
<c:forEach items="${list }" var="dept">
    <a href="getDept?department_id=${dept.department_id}">${dept.department_id}</a> ${dept.department_name } ${dept.manager_id } ${dept.location_id } ${dept.last_name } ${dept.city }<br>
</c:forEach>
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