package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceConsulta extends JFrame {

	private JPanel contentPane;
	InterfaceRetornoConsulta interRetornoConsulta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsulta frame = new InterfaceConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceConsulta() {
		InterfaceNegocio jdbc = new Negocio();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(69, 54, 133, 20);
		contentPane.add(textPane);
		
		JLabel lblSelect = new JLabel("SELECT");
		lblSelect.setBounds(10, 54, 46, 14);
		contentPane.add(lblSelect);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(69, 79, 133, 20);
		contentPane.add(textPane_1);
		
		JLabel lblWhere = new JLabel("WHERE");
		lblWhere.setBounds(10, 85, 46, 14);
		contentPane.add(lblWhere);
		
		JButton btnNewButton = new JButton("Consulta sem Where");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textPane.getText().equals("select  from PESSOA")) {
					System.out.println(textPane.getText());
					String str[][] = jdbc.selecionarInstrucao(textPane.getText());
					if(interRetornoConsulta == null) {
						interRetornoConsulta = new InterfaceRetornoConsulta(str, textPane.getText());
						interRetornoConsulta.setLocationRelativeTo(null);
					}
					interRetornoConsulta.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Consulta não realizada por falta de propriedades do select");
				}
			}
		});
		btnNewButton.setBounds(10, 119, 192, 23);
		contentPane.add(btnNewButton);
		
		JButton btnConsultaComWhere = new JButton("Consulta com Where");
		btnConsultaComWhere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textPane.getText().equals("select  from PESSOA")) {
					if(!textPane_1.getText().equals("select  from PESSOA where")) {
						String str[][] = jdbc.selecionarInstrucao(textPane.getText(),textPane_1.getText());
						if(interRetornoConsulta == null) {
							interRetornoConsulta = new InterfaceRetornoConsulta(str, textPane.getText());
							interRetornoConsulta.setLocationRelativeTo(null);
						}
						interRetornoConsulta.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Consulta não realizada por falta de propriedades do where");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Consulta não realizada por falta de propriedades do select");
				}
			}
		});
		btnConsultaComWhere.setBounds(10, 146, 192, 23);
		contentPane.add(btnConsultaComWhere);
	}
}
