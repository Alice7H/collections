package collections.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Faça um programa que receba a temperatura média dos 6
 * primeiros meses do ano e armazene-as em uma lista.
 *
 * Após isto, calcule a média semestral das temperaturas e
 * mostre todas as temperaturas acima desta média, e em que
 * mês elas ocorreram (mostrar o mês por extenso:
 * 1 – Janeiro, 2– Fevereiro e etc).
 */

public class ExercicioProposto1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Double> temperaturas = new ArrayList<>();
    int contador = 0;

    while (contador < 6) {
      System.out.print("Informe a temperatura do índice " + (contador + 1) + ": ");
      temperaturas.add(scanner.nextDouble());
      contador++;
    }
    System.out.println();
    System.out.println("Temperaturas:");
    System.out.println(temperaturas);
    System.out.println();

    System.out.println("Média:");
    Iterator<Double> iterator = temperaturas.iterator();
    Double soma = 0d;
    while (iterator.hasNext()) {
      Double next = iterator.next();
      soma += next;
    }
    Double media = soma / temperaturas.size();
    System.out.println(media);
    System.out.println();

    System.out.println("Temperaturas e meses com valores acima da média: ");
    Iterator<Double> iterator2 = temperaturas.iterator();
    int count = 0;
    while (iterator2.hasNext()) {
      Double next = iterator2.next();
      if (next > media) {
        switch (count) {
          case 0:
            System.out.println("1 - Janeiro com " + next);
            break;
          case 1:
            System.out.println("2 - Fevereiro com " + next);
            break;
          case 2:
            System.out.println("3 - Março com " + next);
            break;
          case 3:
            System.out.println("4 - Abril com " + next);
            break;
          case 4:
            System.out.println("5 - Maio com " + next);
            break;
          case 5:
            System.out.println("6 - Junho com " + next);
            break;
          default:
            System.out.println("Não houve temperatura acima da média.");
            break;
        }
      }
      count++;
    }

  }
}
