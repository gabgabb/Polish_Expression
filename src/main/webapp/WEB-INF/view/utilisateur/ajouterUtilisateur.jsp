<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<h1>Créer un nouveau compte</h1>
<form method="post" action="ajouter">
    <div>
        <label for="prenom">Prénom : </label>
        <input type="text" name="prenom" id="prenom" /> <br>

        <label for="nom">Nom : </label>
        <input type="text" name="nom" id="nom" /> <br>

        <label for="username">Username : </label>
        <input type="text" name="username" id="username" /> <br>

        <label for="password">Password : </label>
        <input type="text" name="password" id="password" /> <br>

        <input type="submit" name="Créer" id="Créer"/>
    </div>

</form>

</body>
</html>