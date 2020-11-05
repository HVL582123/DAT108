package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Logginn {

	private String mobilnr;
	private String passord;
	private String feilmelding;
	
	private PersonDAO personDAO;
	
	public Logginn(HttpServletRequest request, PersonDAO personDAO) {
		this.mobilnr = request.getParameter("mobilnr");
		this.passord = request.getParameter("passord");
		this.feilmelding = "";
		this.personDAO = personDAO;
	}

	public boolean verifiserLoginn() {
	boolean verifisert = false;
		if(gyldigInput()) {
			Person p = hentPerson();
			verifisert = PassordUtil.sjekkPassord(passord, p.getPassord());
		}
		return verifisert;
	}
	
	public Person hentPerson() {
		return personDAO.finnPerson(mobilnr);
	}
	
	
	public boolean gyldigInput() {
		return gyldigPassord() && gyldigMobilnr();
	}
	
	private boolean gyldigPassord() {
		return passord.matches("^(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$");
	}
	
	private boolean gyldigMobilnr() {
		return mobilnr.matches("^[0-9]{8}$");
	}
	
	
	public void feilmelding() {
		if(!gyldigInput() || !verifiserLoginn()) {
			feilmelding = "Ugyldig brukernavn og/eller passord!";
			mobilnr = "";
			passord = "";
		}
	}
	
	
	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getFeilmelding() {
		return feilmelding;
	}

	public void setFeilmelding(String feilmelding) {
		this.feilmelding = feilmelding;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	
}
