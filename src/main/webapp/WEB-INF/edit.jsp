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
	<title>Edit Language</title>	
</head>
<body>
<div class = "container">x

<a href = "/languages">Dashboard</a>
</div>

<div class = "forms">
<!-- this form is update the edited language -->
<form:form class ="" action="/languages/update" method ="post" modelAttribute= "language">
<input type="hidden" name="id" value= '<c:out value = "${language.id}"/>'>


<p>
<form:errors class="text-danger" path="name"/>
<form:label path ="name">Name</form:label>
<form:input path = "name"/>
</p>
<p>
<form:errors class="text-danger" path="creator"/>
<form:label path ="creator">Creator</form:label>
<form:input path = "creator"/>
</p>
<p>
<form:errors class="text-danger" path="version"/>
<form:label path ="version">Version</form:label>
<form:input path = "version"/>
</p>
<input type="submit" value="Submit"/>
</form:form>
</div>	
</body>
</html>