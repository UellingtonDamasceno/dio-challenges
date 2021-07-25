package average.fuel.consumption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Uellington Damasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            br.lines()
                    .limit(2)
                    .map(Double::parseDouble)
                    .reduce((distance, consumption)-> distance/consumption)
                    .map(average -> String.format("%.3f km/l", average))
                    .ifPresent(System.out::println);
        }
    }
}
