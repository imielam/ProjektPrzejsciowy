<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%><%@taglib
	uri="http://java.sun.com/jstl/core" prefix="c"%><%@taglib
	uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<h1>Home</h1>
<c_rt:if test="${message ne ''}"><div class="errorMessage">${message}</div></c_rt:if>

<p>This is a simple placeholder for home page of the system</p>

<s:url value="/users/user?id={userID}" var="user_url">
	<s:param name="userID" value="${user.id}" />
</s:url>
<p>Users:
<ul>
	<li><a href="${ user_url }">Login: ${user.username}</a></li>
</ul>
</p>
