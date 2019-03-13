package nouveauProjetTDD.test;

import static org.junit.Assert.*;

import org.junit.Test;

import nouveauProjetTDD.service.CalculatriceService;

public class TestCalculatrice {

	CalculatriceService calc = new CalculatriceService();
	
	@Test
	public void AdditionEntier() {
		assertEquals(calc.addition(2,3), 5);		
	}
	@Test
	public void SoustractionEntier() {
		assertEquals(calc.soustraction(5,2), 3);		
	}

}
