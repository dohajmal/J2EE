<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="ProduitServlet">
		<label for="nom">Nom</label> <input type="text" id="nom" name="nom"
			value="" size="20" maxlength="20" /> <br /> <label for="Qte">Qte</label>
		<input type="text" id="qte" name="qte" value="" size="20"
			maxlength="20" /> <br /> <label for="prix">Prix</label> <input
			type="text" id="prix" name="prix" value="" size="20" maxlength="20" />
		<br /> <input type="submit" value="Ajout" name="bt" class="sansLabel" />
		<input type="submit" value="Modifier" name="bt" class="sansLabel" />
		<input type="submit" value="Supprimer" name="bt" class="sansLabel" />
		<input type="submit" value="List" name="bt" class="sansLabel" /> <br />
		<input type="submit" value="Total" name="bt" class="sansLabel" /> <br />
	</form>

</body>
</html>