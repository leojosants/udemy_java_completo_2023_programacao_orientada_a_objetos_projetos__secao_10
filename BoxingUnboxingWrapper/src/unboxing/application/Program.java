package unboxing.application;

public class Program {

	public static void main(String[] args) {

		/*
		 * Unboxing - É o processo de conversão de um objeto tipo referência para um
		 * objeto tipo valor compatível
		 * 
		 */

		int x = 20;

		Object obj = x;

		int y=(int)obj;
		
		System.out.println(x);
		System.out.println(y);

	}

}
