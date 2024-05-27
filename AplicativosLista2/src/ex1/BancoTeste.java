package ex1;

public class BancoTeste {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		banco.adicionarNovaConta("Danilo", 111222333);
		banco.adicionarNovaConta("Laura", 98765);
		banco.adicionarNovaConta("Regina", 567890);
		
		banco.verificarSaldo(1);
		banco.realizarSaque(1, 100);
		banco.realizarDeposito(1, 100);
		
		banco.realizarDeposito(2, 9);
		banco.realizarSaque(2, 10);
		banco.verificarSaldo(2);
		
		banco.realizarSaque(2, 6.50);
		banco.realizarSaque(2, 2.50);
		banco.verificarSaldo(2);
		
		banco.removerConta(0);
		banco.removerConta(3);
		banco.verificarSaldo(3);
		
		banco.imprimirContas();
	}
}
