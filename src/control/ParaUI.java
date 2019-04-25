package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Ventana;

public class ParaUI extends Ventana {

	private Estado estado;

	public ParaUI() {
		super();
		this.estado = new Estado();
		listener();
		boolean salir = false;
		do {
			actualizarDatos(estado.getDatosVista());
			estado.actualizarListas();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		} while (!salir);

	}

	private void listener() {

		getBtnPasarAño().addActionListener(new ActionListener() {
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
