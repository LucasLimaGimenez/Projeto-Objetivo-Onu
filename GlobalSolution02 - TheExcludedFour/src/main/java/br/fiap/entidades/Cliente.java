package br.fiap.entidades;

public class Cliente {
	
	private int id_cliente;
	private int id_empresa;
	private String nm_cliente;
	private String cnpj;
	private String endereco;
	private String telefone;
	
	public Cliente(int id_cliente, int id_empresa, String nm_cliente, String cnpj, String endereco, String telefone) {
		this.id_cliente = id_cliente;
		this.id_empresa = id_empresa;
		this.nm_cliente = nm_cliente;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
