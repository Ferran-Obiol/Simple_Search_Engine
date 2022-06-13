import java.util.Scanner;

abstract class SocialNetwork {

    public void connect() {
        // write your code here ...
        login();
        postMessage();
        logOut();
    }

    public abstract void login();

    public abstract void postMessage();

    public abstract void logOut();
    // write your code here ...

}

class Instagram extends SocialNetwork {
    @Override
    public void login() {
        System.out.println("Log into Instagram");
    }

    @Override
    public void postMessage() {
        System.out.println("Post: Hello, Instagram!");
    }

    @Override
    public void logOut() {
        System.out.println("Log out of Instagram");
    }
    // write your code here ...
}


class Facebook extends SocialNetwork {
    // write your code here ...
    @Override
    public void login() {
        System.out.println("Log into Facebook");
    }

    @Override
    public void postMessage() {
        System.out.println("Post: Hello, Facebook!");
    }

    @Override
    public void logOut() {
        System.out.println("Log out of Facebook");
    }
    // write your code here ...
}

// Do not change the code below
class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        SocialNetwork network = null;
        if ("facebook".equalsIgnoreCase(type)) {
            network = new Facebook();
        } else if ("instagram".equalsIgnoreCase(type)) {
            network = new Instagram();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        network.connect();
    }
}