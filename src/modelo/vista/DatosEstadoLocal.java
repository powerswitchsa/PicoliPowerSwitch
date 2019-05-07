package modelo.vista;

import java.util.ArrayList;

public class DatosEstadoLocal extends Datos {

	public DatosEstadoLocal(int factorias) {
		super();
		ArrayList datos = getDatos();
		datos.add(factorias);
	}

}
