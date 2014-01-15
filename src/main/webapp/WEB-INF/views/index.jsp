<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%><%@taglib
	uri="http://java.sun.com/jstl/core" prefix="c"%>
<h1>Home</h1>

<p>This is a simple placeholder for home page of the system</p>

<s:url value="/user/id?={userID}" var="user_url">
	<s:param name="userID" value="${user.id}" />
</s:url>
<p>User's id: ${user.id}
<ul>
	<li>Login: ${user.username}, verified: ${user.verified}, address:  ${user_url}</li>
</ul>
</p>
