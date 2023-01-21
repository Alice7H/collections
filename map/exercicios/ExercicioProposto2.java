package collections.map.exercicios;

import java.util.*;
/*
 * Faça um programa que simule um lançamento de dados.
 * Lance o dado 100 vezes e armazene.
 * Depois, mostre quantas vezes cada valor foi inserido.
 */

public class ExercicioProposto2 {
  public static void main(String[] args) {
    List<Integer> lancamentos = new ArrayList<>();
    Random geradorDeLancamento = new Random();
    int qtdLancamentos = 100;

    for (int i = 0; i < qtdLancamentos; i++) {
      int resultado = geradorDeLancamento.nextInt(6) + 1;
      lancamentos.add(resultado);
    }
    System.out.println(lancamentos);
    System.out.println();

    Map<Integer, Integer> lancamentos2 = new HashMap<>();
    for (Integer resultado : lancamentos) {
      if (lancamentos2.containsKey(resultado))
        lancamentos2.put(resultado, (lancamentos2.get(resultado) + 1));
      else
        lancamentos2.put(resultado, 1);
    }
    for (Map.Entry<Integer, Integer> entry : lancamentos2.entrySet()) {
      System.out.println("Lado do dado: " + entry.getKey() + " - inserido " + entry.getValue() + " vezes");
    }
  }
}
