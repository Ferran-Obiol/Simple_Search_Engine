import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numberRecords = scanner.nextInt();

        HashSet<String> dictionary = new HashSet<>();
        for (int i = 0; i <= numberRecords; i++) {
            dictionary.add(scanner.nextLine().toLowerCase());
        }

        int numberLines = scanner.nextInt();
        HashSet<String> lines = new HashSet<>();
        for (int i = 0; i <= numberLines; i++) {
            Collections.addAll(lines, scanner.nextLine().split(" "));
        }

        lines.removeIf(x -> dictionary.contains(x.toLowerCase()));
        lines.forEach(System.out::println);

    }

}