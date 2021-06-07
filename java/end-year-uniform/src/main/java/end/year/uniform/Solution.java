package end.year.uniform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 *
 * @author Uellington Damasceno
 * @git https://github.com/UellingtonDamasceno
 */
public class Solution {

    private static final Function<BufferedReader, String> readLineWrap = (br) -> {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static void main(String... args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            int numInfo = Integer.parseInt(br.readLine());
            br.lines()
                    .limit(numInfo)
                    .map(owner -> new Uniform(owner, readLineWrap.apply(br)))
                    .sorted()
                    .forEach(System.out::println);
        }
    }

    public static class Uniform implements Comparable<Uniform> {

        protected String owner;
        protected String color;
        protected String size;

        public Uniform(String owner, String details) {
            this.owner = owner;
            String[] splitedDetails = details.split(" ");
            this.color = splitedDetails[0];
            this.size = splitedDetails[1];
        }

        @Override
        public int compareTo(Uniform another) {
            int integer = this.color.compareTo(another.color);
            if (integer == 0) {
                integer = another.size.compareTo(this.size);
                return (integer == 0)
                        ? this.owner.compareTo(another.owner)
                        : integer;
            }
            return integer;
        }

        @Override
        public String toString() {
            return color + " " + size + " " + owner;
        }
    }
}
