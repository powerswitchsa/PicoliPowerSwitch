package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnPasarAño;
	private JButton btnAumentarNacimientos;
	private JButton btnDisminuirNacimientos;

	public Ventana() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 0, 0));
		setContentPane(contentPane);
		setTitle("Picoli - PowerSwitch");

		panel = new JPanel();
		panel.setBackground(Color.WHITE);

		btnAumentarNacimientos = new JButton("PRODUCCION++");
		btnAumentarNacimientos.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		btnAumentarNacimientos.setForeground(Color.BLACK);
		btnAumentarNacimientos.setBackground(Color.GREEN);
		btnAumentarNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnDisminuirNacimientos = new JButton("PRODUCCION--");
		btnDisminuirNacimientos.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDisminuirNacimientos.setForeground(Color.BLACK);
		btnDisminuirNacimientos.setBackground(Color.RED);
		btnDisminuirNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnPasarAño = new JButton("A\u00F1o");
		btnPasarAño.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnPasarAño.setForeground(Color.BLACK);
		btnPasarAño.setBackground(Color.CYAN);
		btnPasarAño.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE).addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnAumentarNacimientos, GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
								.addGap(20).addComponent(btnPasarAño, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addGap(20)
								.addComponent(btnDisminuirNacimientos, GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
								.addGap(20)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDisminuirNacimientos, GroupLayout.PREFERRED_SIZE, 45,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAumentarNacimientos, GroupLayout.PREFERRED_SIZE, 45,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPasarAño, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
				.addGap(20).addComponent(panel, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE).addGap(20)));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}

	public void actualizarDatos(ArrayList<String> datos) {
		panel.removeAll();
		int filas = 5, columnas = 3;
		panel.setLayout(new GridLayout(filas, columnas, 5, 5));
		for (String cadena : datos) {
//			panel.add(new PanelJtextArea("\t" + cadena));
			panel.add(new PanelJlabel(cadena));
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
