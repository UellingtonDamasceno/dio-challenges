package only.even;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNumber = scanner.nextInt() / 2;
        Stream.iterate(2, (currentNumber) -> currentNumber + 2)
                .limit(maxNumber)
                .forEach(System.out::println);
    }
}
