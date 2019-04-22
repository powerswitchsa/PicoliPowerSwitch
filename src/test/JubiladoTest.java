package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.CapitalEstado;
import modelo.seres.Jubilado;

class JubiladoTest {

	private Jubilado jubilado = new Jubilado("pepito", 1, 500);

	@Test
	void testCobrar() {
		CapitalEstado capitalEstado = new CapitalEstado(0);
		double dineroEstado = 0;
		jubilado.setAhorros(1000);
		jubilado.cobrar(0, capitalEstado);
		assertTrue(jubilado.getAhorros() == 1000 - 182.5);
	}

	@Test
	void testMorir() {
		jubilado.setFechaMuerte(85);
		jubilado.setEdad(85);
		assertTrue(jubilado.morir());
	}

}
