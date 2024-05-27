package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;
import entities.Curso;

public class AlunoDAOTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException {
		Curso curso = new Curso();
		curso.setCodigo(4);
		curso.setNome("Tecn. em Análise e Desenvolvimento de Sistemas");
		curso.setPeriodo("Noturno");
		curso.setDuracao(6);
		
		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(2422222);
		aluno.setNome("Maria de Oliveira");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new Date(2022, 12,  12));
		aluno.setPeriodo(2);
		aluno.setCoeficiente(0.6);
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).cadastrar(aluno);
		
		System.out.println("Cadastro efetuado com sucesso!");
	}
	
	public static void buscarTodosTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<Aluno> listaAlunos = new AlunoDAO(conn).buscarTodos();
		
		for(Aluno aluno : listaAlunos) {
			System.out.println(aluno);
		}
	}
	
	public static void buscarPorRATeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Aluno aluno = new AlunoDAO(conn).buscarPorRA(2422222);
		
		if(aluno != null) {
			System.out.println(aluno);
		}
		else {
			System.out.println("Erro - Código não encontrado.");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		Curso curso = new Curso();
		curso.setCodigo(4);
		curso.setNome("Tecn. em Análise e Desenvolvimento de Sistemas");
		curso.setPeriodo("Noturno");
		curso.setDuracao(6);
		
		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(2422222);
		aluno.setNome("Maria de Oliveira");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new Date(2022, 12,  12));
		aluno.setPeriodo(3);
		aluno.setCoeficiente(0.79);
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).atualizar(aluno);
		
		System.out.println("Dados do aluno atualizados com sucesso.");
	}
	
	public static void excluirTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new AlunoDAO(conn).excluir(29000000);
		
		if(linhasManipuladas > 0) {
			System.out.println("Aluno excluído com sucesso.");
		}
		else {
			System.out.println("Nenhum registro foi encontrado.");
		}
	}
	
	public static void main(String[] args) {
		try {
			//AlunoDAOTeste.cadastrarAlunoTeste();
			AlunoDAOTeste.buscarTodosTeste();
			AlunoDAOTeste.buscarPorRATeste();
			//AlunoDAOTeste.atualizarTeste();
			AlunoDAOTeste.excluirTeste();
		}
		catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
