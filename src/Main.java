import processor.Determinant;
import processor.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
//        ui.run();

//        tests:
//        int[][] a = new int[][]{
//                {1, 7, 7},
//                {6, 6, 4},
//                {4, 2, 1}
//        };
        double[][] b = new double[][]{
                {2, -1, 0},
                {0, 1, 2},
                {1, 1, 0}
        };

        Determinant determinant = new Determinant();
        double[][] inverse = determinant.inverseMatrix(b);
        determinant.printInverse(inverse);

//        for (int i = 0; i < sub.length; i++) {
//            for (int j = 0; j < sub.length; j++) {
//                System.out.print(sub[i][j] + " ");
//            }
//            System.out.println();
//        }
//        int det = determinant.getDeterminant(a, len);
//        System.out.println(det);
    }
}
