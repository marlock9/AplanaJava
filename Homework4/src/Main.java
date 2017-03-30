import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by marlock on 28.03.17.
 */
public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Bank roga = new Bank("ООО Рога и Копыта");
    private static Bank sun = new Bank("ООО Солнышко");
    private static LinkedList<Transfer> transfers = new LinkedList<>();

    private static void mainMenu() {
        do {
            System.out.println("1 - Добавить клиента");
            System.out.println("2 - Добавить счёт клиенту");
            System.out.println("3 - Просмотреть всех клиентов");
            System.out.println("4 - Показать все счета клиента");
            System.out.println("5 - Пополнить счёт клиента");
            System.out.println("6 - Перевести деньги со счёта на счёт");
            System.out.println("7 - Вывод всех операций клиента в файл");
            System.out.println("8 - Выход");
            String choice;
            if (!((choice = scan.nextLine()).isEmpty())) {
                if ("1".equalsIgnoreCase(choice)) addClientMenu();
                if ("2".equalsIgnoreCase(choice)) addAccountToClientMenu();
                if ("3".equalsIgnoreCase(choice)) printClientsMenu();
                if ("4".equalsIgnoreCase(choice)) printClientAccountsMenu();
                if ("5".equalsIgnoreCase(choice)) addMoneyToAccountMenu();
                if ("6".equalsIgnoreCase(choice)) transferMenu();
                if ("7".equalsIgnoreCase(choice)) printToFileMenu();
                if ("8".equalsIgnoreCase(choice)) break;
            } else System.out.println("You entered nothing, try again");
        } while (true);
    }

    private static void printToFileMenu() {
        try (PrintStream out = new PrintStream(new FileOutputStream("transfers.txt"))) {
            for (Transfer transfer : transfers) out.print(transfer);
        } catch (IOException ioe) {
            System.out.println("Не смог записать:  " + ioe.getMessage());
        }
    }

    private static void transferMenu() {
        Transfer temp = new Transfer();
        if (temp.isCompleted()) transfers.add(temp);
        else temp = null;
    }

    private static void addMoneyToAccountMenu() {
        Bank bank = selectBank();
        if (bank != null) bank.addMoneyToAccount();
    }

    private static void printClientAccountsMenu() {
        Bank bank = selectBank();
        if (bank != null) bank.printClientAccounts();
    }

    private static void printClientsMenu() {
        Bank bank = selectBank();
        if (bank != null) bank.printClients();
    }

    private static void addAccountToClientMenu() {
        Bank bank = selectBank();
        if (bank != null) bank.addAccountToClient();
    }

    private static void addClientMenu() {
        Bank bank = selectBank();
        if (bank != null) bank.addClient();
    }

    public static Bank selectBank() {
        int input;
        while (true) {
            System.out.println("Выберите банк\n" +
                    "1 - " + roga.getName() + "\n" +
                    "2 - " + sun.getName() + "\n" +
                    "0 - Вернуться в главное меню");
            try {
                input = scan.nextInt();
                if (input == 1) return roga;
                else if (input == 2) return sun;
                else if (input == 0) return null;
                else throw new Exception("Введите корректное число");
            }
            catch (InputMismatchException e) {System.out.println(e + ": Вводите число");}
            catch (Exception en) {System.out.println(en);}
            finally {scan.nextLine();}
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
