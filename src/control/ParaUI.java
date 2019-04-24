package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaNueva;

public class ParaUI extends VentanaNueva {

	private Estado estado;

	public ParaUI() {
		super();
		this.estado = new Estado();
		actualizarDatos(estado.getDatosVista().getDatos());
		listener();
	}

	private void listener() {

		getBtnPasarAño().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.actualizarListas();
				actualizarDatos(estado.getDatosVista().getDatos());
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
