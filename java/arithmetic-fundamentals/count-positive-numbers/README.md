# Quantidade de Números Positivos

Crie um programa que leia 6 valores. Você poderá receber valores
negativos e/ou positivos como entrada, devendo desconsiderar os
valores nulos. Em seguida, apresente a quantidade de valores
positivos digitados.

## Entrada

Você receberá seis valores, negativos e/ou positivos.

## Saída

Exiba uma mensagem dizendo quantos valores positivos foram lidos
assim como é exibido abaixo no exemplo de saída. Não esqueça da
mensagem "valores positivos" ao final.

|           Exemplo de Entrada           | Exemplo de Saída    |
| :------------------------------------: | ------------------- |
| 7</br>-5</br>6</br>-3.4</br>4.6</br>12 | 4 valores positivos |

## Solução

```java
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            long positiveNumbers = br.lines()
                    .limit(6)
                    .map(Float::parseFloat)
                    .filter(value -> value > 0)
                    .count();
            System.out.println(String.format("%d valores positivos", positiveNumbers));
        }
    }
}
```
