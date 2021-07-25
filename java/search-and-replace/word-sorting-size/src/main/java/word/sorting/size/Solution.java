package word.sorting.size;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 * @github https://github.com/UellingtonDamasceno
 */
public class Solution {

    private static final Consumer<Stream<String>> printWords = words -> {
        words.forEach(word -> System.out.print(word + " "));
        System.out.println();
    };

    private static final Comparator<String> comparator = (word, word0) -> {
        int sizeResult = word0.length() - word.length();
        return sizeResult == 0 ? word.compareTo(word0) : sizeResult;
    };

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(br.readLine());
            br.lines()
                    .limit(numTests)
                    .map(line -> line.split(" "))
                    .map(Arrays::stream)
                    .map(words -> words.sorted(comparator))
                    .forEach(printWords);
        }
    }
}
