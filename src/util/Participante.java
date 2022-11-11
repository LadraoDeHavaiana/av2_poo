package util;

import java.util.Date;
import enums.Categoria;

public class Participante extends Pessoa {
	private Boolean validado;

	public Participante(String cpf, String nome, Date nascimento, String titulo, String instituicao,
			Categoria categoria, String senha) {
		super(cpf, nome, nascimento, titulo, instituicao, categoria, senha);
		// TODO Auto-generated constructor stub
		setValidado(false);
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

}
