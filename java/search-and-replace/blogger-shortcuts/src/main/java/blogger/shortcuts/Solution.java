package blogger.shortcuts;

import java.io.IOException;
import java.util.Scanner;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Uellington Damasceno
 * @github https://github.com/UellingtonDamasceno
 */
public class Solution {

    private static boolean openItalic = true, openBold = true;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String processedPhrase = scanner.nextLine()
                    .chars()
                    .mapToObj(Character::toString)
                    .map(c -> {
                        if (!c.equals("*") && !c.equals("_")) {
                            return c;
                        }
                        if (c.equals("_") && openItalic) {
                            openItalic = false;
                            return "<i>";
                        } else if (c.equals("_") && !openItalic) {
                            openItalic = true;
                            return "</i>";
                        } else if (c.equals("*") && openBold) {
                            openBold = false;
                            return "<b>";
                        } else {
                            openBold = true;
                            return "</b>";
                        }
                    })
                    .collect(joining());
            System.out.println(processedPhrase);
        }
    }
}
