package main;

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
	public void selectInstrucao(String consulta) {
		consulta = "select "+ consulta +"from PESSOA";
		servidor.selectBasico(consulta);
		
	}
	public void selectInstrucao(String consulta, String complemento) {
		consulta = "select "+ consulta +"from PESSOA WHERE" + complemento;
		servidor.selectBasico(consulta);
		
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
