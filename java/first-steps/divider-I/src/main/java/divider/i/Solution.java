package divider.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 * @github github/UellingtonDamasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(br.readLine());
            int gap;
            if (number <= 0) {
                return;
            }
            if (number == 1) {
                System.out.println(1);
                return;
            }
            System.out.println(1);
            if (number == 2) {
                System.out.println(2);
                return;
            }
            if (number == 3) {
                System.out.println(3);
                return;
            }
            int half = 0;

            int n = 3;
            if (number % 2 == 0) {
                n = 2;
                gap = 1;
                half = number / 8;
            } else {
                gap = 2;
            }

            Set divisors = new TreeSet();
            int i = 0;
            do {
                if (number % n == 0) {
                    divisors.add(n);
                    divisors.add(number / n);
                }
                n = n + gap;
                i++;
            } while (!divisors.contains(n) || n < half);
            System.out.println(i);
            divisors.forEach(System.out::println);

            System.out.println(number); //imprimir ele mesmo.
        }
    }

    private static void mySolution(int number, int start, int half, int gap) {
        int max = number / 3;

        Stream.iterate(start, i -> i <= max, i -> i + gap)
                .filter(current -> number % current == 0)
                .forEach(System.out::println);

        if (half != 0) {
            System.out.println(half);
        }

        System.out.println(number);
    }
}
