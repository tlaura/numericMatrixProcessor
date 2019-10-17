package processor;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Multiply multiply = new Multiply();

    public double[][] matrix() {
        System.out.print("Enter size of matrix: ");
        String[] size = scanner.nextLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        System.out.println("Enter matrix: ");
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }

    public void printMatrix(double[][] matrix){
        System.out.println("The multiplication result is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void multiplyWithConstant() {
        double[][] matrix = matrix();
        System.out.print("Enter constant: ");
        int constant = Integer.parseInt(scanner.nextLine());

        double[][] result = multiply.multiplyWithConstant(matrix, constant);
        printMatrix(result);
    }

    public void multiplyMatrices(){
        double[][] firstMatrix = matrix();
        double[][] secondMatrix = matrix();

        double[][] result = multiply.multiplyMatrices(firstMatrix, secondMatrix);
        printMatrix(result);
    }

    public static void options() {
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit");
    }

    public void run() {
        boolean exit = false;
        while(!exit){
            options();
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    matrix();
                    break;
                case 2:
                    multiplyWithConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
            }
        }
    }
}
