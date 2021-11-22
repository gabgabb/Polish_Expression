<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Calcul mental - Home page</title>
</head>
<body>
<h1>Les 10 meilleurs scores</h1>


<table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Username</th>
            <th scope="col">Score</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="utilisateurs" scope="request" type="java.util.List"/>
        <c:forEach items="${utilisateurs}" var="utilisateur" varStatus="loop">
            <tr>
                <th scope="row">${loop.count}</th>
                <td><c:out value="${utilisateur.username}"/></td>
                <td><c:out value="${utilisateur.score}"/></td>
            </tr>
        </c:forEach>
        </tbody>

</table>
<br>
<a class="btn btn-lg btn-primary" href="jeu.jsp"> Jouer !</a>
</body>
</html>
