package com.servlets;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.javaBeans.Ville;
import com.javaBeansUtils.RestClient;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Servlet implementation class Tp1Servlet
 */
@WebServlet("/ListeVilleServlet")
public class ListeVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeVilleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Ville> listevilles = RestClient.getListeVille();
		request.setAttribute("listevilles", listevilles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeville.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String codeInsee = request.getParameter("delete");
		RestClient.DeleteVille(codeInsee);

		this.doGet(request, response);

		// this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
	}

}
