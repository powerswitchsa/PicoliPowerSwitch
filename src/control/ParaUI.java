package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.vista.Datos;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import vista.Comunicador;
import vista.UI;

public class ParaUI extends UI {

	private Estado estado = new Estado();

	public ParaUI() {
		super();
		listener();
		boolean salir = false;
		do {
			estado.pasarA�o();
			setDatosEnElInterfazUsuario(estado.getDatosPoblacion(), estado.getDatosEstadoLocal(),
					estado.getDatosEstadoGlobales());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!salir);

	}

	private void listener() {

		getBtnIncrementar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.setAumentarDemanda(100000);
			}
		});

		getBtnDecrementar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.setDisminuirDemanda(100000);
			}
		});

		getBtnA�o().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.pasarA�o();
			}
		});
	}

	public void setDatosEnElInterfazUsuario(DatosPoblacion datosPoblacion, DatosEstadoLocal datosEstadoLocal,
			DatosEstadoGlobal datosEstadoGlobal) {
		rellenarComunicador(comunicadorPoblacion, datosPoblacion);
		rellenarComunicador(comunicadorEstadoLocal, datosEstadoLocal);
		rellenarComunicador(comunicadorEstadoGlobal, datosEstadoGlobal);
	}

	public void rellenarComunicador(Comunicador comunicador, Datos datos) {
		comunicador.asignarValores(datos);
	}

}
