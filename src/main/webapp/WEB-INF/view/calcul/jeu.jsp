<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Calcul mental</title>
</head>
<body>

        <select id="diff" class="form-select" data-size="5" aria-label="Default select example" >
            <option selected>Selectionner une difficulté</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>

        <p id="affichageCalcul"> Calcul </p>
        <input type="text" id="reponse" placeholder="Entrez le résultat" onclick="refreshCalcul()"/>
        <input type="submit" value="Valider"/>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">

    function refreshCalcul() {
                select = document.getElementById("diff");
                difficulte = select.selectedIndex;

                $.ajax({
                    type: 'GET',
                    url: './Calcul'+difficulte,   //Make sure you put the correct endpoint URL here!
                    success: function(data) {
                        //DO SOMETHING HERE AFTER YOU GET THE RESPONSE FROM the validate function
                        document.getElementById("affichageCalcul").innerHTML = data;
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        //Do something on ERROR here
                    }
                });
    }

</script>
</html>
