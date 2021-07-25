package cpf.spliterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Desafio

Elabore um programa que possuas as características abaixo:

    Leia os dados de um CPF no formato XXX.YYY.ZZZ-DD;
    Imprima os quatro grupos numéricos, sendo um valor por linha.

Entrada

A entrada consiste vários arquivos de teste e cada um possuindo uma linha com 
formato XXX.YYY.ZZZ-DD, onde XXX, YYY, ZZZ, DD são números inteiros.
Saída

Para cada arquivo da entrada, tem que ter um arquivo de saída com quatro linhas,
e em cada linha um número inteiro de acordo com procedimento 2 descrito no
Desafio. Confira o exemplo abaixo:

 */
/**
 *
 * @author Uellington Damasceno
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            String newCpf = br.readLine().replaceAll("[\\.-]", "\n");
            System.out.println(newCpf);
        }
    }
}
