<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcul mental - Home page</title>
</head>
<body>
<h1>Les meilleurs scores</h1>
<table>
        <jsp:useBean id="utilisateurs" scope="request" type="java.util.List"/>
        <c:forEach items="${utilisateurs}" var="utilisateur" >
            <tr>
                <td><c:out value="${utilisateur.username}"/></td>
                <td><c:out value="${utilisateur.score}"/></td>
            </tr>
        </c:forEach>


</table>
</body>
</html>
