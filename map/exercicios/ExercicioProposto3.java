package collections.map.exercicios;

import java.util.*;
import java.util.Map.Entry;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/
public class ExercicioProposto3 {
  public static void main(String[] args) {
    System.out.println("Ordem aleatória");
    Map<Integer, Contato> agenda = new HashMap<>() {
      {
        put(1, new Contato("Simba", 2222));
        put(4, new Contato("Cami", 5555));
        put(3, new Contato("Jon", 1111));
      }
    };
    for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
    System.out.println();

    System.out.println("Ordem Inserção");
    Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {
      {
        put(1, new Contato("Simba", 2222));
        put(4, new Contato("Cami", 5555));
        put(3, new Contato("Jon", 1111));
      }
    };
    for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
    System.out.println();

    System.out.println("Ordem id");
    Map<Integer, Contato> agenda2 = new TreeMap<>(agenda1);
    for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
    System.out.println();

    System.out.println("Ordem número telefone");
    Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(new ComparatorNumeroTelefone());
    agenda3.addAll(agenda.entrySet());
    for (Map.Entry<Integer, Contato> entry : agenda3) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
    System.out.println();

    System.out.println("Ordem nome contato");
    Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new ComparatorNomeContato());
    agenda4.addAll(agenda.entrySet());
    for (Map.Entry<Integer, Contato> entry : agenda4) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
  }
}

class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

  @Override
  public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
    return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
  }

}

class ComparatorNomeContato implements Comparator<Map.Entry<Integer, Contato>> {

  @Override
  public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
    return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
  }

}

class Contato {
  private String nome;
  private Integer numero;

  public Contato(String nome, Integer numero) {
    this.nome = nome;
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public Integer getNumero() {
    return numero;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Contato contato = (Contato) o;
    return nome.equals(contato.nome) && numero.equals(contato.numero);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, numero);
  }

  @Override
  public String toString() {
    return "Contato{" +
        "nome='" + nome + '\'' +
        ", numero='" + numero + '\'' +
        '}';
  }
}