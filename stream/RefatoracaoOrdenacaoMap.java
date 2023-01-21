package collections.stream;

import java.util.*;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

public class RefatoracaoOrdenacaoMap {
  public static void main(String[] args) {
    System.out.println("Ordem aleatória");
    Map<Integer, Contato> agenda = new HashMap<>() {
      {
        put(1, new Contato("Simba", 2222));
        put(4, new Contato("Cami", 5555));
        put(3, new Contato("Jon", 1111));
        put(2, new Contato("Alan", 2525));
      }
    };

    System.out.println("Ordem número telefone");
    /*
     * // Refatoração com uso de classe anônima sem ComparatorNumeroTelefone
     * Set<Map.Entry<Integer, Contato>> agenda2 = new TreeSet<>(new
     * Comparator<Map.Entry<Integer, Contato>>() {
     *
     * @Override
     * public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
     * return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
     * }
     * });
     * agenda2.addAll(agenda.entrySet());
     * for (Map.Entry<Integer, Contato> entry : agenda2) {
     * System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
     * ": " + entry.getValue().getNumero());
     * }
     * System.out.println();
     */

    /*
     * // Functional interface
     * Set<Map.Entry<Integer, Contato>> agenda2 = new
     * TreeSet<>(Comparator.comparing(
     * new Function<Map.Entry<Integer, Contato>, Integer>() {
     *
     * @Override
     * public Integer apply(Entry<Integer, Contato> cont) {
     * return cont.getValue().getNumero();
     * }
     * }));
     * agenda2.addAll(agenda.entrySet());
     * for (Map.Entry<Integer, Contato> entry : agenda2) {
     * System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
     * ": " + entry.getValue().getNumero());
     * }
     * System.out.println();
     */

    // Com lambda
    Set<Map.Entry<Integer, Contato>> agenda2 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
    agenda2.addAll(agenda.entrySet());
    for (Map.Entry<Integer, Contato> entry : agenda2) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
    System.out.println();

    System.out.println("Ordem nome contato");
    /*
     * // Classe anônima sem ComparatorNomeContato
     * Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(
     * new Comparator<Map.Entry<Integer, Contato>>() {
     *
     * @Override
     * public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
     * return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
     * }
     * });
     * agenda4.addAll(agenda.entrySet());
     * for (Map.Entry<Integer, Contato> entry : agenda4) {
     * System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
     * ": " + entry.getValue().getNumero());
     * }
     */

    /*
     * // Functional Interface
     * Set<Map.Entry<Integer, Contato>> agenda4 = new
     * TreeSet<>(Comparator.comparing(
     * new Function<Map.Entry<Integer, Contato>, String>() {
     *
     * @Override
     * public String apply(Entry<Integer, Contato> cont) {
     * return cont.getValue().getNome();
     * }
     * }));
     *
     * agenda4.addAll(agenda.entrySet());
     * for (Map.Entry<Integer, Contato> entry : agenda4) {
     * System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
     * ": " + entry.getValue().getNumero());
     * }
     */

    // Com lambda
    Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
        cont -> cont.getValue().getNome()));

    agenda4.addAll(agenda.entrySet());
    for (Map.Entry<Integer, Contato> entry : agenda4) {
      System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
          ": " + entry.getValue().getNumero());
    }
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
