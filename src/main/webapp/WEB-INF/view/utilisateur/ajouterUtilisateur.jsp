<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Création de compte</title>
</head>

<body>
<h1>Créer un nouveau compte</h1>

<form class="formulaire" id="ajoutUtilisateur" method="post" action="ajouter">

    <div class="form-group">
        <label for="prenom">Prénom : </label>
        <input class="form-control" type="text" name="prenom" id="prenom" required/> <br>

        <label for="nom">Nom : </label>
        <input class="form-control" type="text" name="nom" id="nom" required/> <br>

        <label for="username">Username : </label>
        <input class="form-control" type="text" name="username" id="usernameInput" minlength="4" required/> <br>

        <div id="errorAlert" class="alert alert-danger align-items-center" role="alert">
            <p id="msgUsername"></p>
        </div>

        <label for="password">Password : </label>
        <input class="form-control" type="password" name="password" id="password" minlength="4" autocomplete="on"
               required/> <br>
    </div>
    <input class="btn btn-success" type="submit" name="Creer" id="Creer" value="Valider"/>

</form>
</body>

<script>

    $(document).ready(function () {
        $('#errorAlert').hide();
        $('#navbarbrand').hide();
        $('#divDroite').hide();
        $('#containerDiv').removeClass('container-fluid justify-content-between');
        $('#containerDiv').addClass('container-fluid justify-content-center');

        $("#usernameInput").blur(function () {
            if ($(this).val() != "") {
                var data = {usernamedata: $(this).val()}
                $.ajax({
                    type: "POST",
                    url: "ajouter",
                    async: true,
                    dataType: 'JSON',
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (resultatJSON) {
                        if (resultatJSON.estUtilise === true) {
                            $("#Creer").prop("disabled", true);
                            $("#msgUsername").text(resultatJSON.username + " est déjà utilisé, entrez en un nouveau.");
                            $("#errorAlert").fadeTo(2000, 500);
                        } else {
                            $('#errorAlert').removeClass('alert alert-danger align-items-center');
                            $('#errorAlert').addClass('alert alert-success align-items-center');
                            $("#msgUsername").text(resultatJSON.username + " est disponible.");
                            $("#errorAlert").fadeTo(2000, 500);
                            $("#Creer").prop("disabled", false);
                        }
                        setTimeout(function () {
                            $("#errorAlert").fadeOut("slow");
                        }, 2500);
                    },
                    error: function (errorThrown) {
                        alert("not success : " + errorThrown);
                    }
                });
            }
        });
    });

</script>
</html>