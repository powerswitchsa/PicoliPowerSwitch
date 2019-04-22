package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.CapitalEstado;
import modelo.seres.Menor;

class MenorTest {

	private Menor menor = new Menor(1);

	@Test
	void testCobrar() {
		CapitalEstado capitalEstado = new CapitalEstado(0);
		menor.setFechaMuerte(15);
		menor.cobrar(0, capitalEstado);
		assertEquals(menor.getFechaMuerte(), 14.5, 0.1);
	}

	@Test
	void testMorir() {
		menor.setEdad(15);
		menor.setFechaMuerte(15);
		assertTrue(menor.morir());
	}

}
