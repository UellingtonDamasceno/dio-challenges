package good.or.bad.sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Uellington Damasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"))) {
            Trie trie = new Trie();
            List<String> words = new LinkedList();
            for (String line = br.readLine(); !line.equals("0"); line = br.readLine()) {
                int qtdWords = Integer.parseInt(line);
                for (int i = 0; i < qtdWords; i++) {
                    String currentWord = br.readLine();
                    words.add(currentWord);
                    trie.insert(currentWord);
                }
                words.stream()
                        .filter(word -> !trie.isUnique(word))
                        .findAny().
                        ifPresentOrElse(word
                                -> System.out.println("Conjunto Ruim"),
                                () -> System.out.println("Conjunto Bom"));
                trie.clear();
                words.clear();
            }
        }
    }

    public static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = this.root;
            node.prefixCount++;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                node = node.get(character);
                node.prefixCount++;
            }
            node.isFinal = true;
        }

        public boolean isUnique(String word) {
            char character;
            Node node = this.root;
            for (int i = 0; i < word.length(); i++) {
                character = word.charAt(i);
                node = node.get(character);
            }
            return node.isFinal && node.prefixCount == 1;
        }

        private void clear() {
            this.root = new Node();
        }

        public static class Node {

            private Map<Character, Node> children;
            private boolean isFinal;
            private int prefixCount;

            public Node() {
                this.children = new HashMap();
                this.isFinal = false;
                this.prefixCount = 0;
            }

            public Node put(Character character) {
                return this.children.putIfAbsent(character, new Node());
            }

            public Node get(Character character) {
                return this.children.getOrDefault(character, this.put(character));
            }

            @Override
            public String toString() {
                return isFinal + " " + prefixCount + " " + this.children.keySet();
            }
        }
    }
}
