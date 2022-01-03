<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Profil de ${sessionScope.username} </title>
</head>
<body>
<h1>Profil de ${sessionScope.username}</h1>
<div id="profil">
    <br>
    <div class="labelProfil">
        <label> Nom : </label>
        <p id="nom"> ${sessionScope.nom}</p>
    </div>

    <div class="labelProfil">
        <label> Prenom : </label>
        <p id="prenom"> ${sessionScope.prenom}</p>

    </div>
    <div class="labelProfil">
        <label> Username : </label>
        <p id="username"> ${sessionScope.username}</p>

    </div>
    <div class="labelProfil">
        <label> Nombre de parties effectuées : </label>
        <p id="nbPartie"> ${sessionScope.nbpartie}</p>

    </div>
    <div class="labelProfil">
        <label> Moyenne des parties :</label>
        <p id="moyenne"> ${sessionScope.moyenne}</p>

    </div>

</div>

<h4> Parties effectuées </h4>
<div id="taaaab">
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
</div>
</body>

</html>
