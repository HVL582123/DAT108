package Tester;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Validering {
	private final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈]";
	private final String UPPERCASE_FIRST = "[A-Z∆ÿ≈{1}";

	private String regexMobilnr = "^[0-9]{8,8}$";
	private String regexFnavn = "([A-Z∆ÿ≈][A-Za-z Ê¯Â-]{1,20})";
	private String regexEnavn = "([A-Z∆ÿ≈][A-Za-z Ê¯Â-]{1,20})";
	private String regexPassord = "^(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$";

	private String mobil1 = "12341234";
	private String mobil2 = "123heidu";
	private String mobil3 = "123451234";

	private String fnavn1 = "Steffen";
	private String fnavn2 = "123potet";
	private String fnavn3 = "99";

	private String enavn1 = "Lampe";
	private String enavn2 = "pau125";
	private String enavn3 = "9371";

	private String pass1 = "passOrd123";
	private String pass2 = "passord";
	private String pass3 = "123";

	@Test
	public void validMobilnr() {
		assertTrue(mobil1.matches(regexMobilnr));
		assertFalse(mobil2.matches(regexMobilnr));
		assertFalse(mobil3.matches(regexMobilnr));
	}

	@Test
	public void validFnavn() {
		assertTrue(fnavn1.matches(regexFnavn));
		assertFalse(fnavn2.matches(regexFnavn));
		assertFalse(fnavn3.matches(regexFnavn));
	}

	@Test
	public void validEnavn() {
		assertTrue(enavn1.matches(regexEnavn));
		assertFalse(enavn2.matches(regexEnavn));
		assertFalse(enavn3.matches(regexEnavn));
	}

	@Test
	public void validPassord() {
		assertTrue(pass1.matches(regexPassord));
		assertFalse(pass2.matches(regexPassord));
		assertFalse(pass3.matches(regexPassord));
	}
}