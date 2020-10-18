package no.hvl.dat108;
import java.util.ArrayList;

public class HandlelisteDOA {
	private ArrayList<String> liste;
	
	public HandlelisteDOA() {
		liste = new ArrayList<>();
	}
	
	public void leggTil(String ting) {
		liste.add(ting);
	}
	
	public void slettTing(String ting) {
		liste.remove(ting);
	}
	
	public ArrayList<String> getHandelisteDOA(){
		return liste;
	}
}
