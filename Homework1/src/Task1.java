/**
 * Created by marlock on 14.03.17.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    static void method() {
        int q;
        int w;
        while (true) {
            try {
                System.out.println("Введите два числа: ");
                Scanner scanInt = new Scanner(System.in);
                q = scanInt.nextInt();
                w = scanInt.nextInt();
                if (q < 0 || w < 0) throw new Exception("Числа должны быть натуральными\n");
            } catch (InputMismatchException e) {
                System.out.println(e+" Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception n) {
                System.out.println(n);
                continue;
            }
            System.out.println(q + "/" + w + " = " + q/w + ", остаток "+ q%w);
        }
    }
}