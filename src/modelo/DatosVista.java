package modelo;

import java.util.ArrayList;

import control.Estado;

public class DatosVista {

	private ArrayList<String> datos = new ArrayList<String>();

	public DatosVista(int habitantes, int menores, int trabajadores, int jubilados, int nacimientos, int fallecimientos,
			int jubilaciones, int nuevosTrabajadores, int factorias, double dineroEstado, int desempleados) {
		super();
		datos.add(" POBLACION :");
		datos.add(" Habitantes --> " + habitantes);
		datos.add(" Menores --> " + menores);
		datos.add(" Trabajadores --> " + trabajadores);
		datos.add(" Desempleados --> " + desempleados);
		datos.add(" Jubilados --> " + jubilados);
		datos.add("--------------------------------------");
		datos.add(" CRECIMIENTO :");
		datos.add(" Fallecimientos --> " + fallecimientos);
		datos.add(" Nacimientos --> " + nacimientos);
		datos.add(" Nuevos Trabajadores --> " + nuevosTrabajadores);
		datos.add(" Jubilaciones --> " + jubilaciones);
		datos.add("--------------------------------------");
		datos.add(" Dinero Estado --> " + dineroEstado);
		datos.add(" Factorias --> " + factorias);
		datos.add(" Produccion Anual --> ");
		datos.add(" Demanda Anual --> ");
		datos.add(" Crecimiento Anual --> ");
	}

	public ArrayList<String> getDatos() {
		return datos;
	}

}
