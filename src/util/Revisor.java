package util;

import java.util.Date;
import java.util.HashSet;

import enums.Categoria;

public class Revisor extends Participante{
	private HashSet<Artigo> artigosRevisados = new HashSet<Artigo>();

	public Revisor(String cpf, String nome, Date nascimento, String titulo, String instituicao, Categoria categoria,
			String senha) {
		super(cpf, nome, nascimento, titulo, instituicao, categoria, senha);
		// TODO Auto-generated constructor stub
	}

	public HashSet<Artigo> getArtigosRevisados() {
		return artigosRevisados;
	}

	public void addArtigosRevisados(Artigo artigo) {
		artigosRevisados.add(artigo);
	}

}
