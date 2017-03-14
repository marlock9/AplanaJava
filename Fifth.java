import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 14.03.17.
 */
public class Fifth {
    public static void main(String[] args) {
        int weight = 0;
        while (true) {
            try {
                System.out.println("Введите ваш вес на Земле: ");
                Scanner scanInt = new Scanner(System.in);
                weight = scanInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Вводите, пожалуйста, число. \n");
                continue;
            }
            System.out.println("Ваш вес на Венере ~ " + weight*0.9);
        }
    }
}
