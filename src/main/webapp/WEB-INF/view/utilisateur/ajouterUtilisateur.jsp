<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Création de compte</title>
</head>

<body>
<h1>Créer un nouveau compte</h1>

<form id="ajoutUtilisateur" method="post" action="ajouter">

    <div class="form-group">
        <label for="prenom">Prénom : </label>
        <input class="form-control" type="text" name="prenom" id="prenom" required/> <br>

        <label for="nom">Nom : </label>
        <input class="form-control" type="text" name="nom" id="nom" required/> <br>

        <label for="username">Username : </label>
        <input class="form-control" type="text" name="username" id="username" minlength="4" required/> <br>
        <div id="msg"></div>

        <label for="password">Password : </label>
        <input class="form-control" type="password" name="password" id="password" minlength="4" required/> <br>
    </div>
    <input class="btn btn-success" type="submit" name="Creer" id="Creer" value="Valider"/>

</form>


</body>
</html>