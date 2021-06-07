package old.and.even.number.sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.Comparator.reverseOrder;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.partitioningBy;

/**
 *
 * @author Uellington Damasceno
 * @git https://github.com/UellingtonDamasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            int lineNumbers = Integer.parseInt(br.readLine());

            Map<Boolean, List<Integer>> numbers = br.lines()
                    .limit(lineNumbers)
                    .map(Integer::parseInt)
                    .collect(partitioningBy(number -> number % 2 == 0));

            List<Integer> pairNumbers = numbers.get(true);
            List<Integer> oddNumbers = numbers.get(false);

            pairNumbers.stream().sorted().forEach(System.out::println);
            oddNumbers.stream().sorted(reverseOrder()).forEach(System.out::println);
        }
    }
}
