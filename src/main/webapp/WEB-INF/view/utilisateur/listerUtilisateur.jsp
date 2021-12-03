<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Home page</title>
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
<a class="btn btn-lg btn-primary" href="calculMental"> Jouer !</a>

<select id="diff" name="diff" class="form-select" data-size="5" aria-label="Default select example">
    <option>Selectionner une difficulté</option>
    <option selected value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
</select>

</body>
</html>
