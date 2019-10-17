import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeA = scanner.nextLine().split(" ");
        int nA = Integer.parseInt(sizeA[0]);
        int mA = Integer.parseInt(sizeA[1]);

        int[][] matrixA = new int[nA][mA];
        for (int i = 0; i < nA; i++) {
            String[] line = scanner.nextLine().split("\\p{Zs}");
            for (int j = 0; j < mA; j++) {
                matrixA[i][j] = Integer.parseInt(line[j]);
            }
        }
        String[] sizeB = scanner.nextLine().split(" ");
        int nB = Integer.parseInt(sizeB[0]);
        int mB = Integer.parseInt(sizeB[1]);
        int[][] matrixB = new int[nB][mB];
        for (int i = 0; i < nB; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < mB; j++) {
                matrixB[i][j] = Integer.parseInt(line[j]);
            }
        }
        if(nA == nB && mA == mB){
            int[][] sum = new int[nA][mA];
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
