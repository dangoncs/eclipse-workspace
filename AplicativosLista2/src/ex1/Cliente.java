package ex1;

public class Cliente {

	private String nome;
	private long cpf;
	
	public Cliente(String nome, long cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void imprimirDadosCliente() {
		System.out.println("Nome do titular: " + nome);
		System.out.println("CPF do titular: " + cpf);
	}
}
