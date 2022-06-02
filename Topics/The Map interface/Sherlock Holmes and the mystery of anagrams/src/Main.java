import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        var characterIntegerMap1 = convertToLetterMap(word1);
        var characterIntegerMap2 = convertToLetterMap(word2);
        System.out.println(Objects.equals(characterIntegerMap1, characterIntegerMap2) ? "yes" : "no");
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