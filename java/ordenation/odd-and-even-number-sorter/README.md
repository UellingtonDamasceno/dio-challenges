# Desafio
Crie um programa onde você receberá valores inteiros não negativos como entrada.

Ordene estes valores de acordo com o seguinte critério:
  - Primeiro os Pares
  - Depois os Ímpares

Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.

# Entrada

A primeira linha de entrada contém um único inteiro positivo `N (1 < N < 10000)` 
Este é o número de linhas de entrada que vem logo a seguir.
As próximas `N` linhas terão, cada uma delas, um valor inteiro não negativo.

# Saída

Exiba todos os valores lidos na entrada segundo a ordem apresentada acima. 
Cada número deve ser impresso em uma linha, conforme exemplo de saída abaixo.

| Exemplo de Entrada | Exemplo de saída |
| :----------------: | :--------------: |
| 10<br>4<br>32<br>34<br>543<br>3456<br>654<br>567<br>87<br>6789<br>98 | 4<br>32<br>34<br>98<br>654<br>3456<br>6789<br>567<br>543<br>87 |

# Solução

```java
public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
        int lineNumbers = Integer.parseInt(br.readLine());

        Map<Boolean, List<Integer>> numbers = br.lines()
                .limit(lineNumbers)
                .map(Integer::parseInt)
                .collect(partitioningBy(number -> number % 2 == 0));

        List<Integer> pairNumbers = numbers.get(true);
        List<Integer> oddNumbers = numbers.get(false);

        pairNumbers.stream()
        .sorted()
        .forEach(System.out::println);
        
        oddNumbers.stream()
        .sorted(reverseOrder())
        .forEach(System.out::println);
    }
}
```
