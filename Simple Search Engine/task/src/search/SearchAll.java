package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchAll extends SearchStrategy {

    @Override
    public Set<Integer> findPerson(String query, List<Person> people, Map<String, List<Integer>> invertedIndex) {
        Set<Integer> totalLines = IntStream.rangeClosed(0, people.size() - 1).boxed().collect(Collectors.toSet());
        for (String word : query.split(" ")) {
            List<Integer> localLines = new ArrayList<>();
            if (invertedIndex.containsKey(word.toLowerCase())) {
                localLines.addAll(invertedIndex.get(word.toLowerCase()));
            }
            totalLines.retainAll(localLines);
            if (totalLines.isEmpty()) {
                break;
            }
        }
        return totalLines;
    }
}
