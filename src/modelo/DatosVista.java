package modelo;

import java.util.ArrayList;

public class DatosVista {

	private ArrayList<String> datos = new ArrayList<String>();

	public DatosVista(int habitantes, int menores, int trabajadores, int jubilados, int nacimientos, int fallecimientos,
			int jubilaciones, int nuevosTrabajadores, int factorias, double dineroEstado, int desempleados,
			double produccionAnual, int años, double demanda) {
		super();
		datos.add("Habitantes : " + habitantes);
		datos.add("Años : " + años);
		datos.add("Dinero Estado : " + (int) dineroEstado);
		datos.add("Menores : " + menores);
		datos.add("Nacimientos : " + nacimientos);
		datos.add("Factorias : " + factorias);
		datos.add("Desempleados : " + desempleados);
		datos.add("Nuevos Trabajadores : " + nuevosTrabajadores);
		datos.add("Produccion Anual : " + (int) produccionAnual);
		datos.add("Trabajadores : " + trabajadores);
		datos.add("Jubilaciones : " + jubilaciones);
		datos.add("Demanda Anual : " + (int) demanda);
		datos.add("Jubilados : " + jubilados);
		datos.add("Fallecimientos : " + fallecimientos);
		datos.add("Crecimiento Anual : " + 0);
	}

	public ArrayList<String> getDatos() {
		return datos;
	}

}
