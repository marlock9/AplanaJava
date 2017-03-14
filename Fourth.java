/**
 * Created by marlock on 14.03.17.
 */
public class Fourth {
    //теперь через рекурсию
    static int getSum(int x) {
        if (x < 10) return x;
        else return x%10 + getSum(x/10);
    }

    public static void main(String[] args) {
        int n = 576;
        System.out.println(getSum(n));
    }
}
