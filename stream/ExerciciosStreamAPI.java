package collections.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        System.out.println("Imprima todos os elementos dessa lista de String: ");
        /*
         * numerosAleatorios.stream().forEach(new Consumer<String>() {
         *
         * @Override
         * public void accept(String t) {
         * System.out.println(t);
         * }
         * });
         */
        // numerosAleatorios.stream().forEach(t -> System.out.println(t));
        numerosAleatorios.forEach(System.out::println);
        System.out.println();

        // Lembrando: Set não repete valores
        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        List<Integer> collectionList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // .forEach(System.out::println);
        System.out.println(collectionList);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        // Lista de Integer to
        collectionList.removeIf(integer -> integer % 2 != 0);
        System.out.println(collectionList);

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        long count = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + count);

        System.out.print("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        int somaDePares = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(inteiro -> (inteiro % 2 == 0))
                .sum();
        System.out.println("Pegue apenas os números pares e some: " + somaDePares);

        System.out.println("Mostre a lista na ordem númerica: ");
        // numerosAleatorios.stream()
        // .map(Integer::parseInt)
        // .sorted(Comparator.naturalOrder())
        // .collect(Collectors.toList())
        // .forEach(System.out::println);

        numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> collectNumImparMultiplosDe3E5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> i % 2 != 0 && (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumImparMultiplosDe3E5);

    }
}
