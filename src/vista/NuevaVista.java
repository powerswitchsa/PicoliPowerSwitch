package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class NuevaVista extends JFrame {

	private JPanel contentPane;
	private PanelPoblacion panelPoblacion = new PanelPoblacion();
	
	private JPanel pnlPoblacion = new JPanel();
	private JPanel pnlBotones = new JPanel();
	private JPanel pnlLocal = new JPanel();
	private JPanel pnlGlobal = new JPanel();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton btnNewButton_1 = new JButton("New button");
	private final JButton btnNewButton_2 = new JButton("New button");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaVista frame = new NuevaVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NuevaVista() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 10, 10));
		contentPane.add(this.panelPoblacion);
//		contentPane.add(this.pnlPoblacion);
		pnlPoblacion.setLayout(new BorderLayout(0, 0));
		contentPane.add(this.pnlBotones);
		pnlBotones.setLayout(new GridLayout(3, 0, 0, 0));
		
		pnlBotones.add(btnNewButton_1);
		
		pnlBotones.add(btnNewButton_2);
		
		pnlBotones.add(btnNewButton);
		contentPane.add(this.pnlLocal);
		contentPane.add(this.pnlGlobal);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
