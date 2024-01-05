import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        characters.Pokemon pokemon = new characters.Pokemon();

        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = kb.nextLine();

        pokemon.setName(enteredPokemonName);
        System.out.println(pokemon.attack() + " with " + pokemon.getName());
    }

}
