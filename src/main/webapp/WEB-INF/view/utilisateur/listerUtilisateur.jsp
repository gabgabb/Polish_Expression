<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="plep.entite.Utilisateur" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcul mental - Home page</title>
</head>
<body>
<h1>Les meilleurs scores</h1>
<ul>
    <%
        ArrayList<Utilisateur> listeCollabos = (ArrayList<Utilisateur>) request.getAttribute("listeCollabos");
        for (Utilisateur c : listeCollabos) {
    %>
    <li><%= c.getNom() %></li>
    <%
        } %>
</ul>
</body>
</html>
