package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Cliente;


public class ClienteDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	
	public ClienteDAO() {
		connection = Conexao.conectar();
	}

	public void inserir(Cliente cli) {
		sql = "insert into cliente(id_cliente,id_empresa,nm_cliente,cnpj,endereco,telefone) values(?,?,?,?,?,?)"; 
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, cli.getId_cliente()); 
			ps.setInt(2, cli.getId_empresa()); 
			ps.setString(3, cli.getNm_cliente());
			ps.setString(4, cli.getCnpj());
			ps.setString(5, cli.getEndereco());
			ps.setString(6, cli.getTelefone());
			ps.execute(); 
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco de dados \n"+ e);
		}
	}
	
	public boolean pesquisar(int id_cliente) {
		boolean aux = false;
		sql = "select * from cliente where id_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_cliente);
			rs = ps.executeQuery(); 
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar no banco de dados \n"+ e);
		}
		return aux;
	}
	
	public void alterar (Cliente cli) {
		sql = "update cliente set id_empresa = ?, nm_cliente = ?, cnpj = ? , endereco = ? , telefone = ?  where id_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1,cli.getId_empresa());
			ps.setString(2,cli.getNm_cliente());
			ps.setString(3,cli.getCnpj());
			ps.setString(4,cli.getEndereco());
			ps.setString(5,cli.getTelefone());
			ps.setInt(6, cli.getId_cliente());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao atualizar dados no banco de dados \n"+ e);
		}
	}
	
	public void deletar(int id_cliente) {
		sql = "delete from cliente where id_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_cliente);
			ps.executeQuery(); 
		}catch(SQLException e) {
			System.out.println("Erro ao deletar no banco de dados \n"+ e);
		}
	}

}
