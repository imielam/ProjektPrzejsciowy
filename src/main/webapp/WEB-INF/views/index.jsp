<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%><%@taglib
	uri="http://java.sun.com/jstl/core" prefix="c"%>
<h1>Home</h1>

<p>This is a simple placeholder for home page of the system</p>

<s:url value="/users/user?id={userID}" var="user_url">
	<s:param name="userID" value="${user.id}" />
</s:url>
<p>Users:
<ul>
	<li><a href="${ user_url }">Login: ${user.username}</a></li>
</ul>
</p>
