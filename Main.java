import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Variables for the loop
        boolean isBattleOngoing = true, healOption = true;
        int contador = 1, contadorbuff = 0, contadorbuffO = 0;

        final int ATTACK_OPTION = 1, BUFF_OPTION = 2, HEAL_OPTION = 3;

        // Objects are created
        Scanner keyboard = new Scanner(System.in); // Keyboard
        characters.Pokemon pokemon = new characters.Pokemon(); // Father Pokemon class
        characters.Pokemon enemyPokemon = new characters.Pokemon(); // Enemy Pokemon class

        // Random number for a random Pokémon
        final int max = 19, min = 0, range = max - min + 1;
        int aleatoryNumber = (int) (Math.random() * range) + min;

        // Create the name for your Pokémon
        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = keyboard.nextLine();
        pokemon.setName(enteredPokemonName);

        // Initializations for enemy and user Pokemon stats
        int enemyAttack = enemyPokemon.enemyAttack();
        int enemyLife = enemyPokemon.enemyLife();
        int enemybuff = enemyPokemon.enemyBuff();
        int enemyheal = enemyPokemon.enemyHead();
        int MyPokemonAttack = enemyPokemon.enemyAttack();
        int MyPokemonLife = enemyPokemon.enemyLife();
        int MyPokemonbuff = enemyPokemon.enemyBuff();
        int MyPokemonheal = enemyPokemon.enemyHead();

        // The fight starts
        System.out.println("\nYour enemy will be " + enemyPokemon.Pokemos(aleatoryNumber));
        System.out.println("Life: " + enemyLife + "\nAttack: " + enemyAttack);

        System.out.println("\nYour pokemon is " + pokemon.getName() + "\nLife: " + MyPokemonLife + "\nAttack: "
                + MyPokemonAttack + "\nBuff: " + MyPokemonbuff);

        // The fight system
        do {
            // Check if either Pokémon has lost all its life
            if ((enemyLife <= 0) || (MyPokemonLife <= 0)) {
                isBattleOngoing = false; // If one of the Pokémon has lost, end the fight
            } else {
                if (contador % 2 != 0) { // Your turn
                    System.out.println("\nChoose an attack option" + "\n" + ATTACK_OPTION + ". Attack" + "\n" + BUFF_OPTION + ". Buff" + "\n" + HEAL_OPTION + ". Heal");
                    int option = keyboard.nextInt();

                    switch (option) {
                        case ATTACK_OPTION:
                            // Attack
                            enemyLife -= MyPokemonAttack;
                            System.out.println("\nThe life of your opponent is " + enemyLife);
                            break;
                        case BUFF_OPTION:
                            // Buff
                            if (contadorbuff == 3) {
                                enemyLife -= (MyPokemonbuff + MyPokemonAttack);
                                System.out.println("\nThe life of your opponent is " + enemyLife);
                                contadorbuff = -1; // Reset the buff counter after using it three times
                            } else {
                                enemyLife -= MyPokemonAttack;
                                System.out.println("\nThe life of your opponent is " + enemyLife);
                            }
                            break;
                        case HEAL_OPTION:
                            // Heal
                            if (healOption) {
                                MyPokemonLife += MyPokemonheal;
                                System.out.println("\nYour life is " + MyPokemonLife);
                                healOption = false; // Disable the heal option after using it once
                            } else {
                                System.out.println("Your don't have more heal");
                                contador++;
                            }
                            break;
                        default:
                            contador++;
                            break;
                    }
                    contadorbuff++;
                    contador++;
                } else { // Enemy's turn
                    Random enemyOption = new Random();
                    int enemyOp = enemyOption.nextInt(3) + 1;

                    switch (enemyOp) {
                        case 1:
                            // Enemy's attack
                            MyPokemonLife -= enemyAttack;
                            System.out.println("Your life is " + MyPokemonLife);
                            break;
                        case 2:
                            // Enemy's buff
                            if (contadorbuffO == 3) {
                                MyPokemonLife -= (enemyAttack + enemybuff);
                                System.out.println("\nYour life is " + MyPokemonLife);
                                contadorbuffO = -1; // Reset the enemy's buff counter after using it three times
                            } else {
                                MyPokemonLife -= enemyAttack;
                                System.out.println("\nYour life is " + MyPokemonLife);
                            }
                            break;
                        case 3:
                            // Enemy's heal
                            if (healOption) {
                                enemyLife += enemyheal;
                                System.out
                                        .println("\nYour enemy was used the heal ability and his life is " + enemyLife);
                                healOption = false; // Disable the enemy's heal option after using it once
                            } else {
                                contador++;
                            }
                            break;
                        default:
                            contador++;
                            break;
                    }
                    contador++;
                    contadorbuffO++;
                }
            }
        } while (isBattleOngoing);

        if (enemyLife <= 0) {
            System.out.println("\nCongratulation you won!!!!!");
        } else {
            System.out.println("\nYou lost against " + enemyPokemon.Pokemos(aleatoryNumber));
        }
        keyboard.close();
    }
}