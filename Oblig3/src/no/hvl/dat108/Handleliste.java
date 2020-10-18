package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.transport.commons_text.StringEscapeUtils;

import javax.servlet.*;

@WebServlet(name = "Handleliste", urlPatterns = "/Handleliste")
public class Handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HandlelisteDOA liste = new HandlelisteDOA();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (sesjon == null) {
			System.out.println("Du har vært innaktiv for lenge");
			response.sendRedirect("Innlogging");
			return;
		}

		String ny = request.getParameter("nyTing");
		if (ny != null && !ny.isEmpty()) {
			liste.leggTil(ny.strip());
		}

		String slett = request.getParameter("slettElement");
		if (slett != null) {
			liste.slettTing(slett);
		}

		System.out.println("Oppdaterer handlelisten");
		response.sendRedirect("Handleliste");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Handleliste</title>");
		out.println("</head>");
		out.println("</body>");
		out.println("<form action=\"Handleliste\" method=\"post\">");
		out.println("<h3>Min handleliste</h3>");
		out.println("<p><input type=\"submit\" value=\"Legg til\" /><input type=\"text\" name=\"nyTing\" /></p>");
		out.println("</form>");
		for (String ting : liste.getHandelisteDOA()) {
			out.println("<form action=\"Handleliste\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"slettElement\" value=\"" + ting + "\" />");
			out.println("<input type=\"submit\" value=\"Slett\" />");
			out.println(StringEscapeUtils.escapeHtml4(ting.toString()));
			out.println("</form>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}