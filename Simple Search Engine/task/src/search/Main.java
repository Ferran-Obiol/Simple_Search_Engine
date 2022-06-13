package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if (!args[0].equals("--data")) {
            System.exit(-1);
        }

        String path = args[1];

        List<Person> people = new ArrayList<>();
        Map<String, List<Integer>> invertedIndex = new HashMap<>();

        readPeopleFromFile(path, invertedIndex, people);

        int option = -1;
        Scanner scanner = new Scanner(System.in);
        while (option != 0) {
            printMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner.nextLine();
                    SearchStrategy strategyClass = selectStrategy(strategy);
                    System.out.println("Enter a name or email to search all suitable people.");
                    String needle = scanner.nextLine();
                    Set<Integer> persons = strategyClass.findPerson(needle, people, invertedIndex);
                    printPersonsFound(people, persons);
                    break;
                case 2:
                    printAll(people);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Bye!");
    }

    private static void printPersonsFound(List<Person> people, Set<Integer> persons) {
        if (persons.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(persons.size() + " persons found:");
            Stream<Person> personStream = persons.stream()
                    .map(people::get);
            personStream.forEach(System.out::println);
        }
    }

    private static SearchStrategy selectStrategy(String strategy) {
        if ("ANY".equals(strategy)) {
            return new SearchAny();
        } else if ("ALL".equals(strategy)) {
            return new SearchAll();
        } else { // if ("NONE".equals(strategy))
            return new SearchNone();
        }
    }


    private static void readPeopleFromFile(String path, Map<String, List<Integer>> invertedIndex, List<Person> people) throws FileNotFoundException {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        try (Scanner scanner = new Scanner(new File(path))) {
            int lineCount = 0;
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(" ");
                feedInvertedIndex(invertedIndex, lineCount, data);
                addPersonToList(people, data);
                lineCount++;
            }
        }
    }

    private static void feedInvertedIndex(Map<String, List<Integer>> invertedIndex, int lineCount, String[] data) {
        for (String string : data) {
            List<Integer> entries = invertedIndex.getOrDefault(string.toLowerCase(), new ArrayList<>());
            entries.add(lineCount);
            invertedIndex.put(string.toLowerCase(), entries);
        }
    }

    private static void addPersonToList(List<Person> people, String[] data) {
        Person person;
        if (data.length == 3) {
            person = new Person(data[0], data[1], data[2]);
        } else if (data.length == 2) {
            person = new Person();
            person.setFirstName(data[0]);
            person.setLastName(data[1]);
        } else {
            person = new Person();
            person.setFirstName(data[0]);
        }
        people.add(person);
    }

    private static void printAll(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void printMenu() {
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit\n");
    }

}

