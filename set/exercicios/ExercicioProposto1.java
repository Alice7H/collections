package collections.set.exercicios;

import java.util.*;

/*
 * Crie um conjunto contendo as cores do arco-íris e:
 * Exiba todas as cores uma abaixo da outra
 * A quantidade de cores que o arco-íris tem
 * Exiba as cores em ordem alfabética
 * Exiba as cores na ordem inversa da que foi informada
 * Exiba todas as cores que começam com a letra ”v”
 * Remova todas as cores que não começam com a letra “v”
 * Limpe o conjunto
 * Confira se o conjunto está vazio
 */

public class ExercicioProposto1 {
  public static void main(String[] args) {
    System.out.println("Crie um conjunto contendo as cores do arco-íris: ");
    Set<String> coresArcoIris = new HashSet<String>();
    coresArcoIris.add("vermelha");
    coresArcoIris.add("laranja");
    coresArcoIris.add("amarela");
    coresArcoIris.add("verde");
    coresArcoIris.add("azul");
    coresArcoIris.add("anil");
    coresArcoIris.add("violeta");

    System.out.println(coresArcoIris);
    System.out.println();

    System.out.println("Exiba todas as cores uma abaixo da outra: ");
    for (String cor : coresArcoIris) {
      System.out.println(cor);
    }
    System.out.println();

    System.out.println("A quantidade de cores que o arco-íris tem: ");
    System.out.println(coresArcoIris.size() + " cores ");
    System.out.println();

    System.out.println("Exiba as cores em ordem alfabética:");
    Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
    for (String cor : coresArcoIris2) {
      System.out.println(cor);
    }
    System.out.println();

    System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
    Set<String> coresArcoIris3 = new LinkedHashSet<>(coresArcoIris);
    System.out.println(coresArcoIris3);
    List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris3);
    Collections.reverse(coresArcoIrisList);
    System.out.println(coresArcoIrisList);
    System.out.println();

    System.out.println("Exiba todas as cores que começam com a letra 'v'");
    for (String cor : coresArcoIris) {
      if (cor.startsWith("v"))
        System.out.println(cor);
    }
    System.out.println();

    System.out.println("Remova todas as cores que não começam com a letra 'v'");
    Iterator<String> iterator = coresArcoIris.iterator();
    while (iterator.hasNext()) {
      String cor = iterator.next();
      if (!cor.startsWith("v"))
        iterator.remove();
    }
    System.out.println(coresArcoIris);
    System.out.println();

    System.out.println("Limpe o conjunto 1:");
    coresArcoIris.clear();
    System.out.println(coresArcoIris);
    System.out.println();

    System.out.println("Confira se o conjunto 1 está vazio: " +
        coresArcoIris.isEmpty());
    System.out.println("Confira se o conjunto 2 está vazio: " +
        coresArcoIris2.isEmpty());
    System.out.println("Confira se o conjunto 3 está vazio: " +
        coresArcoIris3.isEmpty());
    System.out.println("Confira se o conjunto 4 está vazio: " +
        coresArcoIrisList.isEmpty());
    System.out.println();

  }
}
