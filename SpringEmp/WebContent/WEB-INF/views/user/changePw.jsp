<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pw 변경</title>
</head>
<body>
<h3>Pw 변경</h3>
<form action="changePw" method="post">
현재Pw : <input name="oldpassword"><br>
변경Pw : <input name="password"><br>
변경Pw확인 : <input name="newpassword"><br> 
<button>변경</button>
</form>
</body>
</html>