
# Desafio

Crie um programa que leia um número e mostre os números pares até esse número, inclusive ele mesmo.

# Entrada
Você receberá 1 valor inteiro N, onde N > 0.

# Saída
Exiba todos os números pares até o valor de entrada, sendo um em cada linha. 

| Exemplo de Entrada | Exemplo de saída |
| :----------------: | ---------------- |
| 6 | 2<br/>4<br/>6<br/>|
| 8 | 2<br/>4<br/>6<br/>8<br/>|
| 11 | 2<br/>4<br/>6<br/>8<br/>10|

# Solução

Para solucionar o problema foi utilizado o método estatico `interate` 
da classe `Stream` para gerar uma stream de valores pares que iniciam 
com o 2 e é incrementado de 2 em 2 até que alcance metade do numero indicado 
pelo usuário.

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int maxNumber = scanner.nextInt() / 2;
    Stream.iterate(2, (currentNumber) -> currentNumber + 2)
            .limit(maxNumber)
            .forEach(System.out::println);
}
```
Também é possível solucionar esse problema utilizando o laço de repetição `for` ficando da 
seguinte forma: 

```java
public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  int maxNumber = scanner.nextInt();
  for(int i = 0; i <= maxNumber; i++){
    if(i % 2 == 0) {
      System.out.println(i);
    }
  }
```
