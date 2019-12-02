<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<header>
    <h1>Title : ${title}</h1>
</header>
<section>
    <h1>Message : ${message}</h1>
</section>
<div><a href="films">View all films</a> (only for admins)</div>
<div><a href="films">View and/or edit films</a> (only for superadmins)</div>

</body>
</html>