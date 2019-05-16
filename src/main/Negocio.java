package main;

import java.io.IOException;
import java.sql.SQLException;

public class Negocio implements InterfaceNegocio{
	private Servidor servidor;
	
	public Negocio() {
		this.servidor = new Servidor();
	}
	
	@Override
	public void criarConexao() {
		// TODO Auto-generated method stub
		servidor.createConnection();
	}

	@Override
	public void fecharConexao() {
		// TODO Auto-generated method stub
		servidor.closeConnection();
	}

	@Override
	public String[][] selecionarInstrucao(String consulta) {
		consulta = "select "+ consulta +" from PESSOA";
		return servidor.selectBasico(consulta);
		
	}
	public String[][] selecionarInstrucao(String consulta, String complemento) {
		consulta = "select "+ consulta +" from PESSOA WHERE" + complemento;
		return servidor.selectBasico(consulta);
		
	}

	@Override
	public void imprimirResultados() {
		// TODO Auto-generated method stub
		servidor.ImprimirResultado();
	}
	public void vizualizarMidia(String Nome) {
		servidor.pegaBlob(Nome);
	}

	@Override
	public void adicionarMidia(String path, String Nome) throws SQLException, IOException {
		// TODO Auto-generated method stub
		servidor.addMidia(path, Nome); 
	}


	@Override
	public void adicionarPessoa(String cpf, String nome, String data, String sexo) {
		// TODO Auto-generated method stub
		servidor.adicionarPessoa(cpf, nome, data, sexo);
	}
	

}
