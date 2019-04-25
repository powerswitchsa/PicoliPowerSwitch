package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Poblacion;
import modelo.Ser;
import modelo.TipoSeres;

class Pruebas {

//	@Test
//	void test() {
//		Ser trabajadorUno = new Ser(9, TipoSeres.trabajador, 30);
//		Ser trabajadorDos = new Ser(9, TipoSeres.trabajador, 30);
//		Ser jubilado = new Ser(9, TipoSeres.jubilado, 30);
//		Ser menor = new Ser(9, TipoSeres.menor, 30);
//		Ser desempleado = new Ser(9, TipoSeres.desempleado, 30);
//		assertTrue(trabajadorUno.equals(trabajadorDos));
//
//	}

	@Test
	void testUno() {
		Poblacion poblacion = new Poblacion(200, 500, 100);
		ArrayList<Ser> listaDesempleados = poblacion.getDesempleados();

		assertEquals(500, listaDesempleados.size());
	}

}
