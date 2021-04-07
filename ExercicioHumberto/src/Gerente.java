

public class Gerente extends Empregado implements Bonus{

	double salario;
	double bonus;
	
	public Gerente (String matricula, String nome, String cpf, double salario, double bonus) { 
		 super(nome, cpf, matricula);
		this.salario = salario;
		this.bonus = bonus;
	}
	
	
	private String nome;
	public String getNome() {
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
	
	
	public double calcularBonus() {
		return 1.1;
	}
	
}