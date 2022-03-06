package br.fiap.entidades;

public class Produto {
	
	private int id_produto;
	private int id_empresa;
	private String nm_produto;
	private double vl_unitario;
	private String funcao;
	
	public Produto(int id_produto, int id_empresa, String nm_produto, double vl_unitario, String funcao) {
		this.id_produto = id_produto;
		this.id_empresa = id_empresa;
		this.nm_produto = nm_produto;
		this.vl_unitario = vl_unitario;
		this.funcao = funcao;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNm_produto() {
		return nm_produto;
	}

	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}

	public double getVl_unitario() {
		return vl_unitario;
	}

	public void setVl_unitario(double vl_unitario) {
		this.vl_unitario = vl_unitario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
