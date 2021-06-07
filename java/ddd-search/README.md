# Desafio

Leia um número inteiro que representa um código de DDD para discagem interurbana.
Em seguida, informe à qual cidade o DDD pertence, considerando a tabela abaixo:

| DDD | Cidade | 
| :-: | ------ |
| 61 | Brasilia |
| 71 | Salvador |
| 11 | Sao Paulo |
| 21 | Rio de Janeiro |
| 32 | Juiz de Fora |
| 19 | Campinas |
| 27 | Vitoria |
| 31 | Belo Horizonte |

Se a entrada for qualquer outro DDD que não esteja presente na tabela acima, 
o programa deverá informar: `DDD nao cadastrado` 

# Entrada
A entrada consiste de um único valor inteiro.

# Saída
Imprima o nome da cidade correspondente ao DDD existente na entrada. 
Imprima DDD nao cadastrado caso não existir DDD correspondente ao número digitado.

# Solução
Para solucionar o problema foi utilzado um `Map<Integer, String>` para associar o DDD a cidade. Essa 
abordagem foi utilizada por causa da complexidade O1 de leitura do Map.
```java
public static void main(String[] args) {
    Map<Integer, String> ddd = Map.of(
            61, "Brasilia",
            71, "Salvador",
            11, "Sao Paulo",
            21, "Rio de Janeiro",
            32, "Juiz de Fora",
            19, "Campinas",
            27, "Vitoria",
            31, "Belo Horizonte");
    Scanner scanner = new Scanner(System.in);
    String city = ddd.getOrDefault(scanner.nextInt(), "DDD nao cadastrado");
    System.out.println(city);
}
```

Além da velocidade na recuperação dos dados, essa solução possui menos linhas de código se comparado com uma
abordagem convencional utilizando `if-else` ou `switch`.

### Solução com if-else:

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int ddd = scanner.nextInt();
    String city;
    if(ddd == 61){
      city = "Brasilia";
    }else if(ddd == 71){
      city = "Salvador";
    }else if(ddd == 11){
      city = "Sao Paulo";
    }
    .
    .
    .
    else{
      city = "DDD nao cadastrado";
    }
}
```

### Solução com switch:

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String city;
    switch(scanner.nextInt()){
      case 61:
        city = "Brasilia";
        break;
     case 71: 
        city = "Salvador";
        break;
     case 11:
        city = "Sao Paulo";
        break;
     case 21:
        city = "Rio de Janeiro";
        break;
        .
        .
        .
     default:
        city = "DDD nao cadastrado";
        break;
    }
    system.out.println(city);
}
```
> ℹ️ A partir do java 12/13 é possível utilizar o switch statment para reduzir a quantidade de linhas da solução apresentada acima.
