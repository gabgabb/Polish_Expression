<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcul mental - Home page</title>
</head>
<body>
<h1>Les meilleurs scores</h1>
<ul>
        <c:forEach var="utilisateur" items="${utilisateurs}">
            <li><c:out value="${ utilisateur.prenom }" /> <c:out value="${ utilisateur.nom }" /></li>
        </c:forEach>
</ul>
</body>
</html>
