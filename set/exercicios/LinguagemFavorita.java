package collections.set.exercicios;

import java.util.*;

public class LinguagemFavorita implements Comparable<LinguagemFavorita> {

  private String nome;
  private Integer anoDeCriacao;
  private String ide;

  public LinguagemFavorita(String nome, Integer anoDeC, String ide) {
    this.nome = nome;
    this.anoDeCriacao = anoDeC;
    this.ide = ide;
  }

  public String getNome() {
    return nome;
  }

  public Integer getAnoDeCriacao() {
    return anoDeCriacao;
  }

  public String getIde() {
    return ide;
  }

  @Override
  public int compareTo(LinguagemFavorita obj) {
    return this.getNome().compareToIgnoreCase(obj.getNome());
  }

  @Override
  public String toString() {
    return this.getNome() + " - " + this.getAnoDeCriacao() + " - " + this.getIde();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    LinguagemFavorita that = (LinguagemFavorita) o;
    return nome.equals(that.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome);
  }
}
