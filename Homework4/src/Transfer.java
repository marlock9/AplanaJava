import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 30.03.17.
 */
public class Transfer {
    private Bank bankFrom, bankTo;
    private Client clientFrom, clientTo;
    private Account accountFrom, accountTo;
    private double commission = 1.0;
    private double fullSum;
    private boolean completed = false;

    public Transfer() {
        try {
            System.out.println("Выберите счёт, с которого нужно совершить перевод");
            bankFrom = Main.selectBank();
            clientFrom = bankFrom.selectClient();
            accountFrom = clientFrom.selectAccount();
            accountFrom.getType(); //чтобы словить NPE и выйти в главное меню
            System.out.println("Выберите счёт, на который нужно совершить перевод");
            bankTo = Main.selectBank();
            clientTo = bankTo.selectClient();
            accountTo = clientTo.selectAccount();
            accountTo.getType();
        }
        catch (NullPointerException e) {return;}
        if (accountFrom.getType() != accountTo.getType()) commission*=1.01;
        if (bankFrom != bankTo) commission*=1.05;
        fullSum = Account.inputSum()*commission;
        if (fullSum == 0) return;

        System.out.println("Будет проведён перевод");
        System.out.println(toString());

        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Для подтверждения нажмите 1, для отмены 0");
            try {
                input = scan.nextInt();
                if (input == 0) {
                    System.out.println("Отмена");
                    return;
                }
                else if (input == 1) break;
                else throw new Exception("Выберите один из двух вариантов");
            }
            catch (InputMismatchException e) {System.out.println(e+": Вводите число");}
            catch (Exception en) {System.out.println(en);}
            finally {scan.nextLine();}
        }
        double allowed = accountFrom.reduceMoney(fullSum);
        if (allowed < 0) {
            System.out.println("На счёту недостаточно средств, после перевода осталось бы: " + allowed);
            return;
        }
        else accountTo.addMoney(fullSum/commission);
        System.out.println("Успешно, остаток на счету "+accountFrom.getAmount());
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Перевод" + "\n" +
                "Откуда: \n" +
                bankFrom +
                clientFrom +
                accountFrom +
                "Куда: \n" +
                bankTo +
                clientTo +
                accountTo +
                "Комиссия: " +
                String.format("%.2f",(commission%1)*100) + "\n" +
                "Полная сумма: " +
                fullSum + "\n";
    }
}
