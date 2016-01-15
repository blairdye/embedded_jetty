<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.Map"%>
<html>
	<body>
		<h1>Demo</h1>
		This submits a simple attribute to your servlet and displays the response.
		<form name='simpleForm' method='POST' action='FrontEndController'>
			<h1>Test Submit</h1>
			Test Name:&nbsp;<input type='text' id='testName' name='testName' value=''/> <br/>
      
			<input type='submit' name='show' value='Show'/>
      <input type='submit' name='submit' value='Submit'/>
		</form>
	</body>
</html>
