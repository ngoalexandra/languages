<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Creator</th>
          <th>Version</th>
          <th>Action</th>
         
        </tr>
      </thead>
      <tbody>
      <!-- languages is that name of the table in our database -->
      <c:forEach items="${languages}" var="lang">
			<tr>
				<td><a href="/languages/<c:out value="${lang.id}"/>" class="btn btn-link"><c:out value="${lang.name}"/></a></td>
				<td><c:out value="${lang.creator}"/></td>
				<td><c:out value="${lang.version}"/></td>
				<td class="row">
					<form action="/languages/delete" method="post">
						<input type="hidden" name="id" value="<c:out value="${lang.id}"/>">
						<button class="btn btn-link" type="submit">delete</button>
					</form>
					<a href="/languages/edit/<c:out value="${lang.id}"/>" class="btn btn-link">edit</a>
				</td>
			</tr>
			</c:forEach>
      </tbody>
    </table>
</div>
<div class="form">
	<form:form class="" action="/languages/create" method="post" modelAttribute="language">
		
		<p>
			<form:errors class="text-danger" path="name"/>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
		</p>
		<p>
			<form:errors class="text-danger" path="creator"/>
			<form:label path="creator">Creator</form:label>
			<form:input path="creator"/>
		</p>
		
		<p>
			<form:errors class="text-danger" path="version"/>
			<form:label path="version">Version</form:label>
			<form:input path="version"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</div>
   
</body>
</html>