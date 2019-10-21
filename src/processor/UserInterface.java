package processor;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Multiply multiply = new Multiply();
    Transpose transpose = new Transpose();
    Determinant determinant = new Determinant();

    public static void options() {
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit");
        System.out.println();
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
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    determinant();
                    break;
                case 6:
                    inverseMatrix();
                    break;
            }
        }
    }

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

    public static void displayMatrix(double[][] matrix){
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
        System.out.println("The multiplication result is: ");
        displayMatrix(result);
        System.out.println();
    }

    public void multiplyMatrices(){
        double[][] firstMatrix = matrix();
        double[][] secondMatrix = matrix();

        double[][] result = multiply.multiplyMatrices(firstMatrix, secondMatrix);
        System.out.println("The multiplication result is: ");
        displayMatrix(result);
        System.out.println();
    }

    public void transposeMatrix(){
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                double[][] matrix = matrix();
                transpose.mainDiagonal(matrix);
                System.out.println("The result is:");
                displayMatrix(matrix);
                break;
            case 2:
                matrix = matrix();
                matrix = transpose.sideDiagonal(matrix);
                System.out.println("The result is:");
                displayMatrix(matrix);
                break;
            case 3:
                matrix = matrix();
                transpose.flipVertical(matrix);
                System.out.println("The result is:");
                displayMatrix(matrix);
                break;
            case 4:
                matrix = matrix();
                transpose.flipHorizontal(matrix);
                System.out.println("The result is:");
                displayMatrix(matrix);
                break;
        }
        System.out.println();
    }

    public void determinant() {
        double[][] matrix = matrix();
        double det = determinant.getDeterminant(matrix, matrix.length);
        System.out.println("The result is:");
        System.out.println(det);
        System.out.println();
    }

    public void inverseMatrix() {
        double[][] matrix = matrix();
        double[][] result;
        if(determinant.inverseMatrix(matrix) == null){
            System.out.println("Inverse matrix can't be found because the determinant equals to 0");
        } else {
            result = determinant.inverseMatrix(matrix);
            System.out.println("The result is:");
            determinant.printInverse(result);
        }
        System.out.println();
    }
}
