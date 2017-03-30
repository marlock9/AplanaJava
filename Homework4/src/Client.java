import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by marlock on 28.03.17.
 */
public class Client {
    private String name;
    private String lastName;
    private int id;
    private LinkedList<Account> clientAccounts = new LinkedList<>();

    public Client(int id) {
        Scanner scanString = new Scanner(System.in);
        System.out.println("Введите имя клиента: ");
        name = scanString.nextLine();
        System.out.println("Введите фамилию клиента: ");
        lastName = scanString.nextLine();
        this.id = id;
    }

    public Client(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Account> getClientAccounts() {
        return clientAccounts;
    }

    public void addAccount() {
        clientAccounts.add(new Account(clientAccounts.size()+1));
    }

    public void printAccounts() {
        for (Account account : clientAccounts) System.out.println(account);
    }

    public void addMoneyToAccount() {
        Account account = selectAccount();
        if (account != null) account.addMoney();
    }

    public Account selectAccount() {
        if (clientAccounts.isEmpty()) {
            System.out.println("У клиента нет счетов");
            return null;
        }
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Введите № счёта (0 для выхода): ");
            try {
                input = scan.nextInt();
                if (input == 0) return null;
                else return clientAccounts.get(input-1);
            }
            catch (InputMismatchException e) {System.out.println(e+": Вводите число");}
            catch (IndexOutOfBoundsException outofsize) {System.out.println(outofsize+": Счёта с таким номером нет");}
            catch (Exception en) {System.out.println(en);}
            finally {scan.nextLine();}
        }
    }

    @Override
    public String toString() {
        return "Клиент №" + id + "\n" +
                lastName + " " + name + "\n" +
                "Cчетов открыто: " + clientAccounts.size() +
                "\n-------------------\n";
    }
}
