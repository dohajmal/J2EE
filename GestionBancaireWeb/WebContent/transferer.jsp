<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="CompteBancaireServlet" name="form"
		style="margin-left: 30%">
		<h2 style="margin-left: 12%;color: rgba(23, 53, 169, 0.66);;">Transferer Solde</h2>

		<table>
			<tr>

				<td>Solde :</td>
				<input name="rib" value="${listt.rib}" hidden="true" />

				<input name="cin" value="${liste.get(0).client.cin}" type="hidden" />
				<td><input type="text" name="solde" id="solde" class="form-control" placeholder="Solde" style="width:178%;height:34px" /></td>
</tr>
			<tr>	<td></td><td><select size="1" name="transfer" class="form-control" style="width: 178%;height: 34px;" >
						<c:forEach items="${listee}" var="compte">
						<%-- 	<option value="${compte.rib}">${compte.client.nom}</option>--%>
						<option value="${compte.rib}">${compte.rib}</option>
						</c:forEach></td>
				</select>

			</tr>
		</table>
		<input type="submit" value="Transferer" name="bt"
			class="btn btn-default" style="margin-left: 16%;margin-top: 7px;width: 20%;" />
	</form>
</body>
</html>