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
import tn.iit.model.CompteBancaire;
import tn.iit.service.ClientBanqueService;
import tn.iit.service.CompteBancaireService;
import tn.iit.service.CompteBancaireServiceLocal;

/**
 * Servlet implementation class CompteBancaireServlet
 */
@WebServlet("/CompteBancaireServlet")
public class CompteBancaireServlet extends HttpServlet {
	@EJB
	private CompteBancaireService serviceB;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteBancaireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private ClientBanqueService serviceC;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int var = Integer.parseInt(request.getParameter("var"));
		if (var == 2) {
			String cin = request.getParameter("cin");
			ClientBanque c = serviceC.find(cin);
			// System.out.println(c.getNom());
			List<CompteBancaire> cb = serviceB.list(c);
			System.out.println("ddd" + cb.size());
			HttpSession session = request.getSession(true);
			session.setAttribute("liste", cb);
			response.sendRedirect("comptes.jsp");
		} else if (var == 1) {
			String cin = request.getParameter("cin");
			String ribb = request.getParameter("id");
			Long rib = Long.parseLong(ribb);
			System.out.println(cin + "  ");
			System.out.println(rib);
			CompteBancaire cb1 = new CompteBancaire();
			cb1.setRib(rib);
			serviceB.remove(cb1);
			ClientBanque c1 = serviceC.find(cin);
			List<CompteBancaire> cb = serviceB.list(c1);

			HttpSession session = request.getSession(true);
			session.setAttribute("liste", cb);

			response.sendRedirect("comptes.jsp");
		} else if (var == 3) {
			String cin = request.getParameter("cin");
			String ribb = request.getParameter("id");
			Long rib = Long.parseLong(ribb);
			System.out.println(rib);
			String soldee = request.getParameter("solde");
			double solde = Double.parseDouble(soldee);
			System.out.println(solde);
			serviceB.depotArgent(rib, solde);
			ClientBanque c1 = serviceC.find(cin);
			List<CompteBancaire> cb = serviceB.list(c1);

			HttpSession session = request.getSession(true);
			session.setAttribute("liste", cb);

			response.sendRedirect("comptes.jsp");
		} else if (var == 4) {
			String cin = request.getParameter("cin");
			String ribb = request.getParameter("id");
			Long rib = Long.parseLong(ribb);
			System.out.println(rib);
			String soldee = request.getParameter("solde");
			double solde = Double.parseDouble(soldee);
			System.out.println(solde);
			serviceB.retraitArgent(rib, solde);
			ClientBanque c1 = serviceC.find(cin);
			List<CompteBancaire> cb = serviceB.list(c1);

			HttpSession session = request.getSession(true);
			session.setAttribute("liste", cb);

			response.sendRedirect("comptes.jsp");

		} else if (var == 5) {
			String ribb = request.getParameter("rib");
			Long rib = Long.parseLong(ribb);
			System.out.println(rib);
			CompteBancaire cbb= new CompteBancaire(rib);
			List<CompteBancaire> cb = serviceB.listRib(rib);
			HttpSession session = request.getSession(true);
			session.setAttribute("listee", cb);
			session.setAttribute("listt", cbb);

			response.sendRedirect("transferer.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 if(request.getParameter("bt").equals("Ajouter")){
		String cin = request.getParameter("id");
		Double solde = Double.parseDouble(request.getParameter("solde"));
		System.out.println(cin);
		System.out.println(solde);
		ClientBanque c1 = serviceC.find(cin);
		System.out.println(c1.getNom());
		CompteBancaire cb1 = new CompteBancaire();
		cb1.setSolde(solde);
		cb1.setClient(c1);
		serviceB.save(cb1);

		List<CompteBancaire> cb = serviceB.list(c1);

		HttpSession session = request.getSession(true);
		session.setAttribute("liste", cb);

		response.sendRedirect("comptes.jsp");

		 }else if(request.getParameter("bt").equals("Transferer")){
				String cin = request.getParameter("cin");
				Double solde = Double.parseDouble(request.getParameter("solde"));
				String transferr=request.getParameter("transfer");
				Long transfer =Long.parseLong(transferr);
				String ribb = request.getParameter("rib");
				Long rib = Long.parseLong(ribb);
				System.out.println("cin"+cin);
				System.out.println("transfer"+transfer);
				System.out.println("solde"+solde);
				serviceB.retraitArgent(rib, solde);
				serviceB.depotArgent(transfer, solde);
				ClientBanque c1 = serviceC.find(cin);
				CompteBancaire cb1 = new CompteBancaire();
				cb1.setSolde(solde);
				cb1.setClient(c1);
				//serviceB.save(cb1);
				List<CompteBancaire> cb = serviceB.list(c1);

				HttpSession session = request.getSession(true);
				session.setAttribute("liste", cb);
				response.sendRedirect("comptes.jsp");
		 }

	}

}
