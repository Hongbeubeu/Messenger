<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Profile:${customer.name}</title>
</head>
<body>
	<h1>Profile</h1>	
	ID: ${customer.id} <br/>
	Name: ${customer.name} <br/>
	Email: ${customer.email} <br/>
	Address: ${customer.address} <br/>
	Password: ${customer.password} <br/>
</body>
</html>