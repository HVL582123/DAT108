package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogginnServlet")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private PersonDAO personDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.getSession().removeAttribute("ingenSesjon");
	HttpSession sesjon = request.getSession(false);
	
	if(sesjon != null && sesjon.getAttribute("bruker") != null) {
		response.sendRedirect("deltagerlisteServlet" + "?loggetinn");
	}else {
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Logginn logginn = new Logginn(request,personDAO);
	Person person = logginn.hentPerson();
	if(logginn.verifiserLoginn()) {
		
		HttpSession sesjon = request.getSession(false);
		
		if (sesjon != null) {
			sesjon.invalidate();
		}

		sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(10);
		sesjon.setAttribute("bruker", person);
		response.sendRedirect("deltagerlisteServlet");
	}else {
		
		logginn.feilmelding();
		request.getSession().removeAttribute("ingenSesjon");
		request.getSession().setAttribute("logginn", logginn);
		response.sendRedirect("LogginnServlet");
		
	}
	
	
	}

}