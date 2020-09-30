import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

	private Validator val = new Validator();
	
	
	
	@Test
	public void nullStringIsInvalidTemperatur() {
		assertFalse(val.isValidTemperatur(null));
	}
	
	@Test
	public void emptyStringIsInvalid() {
		assertFalse(val.isValidTemperatur(""));
	}
	
	@Test
	public void regneTilFahrenheit(){
		assertTrue(val.isValidCalcCtF(30)==86);
	}
	
	@Test
	public void regneTilCelsius(){
		assertTrue(val.isValidCalcFtC(86)==30);
	}
	
	@Test
	public void nullValgIsInvalid() {
		assertFalse(val.isValidValg(null));
	}
}
