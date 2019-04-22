package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.CapitalEstado;
import modelo.seres.Trabajador;

class TrabajadorTest {

	private Trabajador trabajador = new Trabajador("pepito", 1);
	private Trabajador desempleado = new Trabajador("pepito", 2);

	@Test
	void testCobrar() {
		CapitalEstado capitalEstado = new CapitalEstado(0);
		trabajador.cobrar(730, capitalEstado);
		assertEquals((730 - 365) / 2, trabajador.getAhorros());
		assertEquals((730 - 365) / 2, capitalEstado.getDineroEstado());
	}

	@Test
	void testMorir() {
		trabajador.setEdad(40);
		trabajador.setFechaMuerte(40);
		assertTrue(trabajador.morir());
	}

}
