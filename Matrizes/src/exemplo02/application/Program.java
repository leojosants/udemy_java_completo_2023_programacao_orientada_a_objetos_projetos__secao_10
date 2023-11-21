package exemplo02.application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("\nInforme o número de linhas da matriz: ");
		int m = scanner.nextInt();

		System.out.print("Informe o número de colunas da matriz: ");
		int n = scanner.nextInt();

		int[][] mat = new int[m][n];

		System.out.println();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.printf("Digite o elemento da linha %d coluna %d: ", i, j);
				mat[i][j] = scanner.nextInt();
			}

			System.out.println();
		}

		System.out.print("Digite um elemento pertencente a matriz: ");
		int x = scanner.nextInt();
		boolean exist = false;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == x) {
					exist = true;

					System.out.println("Posição " + i + "," + j + ":");

					if (j > 0) {
						System.out.println("Esquerda: " + mat[i][j - 1]);
					}

					if (i > 0) {
						System.out.println("Acima: " + mat[i - 1][j]);
					}

					if (j < mat[i].length - 1) {
						System.out.println("Direita: " + mat[i][j + 1]);
					}

					if (i < mat.length - 1) {
						System.out.println("Abaixo: " + mat[i + 1][j]);
					}

				} else {
					exist = false;
				}
			}
		}
		
		if (!exist) {			
			System.out.printf("\nElemento %d não existe na matriz",x);
		}

		scanner.close();

	}

}
