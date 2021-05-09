package embarrassing.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/*

Desafio

A nutricionista Juliana Alcantra é uma excelente profissional de sua área. 
Em determinado dia, ela foi entrevistada ao vivo para um jornal da cidade. 
No entanto, ficou um pouco nervosa na hora, e diante da situação, 
sua fala ficou um pouco distorcida, repetindo o final de cada palavra após dizer a mesma.
Para que isso não aconteça novamente, ela precisa da sua ajuda para escrever 
um programa que omita a parte repetida, de modo que as palavras sejam pronunciadas como deveriam ser.

Escreva um programa que, dada uma palavra errada, a mesma seja corrigida.
Entrada

Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra, de,
no máximo, 30 caracteres, dita da forma errada. A entrada termina com fim de arquivo.
Saída

Para cada caso de teste, escreva a palavra devidamente corrigida. 
Analise os exemplos para verificar o padrão, de modo a consertar todos os casos.

 */
/**
 *
 * @author Uellington Damasceno
 */
public class Solution {

    private static final Consumer<String> processWord = (word) -> {
        int length = word.length() - 1;
        String prefix, suffix;
        boolean hasRepetition = false;
        for (int i = 0; i <= length; i++) {
            prefix = word.substring(0, i);
            suffix = word.substring(i);
            if(prefix.endsWith(suffix)){
                System.out.println(prefix);
                hasRepetition = true;
            }
        }
        if(!hasRepetition){
            System.out.println(word);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().forEach(processWord);
    }

}
