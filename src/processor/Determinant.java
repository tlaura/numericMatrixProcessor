package processor;

public class Determinant {
    Transpose transpose = new Transpose();

    public double[][] getSubMatrix(double[][] matrix, int deleteRow, int deleteCol){
        int len = matrix.length;
        double[][] subMatrix = new double[len-1][len-1];
        int i = 0, j = 0;

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if(row == deleteRow || col == deleteCol)
                    continue;

                subMatrix[i][j++] = matrix[row][col];
//                when current row is filled
                if(j == len-1){
                    j = 0;
                    i++;
                }
            }
        }
        return subMatrix;
    }

    public double getDeterminant(double[][] matrix, int len){
        int det = 0;
        if(len == 1)
            return matrix[0][0];
        if(len == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int sign = 1;
        double[][] subMatrix;
        for (int i = 0; i < len; i++) {
//            getting sub matrices of first row
            subMatrix = getSubMatrix(matrix, 0, i);
            det += matrix[0][i] * sign * getDeterminant(subMatrix, len-1);
            sign = -sign;
        }
        return det;
    }

    public double[][] inverseMatrix(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                double[][] m = getSubMatrix(matrix, i, j);
                m = transpose.mainDiagonal(m);
                inverse[i][j] = Math.pow(-1, i+j) * getDeterminant(matrix, matrix.length);
            }
        }
        double det = 1.0/ getDeterminant(matrix, matrix.length);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j < inverse[0].length; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }
        return inverse;
    }

    public void printInverse(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 0){
                    System.out.printf("%.2f ", matrix[i][j]);
                } else {
                    System.out.printf(" %.2f ", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
