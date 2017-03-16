/**
 * Created by marlock on 16.03.17.
 */
public class Task0_2 {
    static void method() {
        int rand = (int)((Math.random()*900)+100);
        int biggest = 0;
        int copy = rand;
        while (copy != 0) {
            System.out.println(copy%10);
            if (copy%10 > biggest) biggest = copy%10;
            copy/=10;
        }
        System.out.println("В числе " + rand + " наибольшая цифра " + biggest);
    }
}
