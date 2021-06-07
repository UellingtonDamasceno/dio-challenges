# Desafio

Elabore um programa que possuas as características abaixo:

    Leia os dados de um CPF no formato XXX.YYY.ZZZ-DD;
    Imprima os quatro grupos numéricos, sendo um valor por linha.

# Entrada

A entrada consiste vários arquivos de teste e cada um possuindo uma linha com 
formato XXX.YYY.ZZZ-DD, onde XXX, YYY, ZZZ, DD são números inteiros.

# Saída

Para cada arquivo da entrada, tem que ter um arquivo de saída com quatro linhas,
e em cada linha um número inteiro de acordo com procedimento 2 descrito no
Desafio. Confira o exemplo abaixo:

| Exemplo de Entrada | Exemplo de Saída |
| :----------------: | ---------------- |
| 000.000.000-00 | 000<br/>000<br/>000<br/>00 |
| 123.456.789-01 | 123<br/>456<br/>789<br/>01 |
| 987.654.321-98 | 987<br/>654<br/>321<br/>98 |

# Solução 
Para solucionar esse desafio foi utilizado o método `replaceAll` da classe `String`
que recebe dois argumentos, sendo o primeiro uma regex que corresponde a todas as 
ocorrencias. Já o segundo corresponde a string que deve ser inserida no lugar 
onde houver match.

Essa solução só foi possivel graças ao [PBL de Linguagem formais e compiladores](https://github.com/UellingtonDamasceno/lexical-analyzer#lista-de-siglas)
que acabei de fazer para uma disciplina da Univesidade. 

```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String newCpf = br.readLine().replaceAll("[\\.-]", "\n");
    System.out.println(newCpf);
}
```

