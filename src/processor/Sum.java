package processor;

public class Sum {
    public void sumMatrices(int[][] matrixA, int[][] matrixB){
        if(matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length){
            int[][] sum = new int[matrixA.length][matrixA[0].length];
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[i].length; j++) {
                    sum[i][j] = matrixA[i][j] + matrixB[i][j];
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
