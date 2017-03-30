import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marlock on 28.03.17.
 */
public class Account {
    private enum Type {
        расчётный, текущий;
    }
    private Type type;
    private double amount;
    private int id;

    public Account() {
    }

    public Account(int id) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите тип счёта: 1 для расчётного или 2 для текущего");
                int input = scanner.nextInt();
                if (input == 1) {
                    type = Type.расчётный;
                    break;
                } else if (input == 2) {
                    type = Type.текущий;
                    break;
                } else throw new Exception("Введите корректное число");
            }
            catch (InputMismatchException e) {System.out.println(e+": Вводите число");}
            catch (Exception en) {System.out.println(en);}
            finally {
                scanner.nextLine();
            }
        }
        amount = inputSum();
        this.id = id;
    }

    public Account(Type type, double amount, int id) {
        this.type = type;
        this.amount = amount;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addMoney() {
        amount+=inputSum();
    }

    public void addMoney(double sum) {
        amount+=sum;
    }

    public double reduceMoney(double amountToReduce) {
        if (amountToReduce > amount) return amount-amountToReduce;
        amount-=amountToReduce;
        return amount;
    }

    static public double inputSum() {
        Scanner scan = new Scanner(System.in);
        double input;
        while (true) {
            System.out.println("Введите сумму (0 для выхода): ");
            try {
                input = scan.nextDouble();
                if (input < 0) throw new Exception("Вводите положительное число");
                else return input;
            }
            catch (InputMismatchException e) {System.out.println(e+": Вводите число");}
            catch (Exception en) {System.out.println(en);}
            finally {
                scan.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "Счёт №" + id + "\n" +
                "Тип счёта: " + type + "\n" +
                "Денег на счету: " + amount +
                "\n-------------------\n";
    }
}
