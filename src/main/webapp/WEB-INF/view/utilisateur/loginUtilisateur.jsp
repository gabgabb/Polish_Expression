<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>

<!DOCTYPE html>

<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Page de connexion</title>
</head>

<body>
<h1>Connexion</h1>

<form class="formulaire" id="formLogin" action="login" method="post">

    <div class="form-group">
        <div class="inputLogin">
            <label for="username">Username : </label>
            <input class="form-control" type="text" id="username" name="username" required/>
        </div>

        <div class="inputLogin">
            <label for="password">Mot de passe : </label>
            <input class="form-control" type="password" id="password" name="password" autocomplete="on" required/>
        </div>
    </div>

    <c:if test="${not empty requestScope.error}">
        <div id="errorAlert" class="alert alert-danger d-flex align-items-center" role="alert">
            <div> ${requestScope.error.toString()} </div>
        </div>
    </c:if>

    <div class="buttonLogin">
        <input class="btn btn-success" type="submit" value="Connexion">
    </div>

    <div class="buttonLogin">
        <a class="btn btn-primary" href="ajouter"> Créer un compte</a>
    </div>

</form>
</body>

<script>
    $(document).ready(function () {
        $('#navbarbrand').hide();
        $('#divDroite').hide();
        $('#containerDiv').removeClass('container-fluid justify-content-between');
        $('#containerDiv').addClass('container-fluid justify-content-center');

    });
</script>
</html>