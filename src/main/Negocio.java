package main;

public class Negocio implements InterfaceNegocio{
	private Servidor jdbc;
	
	public Negocio() {
		jdbc = new Servidor();
	}
	
	@Override
	public void criarConexao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fecharConexao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectInstrucao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirResultados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarMidia() {
		// TODO Auto-generated method stub
		
	}

}
