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
			estado.pasarA�o();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		} while (!salir);

	}

	private void listener() {

		getBtnPasarA�o().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.pasarA�o();
				actualizarDatos(estado.getDatosVista());
			}
		});

		getBtnAumentarNacimientos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.setAumentarDemanda(100000);
				actualizarDatos(estado.getDatosVista());
			}
		});

		getBtnDisminuirNacimientos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.setDisminuirDemanda(100000);
				actualizarDatos(estado.getDatosVista());
			}
		});

	}

}
