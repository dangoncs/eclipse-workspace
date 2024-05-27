package entities;

import java.sql.Date;

public class Aluno {

	private int registroAcademico;
	private String nome;
	private String sexo;
	private Curso curso;
	private Date dataIngresso;
	private int periodo;
	private double coeficiente;
	
	public Aluno() {
		this.curso = new Curso();
	}
	
	public int getRegistroAcademico() {
		return registroAcademico;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public Curso getCurso() {
		return curso;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setRegistroAcademico(int registroAcademico) {
		this.registroAcademico = registroAcademico;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	@Override
	public String toString() {
		return "Aluno [registroAcademico=" + registroAcademico + ", nome=" + nome + ", sexo=" + sexo + ", curso="
				+ curso + ", dataIngresso=" + dataIngresso + ", periodo=" + periodo + ", coeficiente=" + coeficiente
				+ "]";
	}
}
