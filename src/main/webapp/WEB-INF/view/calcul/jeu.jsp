<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Calcul mental</title>
</head>
<body>

        <c:set var="calcul" value="${calcul}" scope="request"/>
        <p id="calcul">
        <c:out value="${requestScope.calcul}"/>
        </p>
        <input type="number" id="reponse" name="reponse" placeholder="Entrez le résultat"/>
        <input id="valider" type="submit" value="Valider" name="valider"/>

        <p id="score"></p>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

    $("#valider").on('click',function() {
            //reponse = $("#reponse").val();
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/calculMental",
                data : $('#reponse').serialize(),
                dataType : "text",
                success : function(resultat, score) {
                    $("#calcul").text(resultat);
                    $("#score").text(score);
                },
                error: function (errorThrown) {
                    //your error code
                    alert("not success : " + errorThrown);
                }
            });
    });


</script>
</html>
