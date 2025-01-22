package com.alura.literalura;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.literalura.integrations.BooksService;
import com.alura.literalura.models.Livro;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private BooksService service;

	public LiteraluraApplication(BooksService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String entradaUsuario;
		try (var scanner = new Scanner(System.in)) {
			do{
				
				System.out.println("Digite 1 para procurar por titulo ");
				
				System.out.println("Digite 2 para procurar por linguagem");
				
				System.out.println("Digite 3 para continuar");
				entradaUsuario = scanner.nextLine();
				
				if (entradaUsuario.equals("1")) {
					System.out.println("Você escolheu a opção 1.");
					System.out.println("Digite o titulo para pesquisa");
					entradaUsuario = scanner.nextLine();
					var livros = service.listarLivrosPeloTitulo(entradaUsuario);
					this.printarLivros(livros);
				} else if (entradaUsuario.equals("2")) {
					System.out.println("Você escolheu a opção 2.");
					System.out.println("Digite a linguagem para pesquisa");
					entradaUsuario = scanner.nextLine();
					var livros = service.listarLivrosPelaLinguagem(entradaUsuario);
					this.printarLivros(livros);
					
				} else if (entradaUsuario.equals("3")) {
					System.out.println("Você escolheu a opção 3.");
					System.out.println("Livros disponiveis");
					var livros = service.listarLivros();
					this.printarLivros(livros);
				} else {
					System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
				}
				 

				

				
			}while(true);
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}

	}

	private void printarLivros(List<Livro> livros){
		if (livros != null)
		for(var livro : livros)	
		System.out.println(livro.toString());
	}
}
