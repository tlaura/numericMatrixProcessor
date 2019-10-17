package processor;

public class Multiply {

    public double[][] multiplyWithConstant(double[][] matrix, int constant) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= constant;
            }
        }
        return matrix;
    }

    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        int firstRow = firstMatrix.length;
        int firstCol = firstMatrix[0].length;
        int secondRow = secondMatrix.length;
        int secondCol = secondMatrix[0].length;

//        the number of columns for the first matrix should be equal to the number of rows for the second matrix
        if(firstCol != secondRow) {
            throw new IllegalArgumentException("First Matrix rows did not match Second Matrix column");
        }

        double[][] resultMatrix = new double[firstRow][secondCol];

//        sum of multiplication M elements across rows of A matrix on M elements down columns of B matrix
//        M = secondMatrix:Row, firstMatrix:Column
        for (int i = 0; i < firstRow; i++) {
            for (int j = 0; j < secondCol; j++) {
                for (int k = 0; k < firstCol; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return resultMatrix;
    }

}
