import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SprakSjekkTest {

	private SprakSjekk sprk = new SprakSjekk();

	@Test
	public void emptyStringIsInvalid() {
		assertFalse(sprk.isValidLanguage(""));
	}
	
	@Test
	public void isInvalidTypeSprak() {
		assertFalse(sprk.isValidLanguage("se"));
	}
	
	@Test
	public void isValid() {
		assertTrue(sprk.isValidLanguage(("de")));
	}
}
