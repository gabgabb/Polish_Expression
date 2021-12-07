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
        <input class="form-control" type="text" name="username" id="username" minlength="4" required/> <br>
        <div id="msg"></div>

        <label for="password">Password : </label>
        <input class="form-control" type="password" name="password" id="password" minlength="4" autocomplete="on" required/> <br>
    </div>
    <input class="btn btn-success" type="submit" name="Creer" id="Creer" value="Valider"/>

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