/**
 * Created by marlock on 16.03.17.
 */
public class Task13 {
    static boolean isBad(int x) {
        while (x != 0) {
            if (x%10 == 4 || x%100 == 13) return true;
            x/=10;
        }
        return false;
    }

    static void method() {
        int count = 0;
        for (int i=4; i<99995; i++) {
            if (isBad(i)) count++;
        }
        System.out.println(count);
    }
}
