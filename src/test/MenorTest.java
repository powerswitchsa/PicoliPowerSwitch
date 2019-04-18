package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.seres.Menor;

class MenorTest {

	private Menor menor = new Menor(1);

	@Test
	void testCobrar() {

	}

	@Test
	void testMorir() {
		menor.setEdad(15);
		menor.setFechaMuerte(15);
		assertTrue(menor.morir());
	}

}
