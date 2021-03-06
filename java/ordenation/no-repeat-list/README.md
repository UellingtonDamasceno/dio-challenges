# Desafio

Pedro trabalha sempre até tarde todos os dias, 
com isso tem pouco tempo tempo para as tarefas domésticas.
Para economizar tempo ele faz a lista de compras do supermercado em um aplicativo
e costuma anotar cada item na mesma hora que percebe a falta dele em casa.

O problema é que o aplicativo não exclui itens duplicados, 
como Pedro anota o mesmo item mais de uma vez e a lista acaba ficando extensa. 
Sua tarefa é melhorar o aplicativo de notas desenvolvendo um código que exclua
os itens duplicados da lista de compras e que os ordene alfabeticamente.

# Entrada

A primeira linha de entrada contém um inteiro N (N < 100) com a quantidade de 
casos de teste que vem a seguir, ou melhor, a quantidade de listas de 
compras para organizar. Cada lista de compra consiste de uma única linha que 
contém de 1 a 1000 itens ou palavras compostas apenas de letras minúsculas 
(de 1 a 20 letras), sem acentos e separadas por um espaço.

# Saída

A saída contém N linhas, cada uma representando uma lista de compra, sem os 
itens repetidos e em ordem alfabética.

| Exemplo de Entrada | Exemplo de Saída |
| ----- | ---- |
| 2 <br> carne laranja suco picles laranja picles<br>laranja pera laranja pera pera | carne laranja picles suco<br>laranja pera| 
| 3 <br> suco carne frango carne chocolate<br>sacola amaciante<br>leite chocolate suco laranja | carne chocolate frango suco<br>amaciante sacola<br>chocolate laranja leite suco |

# Solução

```java
public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
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
```

----------

| :arrow_left: [Desafio anterior](/java/ordenation/odd-and-even-number-sorter#readme) |............................... :arrow_up: [Voltar ao topo](#desafio) :arrow_up: ...............................| [Próximo Desafio](/java/ordenation/end-year-uniform#readme) :arrow_right: | 
| :----: |-----| :-----:|
