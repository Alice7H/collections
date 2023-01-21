package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Dados as seguintes informações sobre seus gatos.
 * Crie um lista e ordeno esta lista exibindo:
 * (nome - idade - cor);
 *
 * GATO 1 - nome: Jon, idade: 18, cor: preto
 * GATO 2 - nome: Simba, idade: 6, cor: tigrado
 * GATO 3 - nome: Jon, idade: 12, cor: amarelo
 */

public class ExemploOrdenacaoList {
  public static void main(String[] args) {
    List<Gato> list = new ArrayList<>() {
      {
        add(new Gato("Jon", 18, "preto"));
        add(new Gato("Simba", 6, "tigrado"));
        add(new Gato("Jon", 12, "amarelo"));
      }
    };
    System.out.println("Lista de gatos:");
    System.out.println(list.toString());
    System.out.println();

    System.out.println("Ordem de inserção: ");
    System.out.println(list);

    System.out.println("Ordem aleatória: ");
    Collections.shuffle(list);
    System.out.println(list);
    System.out.println();

    System.out.println("Ordem natural (nome)");
    // não posso usar list.sort() pois sobreescrevi o método compareTo.
    Collections.sort(list);
    System.out.println(list);
    System.out.println();

    System.out.println("Ordem idade");
    // list.sort(new ComparatorIdade());
    Collections.sort(list, new ComparatorIdade());
    System.out.println(list);
    System.out.println();

    System.out.println("Ordem cor");
    // list.sort(new ComparatorCor());
    Collections.sort(list, new ComparatorCor());
    System.out.println(list);
    System.out.println();

    System.out.println("Ordem nome/cor/idade");
    // list.sort(new ComparatorNomeCorIdade());
    Collections.sort(list, new ComparatorNomeCorIdade());
    System.out.println(list);
  }
}

class Gato implements Comparable<Gato> {
  private String nome;
  private Integer idade;
  private String cor;

  public Gato(String nome, Integer idade, String cor) {
    this.nome = nome;
    this.idade = idade;
    this.cor = cor;
  }

  public String getNome() {
    return this.nome;
  }

  public int getIdade() {
    return this.idade;
  }

  public String getCor() {
    return this.cor;
  }

  @Override
  public String toString() {
    return "{" + "nome: " + this.nome + "\'"
        + ", idade " + this.idade + "\'"
        + ", cor " + this.cor + "\'" +
        "}";
  }

  @Override
  public int compareTo(Gato gato) {
    return this.getNome().compareToIgnoreCase(gato.getNome());
  }
}

class ComparatorIdade implements Comparator<Gato> {

  @Override
  public int compare(Gato g1, Gato g2) {
    return Integer.compare(g1.getIdade(), g2.getIdade());
  }

}

class ComparatorCor implements Comparator<Gato> {

  @Override
  public int compare(Gato g1, Gato g2) {
    return g1.getCor().compareToIgnoreCase(g2.getCor());
  }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

  @Override
  public int compare(Gato g1, Gato g2) {
    int casoNome = g1.getNome().compareToIgnoreCase(g2.getNome());
    if (casoNome != 0)
      return casoNome;
    int casoCor = g1.getCor().compareToIgnoreCase(g2.getCor());
    if (casoCor != 0)
      return casoCor;

    return Integer.compare(g1.getIdade(), g2.getIdade());
  }

}