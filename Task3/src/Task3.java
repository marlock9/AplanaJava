/**
 * Created by marlock on 14.03.17.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        double n;
        while (true) {
            try {
                System.out.println("Введите число: ");
                Scanner scanDouble = new Scanner(System.in);
                n = scanDouble.nextDouble();
                if (n%1.0 == 0) throw new Exception("Дробная часть должна быть ненулевой\n");
            } catch (InputMismatchException e) {
                System.out.println(e+" Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            if (Math.abs(n%1.0) < 0.5) System.out.println((int) n);
            else {
                if (n>0) System.out.println(((int) n) +1);
                else System.out.println(((int) n)-1);
            }
        }
    }
}