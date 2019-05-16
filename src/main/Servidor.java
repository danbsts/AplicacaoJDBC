package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Servidor {

    public String url = "jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:instance01";
    public String user = "g191if685cc_eq05";
    public String senha = "myjxmwoh";

    public Connection conexao;
    public Statement stmt;

    public ResultSet resultado;
    
    public Servidor() {
    	createConnection();
    }

    public void createConnection(){

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(url, user, senha);
            stmt = conexao.createStatement();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMidia(String str_path, String Nome) throws SQLException, IOException {
    	String INSERIR = "update pessoa set Foto=? where Nome='" + Nome + "'";
    	if(str_path != null) {
    		File file = new File(str_path);
    		FileInputStream is = new FileInputStream(file);
 
    		try {
    			PreparedStatement ps;
    			ps = conexao.prepareStatement(INSERIR);
    			ps.setBinaryStream(1, is, (int)file.length()); 
    			ps.execute();
    			ps.close();
    		}catch(SQLException e){
    			 e.printStackTrace();
    		}
    	}
    	
    }
    
    public void adicionarPessoa(String cpf, String nome, String data, String sexo) {
    	String consulta = "INSERT INTO pessoa(CPF_p, Nome, Data_de_nascimento, Sexo, Foto) VALUES (" + cpf + ",'" + nome + "'," + "TO_DATE('" + data +"', 'dd/MM/yyyy'), '" + sexo + "', null)";
    	System.out.println(consulta);
    	try {
    		stmt.executeQuery(consulta);
    	}catch(SQLException e) {
    		
    	}
    }
    
    public void closeConnection(){
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[][] selectBasico(String consulta){
    	String[][] res = new String[100000][4];
        try {
            resultado = stmt.executeQuery(consulta);
            res = ImprimirResultado();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public void pegaBlob(String Nome) {
    	String PEGA = "select foto from pessoa where nome='" + Nome + "'";
    	try {
    		ResultSet rs = stmt.executeQuery(PEGA);
    		Blob glob = null;
    		rs.next();
    		glob = rs.getBlob("Foto");
    		Midia m = new Midia(glob, "fon");
    		m.Create();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public String[][] ImprimirResultado(){
    	String result[][] = new String[100000][5];
    	int contador = 0;
        while(true){
        	String resultados[] = new String[5];
            try {
                if (resultado.next()){
                	for(int i = 0; i < resultado.getMetaData().getColumnCount(); i++) {
                		if(i != 4)
                		resultados[i] = resultado.getString(i+1);
                		else {
                			if(resultado.getBlob(5) == null) {
                				resultados[i] = "Não tem";
                			}else {
                				resultados[i] = "Tem";
                			}
                		}
                	}
                	result[contador] = resultados;
                	contador++;
                }else {
                	return result;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}