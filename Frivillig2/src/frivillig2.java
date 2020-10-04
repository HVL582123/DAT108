import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle.*;
import org.apache.commons.text.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dittnavn")
public class frivillig2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String navn = request.getParameter("navn");
		navn = escapeHtml(navn);
		
		String utmld;
		 String sprak = request.getLocale().toString();
		 SprakSjekk spr = new SprakSjekk();
		 
		 if(spr.isValidLanguage(sprak)) {
			 utmld = spr.riktigSprak(sprak);
		 }else {
			 utmld = "Hello ";
		 }
		
		
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Hei</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><b>" + utmld + navn +"!" +"</b></p>");
        out.println("<button onclick=" + "goBack()" + ">En gang til</button>");
        out.println("<script> function goBack() { window.history.back(); } </script>");
        out.println("</body>");
        out.println("</html>");
	}
	
	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		//...
		return resultat;
	}
}
