package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.DatosVista;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class VentanaNueva extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnPasarAño;
	private JButton btnAumentarNacimientos;
	private JButton btnDisminuirNacimientos;

	public VentanaNueva() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE).addGap(20)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1.setLayout(new BorderLayout(0, 0));

		btnAumentarNacimientos = new JButton("AUMENTAR PRODUCCION");
		btnAumentarNacimientos.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		btnAumentarNacimientos.setForeground(Color.BLACK);
		btnAumentarNacimientos.setBackground(Color.LIGHT_GRAY);
		btnAumentarNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnAumentarNacimientos, BorderLayout.NORTH);

		btnDisminuirNacimientos = new JButton("DISMINUIR PRODUCCION");
		btnDisminuirNacimientos.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDisminuirNacimientos.setForeground(Color.BLACK);
		btnDisminuirNacimientos.setBackground(Color.LIGHT_GRAY);
		btnDisminuirNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnDisminuirNacimientos, BorderLayout.SOUTH);

		btnPasarAño = new JButton("A\u00F1o");
		btnPasarAño.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnPasarAño.setForeground(Color.BLACK);
		btnPasarAño.setBackground(Color.WHITE);
		btnPasarAño.setFont(new Font("Tahoma", Font.PLAIN, 25));

		panel_1.add(btnPasarAño, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}

	public void actualizarDatos(ArrayList<String> datos) {
		panel.removeAll();
		int indice = 0;
		panel.setLayout(new GridLayout(datos.size(), 0, 0, 0));
		for (String cadena : datos) {
			String[] cadenaSeparada = cadena.split("/");
			if (indice == 0) {
				panel.add(new PanelInformacion(cadenaSeparada[0], cadenaSeparada[1], false, true));
			} else if (indice == datos.size() - 1) {
				panel.add(new PanelInformacion(cadenaSeparada[0], cadenaSeparada[1], true, false));
			} else {
				panel.add(new PanelInformacion(cadenaSeparada[0], cadenaSeparada[1], false, false));
			}
			indice++;
		}
		contentPane.revalidate();
	}

	public JButton getBtnPasarAño() {
		return btnPasarAño;
	}

	public JButton getBtnAumentarNacimientos() {
		return btnAumentarNacimientos;
	}

	public JButton getBtnDisminuirNacimientos() {
		return btnDisminuirNacimientos;
	}

}
