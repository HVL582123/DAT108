import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regnom")
public class frivillig1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String temperatur = (request.getParameter("temperatur"));
		String valg = request.getParameter("kalkuler").toLowerCase();
		
		String responsmelding = "";
		Validator val = new Validator();
		if(val.isValidTemperatur(temperatur)) {
			responsmelding = omregning(temperatur,valg);
		}else {
			responsmelding += "Ugyldig input, prøv gjerne igjen!";
		}
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Resultat</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Temperaturomregning resultat</p>");
        out.println("<p><b>" + responsmelding +" </b></p>");
        out.println("<button onclick=" + "goBack()" + ">En gang til</button>");
        out.println("<script> function goBack() { window.history.back(); } </script>");
        out.println("</body>");
        out.println("</html>");
	}
	
	private String omregning(String temperatur, String valg) {
		String resultat;
		float temp = Float.parseFloat(temperatur);
		if(valg.startsWith("c") && (temp >= -273.15)) {
			//Celsius til Fahrenheit
			temp = temp*(9f/5) + 32;
			resultat = temperatur + format(valg) + " = " + String.format("%.1f", temp)+"°F";
		}else if(valg.startsWith("f") && (temp >= -459.67)){
			temp = (temp-32)*(5f/9);
			resultat = temperatur + format(valg) + " = " + String.format("%.1f", temp)+"°C";
			
		}else {
			resultat = "Her gikk noe galt, sjekk over og prøv på nytt";
		}
		return resultat;
	}
	
	private String format(String valg) {
		String enhet;
		if(valg.startsWith("c")) {
			enhet = "°C";
		}else {
			enhet = "°F";
		}
		return enhet;
	}

//	private boolean erGyldigTall(String temperatur,String valg) {
//		boolean gyldig = true;
//		float sjekk;
//		if(temperatur.matches("-?\\d+(\\.\\d+)?")) {
//			sjekk = Float.parseFloat(temperatur);
//			if(valg.startsWith("c")) {
//				gyldig = (sjekk >= -273.15);
//			}else if (valg.startsWith("f")){
//				gyldig = (sjekk >= -459.67);
//			}
//		}else {
//			gyldig = false;
//	}
//		return gyldig;
	}


