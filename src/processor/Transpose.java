package processor;

public class Transpose {


    public int[][] mainDiagonal(int[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new IllegalArgumentException("Transposition is only possible on square matrix");
        }
        int temp;
        for (int i = 0; i < matrix.length/2+1; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    private static int[][] rotate90Degrees(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        return result;
    }
    
    public int[][] flipVertical(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                int temp = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

    public int[][] flipHorizontal(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

//    rotate it 90 degrees, and transpose at main diagonal
    public int[][] sideDiagonal(int[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new IllegalArgumentException("Transposition is only possible on square matrix");
        }
        int[][] resultMatrix = flipHorizontal(rotate90Degrees(matrix));
        return resultMatrix;
    }
}
