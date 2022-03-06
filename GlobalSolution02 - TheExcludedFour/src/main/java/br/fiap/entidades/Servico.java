package br.fiap.entidades;

public class Servico {
	
	private int id_servico;
	private int id_empresa;
	private int id_funcionario;
	private String nm_servico;
	private double valor_servico;
	
	public Servico(int id_servico, int id_empresa, int id_funcionario, String nm_servico, double valor_servico) {
		this.id_servico = id_servico;
		this.id_empresa = id_empresa;
		this.id_funcionario = id_funcionario;
		this.nm_servico = nm_servico;
		this.valor_servico = valor_servico;
	}

	public int getId_servico() {
		return id_servico;
	}

	public void setId_servico(int id_servico) {
		this.id_servico = id_servico;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNm_servico() {
		return nm_servico;
	}

	public void setNm_servico(String nm_servico) {
		this.nm_servico = nm_servico;
	}

	public double getValor_servico() {
		return valor_servico;
	}

	public void setValor_servico(double valor_servico) {
		this.valor_servico = valor_servico;
	}
	
	
	
	

}
