<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title> luv 2 code company Home page</title>
</head>
<body>
<h2>luv 2 code company Home page </h2>
<hr>
<p>
Welcome to luv2code company home page!
</p>

<hr>
<!-- Display username and role -->

<p>
	User:<security:authentication property="principal.username" />
	<br><br>
	Role(s):<security:authentication property="principal.authorities" />
</p>



<security:authorize access="hasRole('MANAGER')">

<!--  Add a link to point to leaders ..this is for managers -->
<p>
<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting</a>
(Only for Manager peeps)
</p>

</security:authorize>


<security:authorize access="hasRole('ADMIN')">
<!--  Add a link to point to systems ..this is for admins -->
<p>
<a href="${pageContext.request.contextPath}/systems"> IT Systems Meeting</a>
(Only for Admin peeps)
</p>

</security:authorize>

<hr>
<!--  Add Logout button -->

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">

</form:form>
</body>

</html>