package ex1;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Conta> contas;
	private int indiceAtual;
	
	public Banco() {
		this.contas = new ArrayList<Conta>();
		indiceAtual = 1;
	}
	
	public void adicionarNovaConta(String nome, long cpf) {
		Conta conta = new Conta(indiceAtual, nome, cpf);
		this.contas.add(conta);
		System.out.println("Conta " + indiceAtual + " adicionada com sucesso.");
		indiceAtual++;
	}
	
	public void imprimirContas() {
		for(Conta conta : contas) {
			conta.imprimirDadosConta();
		}
	}
	
	public void removerConta(int numeroConta) {
		for(int i = 0; i < contas.size(); i++) {
			if(contas.get(i).getNumeroConta() == numeroConta) {
				contas.remove(i);
				System.out.println("Conta " + numeroConta + " removida com sucesso.");
				break;
			}
		}
	}
	
	public void verificarSaldo(int numeroConta) {
		for(Conta conta : contas) {
			if(conta.getNumeroConta() == numeroConta) {
				conta.imprimirSaldo();
				break;
			}
		}
	}

	public void realizarSaque(int numeroConta, double valor) {
		for(Conta conta : contas) {
			if(conta.getNumeroConta() == numeroConta) {
				conta.sacar(valor);
				break;
			}
		}
	}
	
	public void realizarDeposito(int numeroConta, double valor) {
		for(Conta conta : contas) {
			if(conta.getNumeroConta() == numeroConta) {
				conta.depositar(valor);
				break;
			}
		}
	}
}
