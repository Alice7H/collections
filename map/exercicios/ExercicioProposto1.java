package collections.map.exercicios;

import java.util.*;
/*
 * Dada a população estimada de alguns estados do NE brasileiro,
 * faça:
 * Estado = PE - População = 9.616.621
 * Estado = AL - População = 3.351.543
 * Estado = CE - População = 9.187.103
 * Estado = RN - População = 3.534.265
 */

public class ExercicioProposto1 {
  public static void main(String[] args) {

    System.out.println("Crie um dicionário e relacione os estados e suas populações:");
    Map<String, Integer> populacaoEstadosNE = new HashMap<>() {
      {
        put("PE", 9616621);
        put("AL", 3351543);
        put("CE", 9187103);
        put("RN", 3534265);
      }
    };
    System.out.println(populacaoEstadosNE);
    System.out.println();

    System.out.println("Substitua a população do estado do RN por 3.534.165: ");
    populacaoEstadosNE.put("RN", 3534165);
    System.out.println(populacaoEstadosNE);
    System.out.println();

    System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277: ");
    populacaoEstadosNE.put("PB", 4039277);
    System.out.println(populacaoEstadosNE);
    System.out.println();

    System.out.println("Exiba a população PE: " + populacaoEstadosNE.get("PE"));
    System.out.println();

    System.out.println("Exiba todos os estados e suas populações na ordem que foi informado: ");
    Map<String, Integer> populacaoEstadosNE1 = new LinkedHashMap<>() {
      {
        put("PE", 9616621);
        put("AL", 3351543);
        put("CE", 9187103);
        put("RN", 3534265);
      }
    };
    System.out.println(populacaoEstadosNE1);
    System.out.println();

    System.out.println("Exiba os estados e suas populações em ordem alfabética:");
    Map<String, Integer> populacaoEstadosNE2 = new TreeMap<>(populacaoEstadosNE1);
    System.out.println(populacaoEstadosNE2);
    System.out.println();

    System.out.println("Exiba o estado com a menor população e sua quantidade:");
    Collection<Integer> populacao = populacaoEstadosNE2.values();
    String estadoMenorPopulacao = "";
    Set<Map.Entry<String, Integer>> entries = populacaoEstadosNE2.entrySet();
    for (Map.Entry<String, Integer> entry : entries) {
      if (entry.getValue().equals(Collections.min(populacao))) {
        estadoMenorPopulacao = entry.getKey();
      }
    }
    System.out.println(estadoMenorPopulacao + " - " + Collections.min(populacao));
    System.out.println();

    System.out.println("Exiba o estado com a maior população e sua quantidade:");
    String estadoMaiorPopulacao = "";
    Set<Map.Entry<String, Integer>> entries2 = populacaoEstadosNE2.entrySet();
    for (Map.Entry<String, Integer> entry : entries2) {
      if (entry.getValue().equals(Collections.max(populacao))) {
        estadoMaiorPopulacao = entry.getKey();
      }
    }
    System.out.println(estadoMaiorPopulacao + " - " + Collections.max(populacao));
    System.out.println();

    Iterator<Integer> iterator = populacao.iterator();
    Integer soma = 0;
    while (iterator.hasNext()) {
      soma += iterator.next();
    }
    System.out.println("Exiba a soma da população desses estados: " + soma);
    System.out.println();

    System.out.println("Exiba a média da população deste dicionário de estados:" + (soma / populacao.size()));
    System.out.println();

    System.out.println("Remova os estados com a população menor que 4.000.000: ");
    Iterator<Integer> iterator2 = populacaoEstadosNE.values().iterator();
    while (iterator2.hasNext()) {
      if (iterator2.next() < 4000000) {
        iterator2.remove();
      }
    }
    System.out.println(populacaoEstadosNE);
    System.out.println();

    System.out.println("Apague o dicionário de estados: ");
    populacaoEstadosNE.clear();
    System.out.println(populacaoEstadosNE);
    System.out.println();

    System.out.println("Confira se o dicionário está vazio: " + populacaoEstadosNE.isEmpty());
    System.out.println("Confira se o dicionário 1 está vazio: " + populacaoEstadosNE1.isEmpty());
    System.out.println("Confira se o dicionário 2 está vazio: " + populacaoEstadosNE2.isEmpty());
  }
}
