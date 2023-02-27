package com.spring.jwt.dto;

public class produtosDto {

	private String nome;

	private String marca;

	private String preco;

	public produtosDto() {

	}

	public produtosDto(Long id, String nome, String marca, String preco) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}
