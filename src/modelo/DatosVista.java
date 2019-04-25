package modelo;

import java.util.ArrayList;

public class DatosVista {

	private ArrayList<String> datos = new ArrayList<String>();

	public DatosVista(int habitantes, int menores, int trabajadores, int jubilados, int nacimientos, int fallecimientos,
			int jubilaciones, int nuevosTrabajadores, int factorias, double dineroEstado, int desempleados,
			double produccionAnual) {
		super();
		datos.add(" Habitantes --> /" + habitantes);
		datos.add(" Menores --> /" + menores);
		datos.add(" Trabajadores --> /" + trabajadores);
		datos.add(" Desempleados --> /" + desempleados);
		datos.add(" Jubilados --> /" + jubilados);
		datos.add(" Fallecimientos --> /" + fallecimientos);
		datos.add(" Nacimientos --> /" + nacimientos);
		datos.add(" Nuevos Trabajadores --> /" + nuevosTrabajadores);
		datos.add(" Jubilaciones --> /" + jubilaciones);
		datos.add(" Dinero Estado --> /" + String.valueOf(dineroEstado));
		datos.add(" Factorias --> /" + factorias);
		datos.add(" Produccion Anual --> /" + produccionAnual);
		datos.add(" Demanda Anual --> / 0");
		datos.add(" Crecimiento Anual --> / 0");
	}

	public ArrayList<String> getDatos() {
		return datos;
	}

}
