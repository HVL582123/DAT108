package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deltagerlisteServlet")
public class deltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonDAO personDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			request.getSession().setAttribute("listePaameldte", personDAO.paameldingsliste());
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect("LogginnServlet");
		}
		
	}
}
