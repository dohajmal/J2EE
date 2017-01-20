<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="CompteBancaireServlet"  name="form" style="margin-left:30%">
	<h2>Client : ${liste.get(0).client.nom}
${liste.get(0).client.prenom}
(${liste.get(0).client.cin})</h2>
	
		<h2 style=" margin-left: 8%;color:rgba(23, 53, 169, 0.66);">Ajout Compte</h2>

		<table>
			<tr>


				<td>Solde :</td>
				<td><input type="text" name="solde" id="solde" class="form-control" placeholder="Solde" style="    width: 117%;"/></td>
				<td><input name="id" value="${liste.get(0).client.cin}"
					type="hidden" /></td>


			</tr>
		</table>
		<input type="submit" value="Ajouter" name="bt" class="btn btn-default" style=" margin-left: 30%;margin-top: -34px;"/>

	
		<table class="table table-bordered" style=" margin-left: -19%;margin-top: 2%;
    width: 80%;
    max-width: 100%;
    margin-bottom: 20px;">
			<tr class="bg-light">
				<th>Rib</th>
				<th>Solde</th>
				<th>Supprimer</th>
				<th>Déposer</th>
				<th>Retirer</th>
				<th>Transferer</th>
			<tr>
			
			
				<c:forEach items="${liste}" var="compte">

					<tr>

						<td>${compte.rib}</td>
						<td>${compte.solde}</td>
						<td><a
							href="CompteBancaireServlet?id=${compte.rib}&var=1&cin=${compte.client.cin}"
							name="bt"> Delete</a></td>
						
						<td><a href="" onclick="this.href='CompteBancaireServlet?&id=${compte.rib}&var=3&cin=${compte.client.cin}&solde='+document.getElementById('solde').value" name="bt"> Deposer</a></td>
						<td><a href="" onclick="this.href='CompteBancaireServlet?&id=${compte.rib}&var=4&cin=${compte.client.cin}&solde='+document.getElementById('solde').value"
							> Retirer</a></td>
						<td><a href="CompteBancaireServlet?rib=${compte.rib}&var=5&cin=${compte.client.cin}"
							name="bt" value="transferer"> Transférer</a></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</form>
</body>
</html>