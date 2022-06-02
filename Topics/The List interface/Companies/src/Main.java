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
        Collections.addAll(result, s);
        System.out.println(result);
    }
}