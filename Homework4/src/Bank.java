import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by marlock on 28.03.17.
 */
public class Bank {
    private String name;
    private LinkedList<Client> clientList = new LinkedList<>();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addClient() {
        clientList.add(new Client(clientList.size()+1));
    }

    public void addAccountToClient() {
        Client client = selectClient();
        if (client != null) client.addAccount();
    }

    public void addMoneyToAccount() {
        Client client = selectClient();
        if (client != null) client.addMoneyToAccount();
    }

    public void printClients() {
        if (clientList.isEmpty()) {
            System.out.println("Список клиентов пуст");
            return;
        }
        for (Client client : clientList) System.out.println(client);
    }

    public void printClientAccounts() {
        Client client = selectClient();
        if (client != null) client.printAccounts();
    }

    public Client selectClient() {
        if (clientList.isEmpty()) {
            System.out.println("Список клиентов пуст");
            return null;
        }
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Введите id клиента (0 для выхода): ");
            try {
                input = scan.nextInt();
                if (input == 0) return null;
                else return clientList.get(input-1);
            }
            catch (InputMismatchException e) {System.out.println(e+": Вводите число");}
            catch (IndexOutOfBoundsException outofsize) {System.out.println(outofsize+": Клиента с таким id нет");}
            catch (Exception en) {System.out.println(en);}
            finally {scan.nextLine();}
        }
    }

    @Override
    public String toString() {
        return "Банк " + name + "\n";
    }
}
