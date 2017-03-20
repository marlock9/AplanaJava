/**
 * Created by marlock on 20.03.17.
 */
public class Task2 {
    static void method() {
        final int rows = 5;
        final int columns = 8;
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = (int)((Math.random()*199)-99);
            }
        }
        int max = -99;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
                if (array[i][j] > max) max = array[i][j];
            }
            System.out.println();
        }
        System.out.println("Max="+max);
    }
}
