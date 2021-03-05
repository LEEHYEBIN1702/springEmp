<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
</head>
<body>
<h3>job</h3>
<c:forEach items="${list }" var="job">
    <a href="getJob?job_id=${job.job_id}">${job.job_id}</a> ${job.job_title} ${job.min_salary} ${job.max_salary}<br>
</c:forEach>
</body>
</html>