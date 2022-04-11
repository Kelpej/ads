import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Zoo {
    private static final Animal[] animals = {new Monkey("Еммі", 4, 35),
                                            new Monkey("Марічка", 5, 20),
                                            new Elephant("Орест", 10, 70)};
    private static final Security security = new Security("Пан Василь", 45, "Охоронець");
    private static final Supervisor supervisor = new Supervisor("Пан Олександр", 27, "Наглядач");

    private static void night() {
        System.out.println("Надворі ніч, всі звірі позасинали.");
        Arrays.stream(animals).forEach(animal -> animal.setSleeping(true));
        Arrays.stream(animals).forEach(System.out::println);
    }

    private static void morning() {
        System.out.println("Блискучий місяць змінило сонячне сяйво." +
                        "\nНіч пройла без ексцесів та проблем." +
                        "\nВсі прокидаються, " + security.getName() + " готується до здачі своєї зміни.");

        Arrays.stream(animals).forEach(animal -> animal.setSleeping(false));
        Arrays.stream(animals).forEach(animal -> animal.wakeUp());
    }

    private static void afternoon() {

    }
    public static void main(String[] args) {
        night();
        security.startWork();
        System.out.println("До зоопарку прийшов наглядач за тваринами " + supervisor.getName() + '.');
        supervisor.greetPerson(security);
        security.greetBack();
        supervisor.startWork();
        System.out.println("Доки персонал зоопарку виконував свої рутинні обовʼязки, звірята не витрачали денний час марно.");

        ArrayList<Monkey> monkeys = (ArrayList<Monkey>) Arrays.stream(animals).filter(animal -> animal instanceof Monkey)
                .map(animal -> (Monkey) animal)
                .collect(Collectors.toList());

        for (int i = 0; i < monkeys.size() / 2; i++)
            monkeys.get(i).play(monkeys.get(i + 1));

        ArrayList<Elephant> elephants = (ArrayList<Elephant>) Arrays.stream(animals)
                .filter(animal -> animal instanceof Elephant)
                .map(animal -> (Elephant) animal)
                .collect(Collectors.toList());

        elephants.stream().forEach(elephant -> elephant.play("мʼячиком"));

        System.out.println("Але за розкладом саме настав час тваринам їсти.");
        Arrays.stream(animals).forEach(animal -> supervisor.feed(animal));

        supervisor.makeGuidedTour();
        Arrays.stream(animals).forEach(animal -> animal.idle());

        supervisor.endWork();
        System.out.println("Нічне небо застелило собою весь зоопарк, відвідувачі покинули територію, всі звірі позасинали.");

        Arrays.stream(animals).forEach(animal -> animal.setSleeping(true));
        security.startWork();
    }
}