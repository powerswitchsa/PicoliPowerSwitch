package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class PanelPoblacion extends JPanel {

	private String[] textJLabel = { "Habitantes", "Menores", "Desempleados", "Trabajadores", "Jubilados", "Nacimientos",
			"Fallecidos", "New Jubilados", "New Trabajadores" };
	private JPanel panelDatosPoblacion;

	public PanelPoblacion() {

		JLabel lblNewLabel = new JLabel("POBLACION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 30));

		panelDatosPoblacion = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelDatosPoblacion, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblNewLabel).addGap(9)
						.addComponent(panelDatosPoblacion, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(10)));
		panelDatosPoblacion.setLayout(new GridLayout(9, 1, 20, 20));
		setLayout(groupLayout);

		for (int i = 0; i < this.textJLabel.length; i++) {
			this.panelDatosPoblacion.add(crearJLabel(this.textJLabel[i]));
			this.panelDatosPoblacion.add(this.crearJtexField());
		}

		setVisible(true);

	}

	private JTextField crearJtexField() {
		JTextField jtextfield = new JTextField();
		jtextfield.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtextfield.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		jtextfield.setFocusable(false);
		jtextfield.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		return jtextfield;
	}

	private JLabel crearJLabel(String cadena) {
		JLabel jlabel = new JLabel();
		jlabel.setText("              " + cadena);
		jlabel.setFont(new Font("Impact", Font.PLAIN, 30));
		jlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return jlabel;
	}

	public JPanel getPanelDatosPoblacion() {
		return panelDatosPoblacion;
	}

}
