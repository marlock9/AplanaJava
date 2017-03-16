/**
 * Created by marlock on 16.03.17.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task9 {
    static void method() {
        int n;
        while (true) {
            try {
                System.out.println("Введите натуральное число: ");
                Scanner scanInt = new Scanner(System.in);
                n = scanInt.nextInt();
                if (n < 0) throw new Exception("n должно быть натуральным числом\n");
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