<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<h1>Créer un nouveau compte</h1>
<form id="ajoutUtilisateur" method="post" action="ajouter">

    <div class="form-group w-25">
        <div class="col-xs-2">
        <label for="prenom">Prénom : </label>
        <input class="form-control" type="text" name="prenom" id="prenom" /> <br>

        <label for="nom">Nom : </label>
        <input class="form-control" type="text" name="nom" id="nom" /> <br>

        <label for="username">Username : </label>
        <input class="form-control" type="text" name="username" id="username" /> <br>
            <div id="msg"></div>

        <label for="password">Password : </label>
        <input class="form-control"type="text" name="password" id="password" /> <br>

        <input class="btn btn-primary" type="submit" name="Créer" id="Créer"/>

        </div>
    </div>
</form>

</body>
</html>