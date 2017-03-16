/**
 * Created by marlock on 16.03.17.
 */
public class Task8 {
    static void method() {
        int a=1;
        int b=1;
        System.out.println(a);
        System.out.println(b);
        int fib;
        for (int i = 1; i<10; i++) {
            fib = a+b;
            a = b;
            b = fib;
            System.out.println(fib);
        }
    }
}
