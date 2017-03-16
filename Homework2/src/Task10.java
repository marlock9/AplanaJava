/**
 * Created by marlock on 16.03.17.
 */
public class Task10 {
    static boolean isLucky(int x) {
        int sumRight = 0;
        int sumLeft = 0;

        for (int i=0; i<3; i++) {
            sumRight+=x%10;
            x/=10;
        }

        while (x != 0) {
            sumLeft+=(x%10);
            x/=10;
        }

        return sumLeft == sumRight;
    }

    static void method() {
        int count=0;
        //начинаем с 001001, потому что раньше смысла нет
        for (int i = 1001; i <= 999999; i++) if (isLucky(i)) count++;
        System.out.println(count);
    }
}
