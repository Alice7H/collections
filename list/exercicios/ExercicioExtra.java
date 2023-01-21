package collections.list.exercicios;

import java.util.LinkedList;
import java.util.List;

/*
 * Para você: Resolva esses exercícios utilizando os métodos da implementação
 * LinkedList:
 * System.out.println("Crie uma lista chamada notas2 " +
 * "e coloque todos os elementos da list Arraylist (valores do exercício
 * do ExemploList.java) nessa nova lista: ");
 * System.out.println("Mostre a primeira nota da nova lista sem removê-lo: ");
 * System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
 */
public class ExercicioExtra {
  public static void main(String[] args) {

    System.out.println("Crie uma lista chamada notas2 " +
        "e coloque todos os elementos da list Arraylist nessa nova lista: ");
    List<Double> notas2 = new LinkedList<>();
    notas2.add(7.0);
    notas2.add(8.5);
    notas2.add(9.3);
    notas2.add(5d);
    notas2.add(7d);
    notas2.add(0.0);
    notas2.add(3.6);

    System.out.println(notas2);
    System.out.println();

    System.out.println("Mostre a primeira nota da nova lista sem removê-lo: ");
    System.out.println(notas2.get(0));
    System.out.println();

    System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
    System.out.println(notas2.remove(0));
    System.out.println(notas2);
    System.out.println();
  }
}
