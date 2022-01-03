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

<form class="formulaire" id="formLogin">

    <div class="form-group">
        <div class="inputLogin">
            <label>Username : </label>
            <input class="form-control" type="text" id="username" name="username" required/>
        </div>

        <div class="inputLogin">
            <label>Mot de passe : </label>
            <input class="form-control" type="password" id="password" name="password" autocomplete="on" required/>
        </div>
    </div>

    <div id="errorAlert" class="alert alert-danger align-items-center" role="alert">
        <p id="msgError"></p>
    </div>

    <div class="buttonLogin">
        <input id="Connexion" class="btn btn-success" value="Connexion">
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

        $("#Connexion").click(function (e) {
            var data = {
                usernamedata: $("#username").val(),
                pwddata: $("#password").val()
            }
            $.ajax({
                type: "POST",
                url: "login",
                contentType: "application/json",
                async: true,
                dataType: 'JSON',
                data: JSON.stringify(data),

                success: function (result) {
                    var data = result;
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    } else {

                        $("#msgError").text(data.errorLogin);
                        $('#errorAlert').fadeTo(2000, 500);

                        setTimeout(function () {
                            $("#errorAlert").fadeOut("slow");
                        }, 2500);
                    }
                }
            });
        });
    });
</script>
</html>