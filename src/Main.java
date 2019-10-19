import processor.Determinant;
import processor.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();

//        tests:
//        int[][] a = new int[][]{
//                {1, 7, 7},
//                {6, 6, 4},
//                {4, 2, 1}
//        };
//        int[][] b = new int[][]{
//                {2, 4, 5, 6},
//                {6, 6, 7, 8},
//                {5, 0, 0, 1},
//                {8, 8, 2, 9}
//        };

//        Determinant determinant = new Determinant();
//        int len = a.length;
//        int[][] sub = determinant.getSubMatrix(a, len-1, len-1);
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
