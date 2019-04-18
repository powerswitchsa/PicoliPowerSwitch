package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.seres.Trabajador;

class TrabajadorTest {

	private Trabajador trabajador = new Trabajador("pepito", 1);
	private Trabajador desempleado = new Trabajador("pepito", 2);

	@Test
	void testCobrar() {
		double dineroEstado = 0;
		trabajador.cobrar(730, dineroEstado);
		assertEquals((730 - 365) / 2, trabajador.getAhorros());
		assertEquals((730 - 365) / 2, dineroEstado);
	}

	@Test
	void testMorir() {
		trabajador.setEdad(40);
		trabajador.setFechaMuerte(40);
		assertTrue(trabajador.morir());
	}

}
