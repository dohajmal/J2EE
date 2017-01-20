package tn.iit.glid3;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.jms.Session;
import javax.naming.ldap.PagedResultsControl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.shop.ProduitDto;
import tn.iit.shop.Shop;
import tn.iit.shop.ShopLocal;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ShopLocal shoplocal;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		double prix=0 ;
		int qte=0;
        String nom = request.getParameter("nom");
       
       if (request.getParameter("qte") != null && !request.getParameter("qte").equals("")) {
    	      qte = Integer.parseInt(request.getParameter("qte"));
    	   }
		if (request.getParameter("prix") != null && !request.getParameter("prix").equals("")) {
		       prix =Double.parseDouble(request.getParameter("prix"));
		}
		
		HttpSession session = request.getSession(true);
		System.out.println(request.getParameter("bt"));
		if (request.getParameter("bt").equals("Ajout")) {

			shoplocal.creerclient(nom, prix, qte);
			session.setAttribute("list",shoplocal.listproduit());
			
			// response.getWriter().println("rib"+ rib + "nom Client" +
			// nomClient + "solde compte" + solde_compte);
			response.sendRedirect("listeproduit.jsp");
		} else if (request.getParameter("bt").equals("Modifier")) {
			shoplocal.achatProduit(nom, qte, prix);
			session.setAttribute("list",shoplocal.listproduit());
			response.sendRedirect("listeproduit.jsp");
		}else if (request.getParameter("bt").equals("Supprimer")) {
			session.setAttribute("list", shoplocal.suppressionProduit(nom, qte,prix));
			response.sendRedirect("listeproduit.jsp");			
		}
		else if (request.getParameter("bt").equals("List")) {
			session.setAttribute("list", shoplocal.listproduit());
			response.sendRedirect("listeproduit.jsp");	
		}
		else if (request.getParameter("bt").equals("Total")) {
			session.setAttribute("list", shoplocal.getTotal());
			response.sendRedirect("listeproduit.jsp");	
		}
	}
       
       
       /*shoplocal.achatProduit(nom, qte, prix);
	
       response.setContentType("text/html");
      */
       //response.getWriter().println("<h1>"+shoplocal.listProduitAchete()+"</h1>");
       
       //System.out.println("total="+shoplocal.getTotal());
        //HttpSession session=request.getSession(true);
        //session.setAttribute("liste",shoplocal.listProduitAchete());
           
       //session.setAttribute("nom",shoplocal.listproduit() );
       //session.setAttribute("prix", prix);
       //session.setAttribute("qte", qte);


}
