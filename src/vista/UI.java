package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import modelo.Factoria;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private JPanel contentPane;

	private PanelPoblacion panelPoblacion = new PanelPoblacion();
	private JPanel pnlBotones = new JPanel();
	private JPanel pnlLocal = new JPanel();
	private JPanel panelIndustria;
	private JPanel pnlGlobal = new JPanel();
	private JPanel panelGlobal = new JPanel();

	private final JButton btnDecrementar = new JButton("Decrementar Produccion");
	private final JButton btnIncrementar = new JButton("Incrementar Produccion");
	private final JButton btnAño = new JButton("Pasar A\u00F1o");

	protected Comunicador comunicadorPoblacion, comunicadorEstadoLocal, comunicadorEstadoGlobal;

	private final JLabel lblEstadoGlobal = new JLabel("ESTADO GLOBAL");

	public UI() {
		lblEstadoGlobal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoGlobal.setFont(new Font("Impact", Font.PLAIN, 30));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 10, 10));
		contentPane.add(this.panelPoblacion);
		contentPane.add(this.pnlBotones);
		pnlBotones.setLayout(new GridLayout(3, 0, 0, 0));

		btnIncrementar.setBackground(Color.GREEN);
		btnIncrementar.setFont(new Font("SansSerif", Font.PLAIN, 30));
		btnIncrementar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.BLACK));

		pnlBotones.add(btnIncrementar);
		btnAño.setBackground(Color.WHITE);
		btnAño.setFont(new Font("SansSerif", Font.PLAIN, 30));
		btnAño.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.BLACK));

		pnlBotones.add(btnAño);
		btnDecrementar.setBackground(Color.RED);
		btnDecrementar.setFont(new Font("SansSerif", Font.PLAIN, 30));
		btnDecrementar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.BLACK));

		pnlBotones.add(btnDecrementar);
		contentPane.add(this.pnlLocal);

		JLabel lblFactorias = new JLabel("FACTORIAS");
		lblFactorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactorias.setFont(new Font("Impact", Font.PLAIN, 30));

		panelIndustria = new JPanel();
		GroupLayout gl_pnlLocal = new GroupLayout(pnlLocal);
		gl_pnlLocal.setHorizontalGroup(gl_pnlLocal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLocal.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlLocal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFactorias, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
								.addComponent(panelIndustria, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
						.addContainerGap()));
		gl_pnlLocal.setVerticalGroup(gl_pnlLocal.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlLocal
				.createSequentialGroup().addGap(10)
				.addComponent(lblFactorias, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addComponent(panelIndustria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(10)));
		panelIndustria.setLayout(new GridLayout(0, 2, 0, 0));
		pnlLocal.setLayout(gl_pnlLocal);
		contentPane.add(this.pnlGlobal);
		GroupLayout gl_pnlGlobal = new GroupLayout(pnlGlobal);
		gl_pnlGlobal.setHorizontalGroup(gl_pnlGlobal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlobal.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlGlobal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstadoGlobal, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
								.addComponent(panelGlobal, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
						.addContainerGap()));
		gl_pnlGlobal.setVerticalGroup(gl_pnlGlobal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlobal.createSequentialGroup().addContainerGap()
						.addComponent(lblEstadoGlobal, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(panelGlobal, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGap(10)));
		panelGlobal.setLayout(new GridLayout(10, 2, 20, 20));
		pnlGlobal.setLayout(gl_pnlGlobal);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		panelGlobal.add(crearJLabel(""));
		panelGlobal.add(crearJLabel(""));

		panelGlobal.add(crearJLabel("Demanda Anual"));
		panelGlobal.add(crearJtexField(""));

		panelGlobal.add(crearJLabel(""));
		panelGlobal.add(crearJLabel(""));

		panelGlobal.add(crearJLabel("Produccion Anual"));
		panelGlobal.add(crearJtexField(""));

		panelGlobal.add(crearJLabel(""));
		panelGlobal.add(crearJLabel(""));

		panelGlobal.add(crearJLabel("Capital Estatal"));
		panelGlobal.add(crearJtexField(""));

		panelGlobal.add(crearJLabel(""));
		panelGlobal.add(crearJLabel(""));

		panelGlobal.add(crearJLabel("Crecimiento Anual"));
		panelGlobal.add(crearJtexField(""));

		panelGlobal.add(crearJLabel(""));
		panelGlobal.add(crearJLabel(""));

		comunicadorPoblacion = crearComunicador(panelPoblacion.getPanelDatosPoblacion());
		comunicadorEstadoLocal = crearComunicador(panelIndustria);
		comunicadorEstadoGlobal = crearComunicador(panelGlobal);

		Color panelColor = new Color(250, 223, 184);
		panelGlobal.setBackground(panelColor);
		panelIndustria.setBackground(panelColor);
		panelPoblacion.setBackground(panelColor);
		pnlBotones.setBackground(panelColor);
		pnlGlobal.setBackground(panelColor);
		pnlLocal.setBackground(panelColor);
		panelPoblacion.getPanelDatosPoblacion().setBackground(panelColor);

		getContentPane().setBackground(panelColor);

	}

	private JLabel crearJLabel(String cadena) {
		JLabel jlabel = new JLabel();
		jlabel.setText("              " + cadena);
		jlabel.setFont(new Font("Impact", Font.PLAIN, 30));
		jlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return jlabel;
	}

	public void actualizarPanelIndustria(ArrayList<Factoria> factorias) {
		panelIndustria.removeAll();
		int indice = 1;
		for (Factoria factoria : factorias) {
			panelIndustria.add(crearJtexField(indice + "ª Factoria : " + factoria.getTrabajadores().size() + "/ 1000"));
			indice++;
		}
		getContentPane().revalidate();
		getContentPane().repaint();
//		actualizarPantalla();
	}

	public void actualizarPantalla() {

		JPanel temp = (JPanel) this.getContentPane();
		SwingUtilities.updateComponentTreeUI(temp);

	}

	private JTextField crearJtexField(String cadena) {
		JTextField jtextfield = new JTextField();
		jtextfield.setText(cadena);
		jtextfield.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtextfield.setFocusable(false);
		jtextfield.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		jtextfield.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		return jtextfield;
	}

	private Comunicador crearComunicador(JPanel jPanel) {
		Component[] components = jPanel.getComponents();
		Comunicador retorno = new Comunicador();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JTextField) {
				retorno.addControl((JTextField) components[i]);
			}
		}
		return retorno;
	}

	public JButton getBtnDecrementar() {
		return btnDecrementar;
	}

	public JButton getBtnIncrementar() {
		return btnIncrementar;
	}

	public JButton getBtnAño() {
		return btnAño;
	}

}
