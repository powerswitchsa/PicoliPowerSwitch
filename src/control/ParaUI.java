package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Ventana;

public class ParaUI extends Ventana {

	private Estado estado;

	public ParaUI() {
		super();
		this.estado = new Estado();
		this.estado.actualizarListas();
		actualizarDatosVista(estado.getDatosVista());
		listener();
	}

	private void listener() {

		getBtnPasarAño().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.actualizarListas();
				actualizarDatosVista(estado.getDatosVista());
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
