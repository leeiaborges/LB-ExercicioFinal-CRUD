package br.com.rd.model;

public class Carros {
	private Integer id;
	private String modelo;
	private Integer ano;
	
	public Carros(Integer id, String modelo, Integer ano){
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
