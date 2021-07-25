package theon.answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            int limit = Integer.parseInt(br.readLine());
            String[] n = br.readLine().split(" ");
            
            Integer value = Stream.iterate(0, i -> i < limit, i -> i + 1)
                    .map(i -> Map.entry(i + 1, Integer.parseInt(n[i])))
                    .sorted(Entry.comparingByValue())
                    .collect(toList())
                    .get(0)
                    .getKey();

            System.out.println(value);
        }
    }
}
