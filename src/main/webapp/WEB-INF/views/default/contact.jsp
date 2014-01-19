<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib
	uri="http://www.springframework.org/tags" prefix="spring"%><div>
	<h2>Please write your message bellow:</h2>
	<form:form method="POST" modelAttribute="contactMessage">
		<fieldset>
			<form:input path="message" size="250" maxlength="500"/>
			<br />
			<form:errors path="message" cssClass="error" /><br/>
			Please give email address, on which I should answer to:<br/>
			<form:input path="email" size="20" maxlength="40"/>
			<br />
			<form:errors path="email" cssClass="error" />
			<br /> <input name="send" type="submit"
				value="Send" />
		</fieldset>
	</form:form>
</div>