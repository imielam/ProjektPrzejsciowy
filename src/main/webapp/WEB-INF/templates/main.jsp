<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib
	uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<spring:url value="/resources/css/main.css" var="myCss"/>
<link rel="stylesheet" type="text/css"
	href="${myCss}" />
</head>
<body>
	<div id="header">
		<div id="headerTitle">
			<tiles:insertAttribute name="header" />
		</div>
	</div>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div> 
</body>
</html>