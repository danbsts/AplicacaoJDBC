package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Programa{

	public static void main(String[] args) throws SQLException, IOException {
		InterfaceNegocio jdbc = new Negocio();
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
			comando = Integer.parseInt(in.nextLine());
			if (comando == 1) { // inserir pessoa
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
			} else if(comando == 2) { // consulta pessoa
				int escolhido = -1;
				while(escolhido < 0 || escolhido > 2) {
					System.out.println("Digite a opção de sua escolha:");
					System.out.println("1 - Para selecionar atributos sem condição.");
					System.out.println("2 - Para selecionar atributos que satisfazem uma condicao especifica (WHERE).");
					System.out.println("0 - Para selecionar cancelar.");
					escolhido = Integer.parseInt(in.nextLine());
					String colunas;
					if(escolhido == 1 || escolhido == 2) {
						System.out.println("Digite as colunas, na mesma linha, que você deseja selecionar:");
						System.out.println("Para todas as colunas, digite *.");
						colunas = in.nextLine();
						if(escolhido == 1) {
							String str[][] = jdbc.selecionarInstrucao(colunas);
							System.out.println(str[0][0]);
							System.out.println(str[0][1]);
							System.out.println(str[0][2]);
							System.out.println(str[0][3]);
						} else {
							System.out.println("Por favor digite as condicoes como em uma consulta SQL");
							String condicoes = in.nextLine();
							jdbc.selecionarInstrucao(colunas, condicoes);
						}
						escolhido = 0;
					}
				}
			} else if(comando == 3) { // inserir multimidia
				System.out.println("Digite onde deve ser inserida essa imagem (Nome da pessoa)");
				String pessoa = in.nextLine();
				System.out.println("Digite o caminho para a imagem a ser enviada");
				String path = in.nextLine();
				jdbc.adicionarMidia(path, pessoa);
				System.out.println("Imagem Enviada");
				
			} else if(comando == 4) { // visualizar multimidia
				System.out.println("De qual pessoa você quer ver a imagem?");
				String pessoa = in.nextLine();
				jdbc.vizualizarMidia(pessoa);
				System.out.println("imagem recebida");
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
