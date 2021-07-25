package banknote.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/**
 *
 * @author Uellington Damasceno
 * @github https://github.com/UellingtonDamasceno
 */
public class Solution {

    private static final List<Integer> BANKNOTE = List.of(100, 50, 20, 10, 5, 2, 1);
    private static int QTD_NOTES = 0, INSERTED_NOTES = 0;

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            INSERTED_NOTES = Integer.parseInt(br.readLine());
            System.out.println(INSERTED_NOTES);
            BANKNOTE.forEach(noteValue -> {
                QTD_NOTES = INSERTED_NOTES / noteValue;
                INSERTED_NOTES -= QTD_NOTES * noteValue;
                System.out.println(String.format("%d nota(s) de R$ %d,00", QTD_NOTES, noteValue));
            });
        }
    }
}
