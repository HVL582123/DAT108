package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PersonDAO personDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Skjema skjema = new Skjema(request);
		if (skjema.altErGyldig()) {
			HttpSession sesjon = request.getSession(false);
			Person p = skjema.nyPerson();
			
			if (personDAO.finnPerson(p.getMobilnr()) != null) { // Sender personen til Logginn siden
				response.sendRedirect("LogginnServlet");
			} 
			else {
				personDAO.leggTil(p); // legge til personen i databasen
				if (sesjon != null) {
					sesjon.invalidate();
				}
				sesjon = request.getSession(true); // Her vil den ikke finne ny sesjon, så den lager ny

				request.getSession().setAttribute("fornavn", skjema.getFornavn());
				request.getSession().setAttribute("etternavn", skjema.getEtternavn());
				request.getSession().setAttribute("mobilnr", skjema.getMobilnr());
				request.getSession().setAttribute("kjonn", skjema.getKjonn());
				request.getSession().setAttribute("bruker", p);
				request.getSession().removeAttribute("skjema");

				response.sendRedirect("BekreftelseServlet?fornavn=");
			}
		} else {
			skjema.feilmeldinger(); // Setter opp feilmeldinger og endrer attributer
			
			request.getSession().setAttribute("skjema", skjema); // oppdaterer skjema
			response.sendRedirect("PaameldingServlet");
		}

	}
}
