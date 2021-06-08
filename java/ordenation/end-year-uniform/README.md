# Desafio

O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano.
Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou vermelho.
Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma das turmas,
relacionando estas camisetas pela cor, tamanho (`P`, `M` ou `G`) e por último pelo nome.

# Entrada

Cada caso de teste inicia com um valor N, `(1 ≤ N ≤ 60)` inteiro e positivo, que indica a quantidade de uniformes a serem feitas para aquela turma.
As próximas `N*2` linhas contém informações de cada um dos uniformes (serão duas linhas de informação para cada uniforme).
A primeira linha irá conter o nome do estudante e a segunda linha irá conter a cor do uniforme (`"branco"` ou `"vermelho"`)
seguido por um espaço e pelo tamanho do uniforme `"P"`, `"M"` ou `"G"`.
A entrada termina quando o valor de `N` for igual a zero (`0`) e esta valor não deverá ser processado.

# Saída

Para cada caso de entrada deverão ser impressas as informações ordenadas pela `cor em ordem ascendente`,
seguido pelos `tamanhos em ordem descendente` e por último por `ordem ascendente de nome`, conforme o exemplo abaixo.

| Exemplo de Entrada | Exemplo de Saída |
| ---------------- | -------------- |
| 9<br>Maria Jose<br>branco P<br>Mangojata Mancuda<br>vermelhor P<br>Cezar Torres Mo<br>branco P<br>Baka Lhau<br>vermelho P<br>Juju Metina<br>branco M<br>Amaro Dinha<br>vermelho P<br>Adabi Finho<br>branco G<br>Severina Rigudinha<br>branco G<br> Carlos Chade Losna<br>vermelho P<br>0 | branco P Cezar Torres Mo<br>branco P Maria Jose<br>branco M Juju Mentina<br>branco G Adabi Finho<br>branco G Severina Rigudinha<br>vermelho P Amaro Dinha<br>vermelho P Baka Lhau<br>vermelho P Carlos Chade Losana<br>vermelho P Mangojata Mancuda|

# Solução

### Main

``` java
public static void main(String... args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
        int numInfo = Integer.parseInt(br.readLine());
        br.lines()
                .limit(numInfo)
                .map(owner -> new Uniform(owner, readLineWrap.apply(br)))
                .sorted()
                .forEach(System.out::println);
    }
}
```

### ReadLineWrap
```java
private static final Function<BufferedReader, String> readLineWrap = (br) -> {
    try {
        return br.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
};
```

### Uniform class

```java
public static class Uniform implements Comparable<Uniform> {

        protected String owner;
        protected String color;
        protected String size;

        public Uniform(String owner, String details) {
            this.owner = owner;
            String[] splitedDetails = details.split(" ");
            this.color = splitedDetails[0];
            this.size = splitedDetails[1];
        }

        @Override
        public int compareTo(Uniform another) {
            int integer = this.color.compareTo(another.color);
            if (integer == 0) {
                integer = another.size.compareTo(this.size);
                return (integer == 0)
                        ? this.owner.compareTo(another.owner)
                        : integer;
            }
            return integer;
        }

        @Override
        public String toString() {
            return color + " " + size + " " + owner;
        }
    }
```

----------

| :arrow_left: [Desafio anterior](/java/ordenation/no-repeat-list#readme) |............................... :arrow_up: [Voltar ao topo](#desafio) :arrow_up: ...............................| [Próximo Desafio](/java/ordenation/bank-queue#readme) :arrow_right: | 
| :----: |-----| :-----:|
