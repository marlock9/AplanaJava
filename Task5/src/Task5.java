import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 14.03.17.
 */
public class Task5 {
    public static void main(String[] args) {
        int weight;
        while (true) {
            try {
                System.out.println("Введите ваш вес на Земле: ");
                Scanner scanInt = new Scanner(System.in);
                weight = scanInt.nextInt();
                if (weight < 0) throw new Exception("Вес не должен быть отрицательным\n");
            } catch (InputMismatchException e) {
                System.out.println("Вводите, пожалуйста, число. \n");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            System.out.println("Ваш вес на Венере ~ " + weight*0.9);
        }
    }
}
