package unboxing.application;

public class Program {

	public static void main(String[] args) {

		/*
		 * Unboxing - � o processo de convers�o de um objeto tipo refer�ncia para um
		 * objeto tipo valor compat�vel
		 * 
		 */

		int x = 20;

		Object obj = x;

		int y=(int)obj;
		
		System.out.println(x);
		System.out.println(y);

	}

}
