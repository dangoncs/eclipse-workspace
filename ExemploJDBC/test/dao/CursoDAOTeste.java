package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Curso;

public class CursoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
		Curso curso = new Curso();
		curso.setNome("Tecn. em Análise e Desenvolvimento de Sistemas");
		curso.setPeriodo("Noturno");
		curso.setDuracao(8);
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).cadastrar(curso);
		
		System.out.println("Cadastro efetuado com sucesso!");
	}
	
	public static void buscarTodosTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<Curso> listaCursos = new CursoDAO(conn).buscarTodos();
		
		for(Curso curso : listaCursos) {
			System.out.println(curso.getCodigo() + " - " + curso.getNome() + " - " + curso.getPeriodo() + " - " + curso.getDuracao());
		}
	}
	
	public static void buscarPorCodigoTeste(int codigoCurso) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Curso curso = new CursoDAO(conn).buscarPorCodigo(codigoCurso);
		
		if(curso != null) {
			System.out.println(curso.getCodigo() + " - " + curso.getNome() + " - " + curso.getPeriodo() + " - " + curso.getDuracao());
		}
		else {
			System.out.println("Erro - Código não encontrado.");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		Curso curso = new Curso();
		curso.setCodigo(9);
		curso.setDuracao(5);
		curso.setPeriodo("Noturno");
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).atualizar(curso);
		
		System.out.println("Dados do curso atualizados com sucesso.");
	}
	
	public static void excluirTeste(int codigoCurso) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new CursoDAO(conn).excluir(codigoCurso);
		
		if(linhasManipuladas > 0) {
			System.out.println("Curso excluído com sucesso.");
		}
		else {
			System.out.println("Nenhum registro foi encontrado.");
		}
	}
	
	public static void main(String[] args) {
		try {
			//CursoDAOTeste.cadastrarCursoTeste();
			//CursoDAOTeste.buscarTodosTeste();
			//CursoDAOTeste.buscarPorCodigoTeste(1);
			CursoDAOTeste.atualizarTeste();
			//CursoDAOTeste.excluirTeste(17);
		}
		catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
