package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Empresa;

public class EmpresaDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	
	public EmpresaDAO() {
		connection = Conexao.conectar();
	}

	public void inserir(Empresa emp) {
		sql = "insert into empresa(id_empresa,nm_empresa,cnpj,endereco,telefone) values(?,?,?,?,?)"; 
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, emp.getId_empresa()); 
			ps.setString(2, emp.getNm_empresa());
			ps.setString(3, emp.getCnpj());
			ps.setString(4, emp.getEndereco());
			ps.setString(5, emp.getTelefone());
			ps.execute(); 
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco de dados \n"+ e);
		}
	}
	
	public boolean pesquisar(int id_empresa) {
		boolean aux = false;
		sql = "select * from empresa where id_empresa = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_empresa);
			rs = ps.executeQuery(); 
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar no banco de dados \n"+ e);
		}
		return aux;
	}
	
	public void alterar (Empresa emp) {
		sql = "update empresa set nm_empresa = ?, cnpj = ? , endereco = ? , telefone = ?  where id_empresa = ?";
		
		try {
			ps = connection.prepareStatement(sql); 
			ps.setString(1,emp.getNm_empresa());
			ps.setString(2,emp.getCnpj());
			ps.setString(3,emp.getEndereco());
			ps.setString(4,emp.getTelefone());
			ps.setInt(5,emp.getId_empresa());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao atualizar dados no banco de dados \n"+ e);
		}
	}
	
	public void deletar(int id_empresa) {
		sql = "delete from empresa where id_empresa = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_empresa);
			ps.executeQuery(); 
		}catch(SQLException e) {
			System.out.println("Erro ao deletar no banco de dados \n"+ e);
		}
	}
	
	

}
