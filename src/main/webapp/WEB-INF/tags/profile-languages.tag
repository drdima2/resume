<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-language"></i> Foreign Languages
			<a class="edit-block" href="/edit/languages">Edit</a>
		</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="language" items="${profile.languages}">
			<%--<strong>English:</strong> Intermediate<br>--%>
			<strong>${language.name}</strong> ${language.level}<br>
		</c:forEach>


	</div>
</div>