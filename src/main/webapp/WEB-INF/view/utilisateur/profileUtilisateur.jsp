<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Profile de </title>
</head>
<body>
<div id="profil">
    <label> Nom :</label>
    <br>
    <label> Prenom : </label>
    <br>
    <label> Username : </label>
    <br>
    <label> Nombre de partie effectuées : </label>
    <br>
    <label> Moyenne :</label>
    <br>
    <label> Moyenne pondérée :</label>
</div>

<table id="tableauScoreProfile" class="table table-bordered">
    <thead class="table-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Date</th>
        <th scope="col">Score</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${parties}" var="partie" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td><c:out value="${partie.date}"/></td>
            <td><c:out value="${partie.score}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

</html>
