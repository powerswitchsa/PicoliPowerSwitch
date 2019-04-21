package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import modelo.DatosVista;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	private DatosVista abc = new DatosVista(10, 85, 4, 35, 22, 76, 85, 40, 30, 20); // para ver la vista con los text

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("A\u00F1o");
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnAumentarNacimientos = new JButton("Aumentar Produccion");
		btnAumentarNacimientos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnAumentarNacimientos.setBackground(Color.WHITE);
		btnAumentarNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnDisminuirNacimientos = new JButton("Disminuir Produccion");
		btnDisminuirNacimientos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDisminuirNacimientos.setBackground(Color.WHITE);
		btnDisminuirNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textArea.setFocusable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(30)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE).addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDisminuirNacimientos, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(btnAumentarNacimientos, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(30)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(btnAumentarNacimientos, GroupLayout.PREFERRED_SIZE, 75,
										GroupLayout.PREFERRED_SIZE)
								.addGap(30).addComponent(btnDisminuirNacimientos, GroupLayout.PREFERRED_SIZE, 75,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(30)));

		actualizarDatosVista(abc);

		contentPane.setLayout(gl_contentPane);
	}

	public void actualizarDatosVista(DatosVista datos) {
		this.textArea.setText(null);
		for (String string : datos.getDatos()) {
			textArea.setText(textArea.getText().concat(string) + "\n");
		}
	}
}
