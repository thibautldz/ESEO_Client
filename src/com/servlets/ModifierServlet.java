package com.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaBeans.Ville;
import com.javaBeansUtils.RestClient;
import com.sun.jersey.api.client.Client;

/**
 * Servlet implementation class Tp1Servlet
 */
@WebServlet("/ModifierServlet")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm:ss");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codeInsee = request.getParameter("insee");
		request.setAttribute("codeInsee", codeInsee);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String codeInsee = request.getParameter("codeInsee");
		List<Ville> lv1 = RestClient.getVillebyCodeInsee(codeInsee);
        Ville v1 = lv1.get(0);
        
		String nomcom = request.getParameter("nomcom");
		if(nomcom == "")
		{
			nomcom = v1.getNom_commune();
		}
        String cp = request.getParameter("cp");
        if(cp == "")
		{
			cp = v1.getCode_postal();
		}
        String libelle = request.getParameter("libelle");
        if(libelle == "")
		{
			libelle = v1.getLibelle_acheminement();
		}
        String ligne5 = request.getParameter("ligne5");

        String latitude = request.getParameter("latitude");
        if(latitude == "")
		{
			latitude = v1.getLatitude();
		}
        String longitude = request.getParameter("longitude");
        if(longitude == "")
		{
			longitude = v1.getLongitude();
		}
        
        Ville vmodif = new Ville(codeInsee,nomcom,cp,libelle,ligne5,latitude,longitude);
        RestClient.PutVille(vmodif, codeInsee);

		this.doGet(request, response);

		// this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
	}

}
