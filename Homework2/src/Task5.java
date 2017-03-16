import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 16.03.17.
 */
public class Task5 {
    static long getFactorial(long x) {
        if (x == 0) return 1;
        return x * getFactorial(x - 1);
    }

    static void method() {
        while (true) {
            try {
                System.out.println("Введите натуральное число: ");
                Scanner scanInt = new Scanner(System.in);
                int x = scanInt.nextInt();
                if (x<0) throw new Exception("Вводите, пожалуйста, положительное число");
                System.out.println(getFactorial(x));
            } catch (InputMismatchException e) {
                System.out.println("Вводите, пожалуйста, число");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
        }
    }
}
