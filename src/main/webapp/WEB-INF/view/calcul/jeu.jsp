<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Calcul mental</title>
</head>
<body>

        <c:set var="calcul" value="${StringCalcul}" scope="request"/>
        <p id="calcul"> <c:out value="${requestScope.StringCalcul}"/> </p>

        <input type="number" id="reponse" name="reponse" placeholder="Entrez le résultat" required/>
        <input id="valider" type="submit" value="Valider" name="valider"/>

        <p id="score"></p>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

    var nbCalcul = 0;
    $("#valider").on('click',function() {

            console.log("calcul : " + nbCalcul);
            var reponse = $('#reponse').val();
            console.log("reponse : "+reponse);
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/calculMental",
                contentType : 'application/json',
                data : JSON.stringify({ data1 : reponse, data2 : nbCalcul}),

                success : function(resultat) {
                    //nbCalcul++;
                    //$("#calcul").text(resultat);
                    //$('#score').text(score);
                    //console.log("Calcul numero : " + nbCalcul);

                },
                error: function (errorThrown) {
                    //your error code
                    alert("not success : " + errorThrown);
                }
            });
    });


</script>
</html>
