<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/ressources/header.jsp"/>
    <title>Calcul mental</title>
</head>
<body>

<div id="calculJeu">

    <div class="d-block w-100">
        <div class="progress">
            <div id="progressbarCalcul" class="progress-bar bg-info"
                 role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10" style="width: 0"></div>
        </div>
    </div>

    <c:set var="calcul" value="${StringCalcul}" scope="request"/>
    <p id="calcul"><c:out value="${requestScope.StringCalcul}"/></p>

    <input class="form-control" type="number" id="reponse" name="reponse" placeholder="Entrez le résultat"/>
    <input class="btn btn-success" id="valider" type="submit" value="Valider" name="valider"/>

    <p id="bonneReponse"></p>
</div>
</body>

<script>

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
                $("#progressbarCalcul").width(resultatJSON.nbCalcul*10 + '%');
                $("#calcul").text(resultatJSON.affichageCalcul);

                if (resultatJSON.bonneReponse === true) {
                    $("#bonneReponse").css("color", "green");
                    $("#bonneReponse").text("Bonne réponse !");
                } else {
                    $("#bonneReponse").css("color", "red");
                    $("#bonneReponse").text("Mauvaise réponse !");
                }

                if (resultatJSON.nbCalcul === 10) {
                    $("#reponse").val("");
                    $("#reponse").prop("disabled", true);
                    $("#valider").prop("disabled", true);
                    setTimeout(function () {
                        $("#bonneReponse").hide();
                        $("#calcul").text("Score total : " + resultatJSON.score + "/10");

                    }, 1500);
                } else {
                    $("#reponse").val("");
                    setTimeout(function () {
                        $("#bonneReponse").text("");
                    }, 1500);
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
