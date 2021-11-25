<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Page de connexion</title>
</head>

<body>

<form action="login" method="post">

    <div class="form-group w-25">
        <label>Username : </label> <br>
        <input class="form-control" type="text" name="username"/><br>

        <label>Mot de passe : </label><br>
        <input class="form-control" type="text" name="password"/>
    </div>
    <br>
    <input class="btn btn-success" type="submit" value="Connexion"><br><br>

    <a class="btn btn-primary" href="ajouter"> Créer un compte</a>

</form>

</body>
</html>