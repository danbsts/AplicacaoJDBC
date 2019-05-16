package main;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class InterfaceVisualizacao extends JFrame {
 
    private JPanel contentPane;
    private JTextField txtNome;
    private JLabel lblNomePessoa;
   
  
    public InterfaceVisualizacao() {
       
       
        InterfaceNegocio jdbc = new Negocio();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
 
        JButton btnNewButton = new JButton("Selecionar Imagem");
        btnNewButton.setBounds(5, 233, 424, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jdbc.vizualizarMidia(txtNome.getText());
                File file = new File("fon.jpg");
                open(file);
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
            txtNome = new JTextField();
            txtNome.setText("Nome");
            txtNome.setBounds(123, 11, 179, 20);
            contentPane.add(txtNome);
            txtNome.setColumns(10);
            
            lblNomePessoa = new JLabel("Nome Pessoa");
            lblNomePessoa.setBounds(5, 14, 108, 14);
            contentPane.add(lblNomePessoa);
       
    }
    public static boolean open(File file)
    {
        try
        {
            if (OSDetector.isWindows())
            {
                Runtime.getRuntime().exec(new String[]
                {"rundll32", "url.dll,FileProtocolHandler",
                 file.getAbsolutePath()});
                return true;
            } else if (OSDetector.isLinux() || OSDetector.isMac())
            {
                Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
                                                       file.getAbsolutePath()});
                return true;
            } else
            {
                // Unknown OS, try with desktop
                if (Desktop.isDesktopSupported())
                {
                    Desktop.getDesktop().open(file);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace(System.err);
            return false;
        }
    }
}