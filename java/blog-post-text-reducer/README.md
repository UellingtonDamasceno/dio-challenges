# blog-post-text-reducer

- [Desafio](#desafio)
- [Entrada](#entrada)
- [Saída](#saída)
- [Exemplos](#exemplos)
- [Solução](#solução)

# Desafio

Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés
das cidades por onde passa. Recentemente, resolveu criar um blog, para compartilhar
suas experiências e aprendizados com seus amigos.

Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um 
limite de caracteres que se pode escrever por dia, e Leonardo está preocupado que 
essa limitação, afinal, irá impedir de contar suas melhores experiências.
Para contornar esse problema, decidiu usar um sistema de abreviação de palavras
em seus posts.

O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, 
é possível escolher uma palavra que inicia com tal letra e que aparece no post.
Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída
por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos 
na tela.

Por exemplo, na frase: `“hoje eu programei em Python”`, podemos escolher a palavra 
`“programei”` para representar a letra `‘p'`, e a frase ficará assim: `“hoje eu p. em 
Python”`, economizando assim sete caracteres. Uma mesma palavra pode aparecer mais 
de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma abreviação 
o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra
“eu” acima.

Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e 
por isso pediu a sua ajuda. Para cada letra, escolha uma palavra, de modo que ao
serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

# Entrada

Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo 
uma frase de até `10⁴ caracteres`. A frase é composta de palavras e espaços em branco, 
e cada palavra é composta de letras minúsculas ``('a'-'z')``, e contém entre `1 e 30 caracteres` cada.

O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não 
deverá ser processado.

# Saída

Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro `N`, indicando o número de palavras em que foram escolhidas uma
letra para a abreviação no texto. Nas próximas `N` linhas, imprima o seguinte padrão ``C. = P``, 
onde `C` é a letra inicial e `P` é a palavra escolhida para tal letra. As linhas devem ser impressas 
em ordem crescente da letra inicial.

# Exemplos

| Entrada | Saída |
| ------- | ----- |
| abcdef abc abc abc </br> .  | a. abc abc abc </br> 1 </br> a. = abcdef|
| amora amor bala bala beijo </br> . | a. amor b. b. beijo </br> 2 </br> a. = amora </br> b. = bala |
| foo foo bar bar bar </br> . | f. f. b. b. b. </br> 2 </br> f. = foo </br> b. = bar |

# Solução

A solução desse desafio foi desenvolvida totalmente utilizando o máximo que as API's funcionais do java 8 como por exemplo:
`Stream`, `Collectors`, `Function`, `Suppllier` e `Consumer` podem propocionar. Também foi desenvolvido um método recursivo para 
efetuar a substituição palavras selecionadas pela sua respectiva abreviação.

![Código recusivo que substitui uma palavra em uma frase](https://github.com/UellingtonDamasceno/dio-challenges/blob/main/java/blog-post-text-reducer/res/code.png)
