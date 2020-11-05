package no.hvl.dat108;

import javax.persistence.*;

@Entity
@Table(schema = "oblig4", name = "person")
public class Person {

	/* Må matche det som står i skript.sql*/
	@Id
	private String mobilnr;
	
	private String fnavn;
	private String enavn;
	private String passord;
	private String kjonn;

	public Person() {}

	public Person(String mobilnr, String fnavn, String enavn, String passord, String kjonn) {
		this.mobilnr = mobilnr;
		this.fnavn = fnavn;
		this.enavn = enavn;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getFnavn() {
		return fnavn;
	}

	public void setFnavn(String fnavn) {
		this.fnavn = fnavn;
	}

	public String getEnavn() {
		return enavn;
	}

	public void setEnavn(String enavn) {
		this.enavn = enavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Person [mobilnr=" + mobilnr + ", fnavn=" + fnavn + ", enavn=" + enavn	 + ", kjonn=" + kjonn + "]";
	}
}
