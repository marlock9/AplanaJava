import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 16.03.17.
 */
public class Task6 {
    static void showDividers(int x) {
        for (int i = 1; i<=x; i++) if (x%i == 0) System.out.println(i + " - делитель числа " + x);
    }

    static void method() {
        int x;
        while (true) {
            try {
                System.out.println("Введите натуральное число: ");
                Scanner scanInt = new Scanner(System.in);
                x = scanInt.nextInt();
                if (x<0) throw new Exception("Вводите, пожалуйста, натуральное число");
            } catch (InputMismatchException e) {
                System.out.println("Вводите, пожалуйста, число");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            showDividers(x);
        }
    }
}
