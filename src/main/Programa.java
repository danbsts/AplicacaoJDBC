package main;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Negocio jdbc = new Negocio();
		Scanner in = new Scanner(System.in);
		int comando = 1;
		while(comando > 1) {
			comando = Integer.parseInt(in.nextLine());
			/*
			 * inserirPessoa (nome, id, )
			 * inserirMultimidia(??)
			 * visualizarMultimidia()
			 * visualizarPessoa()
			 * removerPessoa()?
			 * atualizarMultimidia()?
			 * atualizarPessoa()?
			 */
		}
		jdbc.fecharConexao();

	}

}
