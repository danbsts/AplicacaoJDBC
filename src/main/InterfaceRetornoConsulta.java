package main;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class InterfaceRetornoConsulta extends JFrame
{
	private String[][] retorno;
	private String atributos;
    public InterfaceRetornoConsulta(String[][] retorno, String atributos)
    {
    	this.retorno = retorno;
    	this.atributos = atributos;
        JTable table = new JTable(this.retorno, splitAtributos(this.atributos));
         
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
        this.pack();
        this.setVisible(true);
    }
    
    public String[] splitAtributos(String at) {
    	if (at.equals("*")) {
    		return new String[] {
    	            "CPF_p", "Nome", "Data_de_nascimento", "Sexo", "Foto"
            };
    	} else {
    		String[] r = at.split(",");
    		for(int i = 0; i < r.length; i++) r[i].trim();
    		return r;
    	}
    }

	public String[][] getRetorno() {
		return retorno;
	}

	public void setRetorno(String[][] retorno) {
		this.retorno = retorno;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}
}