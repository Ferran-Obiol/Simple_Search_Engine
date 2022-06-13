package search;

import java.util.*;

public class SearchAny extends SearchStrategy {

    @Override
    public Set<Integer> findPerson(String query, List<Person> people, Map<String, List<Integer>> invertedIndex) {
        Set<Integer> totalLines = new HashSet<>();
        for (String word : query.split(" ")) {
            if (invertedIndex.containsKey(word.toLowerCase())) {
                totalLines.addAll(invertedIndex.get(word.toLowerCase()));
            }
        }
        return totalLines;
    }
}
