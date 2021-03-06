# good-or-bad-sets

- [Desafio](#desafio)
- [Entrada](#entrada)
- [Saída](#saída)
- [Exemplos](#exemplos)
- [Solução](#solução)
  - [Árvore de prefixo](#árvore-de-préfixo)

## Desafio
Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. 
Por definição, um conjunto é bom quando nenhuma palavra desse conjunto é um 
prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.

Por exemplo, {**dbc**, **dae**, **dbcde**} é um conjunto ruim, pois `dbc` é um 
prefixo de `dbcde`. Quando duas palavras são idênticas, definimos como uma sendo 
prefixo da outra.

## Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste 
terá um inteiro N (1 ≤ N ≤ 10⁵), que representa a quantidade de palavras no
conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo 100 letras
minúsculas. A entrada termina quando N = 0 e não deve ser processada.

## Saída 
Para cada caso de teste, você deverá imprimir `"Conjunto Bom"`, ou `"Conjunto Ruim"`, 
conforme explicado acima.

## Exemplos
| Exemplo de Entrada | Exemplo de Saída |
| ------------------ | ---------------- |
| 3<br>abc<br>dae<br>abcde<br>2<br>abc<br>def<br>0 | Conjunto Ruim<br>Conjunto Bom|

## Solução

Este problema pode ser resolvido armazenando todas as palavras em uma lista e para cada
palavra da lista comparar com as demais utilizando o método `startWith`. O problema é dessa
solução é que ela é custosa.

### Árvore de préfixo
A fim de reduzir o custo da solução anterior foi implementado uma [árvore de préfixo](https://en.wikipedia.org/wiki/Trie)
que em cada nó armazena um contador de préfixo, um map de caracteres e um booleano que 
indica se o nó é o final da palavra.

Para resolver o problema utilizando a árvore de préfixo foi necessário ler todas às palavras
e inserir em uma lista e na árvore. Ao final de todas as leituras, pecorre-se a lista de palavras
a fim de encontrar algum elemento que não seja único. 
No algoritmo, uma palavra é unica se o último nó da árvore correspondente a ele for final e 
possuir um contador de prefixo com valor igual a 1.

```java
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
```
