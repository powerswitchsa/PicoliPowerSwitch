package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelInformacion extends JPanel {

	private JTextField textField;

	public PanelInformacion(String titulo, String valor, boolean fin, boolean primero) {
		if (primero) {
			setBorder(new MatteBorder(2, 2, 1, 2, (Color) new Color(255, 0, 0)));
		} else if (fin) {
			setBorder(new MatteBorder(1, 2, 2, 2, (Color) new Color(255, 0, 0)));
		} else {
			setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(255, 0, 0)));
		}
		setBackground(Color.WHITE);
		setBounds(200, 200, 416, 49);
		setVisible(true);

		JLabel lblNewLabel = new JLabel(titulo);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		textField = new JTextField(valor);
		textField.setForeground(Color.BLUE);
		textField.setDisabledTextColor(Color.DARK_GRAY);
		textField.setOpaque(false);
		textField.setBackground(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setFocusable(false);

		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(textField, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addGap(10)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 27,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30,
										Short.MAX_VALUE))
						.addGap(10)));
		setLayout(groupLayout);
	}
}
