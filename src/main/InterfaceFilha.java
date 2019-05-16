package main;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
 
public class InterfaceFilha extends JFrame {
 
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtDataNacc;
   
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	InterfaceFilha frame = new InterfaceFilha();
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
    public InterfaceFilha() {
        InterfaceNegocio jdbc = new Negocio();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JRadioButton rdbtnF = new JRadioButton("F");
        rdbtnF.setBounds(58, 100, 109, 23);
        contentPane.add(rdbtnF);
        JRadioButton rdbtnM = new JRadioButton("M");
        rdbtnM.setBounds(5, 100, 109, 23);
        contentPane.add(rdbtnM);
       
        JButton btnNewButton = new JButton("Adicionar Pessoa");
        btnNewButton.setBounds(5, 233, 424, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnM.isSelected()) {
                jdbc.adicionarPessoa(txtCpf.getText(), txtNome.getText(), txtDataNacc.getText(), "masculino");
                }else if (rdbtnF.isSelected()) {
                    jdbc.adicionarPessoa(txtCpf.getText(), txtNome.getText(), txtDataNacc.getText(), "feminino");
                }
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
       
        txtNome = new JTextField();
        txtNome.setText("Nome");
        txtNome.setBounds(5, 11, 179, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);
       
        txtCpf = new JTextField();
        txtCpf.setText("cpf");
        txtCpf.setBounds(5, 42, 179, 20);
        contentPane.add(txtCpf);
        txtCpf.setColumns(10);
       
        txtDataNacc = new JTextField();
        txtDataNacc.setText("Data Nasc");
        txtDataNacc.setBounds(5, 73, 179, 20);
        contentPane.add(txtDataNacc);
        txtDataNacc.setColumns(10);
       
           
       
    }
}