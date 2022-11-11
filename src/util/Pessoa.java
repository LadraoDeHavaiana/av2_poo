package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Categoria;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private Date nascimento;
	private String titulo;
	private String instituicao;
	private String senha;
	private Categoria categoria;
	
	public Pessoa(String cpf, String nome, Date nascimento, String titulo, String instituicao, Categoria categoria, String senha) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setTitulo(titulo);
		this.setInstituicao(instituicao);
		this.setSenha(senha);
		
		this.categoria = categoria;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
