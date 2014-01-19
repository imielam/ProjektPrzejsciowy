<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<h1>Home</h1>
<s:eval expression='(message == T(com.maciej.imiela.kursy.mvc.GuestController).SUCCES_MESSAGE or message == T(com.maciej.imiela.kursy.mvc.GuestController).FAIL_MESSAGE)' var="errorTest"/>
<c:if test="${errorTest}"><div class="errorMessage">${message}</div></c:if>

<p>This is a simple placeholder for home page of the system</p>

<s:url value="/users/user?id={userID}" var="user_url">
	<s:param name="userID" value="${user.id}" />
</s:url>
<p>Users:
<ul>
	<li><a href="${ user_url }">Login: ${user.username}</a></li>
</ul>
</p>
