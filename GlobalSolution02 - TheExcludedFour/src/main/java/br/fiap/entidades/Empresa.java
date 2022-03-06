package br.fiap.entidades;

public class Empresa {
	
	private int id_empresa;
	private String nm_empresa;
	private String cnpj;
	private String endereco;
	private String telefone;
	
	public Empresa(int id_empresa, String nm_empresa, String cnpj, String endereco, String telefone) {
		this.id_empresa = id_empresa;
		this.nm_empresa = nm_empresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNm_empresa() {
		return nm_empresa;
	}

	public void setNm_empresa(String nm_empresa) {
		this.nm_empresa = nm_empresa;
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
