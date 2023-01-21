package collections.set.exercicios;

import java.util.*;

/*
 * Crie uma classe LinguagemFavorita que possua os atributos
 * nome, anoDeCriacao e ide.
 * Em seguida, crie um conjunto com 3 linguagens e faça um
 * programa que ordene esse conjunto por:
 * A. Ordem de Inserção
 * B. Ordem Natural (nome)
 * C. IDE
 * D. Ano de criação e nome
 * E. Nome, ano de criacao e IDE
 * Ao final, exiba as linguagens no console, um abaixo da outra.
 */

public class ExercicioProposto2 {
  public static void main(String[] args) {
    System.out.println("Crie um conjunto com 3 linguagens: ");
    Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>() {
      {
        add(new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"));
        add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
        add(new LinguagemFavorita("C#", 1999, "Visual Studio"));
      }
    };
    for (LinguagemFavorita lingFavorita : linguagensFavoritas)
      System.out.println(lingFavorita);
    System.out.println();

    System.out.println("Ordem de Inserção:");
    Set<LinguagemFavorita> linguagensFavoritas1 = new LinkedHashSet<>(
        Arrays.asList(
            new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"),
            new LinguagemFavorita("Java", 1991, "IntelliJ"),
            new LinguagemFavorita("C#", 1999, "Visual Studio")));
    for (LinguagemFavorita lingFavorita : linguagensFavoritas1)
      System.out.println(lingFavorita);
    System.out.println();

    System.out.println("Ordem de Natural (Nome):");
    Set<LinguagemFavorita> linguagemFavoritas2 = new TreeSet<>(linguagensFavoritas);
    for (LinguagemFavorita lingFavorita : linguagemFavoritas2)
      System.out.println(lingFavorita);
    System.out.println();

    System.out.println("IDE:");
    Set<LinguagemFavorita> lingFavoritas = new TreeSet<>(new ComparatorIde());
    lingFavoritas.addAll(linguagensFavoritas);
    for (LinguagemFavorita lingFavorita : lingFavoritas)
      System.out.println(lingFavorita);
    System.out.println();

    System.out.println("Ano de criação e nome:");
    Set<LinguagemFavorita> lingFavoritas2 = new TreeSet<>(new ComparatorAnoCriacaoNome());
    lingFavoritas2.addAll(linguagensFavoritas);
    for (LinguagemFavorita lingFavorita : lingFavoritas2)
      System.out.println(lingFavorita);
    System.out.println();

    System.out.println("Nome, ano de criacao e IDE:");
    Set<LinguagemFavorita> lingFavoritas3 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
    lingFavoritas3.addAll(linguagensFavoritas);
    for (LinguagemFavorita lingFavorita : lingFavoritas3)
      System.out.println(lingFavorita);
    System.out.println();
  }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
    return o1.getIde().compareToIgnoreCase(o2.getIde());
  }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
    int anoCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
    if (anoCriacao != 0)
      return anoCriacao;
    return o1.getNome().compareToIgnoreCase(o2.getNome());
  }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
    int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
    if (nome != 0)
      return nome;
    int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
    if (anoCriacao != 0)
      return anoCriacao;
    return l1.getIde().compareToIgnoreCase(l2.getIde());
  }

}