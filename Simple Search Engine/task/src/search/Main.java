package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if (args[0] != "--data") {
            System.exit(-1);
        }

        String path = args[1];

        List<Person> people = new ArrayList<>();

        readPeopleFromFile(path, people);

        int option = -1;
        Scanner scanner = new Scanner(System.in);
        while (option != 0) {
            printMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    String needle = scanner.nextLine();
                    findPerson(needle, people);
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

    private static void readPeopleFromFile(String path, List<Person> people) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(" ");
                Person person;
                if (data.length == 3) {
                    person = new Person(data[0], data[1], data[2]);
                }
                else if (data.length == 2){
                    person = new Person();
                    person.setFirstName(data[0]);
                    person.setLastName(data[1]);
                }else {
                    person = new Person();
                    person.setFirstName(data[0]);
                }
                people.add(person);
            }
        }
    }

    private static void printAll(List<Person> people) {
     //   System.out.println("=== List of people ===");
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

    private static void findPerson(String needle, List<Person> people) {
        boolean found = false;
        for (Person person : people) {
            if (person.isPerson(needle)) {
                System.out.println(person);
            }
        }
        if (!found) {
            System.out.println("No matching people found.");
        }
    }
}

