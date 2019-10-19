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
	First Name: ${customer.firstName} <br/>
	Last Name: ${customer.lastName} <br/>
	Address: ${customer.address} <br/>
	Phone Number: ${customer.phoneNumber} <br/>
	Avatar: ${customer.avatar} <br/>
	Gender: ${customer.gender} <br/>
	Email: ${customer.email} <br/>
	Password: ${customer.password} <br/>
	Create At: ${customer.CreateAt} <br/>
</body>
</html>