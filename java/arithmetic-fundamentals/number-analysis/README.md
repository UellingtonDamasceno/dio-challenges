# Análise de Números

Você deve fazer a leitura de 5 valores inteiros. Em seguida
mostre quantos valores informados são pares, quantos valores
informados são ímpares, quantos valores informados são positivos
e quantos valores informados são negativos.

## Entrada

Você receberá 5 valores inteiros.

## Saída

Exiba a mensagem conforme o exemplo de saída abaixo, sendo uma
mensagem por linha e não esquecendo o final de linha após cada
uma.

|      Exemplo de Entrada       | Exemplo de Saída                                                                                      |
| :---------------------------: | ----------------------------------------------------------------------------------------------------- |
| -5</br>0</br>-3</br>-4</br>12 | 3 valor(es) par(es)</br>2 valor(es) impar(es)</br>1 valor(es) positivo(s)</br>3 valor(es) negativo(s) |

## Solução

```java
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
```
