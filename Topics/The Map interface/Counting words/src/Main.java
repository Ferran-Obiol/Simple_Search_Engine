import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        for (String string :strings) {
            if (sortedMap.containsKey(string)) {
                sortedMap.put(string, sortedMap.get(string) + 1);
            } else {
                sortedMap.put(string, 1);
            }
        }
        return sortedMap;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}