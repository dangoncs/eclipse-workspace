package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import entities.Curso;

public class AlunoDAO {

	private Connection conn;
	
	public AlunoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Aluno aluno) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into aluno (registro_academico, nome, sexo, codigo_curso, data_ingresso, periodo, coeficiente) values (?, ?, ?, ?, ?, ?, ?)");
			
			st.setInt(1, aluno.getRegistroAcademico());
			st.setString(2, aluno.getNome());
			st.setString(3, aluno.getSexo());
			st.setInt(4, aluno.getCurso().getCodigo());
			st.setDate(5, aluno.getDataIngresso());
			st.setInt(6, aluno.getPeriodo());
			st.setDouble(7, aluno.getCoeficiente());
			
			st.executeUpdate();
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Aluno> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		PreparedStatement st2 = null;
		ResultSet rs2 = null;
		
		try {
			st = conn.prepareStatement("select * from aluno order by nome");
			
			rs = st.executeQuery();
			
			List<Aluno> listaAlunos = new ArrayList<>();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				st2 = conn.prepareStatement("select * from curso where codigo = ?");
				st2.setInt(1, rs.getInt("codigo_curso"));
				rs2 = st2.executeQuery();
				
				if(rs2.next()) {
					Curso curso = new Curso();
					curso.setCodigo(rs2.getInt("codigo"));
					curso.setNome(rs2.getString("nome"));
					curso.setPeriodo(rs2.getString("periodo"));
					curso.setDuracao(rs2.getInt("duracao"));
					
					aluno.setCurso(curso);
				}
				
				BancoDados.finalizarStatement(st2);
				BancoDados.finalizarResultSet(rs2);
				
				aluno.setRegistroAcademico(rs.getInt("registro_academico"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataIngresso(rs.getDate("data_ingresso"));
				aluno.setPeriodo(rs.getInt("periodo"));
				aluno.setCoeficiente(rs.getDouble("coeficiente"));
				
				listaAlunos.add(aluno);
			}
			
			return listaAlunos;
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public Aluno buscarPorRA(int ra) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		PreparedStatement st2 = null;
		ResultSet rs2 = null;
		
		try {
			st = conn.prepareStatement("select * from aluno where registro_academico = ?");
			
			st.setInt(1, ra);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Aluno aluno = new Aluno();
				st2 = conn.prepareStatement("select * from curso where codigo = ?");
				st2.setInt(1, rs.getInt("codigo_curso"));
				rs2 = st2.executeQuery();
				
				if(rs2.next()) {
					Curso curso = new Curso();
					curso.setCodigo(rs2.getInt("codigo"));
					curso.setNome(rs2.getString("nome"));
					curso.setPeriodo(rs2.getString("periodo"));
					curso.setDuracao(rs2.getInt("duracao"));
					
					aluno.setCurso(curso);
				}
				
				BancoDados.finalizarStatement(st2);
				BancoDados.finalizarResultSet(rs2);
				
				aluno.setRegistroAcademico(rs.getInt("registro_academico"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataIngresso(rs.getDate("data_ingresso"));
				aluno.setPeriodo(rs.getInt("periodo"));
				aluno.setCoeficiente(rs.getDouble("coeficiente"));
				
				return aluno;
			}
			
			return null;
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void atualizar(Aluno aluno) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update aluno set nome = ?, sexo = ?, codigo_curso = ?, data_ingresso = ?, periodo = ?, coeficiente = ?  where registro_academico = ?");
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getSexo());
			st.setInt(3, aluno.getCurso().getCodigo());
			st.setDate(4, aluno.getDataIngresso());
			st.setInt(5, aluno.getPeriodo());
			st.setDouble(6, aluno.getCoeficiente());
			st.setInt(7, aluno.getRegistroAcademico());
			
			st.executeUpdate();
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int ra) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from aluno where registro_academico = ?");
			
			st.setInt(1, ra);
			
			int linhasManipuladas = st.executeUpdate();

			return linhasManipuladas;
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
