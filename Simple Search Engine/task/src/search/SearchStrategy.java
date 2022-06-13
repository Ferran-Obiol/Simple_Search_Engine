package search;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class SearchStrategy {

    public abstract Set<Integer> findPerson(String needle, List<Person> people, Map<String, List<Integer>> invertedIndex);
}
