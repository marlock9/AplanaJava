import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by marlock on 20.03.17.
 */
public class Task5 {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanString = new Scanner(System.in);
    private static Scanner scanInt = new Scanner(System.in);

    static void insertData(Employee employee) {

        System.out.println("Введите имя работника: ");
        employee.setName(scanString.nextLine());
        System.out.println("Введите фамилию работника: ");
        employee.setLastName(scanString.nextLine());
        System.out.println("Введите должность работника");
        employee.setPosition(scanString.nextLine());
        while (true) {
            int n;
            try {
                System.out.println("Укажите зарплату работника: ");

                n = scanInt.nextInt();
                if (n < 0) throw new Exception("Зарплата не может быть отрицательной\n");
            } catch (InputMismatchException e) {
                System.out.println(e+": Вводите число, пожалуйста");
                continue;
            } catch (Exception en) {
                System.out.println(en);
                continue;
            }
            employee.setSalary(n);
            break;
            }
        }

    static void findEmployee(String key) {
        System.out.println("Результаты поиска по должности " + key);
        for (Employee employee : employees) {
            if (employee.getPosition().equals(key)) System.out.println(employee);
        }
    }

    static void mainMenu() {
        while (true) {
            System.out.println("A - Добавить работника");
            System.out.println("L - Показать весь список");
            System.out.println("F - Поиск работников по должности");
            System.out.println("S - Сортировка по фамилии");
            System.out.println("Z - Сортировка по зарплате");
            System.out.println("Q - Quit");
            String choice;
            if (!((choice = scanString.nextLine()).isEmpty())) {
                if ("a".equalsIgnoreCase(choice)) {
                    Employee employee = new Employee();
                    insertData(employee);
                    employees.add(employee);
                }
                if ("l".equalsIgnoreCase(choice)) System.out.println(employees.toString());
                if ("f".equalsIgnoreCase(choice)) {
                    System.out.println("Введите должность: ");
                    findEmployee(scanString.nextLine());
                }
                if ("s".equalsIgnoreCase(choice)) employees.sort(Comparator.comparing(Employee::getLastName));
                if ("z".equalsIgnoreCase(choice)) employees.sort(Comparator.comparing(Employee::getSalary));
                if ("q".equalsIgnoreCase(choice)) break;
            } else System.out.println("Вы ничего не ввели, повторите попытку");
        }
    }

    static void test() {
        String[] lastNames = {"Иванов", "Петров", "Егоров", "Сидоров", "Антонов", "Богданов"};
        String[] names = {"Иван", "Петр", "Егор", "Сидор", "Антон", "Богдан"};
        String[] positions = {"Слесарь", "Сантехник", "Токарь", "Электрик", "Монтажник", "Бригадир"};
        for (int i=0; i<10; i++) {
            employees.add(new Employee(lastNames[new Random().nextInt(lastNames.length)],
                    names[new Random().nextInt(names.length)],
                    positions[new Random().nextInt(positions.length)],
                    new Random().nextInt(30000)));
        }
        System.out.println(employees.toString());

        findEmployee(positions[new Random().nextInt(positions.length)]);

        System.out.println("---------");
        System.out.println("Сортировка по фамилии");
        employees.sort(Comparator.comparing(Employee::getLastName));
        System.out.println(employees.toString());

        System.out.println("---------");
        System.out.println("Сортировка по зарплате");
        employees.sort(Comparator.comparing(Employee::getSalary));
        System.out.println(employees.toString());
    }
}

class Employee {
    String lastName;
    String name;
    String position;
    int salary;

    public Employee() {
    }

    public Employee(String lastName, String name, String position, int salary) {
        this.lastName = lastName;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nРаботник \n" +
                "Фамилия: " + lastName + '\n' +
                "Имя: " + name + '\n' +
                "Должность: " + position + '\n' +
                "Зарплата: " + salary + '\n';
    }
}
