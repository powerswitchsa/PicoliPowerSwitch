package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaNueva;

public class ParaUI extends VentanaNueva {

	private Estado estado;

	public ParaUI() {
		super();
		this.estado = new Estado();
		actualizarDatos(estado.getDatosVista());

		boolean salir = false;
		do {
			estado.actualizarListas();
			actualizarDatos(estado.getDatosVista());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		} while (!salir);
		listener();
	}

	private void listener() {

		getBtnPasarA�o().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.actualizarListas();
				actualizarDatos(estado.getDatosVista());
			}
		});

		getBtnAumentarNacimientos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		getBtnDisminuirNacimientos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

}
