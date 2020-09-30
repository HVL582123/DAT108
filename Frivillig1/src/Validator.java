
public class Validator {

	public boolean isValidTemperatur(String t) {
		
		return t!= null
				&& t.matches("-?\\d+(\\.\\d+)?");
	}
	
	public boolean isValidValg(String valg) {
		return valg!=null;
	}

	public float isValidCalcCtF(float n) {
		
		return n*(9f/5) + 32;
	}
	
	public float isValidCalcFtC(float n) {
		
		return (n - 32)*5f/9;
	}
}
