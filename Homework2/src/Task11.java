/**
 * Created by marlock on 16.03.17.
 */
public class Task11 {
    static boolean isDefective(int x) {
        while (x != 0) {
            if (x%10 == 2) return true;
            x/=10;
        }
        return false;
    }

    static void method() {
        int count = 0;
        //49992 -- последняя табличка с 2
        for (int i=2; i<49993; i++) {
            if (isDefective(i)) count++;
        }
        System.out.println(count);
    }
}
