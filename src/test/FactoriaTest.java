package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import modelo.Factoria;
import modelo.seres.Trabajador;

class FactoriaTest {

	private Factoria factoria = new Factoria();
	private int numTrabajdores = 500;
	private Stack<Trabajador> desempleados = new Stack<Trabajador>();

	public FactoriaTest() {
		super();
		for (int i = 0; i < numTrabajdores; i++) {
			this.factoria.getTrabajadores().add(new Trabajador(String.valueOf(i), i));
		}
		for (int i = 0; i < 200; i++) {
			desempleados.add(new Trabajador(String.valueOf(i), i));
		}
	}

	@Test
	void testContratarTrabajador() {

	}

	@Test
	void testDespedirTrabajadores() {
		int numeroDespidos = 50;
		factoria.despedirTrabajadores(desempleados, numeroDespidos);
		assertTrue(desempleados.size() == 250 && factoria.getTrabajadores().size() == 450);
	}

	@Test
	void testCerraFactoria() {
		factoria.cerraFactoria(desempleados);
		assertTrue(desempleados.size() == 700 && factoria.getTrabajadores().isEmpty());
	}

	@Test
	void testGetProduccionAnual() {
		double cuenta = (numTrabajdores * 1000) - (1000 * 1000 * 0.5);
		assertTrue(cuenta == factoria.getProduccionAnual());
	}

}
