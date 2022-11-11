package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import enums.Categoria;

public class Util {
	
	public static Participante CreateParticipante(Scanner sc) throws ParseException {
		Participante p=null;
		
		System.out.println("Qual a categoria do usuário?\n[0] Autor\n[1] Revisor\n[2] Nenhum");
		int i = sc.nextInt();
		System.out.println();
		Categoria cat;
		if(i==0) {
			cat = Categoria.AUTOR;
		}else if(i==1) {
			cat = Categoria.REVISOR;
		}else if(i==2) {
			cat = Categoria.PARTICIPANTE;
		}else {
			System.out.println("opção inválida");
			System.out.println();
			return p;
		}

		System.out.print("CPF: ");
		String cpf = sc.next();
		
		System.out.print("nome: ");
		String nome = sc.next();

		System.out.print("data de nascimento: ");
		String dateString = sc.next();
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date nascimento = f.parse(dateString);

		System.out.print("titulação acadêmica: ");
		String titulo = sc.next();

		System.out.print("instituição de vínculo: ");
		String instituicao = sc.next();
		
		System.out.print("senha: ");
		String senha = sc.next();

		if(cat==Categoria.AUTOR)
			p = new Autor(cpf, nome, nascimento, titulo, instituicao, cat, senha);
		else if(cat==Categoria.REVISOR)
			p = new Revisor(cpf, nome, nascimento, titulo, instituicao, cat, senha);
		else
			p = new Participante(cpf, nome, nascimento, titulo, instituicao, cat, senha);
		
		System.out.println();
		return p;
	}
	
	public static Pessoa Login(Scanner sc, HashSet<Pessoa> users) throws ParseException {
		System.out.print("cpf: ");
		String cpf = sc.next();
		
		System.out.print("senha: ");
		String psw= sc.next();
		
		System.out.println();
		
		Pessoa pr = null;
		for(Pessoa p : users) {
			if(p.getCpf().equals(cpf) && p.getSenha().equals(psw)) {
				pr = p;
			}
		}
		return pr;
	}
	
	public static Participante LoginP(Scanner sc, HashSet<Participante> users) throws ParseException {
		System.out.print("cpf: ");
		String cpf = sc.next();
		
		System.out.print("senha: ");
		String psw= sc.next();

		System.out.println();
		
		Participante pr = null;
		for(Participante p : users) {
			if(p.getCpf().equals(cpf) && p.getSenha().equals(psw) && p.getValidado()) {
				pr = p;
			}
		}
		return pr;
	}
	
	public static Artigo CreateArtigo(Scanner sc, int id, Autor aa) throws ParseException {
		Artigo a = null;
		
		System.out.print("titulo: ");
		String titulo = sc.next();
		
		System.out.print("abstract: ");
		String abs = sc.next();
		
		System.out.print("palavras-chave: ");
		String pc = sc.next();
		
		System.out.print("quantidade de paginas: ");
		int qtdPag = sc.nextInt();
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String now = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		Date data = f.parse(now);
		
		System.out.print("número de autores (max 5): ");
		int qtdAu = sc.nextInt();
		if(qtdAu > 5 || qtdAu < 1) {
			System.out.print("valor inválido\n");
			return a;
		}
		
		HashSet<String> autores = new HashSet<String>();
		HashSet<String> cpfs = new HashSet<String>();
		autores.add(aa.getNome());
		for(int i=0; i<qtdAu-1; i++) {
			System.out.print("nome do autor num "+String.valueOf(i+1)+": ");
			autores.add(sc.nextLine());
		}

		aa.addArtigosSubmetidos(a);
		a = new Artigo(id, titulo, abs, pc, qtdPag, data, autores);
		
		System.out.println();
		return a;
	}

}
