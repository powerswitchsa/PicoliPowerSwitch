package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelJlabel extends JPanel {

	public PanelJlabel(String cadena) {

		setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setText(cadena);
		add(lblNewLabel, BorderLayout.CENTER);
		setVisible(true);
	}

}
