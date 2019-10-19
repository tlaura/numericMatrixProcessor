package processor;

public class Determinant {
//    create subMatrix
    public int[][] getSubMatrix(int[][] matrix, int deleteRow, int deleteCol){
        int len = matrix.length;
        int[][] subMatrix = new int[len-1][len-1];
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

    public int getDeterminant(int[][] matrix, int len){
        int det = 0;
//        base cases
        if(len == 1)
            return matrix[0][0];
        if(len == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int sign = 1;
        int[][] subMatrix;
        for (int i = 0; i < len; i++) {
//            getting sub matrices of first row
            subMatrix = getSubMatrix(matrix, 0, i);
            det += matrix[0][i] * sign * getDeterminant(subMatrix, len-1);
            sign = -sign;
        }
        return det;
    }
}
