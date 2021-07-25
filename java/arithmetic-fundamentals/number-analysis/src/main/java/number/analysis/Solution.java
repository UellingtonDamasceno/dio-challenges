package number.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Uellington Damasceno
 * @github https://github.com/UellingtonDamasceno
 */
public class Solution {

    private static int ZEROS = 0, EVEN = 0, POSITIVE = 0, LIMIT = 5;

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            br.lines()
                    .limit(LIMIT)
                    .mapToInt(Integer::parseInt)
                    .forEach(number -> {
                        ZEROS = number == 0 ? ++ZEROS : ZEROS;
                        POSITIVE = number > 0 ? ++POSITIVE : POSITIVE;
                        EVEN = number % 2 == 0 ? ++EVEN : EVEN;
                    });
            System.out.println(EVEN + " valor(es) par(es)");
            System.out.println(LIMIT - EVEN + " valor(es) impar(es)");
            System.out.println(POSITIVE + " valor(es) positivo(s)");
            System.out.println((LIMIT - ZEROS) - POSITIVE + " valor(es) negativo(s)");
        }
    }
}
