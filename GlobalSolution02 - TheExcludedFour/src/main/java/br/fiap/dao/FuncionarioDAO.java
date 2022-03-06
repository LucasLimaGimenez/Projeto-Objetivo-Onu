package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Funcionario;

public class FuncionarioDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	
	public FuncionarioDAO() {
		connection = Conexao.conectar();
	}

	public void inserir(Funcionario func) {
		sql = "insert into funcionario(id_funcionario,id_empresa,nm_funcionario,rg,endereco,telefone,salario) values(?,?,?,?,?,?,?)"; 
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, func.getId_funcionario()); 
			ps.setInt(2, func.getId_empresa()); 
			ps.setString(3, func.getNm_funcionario());
			ps.setString(4, func.getRg());
			ps.setString(5, func.getEndereco());
			ps.setString(6, func.getTelefone());
			ps.setDouble(7, func.getSalario());
			ps.execute(); 
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco de dados \n"+ e);
		}
	}
	
	public boolean pesquisar(int id_funcionario) {
		boolean aux = false;
		sql = "select * from funcionario where id_funcionario = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_funcionario);
			rs = ps.executeQuery(); 
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar no banco de dados \n"+ e);
		}
		return aux;
	}
	
	public void alterar (Funcionario func) {
		sql = "update funcionario set id_empresa = ?, nm_funcionario = ? ,rg = ? , endereco = ? , telefone = ?, salario = ?  where id_funcionario = ?";
		
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1,func.getId_empresa());
			ps.setString(2,func.getNm_funcionario());
			ps.setString(3,func.getRg());
			ps.setString(4,func.getEndereco());
			ps.setString(5,func.getTelefone());
			ps.setDouble(6, func.getSalario());
			ps.setInt(7,func.getId_funcionario());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao atualizar dados no banco de dados \n"+ e);
		}
	}
	
	public void deletar(int id_funcionario) {
		sql = "delete from funcionario where id_funcionario = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_funcionario);
			ps.executeQuery(); 
		}catch(SQLException e) {
			System.out.println("Erro ao deletar no banco de dados \n"+ e);
		}
	}
	
	public ArrayList<Funcionario> listar(){
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		sql = "select * from  funcionario order by salario desc offset 0 rows fetch next 5 rows only";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Funcionario(rs.getInt("id_funcionario"), rs.getInt("id_empresa"), rs.getString("nm_funcionario"),rs.getString("rg"),rs.getString("endereco"), rs.getString("telefone"), rs.getDouble("salario")));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao listar no banco de dados "+e);
		}
		return lista;
		
	}

}
