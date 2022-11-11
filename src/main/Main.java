package main;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import enums.Categoria;
import util.*;

public class Main{
	
	private final static HashSet<Participante> participantes = new HashSet<Participante>(); // participantes
	private final static HashSet<Pessoa> orgs = new HashSet<Pessoa>(); // organizativo
	private final static HashSet<Artigo> artigos = new HashSet<Artigo>();
	
	public static void main(String[] args) throws ParseException {
		// super(cpf, nome, nascimento, titulo, instituicao, categoria, senha);
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d = f.parse("18/05/2000");

		participantes.add(new Participante("0", "t", d, "t", "t", Categoria.PARTICIPANTE, "0"));
		participantes.add(new Autor("1", "x", d, "x", "x", Categoria.AUTOR, "1"));
		participantes.add(new Revisor("2", "y", d, "y", "y", Categoria.REVISOR, "2"));
		orgs.add(new GeneralChair("3", "z", d, "z", "z", Categoria.GENERAL_CHAIR, "3"));
		orgs.add(new ProgramChair("4", "w", d, "w", "w", Categoria.PROGRAM_CHAIR, "4"));

		HashSet<String> _a = new HashSet<String>();
		_a.add("t");
		_a.add("a");
		_a.add("b");
		artigos.add(new Artigo(0, "titulo1", "abstract","1-2-3", 5, d, _a));
		
		
		Boolean rodando = true;
		Boolean logado = false;
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		Pessoa user = null;
		Participante par = null;
		Autor autor = null;
		Revisor revisor = null;
		GeneralChair gc = null;
		ProgramChair pc = null;
		Categoria cat = null;
		int i;
		
		while(rodando) {
			// menu não logado
			if(!logado) {
				System.out.println("[0] Sair\n[1] Criar Usuário\n[2] Login");
				i = sc.nextInt();	
				System.out.println();
				
				if(i==0) { // finaliza programa
					System.out.println("Finalizando programa");
					rodando = false;
				}else if(i==1) { // adiciona usuário
					Participante p = Util.CreateParticipante(sc);
					if(p!=null) {
						System.out.println("Usuário adicionado");
						participantes.add(p);
					} else System.out.println("erro ao criar usuário");
				}else if(i==2) { // realiza login
					System.out.println("[0] Participante\n[1] Organizador");
					i = sc.nextInt();
					System.out.println();
					
					if(i==0) {
						user = Util.LoginP(sc, participantes);
					}else if(i==1) {
						user = Util.Login(sc, orgs);
					}else {
						System.out.println("Opção inválida");
					}
					
					if(user!=null) {
						logado = true; 
						System.out.println("login realizado com sucesso!");
						if(user.getCategoria()==Categoria.PARTICIPANTE) par = (Participante) user;
						if(user.getCategoria()==Categoria.AUTOR) autor = (Autor) user;
						if(user.getCategoria()==Categoria.REVISOR) revisor = (Revisor) user;
						if(user.getCategoria()==Categoria.GENERAL_CHAIR) gc = (GeneralChair) user;
						if(user.getCategoria()==Categoria.PROGRAM_CHAIR) pc = (ProgramChair) user;
					}else {
						System.out.println("login inválido");
					}
				}
				
			// menu logado
			}else {
				cat = user.getCategoria();
				
				// resposta padrão
				System.out.println("[0] Logout\n[1] Artigos Aceitos\n[2] Artigos Negados\n[3] Participantes\n[4] Ver dados de artigo");
				// caso general chair
				if(cat==Categoria.GENERAL_CHAIR) { 
					System.out.println("[5] Validar inscrições\n[6] Invalidar inscrições\n[7] Emitir certificado para participante");
				// caso program chair
				} else if(cat==Categoria.PROGRAM_CHAIR) { 
					System.out.println("[5] Ver avaliação de artigos\n[6] Aceitar artigo\n[7] Rejeitar artigo");
				// caso autor
				} else if(cat==Categoria.AUTOR) { 
					System.out.println("[5] Ver avaliações de artigos publicados por você\n[6] Submeter artigo");
				// caso revisor
				}else if(cat==Categoria.REVISOR) { 
					System.out.println("[5] Ver avaliações de artigos avliados por você\n[6] Avaliar artigo");
				}
				
				i = sc.nextInt();
				System.out.println();
				
				// logout
				if(i==0) { 
					System.out.println("Logout");
					logado = false;
					user = null;
					
				// user visualiza artigos aceitos
				}else if(i==1) {
					System.out.println("Artigos aceitos: \n");
					//FAZER ORDEM ALFABÉTICA
					if(artigos.isEmpty()) {
						System.out.println("não há artigos");
					}else {
						for(Artigo a : artigos) {
							if(a.getAprovado()) System.out.println(a.getTitulo());
						}
					}
				
				// user visualiza artigos negados
				}else if(i==2) {
					System.out.println("Artigos negados: \n");
					//FAZER ORDEM ALFABÉTICA
					if(artigos.isEmpty()) {
						System.out.println("não há artigos");
					}else {
						for(Artigo a : artigos) {
							if(!a.getAprovado()) System.out.println(a.getTitulo());
						}
					}
				
				// user visualiza participantes
				}else if(i==3) {
					System.out.println("Participantes: \n");
					//FAZER ORDEM ALFABÉTICA
					for(Participante p: participantes) { 
						if(p.getValidado()) System.out.println(p.getNome());
					}
					
				// user obtem detalhes de artigo
				}else if(i==4){
					System.out.print("digite id do artigo: ");
					i = sc.nextInt();
					for(Artigo a : artigos) {
						if(a.getId()==i)
							System.out.println("\ntitulo: "+a.getTitulo());
							System.out.println("abstract: "+ a.getAbs());
							System.out.println("palavras chave: "+a.getPc());
							System.out.println("quantidade de páginas: "+String.valueOf(a.getQtdPag()));
							System.out.println("data de submissão: "+f.format(a.getData()));
							System.out.println("autores: "+a.getAutores());
							System.out.println("avaliado: "+a.getAvaliado());
							System.out.println("aprovado: "+a.getAprovado());
							System.out.println();
					}
					
				// GC valida participante
				}else if(i==5 && cat==Categoria.GENERAL_CHAIR) {
					System.out.print("Digite cpf do participante a ser validado: ");
					i = sc.nextInt();
					for(Participante p : participantes) {
						if(p.getCpf().equals(String.valueOf(i))) {
							System.out.println(p.getNome()+" validado");
							p.setValidado(true);
				}}
					
				// GC invalida participante
				}else if(i==6 && cat==Categoria.GENERAL_CHAIR) {
					System.out.print("Digite cpf do participante a ser invalidado: ");
					i = sc.nextInt();
					for(Participante p : participantes) {
						if(p.getCpf().equals(String.valueOf(i))) {
							System.out.println(p.getNome()+" invalidado");
							p.setValidado(false);
				}}
					
				// GC emite certificado
				}else if(i==7 && cat==Categoria.GENERAL_CHAIR) {
					System.out.print("Digite cpf do participante a emitir o certificado: ");
					i = sc.nextInt();
					for(Participante p : participantes) {
						if(p.getCpf().equals(String.valueOf(i)) && p.getValidado()) {
							System.out.println();
							System.out.println(p.getNome()+" participou do CBPOO");
							System.out.println("Parabéns!!!");
						}
					}

				// PC visualiza avaliação de todos os artigos
				}else if(i==5 && cat==Categoria.PROGRAM_CHAIR) {
					System.out.print("Digite id do artigo: ");
					i = sc.nextInt();
					for(Artigo a : artigos) {
						if(a.getId()==i) {
							System.out.println("Avaliação: ");
							System.out.println(a.getAvaliacao());
						}
					
					}
				
				// PC aceita artigo
				}else if(i==6 && cat==Categoria.PROGRAM_CHAIR) {
					System.out.print("Digite id do artigo a ser aceito: ");
					i = sc.nextInt();
					for(Artigo a: artigos) {
						if(a.getId()==i) {
							a.setAprovado(true);
							System.out.println(a.getTitulo()+" foi aceito");
						}
					}
				// PC rejeita artigo
				}else if(i==7 && cat==Categoria.PROGRAM_CHAIR) {
					System.out.print("Digite id do artigo a ser rejeitado: ");
					i = sc.nextInt();
					for(Artigo a: artigos) {
						if(a.getId()==i) {
							a.setAprovado(false);
							System.out.println(a.getTitulo()+" foi rejeitado");
						}
					}
					
				// A visualiza artigos submetidos e seus status
				}else if(i==5 && cat==Categoria.AUTOR) {
					System.out.println("Seus artigos: ");	
					for(Artigo a: autor.getArtigosSubmetidos()) {
						System.out.println(a.getTitulo()+" aprovado: "+String.valueOf(a.getAprovado()));
					}
					
				// A submete artigo
				}else if(i==6 && cat==Categoria.AUTOR) {
					System.out.println("Submeta seu artigo: ");
					Artigo a = Util.CreateArtigo(sc, artigos.size(), autor);
					artigos.add(a);
					autor.addArtigosSubmetidos(a);
					
				// R visualiza artigos revisados por ele
				}else if(i==5 && cat==Categoria.REVISOR) {
					System.out.println("Artigos avaliados por você: ");
					for(Artigo a: revisor.getArtigosRevisados()) {
						System.out.println(a.getTitulo());
					}
				
				// R revisa artigo
				}else if(i==6 && cat==Categoria.REVISOR) {
					System.out.print("digite id do artigo: ");
					i = sc.nextInt();
					for(Artigo a : artigos) {
						if(a.getId()==i) {
							System.out.println("sua avaliação: ");
							String av = sc.next();
							a.setAvaliacao(av);
							a.setAprovado(true);
							revisor.addArtigosRevisados(a);
						}
					
					}
				}else {
					System.out.println("opção inválida");
				}
			}
			System.out.println();
		}
		System.out.println("Tchau!");
	}
}
