package main;

public class Negocio implements InterfaceNegocio{
	Servidor servidor = new Servidor();
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
	public void selectInstrucao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirResultados() {
		// TODO Auto-generated method stub
		servidor.ImprimirResultado();
	}

	@Override
	public void adicionarMidia() {
		// TODO Auto-generated method stub
		
	}

}
