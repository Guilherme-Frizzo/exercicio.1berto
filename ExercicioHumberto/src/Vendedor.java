


public class Vendedor extends Empregado {

	double totalDeVendas;
	double comissao;
	
	public Vendedor (String nome, String cpf, String matricula, double totalDeVendas,double comissao ) { 
		super(nome, cpf, matricula); 
		this.totalDeVendas = totalDeVendas;
		this.comissao = comissao;
	 }
	
	private String nome;
	public  String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private String cpf;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void calcularSalario(){
		
	}
	
}