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

        <div id="errorAlert" class="alert alert-danger d-flex align-items-center" role="alert">
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
    $('#errorAlert').hide();
    $(document).ready(function () {
        $('#navbarbrand').hide();
        $('#divDroite').hide();
        $('#containerDiv').removeClass('container-fluid justify-content-between');
        $('#containerDiv').addClass('container-fluid justify-content-center');
    });

    $("#Creer").on('click', function () {

        var usernamedata = $('#usernameInput').val();
        var data = {
            usernameData : usernamedata
        }

        $.ajax({
            type: "POST",
            url: "/ajouter",
            dataType: 'JSON',
            data: JSON.stringify(data),
            success: function (resultatJSON) {
                console.log("resultat : " + resultatJSON);
                if (resultatJSON.bonneReponse === true) {
                    $("#msgUsername").text(resultatJSON.username + " est déjà utilisé, entrez en un nouveau.")
                    $("#errorAlert").show();
                }
                setTimeout(function () {
                    $("#errorAlert").hide();
                }, 1500);
            },
            error: function ( errorThrown) {
                alert("not success : " + errorThrown);
            }
        });
    });
</script>
</html>