import java.util.Random;

/**
 * Created by marlock on 20.03.17.
 */
public class Task4 {
    static void method() {
        //в российских номерных знаках используются буквы А, В, Е, К, М, Н, О, Р, С, Т, У, Х
        final char[] allowedLetters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        System.out.print(allowedLetters[new Random().nextInt(allowedLetters.length)]);
        System.out.print(" " + String.format("%03d", new Random().nextInt(999)) + " ");
        System.out.print(allowedLetters[new Random().nextInt(allowedLetters.length)]);
        System.out.print(allowedLetters[new Random().nextInt(allowedLetters.length)]);
        /*трёхзначные коды регионов не поддаются никакой логике, значения дико разбросаны, массив c отдельно стоящими номерами получился бы огромным
        надеюсь, так сойдёт? :)
        */
        System.out.println(String.format(" " + "%02d", new Random().nextInt(199)));
    }
}
