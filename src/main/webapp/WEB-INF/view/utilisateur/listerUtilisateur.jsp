<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Home page</title>
</head>

<body>
<h1>Les 10 meilleurs scores</h1>

<table id="tableauScore" class="table table-bordered">
    <thead class="table-dark">
    <tr>
        <th scope="col">Top 10</th>
        <th scope="col">Username</th>
        <th scope="col">Date</th>
        <th scope="col">Score</th>
        <th scope="col">Nombre de partie</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${parties}" var="partie" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td><c:out value="${partie.utilisateur.username}"/></td>
            <td><c:out value="${partie.date}"/></td>
            <td><c:out value="${partie.score}"/></td>
            <td><c:out value="${partie.utilisateur.nbPartie}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form id="formJeuMental" class="formulaire" action="meilleur_score" method="post">
    <input class="btn btn-lg btn-primary" type="submit" name="bouttonPost" value="Jouer !">

    <p> Difficulté :</p>
    <select name="diff" class="form-select" data-size="5" aria-label="Default select example">
        <option selected value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
</form>

</body>
</html>
