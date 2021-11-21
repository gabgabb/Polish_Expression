<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<h1>Créer un nouveau compte</h1>
<form method="post" action="ajouter">
    <div class="form-group">
        <label for="prenom">Prénom : </label>
        <input class="form-control" type="text" name="prenom" id="prenom" /> <br>

        <label for="nom">Nom : </label>
        <input class="form-control" type="text" name="nom" id="nom" /> <br>

        <label for="username">Username : </label>
        <input class="form-control" type="text" name="username" id="username" /> <br>

        <label for="password">Password : </label>
        <input class="form-control"type="text" name="password" id="password" /> <br>

        <input class="btn btn-primary" type="submit" name="Créer" id="Créer"/>
    </div>

</form>

</body>
</html>