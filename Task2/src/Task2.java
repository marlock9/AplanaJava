/**
 * Created by marlock on 14.03.17.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int n;
        while (true) {
            try {
                System.out.println("Введите число: ");
                Scanner scanInt = new Scanner(System.in);
                n = scanInt.nextInt();
                if (n < 0) throw new Exception("n должно быть натуральным числом\n");
                if ((n < 10) || (n > 99)) throw new Exception("n должно быть двузначным числом");
            } catch (InputMismatchException e) {
                System.out.println(e+" Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            int sum = 0;
            while (n != 0) {
                sum+=(n%10);
                n/=10;
            }
            System.out.println(sum);
        }
    }
}