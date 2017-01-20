package com.helloejb.client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.hello.HelloLocal;
import tn.iit.hello.HelloRemote;

/**
 * Servlet implementation class WebClient
 */
@WebServlet("/WebClient")
public class WebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private HelloRemote helloLocal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("la name est :"+helloLocal.say_hello());
		response.getWriter().append("la name est :"+helloLocal.say_hello());
		response.getWriter().println("la Somme est :"+helloLocal.som(20, 5));
		response.getWriter().println("la Multp est :"+helloLocal.mult(2, 6));
		response.getWriter().println("la Sous est :"+helloLocal.sous(5, 5));
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
