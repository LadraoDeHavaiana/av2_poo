package util;

import java.util.Date;
import java.util.HashSet;

public class Artigo {
	private int id;
	private String titulo;
	private String abs;
	private String pc;
	private int qtdPag;
	private Date data;
	private HashSet<String> autores;
	private Boolean aprovado;
	private Boolean avaliado;
	private String avaliacao;

	public Artigo(int id, String titulo, String abs, String pc, int qtdPag, Date data, HashSet<String> autores) {
		this.id = id;
		this.setTitulo(titulo);
		this.setAbs(abs);
		this.setPc(pc);
		this.setQtdPag(qtdPag);
		this.setData(data);
		this.setAutores(autores);
		setAvaliado(false);
		setAprovado(false);
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public HashSet<String> getAutores() {
		return autores;
	}

	public void setAutores(HashSet<String> autores) {
		this.autores = autores;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Boolean getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(Boolean avaliado) {
		this.avaliado = avaliado;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

}
