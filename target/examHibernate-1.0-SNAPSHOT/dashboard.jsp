<%--
  Created by IntelliJ IDEA.
  User: Johan
  Date: 08/02/2021
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h3>Nombre de voitures par marques :</h3>
<c:forEach items="${nbCarsByMarques}" var="marques">
    Marques : ${marques.key}, nombre de voitures = ${marques.value}<br>
</c:forEach>

<h3>Les dix dernières voitures créées:</h3>
<c:forEach var="tenLastCar" items="${requestScope.tenLastCars}">
    <li>${tenLastCar.marque} - ${tenLastCar.modele}</li>
</c:forEach>

<h3>Nombre de voiture dans la bdd : ${nbCars}</h3>
</body>
</html>
