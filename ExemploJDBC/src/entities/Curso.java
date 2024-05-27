package entities;

public class Curso {

	private int codigo;
	private String nome;
	private String periodo;
	private int duracao;
	
	public Curso() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", periodo=" + periodo + ", duracao=" + duracao + "]";
	}	
}
