<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="margin-left: 37%;color: rgba(23, 53, 169, 0.66);;">Modifier Client</h2>
	<form method="POST" action="ClientBanqueServlet" style="margin-left:30%">
		<input name="id" value="${modif.cin}" hidden="true" /> 
	<label>Nom :</label> <input name="nom" value="${modif.nom}" class="form-control" placeholder="NOM" style="    width: 40%;height:34px"/> 
	<label>Prenom :</label> <input name="prenom"	value="${modif.prenom}" class="form-control" placeholder="PRENOM" style="width: 40%;height:34px"/> 
	<label>Adresse :</label> <input name="adresse"	value="${modif.adresse}" class="form-control" placeholder="ADRESSE" style=" width: 40%;height:34px"/>
	<input type="submit" name="bt" value="modifier" class="btn btn-default" style="margin-left: 10%;margin-top: 13px;width: 22%;"></input>
	</form>
</body>
</html>