import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int acum = 0;
        for (int i = a; i <= b ; i++) {
            acum += i;
        }
        System.out.println(acum);
    }
}