package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Produto;
import br.fiap.entidades.Servico;

public class ServicoDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	
	public ServicoDAO() {
		connection = Conexao.conectar();
	}

	public void inserir(Servico serv) {
		sql = "insert into servicos(id_servico,id_empresa,id_funcionario,nm_servico,valor_servico) values(?,?,?,?,?)"; 
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, serv.getId_servico()); 
			ps.setInt(2, serv.getId_empresa());
			ps.setInt(3, serv.getId_funcionario());
			ps.setString(4, serv.getNm_servico());
			ps.setDouble(5, serv.getValor_servico());
			ps.execute(); 
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco de dados \n"+ e);
		}
	}
	
	public boolean pesquisar(int id_servico) {
		boolean aux = false;
		sql = "select * from servicos where id_servico = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_servico);
			rs = ps.executeQuery(); 
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar no banco de dados \n"+ e);
		}
		return aux;
	}
	
	public void alterar (Servico serv) {
		sql = "update servicos set id_empresa = ?,id_funcionario = ? ,nm_servico = ? ,valor_servico = ?  where id_servico = ?";
		
		try {
			ps = connection.prepareStatement(sql); 
			ps.setInt(1, serv.getId_empresa());
			ps.setInt(2, serv.getId_funcionario());
			ps.setString(3, serv.getNm_servico());
			ps.setDouble(4, serv.getValor_servico());
			ps.setInt(5,serv.getId_servico());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao atualizar dados no banco de dados \n"+ e);
		}
	}
	
	public void deletar(int id_servico) {
		sql = "delete from servicos where id_servico = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_servico);
			ps.executeQuery(); 
		}catch(SQLException e) {
			System.out.println("Erro ao deletar no banco de dados \n"+ e);
		}
	}
	
	public ArrayList<Servico> listar(){
		ArrayList<Servico> lista = new ArrayList<Servico>();
		sql = "select * from  servicos order by valor_servico desc offset 0 rows fetch next 5 rows only";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Servico(rs.getInt("id_servico"),rs.getInt("id_empresa"),rs.getInt("id_funcionario"),rs.getString("nm_servico"),rs.getDouble("valor_servico")));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao listar no banco de dados "+e);
		}
		return lista;
		
	}

}
