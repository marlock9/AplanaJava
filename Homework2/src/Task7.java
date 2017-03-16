import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 16.03.17.
 */
public class Task7 {
    static boolean isSimple(int x) {
        for (int i = 2; i < ((int)Math.sqrt(x))+1; i++) if (x % i == 0) return false;
        return true;
    }

    static void method() {
        int x;
        while (true) {
            try {
                System.out.println("Введите натуральное число: ");
                Scanner scanInt = new Scanner(System.in);
                x = scanInt.nextInt();
                if (x<2) throw new Exception("Вводите, пожалуйста, натуральное число большее 1");
            } catch (InputMismatchException e) {
                System.out.println("Вводите, пожалуйста, число");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            System.out.println("Простое? " + isSimple(x));
        }
    }
}

