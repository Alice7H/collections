package collections.set;

import java.util.*;

/*
 * Dadas as seguintes informações sobre minhas séries favoritas,
 * Crie um conjunto e o ordene exibindo:
 *  (nome - genero - tempo de episódio);
 *
 * Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
 * Série 1 = Nome: dark, genero: drama, tempoEpisodio: 60
 * Série 1 = Nome: that's 70s show, genero: comedia, tempoEpisodio: 25
*/

public class ExemploOrdenacaoSet {
  public static void main(String[] args) {
    System.out.println("Ordem aleatória:");
    Set<Serie> series = new HashSet<>() {
      {
        add(new Serie("got", "fantasia", 60));
        add(new Serie("dark", "drama", 60));
        add(new Serie("that's 70s show", "comedia", 25));
      }
    };

    // System.out.println(series);
    // System.out.println();
    for (Serie serie : series) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();

    System.out.println("Ordem inserção:");
    Set<Serie> series2 = new LinkedHashSet<>() {
      {
        add(new Serie("got", "fantasia", 60));
        add(new Serie("dark", "drama", 60));
        add(new Serie("that's 70s show", "comedia", 25));
      }
    };
    for (Serie serie : series2) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();

    System.out.println("Ordem natural (Tempo Episódio):");
    Set<Serie> series3 = new TreeSet<>(series);
    for (Serie serie : series3) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();

    System.out.println("Ordem nome/gênero/tempo episódio: ");
    Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());
    series4.addAll(series);
    for (Serie serie : series4) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();

    System.out.println("Ordem gênero:");
    Set<Serie> series5 = new TreeSet<>(new ComparatorGenero());
    series5.addAll(series);
    for (Serie serie : series5) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();

    System.out.println("Ordem Tempo Episódio");
    Set<Serie> series6 = new TreeSet<>(new ComparatorTempoEpisodio());
    series6.addAll(series);
    for (Serie serie : series6) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    System.out.println();
  }
}

class ComparatorNomeGeneroTempoEp implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
    if (nome != 0)
      return nome;
    int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
    if (genero != 0)
      return genero;
    return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
  }
}

class ComparatorGenero implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    return s1.getGenero().compareToIgnoreCase(s2.getGenero());
  }

}

class ComparatorTempoEpisodio implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    int tempoEp = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    if (tempoEp != 0)
      return tempoEp;
    return s1.getGenero().compareToIgnoreCase(s2.getGenero());
  }

}