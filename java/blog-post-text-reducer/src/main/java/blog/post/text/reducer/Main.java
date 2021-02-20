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
import java.util.function.Supplier;
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
        List<String> wordsPhrase = new LinkedList();

        Function<List<String>, Map<String, Long>> countRecurrence = words -> words
                .stream()
                .collect(toMap(Function.identity(), word -> wordsPhrase.stream()
                .filter(currentWord -> currentWord.equals(word))
                .count()));

        for (String line = br.readLine(); !line.equals("."); line = br.readLine()) {
            wordsPhrase.addAll(Arrays.asList(line.trim().split(" ")));
            HashMap<String, List<String>> dictionary = wordsPhrase.stream()
                    .distinct()
                    .filter(word -> word.length() > 2)
                    .collect(groupingBy(
                            word -> word.substring(0, 1),
                            HashMap::new,
                            mapping(Function.identity(), toList())));

            List<Map.Entry<String, Long>> recurrenceTable = dictionary.entrySet()
                    .parallelStream()
                    .map(entry -> countRecurrence.apply(entry.getValue()))
                    .flatMap(map -> map.entrySet()
                    .stream()
                    .map(entry -> Map.entry(entry.getKey(), entry.getValue() * (entry.getKey().length() - 2))))
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toList());

            List<Map.Entry<String, Long>> orderedWords = dictionary.entrySet()
                    .stream()
                    .map(entry -> entry.getKey())
                    .map(character -> recurrenceTable.stream()
                    .filter(entry -> entry.getKey().startsWith(character))
                    .findFirst().get())
                    .sorted(Map.Entry.comparingByKey())
                    .collect(toList());

            String phrase = wordsPhrase.stream().collect(joining(" "));
            List<String> biggestWords = orderedWords.stream().map(entry -> entry.getKey()).collect(toList());
            phrase = replace(biggestWords, phrase);

            System.out.println(phrase);
            System.out.println(orderedWords.size());
            orderedWords.forEach(entry -> {
                String word = entry.getKey();
                System.out.println(word.charAt(0) + ". = " + word);
            });
            wordsPhrase.clear();
        }
    }

    private static String replace(List<String> wordsPhrase, String phrase) {
        if (wordsPhrase.isEmpty()) {
            return phrase;
        }
        String word = wordsPhrase.remove(0);
        phrase = phrase.replaceAll("\\b" + word + "\\b", word.charAt(0) + ".");
        return replace(wordsPhrase, phrase);
    }
}
