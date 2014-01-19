<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<h1>Home</h1>
<%-- <s:eval expression='message != ""' var="errorTest"><div class="errorMessage">${message}</div></s:eval>
<c:if test="${message ne ''}"><div class="errorMessage">${message}</div></c_rt:if> --%>

<p>This is a simple placeholder for home page of the system</p>

<s:url value="/users/user?id={userID}" var="user_url">
	<s:param name="userID" value="${user.id}" />
</s:url>
<p>Users:
<ul>
	<li><a href="${ user_url }">Login: ${user.username}</a></li>
</ul>
</p>
