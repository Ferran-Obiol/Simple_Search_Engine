import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        for (;;) {
            String line = scanner.nextLine();
            try {
                value = Integer.parseInt(String.valueOf(line));
                if (value == 0) {
                    break;
                }
                System.out.println(value * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + line);
            }
        }
    }
}