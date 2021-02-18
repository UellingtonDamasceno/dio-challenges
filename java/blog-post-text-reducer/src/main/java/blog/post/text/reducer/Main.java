package blog.post.text.reducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 *
 * @author Uellington Damasceno
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));

        String abbreviationPhrase;
        String biggestWord;

        for (String line = br.readLine(); !line.equals("."); line = br.readLine()) {
            List<String> phrase = Arrays.asList(line.trim().split(" "));
            Set<String> filteredWords = phrase.stream().collect(toSet());

            Function<String, Long> countRecurrence = word -> phrase.stream()
                    .filter(currentWord -> currentWord.equals(word))
                    .count();

            Map<String, Long> recurrenceTable = filteredWords.stream()
                    .collect(toMap(Function.identity(), countRecurrence));

            List<Entry<String, Long>> orderedWords = recurrenceTable.entrySet()
                    .stream()
                    .map((entry) -> Map.entry(entry.getKey(), entry.getKey().length() * entry.getValue()))
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toList());

            biggestWord = orderedWords.get(0).getKey();

            String abbreviation = (biggestWord.length() > 2) ? String.format("%s.", biggestWord.charAt(0)) : biggestWord;
            abbreviationPhrase = (!abbreviation.equals(biggestWord))
                    ? phrase.stream().collect(Collectors.joining(" ")).replaceAll(biggestWord, abbreviation)
                    : phrase.stream().collect(Collectors.joining(" "));

            System.out.println(abbreviationPhrase);
            System.out.println(recurrenceTable.get(biggestWord));
            System.out.println(abbreviation + " = " + biggestWord);

        }
    }

}
