<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.owasp.esapi.StringUtilities"%>
<%@page import="org.owasp.esapi.Encoder"%>
<%@page import="java.util.Map"%>
<html>
	<body>
		<h1>Demo</h1>
		You submitted <%= request.getParameter("testName") %>
	</body>
</html>
