import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
public class SprakSjekk {

	public boolean isValidLanguage(String locale) {
		return sprak(locale) && locale!=null;
	}
	
	public boolean sprak(String s) {
		boolean gyldigsprak;
		if(s.startsWith(("en")) || s.startsWith("no") || s.startsWith("de") || s.startsWith("nb")){
			gyldigsprak = true;
		}else {
			gyldigsprak = false;
		}
		return gyldigsprak;
		
	}
	
	public String riktigSprak(String t) {
		String ut;
		if(t.startsWith("no") || t.startsWith("nb")) {
			ut = "God dag ";
		}else if(t.startsWith("de")) {
			ut = "Guten tag ";
		}else {
			ut = "Hello ";
		}
		return ut;
	}
}
