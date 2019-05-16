package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;

public class InterfaceGrafica extends JFrame {

	private JPanel contentPane;
	InterfaceFilha interFilha;
	InterfaceConsulta interConsulta;
	InterfaceVisualizacao interVisualizacao;
	InterfaceInsercao interInsert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica frame = new InterfaceGrafica();
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
	public InterfaceGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Inserir pessoa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interFilha == null) {
					interFilha = new InterfaceFilha();
					interFilha.setLocationRelativeTo(null);
				}
				interFilha.setVisible(true);
			}
		});
		btnNewButton.setBounds(27, 100, 111, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblPorFavorDefina = new JLabel("Por favor defina a opera\u00E7\u00E3o que deseja realizar:");
		lblPorFavorDefina.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPorFavorDefina.setBounds(84, 11, 281, 55);
		contentPane.add(lblPorFavorDefina);
		
		JButton btnConsultaPessoa = new JButton("Consulta Pessoa");
		btnConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interConsulta == null) {
					interConsulta = new InterfaceConsulta();
					interConsulta.setLocationRelativeTo(null);
				}
				interConsulta.setVisible(true);
			}
		});
		btnConsultaPessoa.setBounds(165, 100, 128, 55);
		contentPane.add(btnConsultaPessoa);
		
		JButton btnInserirMultimdia = new JButton("Inserir Multim\u00EDdia");
		btnInserirMultimdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interInsert == null) {
					interInsert = new InterfaceInsercao();
					interInsert.setLocationRelativeTo(null);
				}
				interInsert.setVisible(true);
			}
		});
		btnInserirMultimdia.setBounds(303, 100, 121, 55);
		contentPane.add(btnInserirMultimdia);
		
		JButton btnVisualizarMultimdia = new JButton("Visualizar Multim\u00EDdia");
		btnVisualizarMultimdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interVisualizacao == null) {
					interVisualizacao = new InterfaceVisualizacao();
					interVisualizacao.setLocationRelativeTo(null);
				}
				interVisualizacao.setVisible(true);
			}
		});
		btnVisualizarMultimdia.setBounds(165, 183, 128, 55);
		contentPane.add(btnVisualizarMultimdia);
	}
}
