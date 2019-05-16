package main;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
 
public class InterfaceInsercao extends JFrame {
 
    private JPanel contentPane;
    private JTextField txtFDir;
    private JTextField txtFNomeP;
 
    public InterfaceInsercao() {
        Negocio jdbc = new Negocio();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
       
        JButton btnEnviarFoto = new JButton("Enviar Foto");
        btnEnviarFoto.setBounds(167, 150, 89, 23);
        contentPane.add(btnEnviarFoto);
        btnEnviarFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    jdbc.adicionarMidia(txtFDir.getText(), txtFNomeP.getText());
                } catch (SQLException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
       
        txtFDir = new JTextField();
        txtFDir.setBounds(99, 80, 222, 20);
        contentPane.add(txtFDir);
        txtFDir.setColumns(10);
       
        txtFNomeP = new JTextField();
        txtFNomeP.setColumns(10);
        txtFNomeP.setBounds(99, 119, 222, 20);
        contentPane.add(txtFNomeP);
       
        JLabel lblDiretorio = new JLabel("Diretorio:");
        lblDiretorio.setBounds(45, 82, 46, 14);
        contentPane.add(lblDiretorio);
       
        JLabel lblNomePessoa = new JLabel("Nome Pessoa:");
        lblNomePessoa.setBounds(23, 121, 68, 14);
        contentPane.add(lblNomePessoa);
    }
}