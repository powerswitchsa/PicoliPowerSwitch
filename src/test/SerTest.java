package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.CapitalEstado;
import modelo.Ser;
import modelo.TipoSeres;

class SerTest {

	@Test
	void testPagarTrabajador() {
		Ser trabajador = new Ser(0, TipoSeres.trabajador, 25);
		CapitalEstado capitalEstado = new CapitalEstado(0);
		trabajador.setAhorros(0);
		trabajador.setPagarTrabajador(capitalEstado, 730);
		assertEquals((730 - 365) / 2, trabajador.getAhorros());
		assertEquals((730 - 365) / 2, capitalEstado.getDineroEstado());
	}

	@Test
	void testPagarMenor() {
		Ser menor = new Ser(0, TipoSeres.menor, 5);
		menor.setFechaMuerte(10);
		menor.setSubsidioMenor(365);
		assertTrue(menor.getFechaMuerte() == 10);
		menor.setSubsidioMenor(0);
		assertTrue(menor.getFechaMuerte() == 9.5);
	}

	@Test
	void testPagaDesempleado() {
		Ser desempleado = new Ser(0, TipoSeres.desempleado, 30);
		desempleado.setAhorros(500);
		desempleado.setSubsidioDesempleado(182.5);
		assertEquals(500 - 182.5, desempleado.getAhorros());
		desempleado.setSubsidioDesempleado(0);
		assertEquals(500 - (182.5 * 3), desempleado.getAhorros());
	}

	@Test
	void testSubsidioJubilado() {
		Ser jubilado = new Ser(0, TipoSeres.jubilado, 70);
		jubilado.setAhorros(500);
		jubilado.setSubsidioJubilado(0);
		assertEquals(500 - 182.5, jubilado.getAhorros());
		jubilado.setAhorros(0);
		jubilado.setFechaMuerte(75);
		jubilado.setSubsidioJubilado(0);
		assertEquals(74.5, jubilado.getFechaMuerte());
	}

	@Test
	void testReducirEsperanzaVida() {
		Ser ser = new Ser(1, TipoSeres.trabajador, 30);
		ser.setFechaMuerte(30);
		ser.setReducirEsperanzaVida(365);
		assertEquals(29.5, ser.getFechaMuerte(), 0.5);
		ser.setReducirEsperanzaVida(0);
		assertEquals(30, ser.getFechaMuerte(), 0.5);
	}

	@Test
	void testIsMuerto() {
		Ser ser = new Ser(1, TipoSeres.trabajador, 30);
		ser.setEdad(30);
		ser.setFechaMuerte(30);
		assertTrue(ser.isMuerto());
		ser.setFechaMuerte(35);
		assertFalse(ser.isMuerto());
	}

}
