package main;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class InterfaceRetornoConsulta extends JFrame
{
	private String[][] retorno;
    public InterfaceRetornoConsulta(String[][] retorno)
    {
    	this.retorno = retorno;
        String[] columns = new String[] {
            "CPF_p", "Nome", "Data_de_nascimento", "Sexo", "Foto"
        };
         
        JTable table = new JTable(this.retorno, columns);
         
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
        this.pack();
        this.setVisible(true);
    }
    
}