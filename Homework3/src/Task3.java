import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 20.03.17.
 */
public class Task3 {
    static void method() {
        while (true) {
            int n;
            try {
                System.out.println("\nВведите число элементов массива: ");
                Scanner scanInt = new Scanner(System.in);
                n = scanInt.nextInt();
                if (n < 1) throw new Exception("n должно быть > 1\n");
            } catch (InputMismatchException e) {
                System.out.println(e+" Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
                System.out.print(array[i] + " ");
            }
            for (int i = 0; i < n-i; i++) {
                int buffer = array[i];
                array[i] = array[n-1-i];
                array[n-1-i] = buffer;
            }
            System.out.println("\nReverse: ");
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
