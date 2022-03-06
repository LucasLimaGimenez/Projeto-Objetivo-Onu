package br.fiap.entidades;

public class Funcionario {
	
	private int id_funcionario;
	private int id_empresa;
	private String nm_funcionario;
	private String rg;
	private String endereco;
	private String telefone;
	private double salario;
	
	public Funcionario(int id_funcionario, int id_empresa, String nm_funcionario, String rg, String endereco,String telefone, double salario) {
		this.id_funcionario = id_funcionario;
		this.id_empresa = id_empresa;
		this.nm_funcionario = nm_funcionario;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.salario = salario;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNm_funcionario() {
		return nm_funcionario;
	}

	public void setNm_funcionario(String nm_funcionario) {
		this.nm_funcionario = nm_funcionario;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	

}
