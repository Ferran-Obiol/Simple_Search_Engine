
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int border1 = scanner.nextInt();
        int border2 = scanner.nextInt();
        int numberEntries = scanner.nextInt();

        SortedMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < numberEntries; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();
            map.put(key, value);
        }
        map.subMap(border1, border2 + 1).forEach((integer, string) -> System.out.println(integer + " " + string));
    }
}