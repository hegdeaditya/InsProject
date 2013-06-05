<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
<link href="default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.style1 {
	color: #FFFFFF;
}
</style>
</head>
<body>

	<div id="page">
		<div id="content">
			On click of this button, session variables will be initialized and we will get seats available in the session variable
			<br/>
			<s:form action="test.action" method="post" validate="true">
				<s:submit value="submit" align="center"></s:submit>
			</s:form>
			
		</div>
	</div>

</body>
</html>