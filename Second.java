/**
 * Created by marlock on 14.03.17.
 */
public class Second {
    public static void main(String[] args) {
        //ещё можно рекурсией
        int n = 11;
        int sum = 0;
        while (n != 0) {
            sum+=(n%10);
            n/=10;
        }
        System.out.println(sum);
    }
}
