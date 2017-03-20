/**
 * Created by marlock on 20.03.17.
 */
public class Task1 {
    static void method() {
        final int rows = 8;
        final int columns = 5;
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = (int)((Math.random()*90)+10);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
