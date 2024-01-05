import java.util.Scanner;
import java.lang.Math;

public class Main {
    
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        characters.Pokemon pokemon = new characters.Pokemon();
        characters.enemyPokemon Nombre = new characters.enemyPokemon();

        final int max = 19, min = 0, range = max - min + 1;
        int aleatoryNumber = (int) (Math.random() * range) + min;

        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = kb.nextLine();
        pokemon.setName(enteredPokemonName);

        Nombre.Pokemos(aleatoryNumber);



    }

}