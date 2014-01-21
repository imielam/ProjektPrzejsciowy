<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<p>
    <a href="<c:url value="/"/>">Home</a>
</p>
<sec:authorize access="isAnonymous()">
    <p>
        <a href="<c:url value="/register"/>">Register</a>
    </p>
    <p>
        <a href="<c:url value="/login"/>">Login</a>
    </p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p>
        <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
    </p>
</sec:authorize>
<p>
    <a href="<c:url value="about"/>">About</a>
</p>
<p>
    <a href="<c:url value="/contact"/>">Contact</a>
</p>
<p>
    <a href="<c:url value="#"/>">Courses</a>
<ul>
    <li><a href="<c:url value="/course/list"/>">Description</a></li>
    <li><a href="<c:url value="/error"/>">Currently</a></li>
        <sec:authorize access="hasRole('ROLE_USER')">
        <li><a href="<c:url value="/error"/>">Sign</a></li>
        </sec:authorize>
</ul>
</p>
<p>
    <a href="<c:url value="#"/>">Examples</a>
<ul>
    <li><a href="<c:url value="/error"/>">Materials</a></li>
    <li><a href="<c:url value="/error"/>">Exam</a></li>
</ul>
</p>
<p>
    <a href="<c:url value="/error"/>">Materials</a>
</p>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p>
        <a href="<c:url value="/error"/>">Admin</a>
    </p>
</sec:authorize>