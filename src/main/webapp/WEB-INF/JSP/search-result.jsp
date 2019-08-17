<%@ page import="org.slf4j.LoggerFactory" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/16/2019
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	LoggerFactory.getLogger("search-result.jsp").debug("Display search-result.jsp");
%>
<html>
	<body>
		<h2>Your name: ${name}</h2>
		<br>
		<a href="/search">Try again</a>
	</body>
</html>
