<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page
        contentType="text/html; charset=windows-1256"
        pageEncoding="windows-1256"
%>

<!DOCTYPE html>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Page de connexion</title>
</head>

<body>
<h1>Connexion</h1>

<c:if test="${not empty requestScope.error}">
    <div id="errorAlert" class="alert alert-danger d-flex align-items-center" role="alert" autohide="true">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
            <use xlink:href="#exclamation-triangle-fill"></use>
        </svg>
        <div> ${requestScope.error.toString()} </div>
    </div>


</c:if>

<form id="formLogin" action="login" method="post">

    <div class="form-group">
        <label for="username">Username : </label> <br>
        <input class="form-control" type="text" id="username" name="username" required/><br>

        <label for="password">Mot de passe : </label><br>
        <input class="form-control" type="password" id="password" name="password" required/> <br>

    </div>
    <div class="buttonLogin">
        <input class="btn btn-success" type="submit" value="Connexion"><br><br>
    </div>
    <div class="buttonLogin">
        <a class="btn btn-primary" href="ajouter"> Créer un compte</a>
    </div>

</form>

<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
    </symbol>
</svg>

</body>

</html>