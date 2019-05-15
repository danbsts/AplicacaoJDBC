package main;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Negocio jdbc = new Negocio();
		Scanner in = new Scanner(System.in);
		int comando = 1;
		while(comando != 0) {
			if(comando < 0 || comando > 4) System.out.println("Não consegui compreender, por favor tente novamente.");
			System.out.println("Por favor defina a operação que deseja realizar:");
			System.out.println("1 - Inserir pessoa");
			System.out.println("2 - Consulta Pessoa");
			System.out.println("3 - Inserir Multimida");
			System.out.println("4 - Visualizar Multimida");
			System.out.println("0 - Para fechar o programa");
			int opcao = Integer.parseInt(in.nextLine());
			if (opcao == 1) { // inserir pessoa
				// (CPF_p, Nome, Data_de_nascimento, Sexo)
				String cpf, nome, dataNasc, genero;
				System.out.println("Por favor digite os dados da pessoa a ser cadastrada.");
				System.out.print("Por favor digite o CPF: ");
				cpf = in.nextLine();
				System.out.print("Por favor digite o nome: ");
				nome = in.nextLine();
				System.out.print("Por favor digite a data de nascimento: ");
				dataNasc = in.nextLine();
				System.out.print("Por favor digite o sexo: ");
				genero = in.nextLine();
				jdbc.adicionarPessoa(cpf, nome, dataNasc, genero);
			} else if(opcao == 2) { // consulta pessoa
				int escolhido = 1;
				while(escolhido < 1 || escolhido > 2) {
					System.out.println("Digite a opção de sua escolha:");
					System.out.println("1 - Para selecionar toda tabela.");
					System.out.println("2 - Para selecionar atributos especificos.");
					System.out.println("0 - Para selecionar cancelar.");
					escolhido = Integer.parseInt(in.nextLine());
				}
			} else if(opcao == 3) { // inserir multimidia
				
			} else if(opcao == 4) { // visualizar multimidia
				
			} else { // fechar
				comando = 0;
			}
			/*
			 * inserirPessoa (nome, id, )
			 * visualizarPessoa()
			 * inserirMultimidia(??)
			 * visualizarMultimidia()
			 * removerPessoa()?
			 * atualizarMultimidia()?
			 * atualizarPessoa()?
			 */
		}
		jdbc.fecharConexao();

	}

}
