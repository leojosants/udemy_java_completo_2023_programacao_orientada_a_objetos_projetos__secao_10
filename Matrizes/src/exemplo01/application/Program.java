package exemplo01.application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int count = 0;

		System.out.print("\nInforme um valor inteiro para N elementos: ");
		int n = sc.nextInt();

		int[][] mat = new int[n][n];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("Digite o elemento");
				mat[i][j] = sc.nextInt();
			}
		}

		System.out.println("\nDiagonal principal:");

		for (int i = 0; i < mat.length; i++) {
			System.out.printf("%d ", mat[i][i]);
		}

		System.out.println();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}

		System.out.printf("\nNumeros negativos: %d", count);

		sc.close();
	}
}