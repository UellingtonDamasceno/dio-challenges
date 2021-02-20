package blog.post.text.reducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Uellington Damasceno
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        final List<String> wordsPhrase = new LinkedList();
        final List<String> biggestWords = new ArrayList(26);

        Function<Map.Entry<String, List<String>>, Map<String, Long>> countRecurrence = entry -> entry
                .getValue()
                .stream()
                .collect(toMap(Function.identity(), word -> wordsPhrase.stream()
                .filter(currentWord -> currentWord.equals(word))
                .count()));

        for (String line = br.readLine(); !line.equals("."); line = br.readLine()) {
            wordsPhrase.addAll(Arrays.asList(line.split(" ")));

            Map<String, List<String>> dictionary = wordsPhrase.stream()
                    .distinct()
                    .filter(word -> word.length() > 2)
                    .collect(groupingBy(
                            word -> word.substring(0, 1),
                            HashMap::new,
                            mapping(Function.identity(), toList())));

            List<String> recurrenceTable = dictionary.entrySet()
                    .parallelStream()
                    .map(countRecurrence)
                    .flatMap(map -> map.entrySet()
                    .stream()
                    .map(entry -> Map.entry(entry.getKey(), entry.getValue() * (entry.getKey().length() - 2))))
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .map(Entry::getKey)
                    .collect(toList());

            dictionary.entrySet()
                    .stream()
                    .map(Entry::getKey)
                    .map(character -> recurrenceTable.stream()
                    .filter(word -> word.startsWith(character))
                    .findFirst().get())
                    .sorted()
                    .collect(() -> biggestWords, List::add, List::addAll);

            String phrase = wordsPhrase.stream().collect(joining(" "));

            System.out.println(replace(biggestWords, phrase, 0));
            System.out.println(biggestWords.size());
            biggestWords.forEach(word -> {
                System.out.println(word.charAt(0) + ". = " + word);
            });
            biggestWords.clear();
            wordsPhrase.clear();
        }
    }

    private static String replace(List<String> wordsPhrase, String phrase, int index) {
        if (wordsPhrase.size() == index) {
            return phrase;
        }
        String word = wordsPhrase.get(index);
        phrase = phrase.replaceAll("\\b" + word + "\\b", word.charAt(0) + ".");
        return replace(wordsPhrase, phrase, ++index);
    }
}
