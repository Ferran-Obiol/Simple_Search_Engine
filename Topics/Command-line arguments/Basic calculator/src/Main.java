
class Problem {
    public static void main(String[] args) {

        int int1 = Integer.parseInt(args[1]);
        int int2 = Integer.parseInt(args[2]);
        switch (args[0]) {
            case "+":
                System.out.println(int1 + int2);
                break;
            case "-":
                System.out.println(int1 - int2);
                break;
            case "*":
                System.out.println(int1 * int2);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}