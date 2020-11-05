package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	
	
	private String fornavn;
	private String etternavn;
	private String mobilnr;
	private String passord;
	private String passordMatch;
	private String kjonn;

	// Feilmeldinger
	private String feilFornavn;
	private String feilEtternavn;
	private String feilMobilnr;
	private String feilPassord;
	private String feilPassordMatch;
	private String feilKjonn;

	public Skjema(HttpServletRequest request) { // Henter verdier fra parametrene i paameldingsskjema
		this.mobilnr = request.getParameter("mobilnr");
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.passord = request.getParameter("passord");
		this.passordMatch = request.getParameter("passordMatch");
		this.kjonn = request.getParameter("kjonn");
	}
	
	public Person nyPerson() {
		passord = PassordUtil.krypterPassord(passord);
		return new Person(mobilnr, fornavn, etternavn, passord, kjonn);
	}

	public boolean kjonnHuketAv() { // Sjekke at det er huket av på parameteret "kjonn"
		return kjonn != null;
	}

	// Lage metoder for å sjekke at input er gyldig
	private boolean gyldigFornavn() {
		return fornavn.matches("([A-ZÆØÅ][A-Za-z-æøå]{1,20})\\w+");
	}

	private boolean gyldigEtternavn() {
		return etternavn.matches("([A-ZÆØÅ][A-Za-z-æøå]{1,20})\\w+");
	}

	private boolean gyldigMobilnr() {
		return mobilnr.matches("^[0-9]{8}$");
	}

	// Minst 8 tegn med små/store bokstaver og tall, minst 1 tall og en stor bokstav
	private boolean gyldigPassord() {
		return passord.matches("^(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$");
	}

	private boolean gyldigPassordMatch() {
		return passordMatch.equals(passord);
	}
	
	public boolean altErGyldig() {
		return gyldigFornavn() && gyldigEtternavn() && gyldigMobilnr() && gyldigPassord() && gyldigPassordMatch() && kjonnHuketAv();
	}
	
	public void feilmeldinger() {
		if(!gyldigFornavn()) {
			feilFornavn = "Ugyldig fornavn!";
			fornavn = "";
		}
		if(!gyldigEtternavn()) {
			feilEtternavn = "Ugyldig etternavn!";
			etternavn = "";
		}
		if(!gyldigMobilnr()) {
			feilMobilnr = "Ugyldig mobilnummer!";
			mobilnr = "";
		}
		if(!gyldigFornavn()) {
			feilFornavn = "Ugyldig fornavn!";
			fornavn = "";
		}
		if(!gyldigPassord()) {
			feilPassord = "Lengde må være 8, inneholde stor bokstav og tall!";
			passord = "";
		}
		if (!gyldigPassordMatch()) {
			feilPassordMatch = "Passordene må være like!";
			passordMatch = "";
		}
		if(!kjonnHuketAv()) {
			feilKjonn = "Oppgi kjønn!";
			kjonn = "";
		}
			
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
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

	public String getPassordMatch() {
		return passordMatch;
	}

	public void setPassordMatch(String passordMatch) {
		this.passordMatch = passordMatch;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getFeilFornavn() {
		return feilFornavn;
	}

	public void setFeilFornavn(String feilFornavn) {
		this.feilFornavn = feilFornavn;
	}

	public String getFeilEtternavn() {
		return feilEtternavn;
	}

	public void setFeilEtternavn(String feilEtternavn) {
		this.feilEtternavn = feilEtternavn;
	}

	public String getFeilMobilnr() {
		return feilMobilnr;
	}

	public void setFeilMobilnr(String feilMobilnr) {
		this.feilMobilnr = feilMobilnr;
	}

	public String getFeilPassord() {
		return feilPassord;
	}

	public void setFeilPassord(String feilPassord) {
		this.feilPassord = feilPassord;
	}

	public String getFeilPassordMatch() {
		return feilPassordMatch;
	}

	public void setFeilPassordMatch(String feilPassordMatch) {
		this.feilPassordMatch = feilPassordMatch;
	}

	public String getFeilKjonn() {
		return feilKjonn;
	}

	public void setFeilKjonn(String feilKjonn) {
		this.feilKjonn = feilKjonn;
	}
}
