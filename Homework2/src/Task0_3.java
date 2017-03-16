/**
 * Created by marlock on 16.03.17.
 */
public class Task0_3 {
    static void method() {
        int rand = (int)(Math.random()*28801);
        System.out.println(rand);
        int remain = rand/60/60;
        if (remain > 4) System.out.println("Осталось " + remain + " часов");
        else if (remain > 1 && remain <= 5) System.out.println("Осталось " + remain + " часа");
        else if (remain == 1) System.out.println("Остался " + remain + " час");
        else System.out.println("Осталось менее часа");
    }
}
