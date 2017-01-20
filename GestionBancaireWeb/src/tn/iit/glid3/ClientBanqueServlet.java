package tn.iit.glid3;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.model.ClientBanque;
import tn.iit.service.ClientBanqueService;



/**
 * Servlet implementation class ClientBanqueServlet
 */
@WebServlet("/ClientBanqueServlet")
public class ClientBanqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientBanqueService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientBanqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			
		
	
		int var = Integer.parseInt(request.getParameter("var"));
		if(var==1){
			//int id = Integer.parseInt(request.getParameter("id"));
			String id = request.getParameter("id");
		 ClientBanque cb = new ClientBanque();
	 	 cb.setCin(id);
	 	 service.delete(cb);	 	
	 	 List<ClientBanque> clb1=service.list();
	 	HttpSession session = request.getSession(true);
		session.setAttribute("listClient",clb1);
		response.sendRedirect("clients.jsp");
		} else if(var ==2){
			String id = request.getParameter("id");
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			ClientBanque cb1 = new ClientBanque(id,nom,prenom,adresse);
			service.update(cb1);
		 
		 	request.getSession().setAttribute("modif", cb1);
		 	response.sendRedirect("Modifier.jsp");
		}else if(var==7){
	 	 List<ClientBanque> clb1=service.list();
	 	HttpSession session = request.getSession(true);
		session.setAttribute("listClient",clb1);
		response.sendRedirect("clients.jsp");
		} 
	
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("bt").equals("Ajouter")){
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
		ClientBanque cl=new ClientBanque(cin,nom,prenom,adresse);
		service.save(cl);
		System.out.println();
		List<ClientBanque> clb=service.list();
		HttpSession session = request.getSession(true);
		session.setAttribute("listClient",clb);
		System.out.println("ddd"+service.list().size());
		response.sendRedirect("clients.jsp");
		
		}else if(request.getParameter("bt").equals("modifier")){
			//int id = Integer.parseInt(request.getParameter("id"));
			String id = request.getParameter("id");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			ClientBanque cb1 = new ClientBanque(id,nom,prenom,adresse);
			service.update(cb1);
			List<ClientBanque> clb=service.list();
			HttpSession session = request.getSession(true);
			session.setAttribute("listClient",clb);
			response.sendRedirect("clients.jsp");
		}	

		doGet(request, response);
		

	}

}
