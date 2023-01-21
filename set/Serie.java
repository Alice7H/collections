package collections.set;

import java.util.*;

public class Serie implements Comparable<Serie> {
  private String nome;
  private String genero;
  private Integer tempoEpisodio;

  public Serie(String nome, String genero, Integer tempoEp) {
    this.nome = nome;
    this.genero = genero;
    this.tempoEpisodio = tempoEp;
  }

  public String getNome() {
    return nome;
  }

  public String getGenero() {
    return genero;
  }

  public Integer getTempoEpisodio() {
    return tempoEpisodio;
  }

  @Override
  public String toString() {
    return "{" + "Nome: " + nome
        + ", genero:" + genero
        + ", tempo de episódio:" + tempoEpisodio
        + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Serie serie = (Serie) obj;
    return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, genero, tempoEpisodio);
  }

  @Override
  public int compareTo(Serie serie) {
    int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
    if (tempoEpisodio != 0)
      return tempoEpisodio;
    return this.getGenero().compareToIgnoreCase(serie.getGenero());
  }
}
