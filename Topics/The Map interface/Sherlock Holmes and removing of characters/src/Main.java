import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        var map1 = convertToLetterMap(word1);
        var map2 = convertToLetterMap(word2);

        int i = adaptWords(map1, map2);
        int i1 = adaptWords(map2, map1);
        System.out.println(i + i1);
    }

    private static int adaptWords(Map<String, Integer> map1, Map<String, Integer> map2) {
        int counter = 0;
        for (String string : map1.keySet()) {
            if (!map2.containsKey(string)) {
                counter += map1.get(string);
                map1.put(string, 0);
            } else {
                counter += Math.abs(map1.get(string) - map2.get(string));
                map1.put(string, Math.min(map1.get(string), map2.get(string)));
                map2.put(string, Math.min(map1.get(string), map2.get(string)));
            }
        }
        return counter;
    }

    private static Map<String, Integer> convertToLetterMap(String word) {
        Map<String, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String key = Character.toString(word.charAt(i)).toLowerCase();
            letterMap.put(key, letterMap.getOrDefault(key, 0) + 1);
        }
        return letterMap;
    }
}