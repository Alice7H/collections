package collections.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Utilizando listas, faça um programa que faça 5 respostas para uma
pessoa sobre um crime. As respostas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"

Se a pessoa responder positivamente a 2 questões ela deve ser
classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
"Assassina". Caso contrário, ela será classificado como "Inocente".
 s para Sim e n para Não
*
*/

public class ExercicioProposto2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<String> respostas = new ArrayList<>();

    System.out.println("Responda com s ou n");
    System.out.println("Telefonou para a vítima?");
    respostas.add(scanner.next());

    System.out.println("Esteve no local do crime?");
    respostas.add(scanner.next());

    System.out.println("Mora perto da vítima?");
    respostas.add(scanner.next());

    System.out.println("Devia para a vítima?");
    respostas.add(scanner.next());

    System.out.println("Já trabalhou com a vítima?");
    respostas.add(scanner.next());

    Iterator<String> iterator = respostas.iterator();
    int contador = 0;
    while (iterator.hasNext()) {
      String result = iterator.next().toLowerCase();
      if (result.contains("s"))
        contador++;
    }

    switch (contador) {
      case 2:
        System.out.println("Suspeita");
        break;
      case 3:
      case 4:
        System.out.println("Cúmplice");
        break;
      case 5:
        System.out.println("Assassina");
        break;
      default:
        System.out.println("Inocente");
        break;
    }
  }
}
