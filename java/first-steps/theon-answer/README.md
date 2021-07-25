# A Resposta de Theon

Ramsay: "(...) você vence se conseguir adivinhar quem eu sou e
por que estou torturando você."

Theon deve pensar rápido e adivinhar quem é seu algoz!
Entretanto, Ramsay já decidiu o que ele irá fazer depois que
Theon der sua resposta.

Theon pode dizer que seu algoz é alguma dentre N pessoas.
Considere que as pessoas são numeradas de 1 a N. Se Theon
responder que seu algoz é a pessoa i, Ramsay irá atingi-lo Ti
vezes.

Sua tarefa é ajudar Theon a determinar qual deve ser sua
resposta de forma a minimizar o número de vezes que ele será
atingido.

## Entrada

A primeira linha contém um inteiro N (1 ≤ N ≤ 100). A segunda linha contém N inteiros T1, T2, ..., TN (0 ≤ Ti ≤ 20).

## Saída

Imprima uma linha contendo o número da pessoa que Theon deve dizer ser seu algoz. Se existe mais de uma resposta possível, imprima a menor.

| Exemplo de Entrada | Exemplo de Saída |
| ------------------ | :--------------: |
| 3</br>8 0 7        |        2         |
| 2</br> 1 1         |        1         |

## Solução

```java
public class Solution {

  public static void main(String[] args) throws IOException {
    try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
      int limit = Integer.parseInt(br.readLine());
      String[] n = br.readLine().split(" ");

      Integer value = Stream.iterate(0, i -> i < limit, i -> i + 1)
              .map(i -> Map.entry(i + 1, Integer.parseInt(n[i])))
              .sorted(Entry.comparingByValue())
              .collect(toList())
              .get(0)
              .getKey();

      System.out.println(value);
    }
  }
}
```
