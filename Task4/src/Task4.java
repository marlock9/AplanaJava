/**
 * Created by marlock on 14.03.17.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {

    static int getSum(int x) {
        if (x < 10) return x;
        else return x%10 + getSum(x/10);
    }

    public static void main(String[] args) {
        int n;
        while (true) {
            try {
                System.out.println("Введите число: ");
                Scanner scanInt = new Scanner(System.in);
                n = scanInt.nextInt();
                if (n < 0) throw new Exception("n должно быть натуральным числом\n");
                if ((n < 100) || (n > 999)) throw new Exception("n должно быть трёхзначным числом");
            } catch (InputMismatchException e) {
                System.out.println(e+" Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            System.out.println(getSum(n));
        }
    }
}