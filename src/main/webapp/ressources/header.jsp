<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <h3 id="titre" class="text-light bg-dark"> Mentis Arithmetica</h3>
        <div id="containerDiv" class="container-fluid justify-content-between">
            <div class="d-flex">
                <a id="navbarbrand" class="navbar-brand" href="meilleur_score"> Meilleurs scores</a>
            </div>
            <ul id="divDroite" class="navbar-nav flex-row" style="width: 12%">
                <li id="premierli"><a id="btnProfil" class="nav-link active" href="profil">Mon profil</a></li>
                <li><a id="btnDeco" class="btn btn-danger" href="logout"> Déconnexion </a></li>
            </ul>
        </div>
    </nav>
</header>
</body>
</html>
