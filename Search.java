import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int counter = 0;
        int[] toSearch = {0, 4, 8, 0, 6, 1, 4, 8, 0, 7};
        int[] toSearchInto = {3, 2, 9, 0, 6, 9, 2, 2, 5, 7};
        for (int i = 0; i < toSearch.length; i++) {
            for (int j = 0; j < toSearchInto.length; j++) {
                if (toSearch[i] == toSearchInto[j]) {
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter);
    }
}
