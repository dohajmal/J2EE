package tn.iit;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.CalculLocal;
import tn.iit.CalculEhbBen;

/**
 * Servlet implementation class ClientCalcul
 */
@WebServlet("/ClientCalcul")
public class ClientCalcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanInterface=CalculEhbBen.class)
	private CalculLocal calcullocal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientCalcul() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("la Somme est :"+calcullocal.som(20, 5));
		response.getWriter().println("la multplicite est :"+calcullocal.mult(2, 6));
		response.getWriter().println("la Soustarction est :"+calcullocal.sous(5, 5));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
