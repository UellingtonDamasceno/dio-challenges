# Consumo Médio do Automóvel

Você deve calcular o consumo médio de
um automóvel onde será informada a
distância total percorrida (em Km) e o
total de combustível consumido (em
litros).

## Entrada

Você receberá dois valores: um valor
inteiro X com a distância total
percorrida (em Km), e um valor real Y
que representa o total de combustível
consumido, com um dígito após o ponto
decimal.

## Saída

Exiba o valor que representa o consumo médio do automóvel (3 casas após a vírgula), incluindo no final a mensagem "km/l".

| Exemplo de Entrada | Exemplo de Saída |
| ------------------ | :--------------: |
| 500</br>35.0       |   14.286 km/l    |

| Exemplo de Entrada | Exemplo de Saída |
| ------------------ | :--------------: |
| 2254</br>124.4     |   18.119 km/l    |

| Exemplo de Entrada | Exemplo de Saída |
| ------------------ | :--------------: |
| 4554</br>464.6     |    9.802 km/l    |

## Solução

```java
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            br.lines()
                    .limit(2)
                    .map(Double::parseDouble)
                    .reduce((distance, consumption)-> distance/consumption)
                    .map(average -> String.format("%.3f km/l", average))
                    .ifPresent(System.out::println);
        }
    }
}
```
