import java.util.Random;

/**
 * Created by marlock on 16.03.17.
 */
public class Task0_1 {
    static void method() {
        int rand = (int)((Math.random()*151)+5);
        if (rand>25 && rand<100) System.out.println("Число "+rand+" содержится в интервале (25,100)");
        else System.out.println("Число "+rand+" не содержится в интервале (25,100)");
    }
}
