<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/main.jsp</title>
</head>
<body>
<h1>main</h1><br>
<a href="getSearchEmp">사원조회</a>
<a href="getSearchDept">부서조회</a>
<a href="getSearchJob">직업정보</a><br><br>
<c:if test="${ ! empty sessionScope.loginid }">
    ${sessionScope.loginid}님 
    <a href="logout">로그아웃</a>
    <a href="changePw">패스워드변경</a>
</c:if>
<c:if test="${  empty sessionScope.loginid }">
   <a href="login">로그인</a>
</c:if>
</body>
</html>