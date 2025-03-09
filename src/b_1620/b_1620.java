package b_1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_1620 {
    private static Map<String, String> pokemons = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        for (int pokemonIdx = 1; pokemonIdx <= N; ++pokemonIdx) {
            String pokemon = scanner.nextLine();
            pokemons.put(String.valueOf(pokemonIdx), pokemon);
            pokemons.put(pokemon, String.valueOf(pokemonIdx));
        }

        for (int resultIdx = 0; resultIdx < M; ++resultIdx) {
            String key = scanner.nextLine();
            System.out.println(pokemons.get(key));
        }
    }
}
