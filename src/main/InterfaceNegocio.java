package main;

public interface InterfaceNegocio {

	public void criarConexao();
	public void fecharConexao();
	public void imprimirResultados();
	public void adicionarMidia();
	public void selectInstrucao(String consulta);
	public void selectInstrucao(String consulta, String complemento);
}
