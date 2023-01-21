package collections.map;

import java.util.*;
import java.util.Map.Entry;

/*
 * Dadas as seguintes informações sobre meus livros favoritos e seus autores,
 * Crie um dicionário e ordene este dicionário:
 * exibindo (Nome Autor - Nome Livro);
 * Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
 * Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
 * Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
 */
public class ExemploOrdenacaoMap {
  public static void main(String[] args) {
    System.out.println("Crie um dicionario em ordem aleatória: ");
    Map<String, Livro> livros = new HashMap<>() {
      {
        put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
        put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
        put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
      }
    };
    for (Map.Entry<String, Livro> livro : livros.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
    System.out.println();

    System.out.println("Ordem Inserção: ");
    Map<String, Livro> livros1 = new LinkedHashMap<>() {
      {
        put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
        put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
        put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
      }
    };
    for (Map.Entry<String, Livro> livro : livros1.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
    System.out.println();

    System.out.println("Ordem alfabética autores: ");
    Map<String, Livro> livros2 = new TreeMap<>(livros1);
    for (Map.Entry<String, Livro> livro : livros2.entrySet()) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
    System.out.println();

    System.out.println("Ordem alfabética nomes dos livros: ");
    Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNomeLivro());
    livros3.addAll(livros2.entrySet());
    for (Map.Entry<String, Livro> livro : livros3) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
    System.out.println();

    System.out.println("Ordem número de página: ");
    Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorNumeroPagina());
    livros4.addAll(livros2.entrySet());
    for (Map.Entry<String, Livro> livro : livros4) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
    System.out.println();
  }
}

class ComparatorNomeLivro implements Comparator<Map.Entry<String, Livro>> {
  @Override
  public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
    return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
  }
}

class ComparatorNumeroPagina implements Comparator<Map.Entry<String, Livro>> {
  @Override
  public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
    return Integer.compare(o1.getValue().getPaginas(), o2.getValue().getPaginas());
  }
}
