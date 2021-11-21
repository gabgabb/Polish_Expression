<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<h1>Créer un nouveau compte</h1>
<form method="post" action="Utilisateur/Ajouter">
    <div>
        <label for="prenom">Nom : </label>
        <input type="text" name="prenom" id="prenom" /> <br>

        <label for="nom">Prénom : </label>
        <input type="text" name="nom" id="nom" /> <br>

        <label for="username">Date de naissance : </label>
        <input type="text" name="username" id="username" /> <br>

        <label for="password">Adresse : </label>
        <input type="text" name="password" id="password" /> <br>

        <input type="submit" name="Créer" id="Créer"/>
    </div>

</form>

</body>
</html>