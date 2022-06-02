import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int distance = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        List<Integer> collect = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
        Integer toLook = scanner.nextInt();

        for (Integer integer : collect) {
            int localDistance = Math.abs(integer - toLook);
            distance = Math.min(localDistance, distance);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : collect) {
            int localDistance = Math.abs(integer - toLook);
            if (localDistance == distance) {
                result.add(integer);
            }
        }

        Collections.sort(result);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }
}