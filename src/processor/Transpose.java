package processor;

public class Transpose {


    public double[][] mainDiagonal(double[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new IllegalArgumentException("Transposition is only possible on square matrix");
        }
        double temp;
        for (int i = 0; i < matrix.length/2+1; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    private static double[][] rotate90Degrees(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        return result;
    }
    
    public double[][] flipVertical(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                double temp = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

    public double[][] flipHorizontal(double[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                double temp = matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

//    rotate it 90 degrees, and transpose at main diagonal
    public double[][] sideDiagonal(double[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new IllegalArgumentException("Transposition is only possible on square matrix");
        }
        double[][] resultMatrix = flipHorizontal(rotate90Degrees(matrix));
        return resultMatrix;
    }
}
