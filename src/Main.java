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
                {0.33, 0, 0.33},
                {-0.33, 0, 0.66},
                {0.16, 0.5, -0.33}
        };

        Determinant determinant = new Determinant();
        determinant.printInverse(b);

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
