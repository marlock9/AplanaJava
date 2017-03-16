import java.util.Scanner;

/**
 * Created by marlock on 16.03.17.
 */
public class Task12 {

    static void method() {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (i/10 == j%10 && i%10 == j/10) count++;
            }
        }
        System.out.println("Итого " + count);
    }


}
