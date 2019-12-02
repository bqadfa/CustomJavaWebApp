<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/5/2019
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Films</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
<h2>Welcome : ${pageContext.request.userPrincipal.name}
        <%--@elvariable id="_csrf" type="org.springframework.web.bind.MissingServletRequestParameterException"--%>
    <c:url var="logoutUrl" value="/logout" />
    <form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <input type="submit" name="submit" value="Log Out">
    </form>
    </c:if>
</h2>
<h2>Films</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>producer</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="film" items="${filmsList}">
        <tr>
            <td>${film.id}</td>
            <td>${film.title}</td>
            <td>${film.year}</td>
            <td>${film.genre}</td>
            <td>${film.producer}</td>
            <td>${film.watched}</td>
            <td>
                <c:url value="/edit/{id}" var="edit"/>
                <a href="/edit/${film.id}">edit</a>
                <c:url value="/delete/{id}" var="delete"/>
                <a href="/delete/${film.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new film</a>
</body>
</html>
