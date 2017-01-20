<%@page import="tn.iit.shop.ProduitDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.taglibs.standard.tag.rt.core.ForEachTag"%>
<%@page import="tn.iit.shop.Shop"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<tr>
<td>

<%
List<ProduitDto> liste = new ArrayList<ProduitDto>();
//List<ProduitDto> list= (List<ProduitDto>) q.getResultList();
int i=0;
out.print("<table>");
for (ProduitDto object: liste) {
	
    //System.out.println(object);
    out.print("<tr>"+ liste.get(i).getNom() + "</tr>");
    
    
    i++;
}

out.print("</table>");
%>

<%=session.getAttribute("list") %>

</body>
</html>