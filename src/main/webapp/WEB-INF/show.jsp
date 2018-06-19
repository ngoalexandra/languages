<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<title>Show Language</title>
</head>
<body>
<div class="text-center">
	<a href="/languages" class="btn btn-link">Dashboard</a>
</div>
<p><c:out value= "${language.name}"/></p>
<p><c:out value= "${language.creator}"/></p>
<p><c:out value= "${language.version}"/></p>

<a href= "/languages/edit/<c:out value = "${language.id}"/>" class = "btn btn-link">Edit</a>

<form action = "/languages/delete" method = "post">
<input type="hidden" name="id" value= '<c:out value = "${language.id}"/>'>
<button type = "submit">Delete</button>
</form>


	
</body>
</html>