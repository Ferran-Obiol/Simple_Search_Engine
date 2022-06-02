import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 1) {
                result.add(s[i]);
            }
        }
        Collections.reverse(result);
        result.forEach(x -> System.out.print(x + " "));
    }
}