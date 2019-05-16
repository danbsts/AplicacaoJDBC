package main;

import java.io.IOException;
import java.sql.SQLException;

public interface InterfaceNegocio {

	public void criarConexao();
	public void fecharConexao();
	public void imprimirResultados();
	public void vizualizarMidia(String Nome);
	public void adicionarMidia(String path, String Nome) throws SQLException, IOException;
	public void adicionarPessoa(String cpf, String nome, String data, String sexo);
	public void selecionarInstrucao(String consulta);
	public void selecionarInstrucao(String consulta, String complemento);
}
