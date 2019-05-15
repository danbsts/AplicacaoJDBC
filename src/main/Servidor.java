package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Servidor {

    public static String url = "jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:instance01";
    public static String user = "g191if685cc_eq05";
    public static String senha = "myjxmwoh";

    public static Connection conexao;
    public static Statement stmt;

    public static ResultSet resultado;
    
    public Servidor() {
    	createConnection();
    }

    public static void createConnection(){

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

    public static void closeConnection(){
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectBasico(String consulta){
        try {
            resultado = stmt.executeQuery(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void ImprimirResultado(){
        while(true){
            try {
                if (resultado.next()){
                	for(int i = 0; i < resultado.getMetaData().getColumnCount(); i++) {
                		if(i != 4)
                		System.out.println(resultado.getString(i+1));
                	}
                	System.out.println();
                }else{
                    break;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){

        //Fazer um select basico:

        //Abrir a conexão:
        createConnection();

        //Fazer um select:
        selectBasico();

        //Imprimir resultado:
        ImprimirResultado();

        //Fechar a conexão;
        closeConnection();
    }

}