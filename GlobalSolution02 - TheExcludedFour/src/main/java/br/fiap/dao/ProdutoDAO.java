package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	
	public ProdutoDAO() {
		connection = Conexao.conectar();
	}

	public void inserir(Produto prod) {
		sql = "insert into produtos(id_produto,id_empresa,nm_produto,vl_unitario,funcao) values(?,?,?,?,?)"; 
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, prod.getId_produto()); 
			ps.setInt(2, prod.getId_empresa()); 
			ps.setString(3, prod.getNm_produto());
			ps.setDouble(4, prod.getVl_unitario());
			ps.setString(5, prod.getFuncao());
			ps.execute(); 
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco de dados \n"+ e);
		}
	}
	
	public boolean pesquisar(int id_produto) {
		boolean aux = false;
		sql = "select * from produtos where id_produto = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_produto);
			rs = ps.executeQuery(); 
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar no banco de dados \n"+ e);
		}
		return aux;
	}
	
	public void alterar (Produto prod) {
		sql = "update produtos set id_empresa = ?, nm_produto = ? ,vl_unitario = ? , funcao = ? where id_produto = ?";
		
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1,prod.getId_empresa());
			ps.setString(2, prod.getNm_produto());
			ps.setDouble(3, prod.getVl_unitario());
			ps.setString(4, prod.getFuncao());
			ps.setInt(5,prod.getId_produto());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao atualizar dados no banco de dados \n"+ e);
		}
	}
	
	public void deletar(int id_produto) {
		sql = "delete from produtos where id_produto = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_produto);
			ps.executeQuery(); 
		}catch(SQLException e) {
			System.out.println("Erro ao deletar no banco de dados \n"+ e);
		}
	}
	
	public ArrayList<Produto> listar(){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		sql = "select * from  produtos order by vl_unitario desc offset 0 rows fetch next 5 rows only";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Produto(rs.getInt("id_produto"),rs.getInt("id_empresa"),rs.getString("nm_produto"),rs.getDouble("vl_unitario"),rs.getString("funcao")));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao listar no banco de dados "+e);
		}
		return lista;
		
	}

}
