package com.servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaBeans.Ville;
import com.javaBeansUtils.RestClient;
import com.sun.jersey.api.client.Client;

/**
 * Servlet implementation class Tp1Servlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codeVille1 = request.getParameter("selectville1");
        String codeVille2 = request.getParameter("selectville2");
        List<Ville> lv1 = RestClient.getVillebyCodeInsee(codeVille1);
        List<Ville> lv2 = RestClient.getVillebyCodeInsee(codeVille2);
        Ville v1 = lv1.get(0);
        Ville v2 = lv2.get(0);
        
        System.out.println(v1.getNom_commune());
        System.out.println(v2.getNom_commune());
        
        double distance = v1.calculerDistance(v2);
        NumberFormat nf = new DecimalFormat("0.###");
        String s = nf.format(distance);
        
        HttpSession session = request.getSession();
        session.setAttribute("ville1",v1.getNom_commune());
        session.setAttribute("ville2",v2.getNom_commune());
        session.setAttribute("distance",s);
        
		
		this.doGet(request, response);

		// this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
	}

}
