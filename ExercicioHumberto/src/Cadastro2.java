import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro2 {

	
	
	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		
		List<Pessoa> listaPessoa = new ArrayList();
		
		
        int indexCliente = 0;

        boolean running = true;
        String line;
        while (running) {
            System.out.print("> ");
            line = teclado.nextLine();
            switch (line.toLowerCase()) {
                case "help":
                    printMenu();
                    break;
                case "bye":
                case "exit":
                    running = false;
                    break;
                case "1":
                case "add empregado":
                    cadastrarEmpregado(listaPessoa);
                    break;
                case "2":
                case "add cliente":
                   cadastrarCliente(listaPessoa);
                    break;
                case "3":
                case "pesquisar":
                	pesquisar(listaPessoa);
                    break;
                case "4":
                case "list empregado":
                   listar(listaPessoa, "empregado");
                   break;
                case "5":
                case "list cliente":
                    listar(listaPessoa, "cliente");
                	break;
                case "6":
                case "remove":
                    remover(listaPessoa);
                case "7":
                case "Finalizar" :
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }
        System.out.println("Bye bye!");

    }

	
	public static void printMenu() {
		System.out.println("-------Menu-------");
		System.out.println("1.Cadastrar empregado");
		System.out.println("2.Cadastrar cliente");
		System.out.println("3.Pesquisar");
		System.out.println("4.Listar empregados");
		System.out.println("5.Listar clientes");
		System.out.println("6.Remover");
		System.out.println("7.Finalizar");
	}
	
	
	
		private static String inputTipoEmpregado() {
			
			String aux = null;
			String tipoEmpregado;
			while(aux == null) {
				System.out.println("Gerente (g) ou Vendedor (v) : ");
				tipoEmpregado = new Scanner(System.in).nextLine();
				if(!"g".equals(tipoEmpregado) && !"v".equals(tipoEmpregado)) {
					aux = null;
					System.out.println("Opção invalida, aceito apenas g ou v");
				}
			
				aux = tipoEmpregado; 
				
			}
			return aux;
			
		}
		
		public static void cadastrarVendedor(List <Pessoa> listaPessoa) {
			
			System.out.println("Digite o nome do vendedor : ");
			String nome = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o cpf do vendedor : ");
			String cpf = new Scanner(System.in).nextLine();
			
			System.out.println("Digite a matricula: ");
			String matricula = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o total de vendas: ");
			double totalDeVendas = new Scanner(System.in).nextDouble();
			
			System.out.println("Digite a comissao : ");
			double comissao = new Scanner(System.in).nextDouble();
			
			Vendedor vendedor = new Vendedor(nome, cpf, matricula, totalDeVendas, comissao);
			
			listaPessoa.add(vendedor);
			
			
		}
		
		public static void cadastrarGerente(List <Pessoa> listaPessoa ) {
			
			System.out.println("Digite o nome do gerente : ");
			String nome = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o cpf do gerente ; ");
			String cpf = new Scanner(System.in).nextLine();
			
			System.out.println("Digite a matricula: ");
			String matricula = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o salario : ");
			Double salario = new Scanner(System.in).nextDouble();
			
			System.out.println("Digite o bonus : ");
			Double bonus = new Scanner(System.in).nextDouble();
			
			Gerente gerente = new Gerente(matricula, nome, cpf, salario, bonus);
			
			listaPessoa.add(gerente); 
			
			
		}
		
		public static void cadastrarEmpregado(List <Pessoa> listaPessoa) {
			
			String tipoEmpregado = inputTipoEmpregado();
			switch (tipoEmpregado) {
			case "g":
			cadastrarGerente(listaPessoa);
				break;
			case"v":
			cadastrarVendedor(listaPessoa);
				break;
			
			}
			
			
		}
		
		public static void cadastrarCliente(List <Pessoa> listaPessoa) {
			
			System.out.println("Digite o nome do Cliente : ");
			String nome = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o cpf do cliente : ");
			String cpf = new Scanner(System.in).nextLine();
			
			System.out.println("Digite o valor da divida do cliente : ");
			double valorDaDivida = new Scanner(System.in).nextDouble();
			
			
			
			Cliente cliente = new Cliente(valorDaDivida, nome, cpf);
			
			listaPessoa.add(cliente);
			
		}
		
		private static void listar(List<Pessoa> listaPessoa, String tipo){
			
			listaPessoa.forEach(pessoa -> {
				if(pessoa instanceof Empregado && tipo.equals("empregado")){ 
					Empregado empregado = (Empregado) pessoa;
					System.out.println(empregado);
				}else if(pessoa instanceof Cliente && tipo.equals("cliente")){ 
					Cliente cliente = (Cliente) pessoa;
					System.out.println(cliente);
				}
			});
		}
		
		
		private static void pesquisar(List<Pessoa> listaPessoa){
			Scanner scanner = new Scanner(System.in);

			System.out.print("Informe o cpf: ");
			String cpf = scanner.nextLine();
			listaPessoa.forEach(pessoa -> {
				if(pessoa.cpf.equals(cpf)){
					if(pessoa instanceof Empregado){ 
						Empregado empregado = (Empregado) pessoa; 
						System.out.println("EMPREGADO -> "+empregado);
					}else if(pessoa instanceof Cliente){
						Cliente cliente = (Cliente) pessoa; 
						System.out.println("CLIENTE -> "+cliente);
					}
				}
			});
		}
		
		private static Pessoa buscar(List <Pessoa> listaPessoa, String cpf) {
			
			Pessoa pessoa = null;
			
			for (int i = 0; i < listaPessoa.size(); i++) {
				if(listaPessoa.get(i).cpf.equals(cpf)) {
					pessoa = listaPessoa.get(i);
					break;
				}
			}
			
			return pessoa;
		}
		
		
		
		
		
		public static void remover (List<Pessoa> listaPessoa) {
			
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Informe o cpf que será removido: ");
			String cpf = teclado.nextLine();
			
			Pessoa pessoa = buscar(listaPessoa, cpf);
			if(pessoa != null) {
				listaPessoa.remove(pessoa);
				System.out.println("CPF cancelado!!!");
			} else {
				System.out.println("Pessoa não encontrada!!!");
			}
		}
			
}
		
		