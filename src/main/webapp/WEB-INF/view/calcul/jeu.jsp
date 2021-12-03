<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/style.css"/>
    <title>Calcul mental</title>
</head>
<body>

<c:set var="calcul" value="${StringCalcul}" scope="request"/>
<p id="calcul"><c:out value="${requestScope.StringCalcul}"/></p>

<input type="number" id="reponse" name="reponse" placeholder="Entrez le résultat" />
<input id="valider" type="submit" value="Valider" name="valider"/>

<p id="bonneReponse"></p>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

    $("#valider").on('click', function () {

        var reponse = $('#reponse').val();

        var data = {
            reponse: reponse
        }
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/calculMental",
            contentType: 'application/json',
            data: JSON.stringify(data),

            success: function (resultatJSON) {
                console.log(resultatJSON);

                $("#calcul").text(resultatJSON.affichageCalcul);

                if(resultatJSON.bonneReponse===true){
                    $("#bonneReponse").css("color", "green");
                    $("#bonneReponse").text("Bonne réponse !");
                } else {
                    $("#bonneReponse").css("color", "red");
                    $("#bonneReponse").text("Mauvaise réponse !");
                }

                if(resultatJSON.nbCalcul===8) {
                    $("#reponse").prop( "disabled", true);
                    $("#calcul").text("Score total : " +resultatJSON.score);
                    $("#valider").attr("value", "Continuer");
                }
            },
            error: function (errorThrown) {
                //your error code
                alert("not success : " + errorThrown);
            }
        });
    });


</script>
</html>
