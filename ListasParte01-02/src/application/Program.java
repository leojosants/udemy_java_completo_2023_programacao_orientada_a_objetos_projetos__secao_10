package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		System.out.println("\n------------------------------------------------");

		// inserir elemento na lista por padrao na ultima posicao
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");

		System.out.println("Exibindo lista apos ADD");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// inserir elemento na lista em um indice especifico
		list.add(2, "Marco");

		System.out.println("Exibindo lista apos ADD");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// tamanho da lista
		System.out.printf("Tamanho da lista: %d%n", list.size());

		System.out.println("\n------------------------------------------------");

		// remover elemento da lista por comparacao
		System.out.printf("Elemento 'Anna' foi removido? %b%n", list.remove("Anna"));

		System.out.println("\nExibindo lista apos REMOVE por comparacao");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// remover elemento em um indice especifico
		System.out.printf("Elemento na posicao '2' foi removido? %b%n", list.remove(2));

		System.out.println("\nExibindo lista apos REMOVE por indice");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// remover elementos por predicado
		System.out.printf("Elemento(s) que iniciam com 'M' foram removidos? %b%n",
				list.removeIf(x -> x.charAt(0) == 'M'));

		System.out.println("\nExibindo lista apos REMOVE por predicado");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// encontrar posicao de elemento
		System.out.printf("Em que posicao se encontra o elemento 'Bob': %d%n", list.indexOf("Bob"));
		System.out.printf("Em que posicao se encontra o elemento 'Joao': %d%n", list.indexOf("Joao"));

		System.out.println("\nExibindo lista apos INDEXOF por predicado");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// inserir elemento na lista por padrao na ultima posicao
		list.add("Anna");

		System.out.println("Exibindo lista apos ADD");
		for (String string : list) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		/*
		 * filtrar lista com base em predicado
		 */
		// - declarar uma nova lista do mesmo tipo da lista que se deseja filtrar -
		// String
		// - atribuir a nova lista, a lista que se deseja filtrar
		// - acessar a lista que se deseja filtrar invocando o metodo 'streem()' para
		// realizar expressoes lambda
		// - atraves do metodo 'streem()' invocar o metodo 'filter()' para realizar
		// operacoes atraves de um predicado
		// - passar um predicado como parametro para o metodo 'filter()'
		// - atraves do do metodo 'filter()' invocar o metodo 'collect()' para converter
		// o 'streem' novamente em uma lista
		// - passar o metodo statico 'Collectors()' como predicado no parametro para o
		// metodo 'collect()'
		// - atraves do metodo estatico 'Collectors()' invocar o metodo 'toList()'

		List<String> resultList = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

		System.out.println("Exibindo nova lista apos FILTER");
		for (String string : resultList) {
			System.out.printf("Elementos: %s%n", string);
		}

		System.out.println("\n------------------------------------------------");

		// encontrar primeira ocorrencia com base em predicado
		String resultName_A = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);

		if (resultName_A != null) {
			System.out.printf("Primeiro elemento encontrado que comeca com 'A': %s%n", resultName_A);

		} else {
			System.out.println("Não foi encontrado nenhum elemento que comeca com 'A'");
		}

		System.out.println("\n------------------------------------------------");

		// encontrar primeira ocorrencia com base em predicado
		String resultName_J = list.stream().filter(x -> x.charAt(0) == 'j').findFirst().orElse(null);
		
		if (resultName_A != null) {
			System.out.printf("Primeiro elemento encontrado que comeca com 'j': %s%n", resultName_J);

		} else {
			System.out.println("Não foi encontrado nenhum elemento que comeca com 'A'");
		}

	}
}
