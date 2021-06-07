package no.repeat.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import static java.util.stream.Collectors.toCollection;

/**
 *
 * @author Uellington Damasceno
 * @git https://github.com/UellingtonDamasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( java.io.BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int allLists = Integer.parseInt(br.readLine());

            br.lines()
                    .limit(allLists)
                    .map(line -> line.split(" "))
                    .map(Arrays::stream)
                    .map(items -> items.collect(toCollection(TreeSet::new)))
                    .forEach((list) -> {
                        list.forEach(item -> System.out.print(item + " "));
                        System.out.println();
                    });
        }
    }
}
