package LeitorDeDados;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GerenciadorGrupos gerenciador = new GerenciadorGrupos();
		boolean primeiraVez = true;
		
		System.out.println("--- Cadastro de Pessoas ---");
		
		while (true) {
		
			if (primeiraVez){
				System.out.print("\nDigite o nome (ou 'sair' para encerrar): ");
				primeiraVez = false;
			} else {
				System.out.print("\nContinue digitando os nomes ou saia (digite 'sair'): ");
			}
			
			String nome = scanner.nextLine();
			
			if (nome.equalsIgnoreCase("sair")) {
				break;
			}
			
			System.out.print("Digite o sexo (M/F): ");
			String sexo = scanner.nextLine();
			
			while (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
				System.out.print("Entrada invalida! Digite apenas 'M' para Masculino ou 'F' para Feminino: ");
				sexo = scanner.nextLine();
			}
			
			gerenciador.adicionarPessoa(new Pessoa(nome, sexo));
		}
		
		List<Pessoa> grupoMasculino = gerenciador.getGrupoPorSexo("M");
		List<Pessoa> grupoFeminino = gerenciador.getGrupoPorSexo("F");
		
		exibirEmColunas(grupoMasculino, grupoFeminino);
		scanner.close();
	}
		private static void exibirEmColunas(List<Pessoa> masculino, List<Pessoa> feminino){
			System.out.println("\n======================= RESULTADO ========================");
			
			System.out.println(String.format("%-25s | %25s",
					"MASCULINO (" + masculino.size() + ")",
					"FEMININO (" + feminino.size() + ")"));
			System.out.println("-----------------------------------------------------------");
			
			
			int maxLinhas = Math.max(masculino.size(), feminino.size());
			 if (maxLinhas == 0) {
				 System.out.println(String.format("%-25s | %-25s", "Nenhum registro", "Nenhum registro"));
				 return;
			 }
			 
			 for(int i = 0; i <maxLinhas; i++) {
				 String nomeM = (i < masculino.size()) ? "- "  + masculino.get(i).getNome() : "";
				 String nomeF = (i < feminino.size()) ? "- "  + feminino.get(i).getNome() : "";
				 
				 System.out.println(String.format("%-25s | %-25s", nomeM, nomeF));
			 }
			 System.out.println("-----------------------------------------------------------");
			 	
		}
}
