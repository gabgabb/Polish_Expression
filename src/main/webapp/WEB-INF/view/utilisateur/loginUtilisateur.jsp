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

    <div id="errorAlert" class="alert alert-danger align-items-center" role="alert">
        <p id="msgError"></p>
    </div>

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
        $('#errorAlert').hide();
        $('#containerDiv').removeClass('container-fluid justify-content-between');
        $('#containerDiv').addClass('container-fluid justify-content-center');

        $.ajax({
            type: "GET",
            url: "login",
            dataType: 'JSON',
            contentType: "application/json",
            success: function (resultJSON) {
                console.log(resultJSON);

                $("#msgError").text(resultJSON.error);
                $('#errorAlert').fadeTo(2000, 500);

                setTimeout(function () {
                    $("#errorAlert").fadeOut("slow");
                }, 2500);
            }
        });
    });
</script>
</html>