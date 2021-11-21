<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<form method="post" action="utilisateur/ajouter">
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