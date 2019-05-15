package main;

public interface InterfaceNegocio {

	public void criarConexao();
	public void fecharConexao();
	public void imprimirResultados();
	public void adicionarMidia();
	public void adicionarPessoa(String cpf, String nome, String data, String sexo);
	public void selecionarInstrucao(String consulta);
	public void selecionarInstrucao(String consulta, String complemento);
}
