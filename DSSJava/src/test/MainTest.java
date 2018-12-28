package test;

import java.util.ArrayList;

import facade.FarmaciaFacade;
import servidor.Farmacia;

public class MainTest {
	
	public static void main(String[] args) {
		FarmaciaFacade farmafac = new FarmaciaFacade();
		Farmacia farma = new Farmacia(1234,"Farmacia test", 1, 2);
		
		farmafac.newFarmacia(farma);
		
		ArrayList<Farmacia> farmacias = farmafac.getFarmacias();
		
		for(Farmacia f: farmacias)
			System.out.println("Farmacia -> " + f.getID()+ " " +   f.getNombre());
	}
	
}
