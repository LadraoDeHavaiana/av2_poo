package util;

import java.util.Date;
import java.util.HashSet;

import enums.Categoria;

public class Autor extends Participante{
	private HashSet<Artigo> artigosSubmetidos = new HashSet<Artigo>();
	
	public Autor(String cpf, String nome, Date nascimento, String titulo, String instituicao,
			Categoria categoria, String senha) {
		super(cpf, nome, nascimento, titulo, instituicao, categoria, senha);
	}

	public HashSet<Artigo> getArtigosSubmetidos() {
		return artigosSubmetidos;
	}

	public void addArtigosSubmetidos(Artigo artigoSubmetido) {
		this.artigosSubmetidos.add(artigoSubmetido);
	}

}
