import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Variables for the loop
        boolean isBattleOngoing = true;
        boolean healOption = true;
        int contador = 1;
        int contadorbuff = 0;
        int contadorbuffO = 0;

        // Constanst for the attack menu
        final int ATTACK_OPTION = 1;
        final int BUFF_OPTION = 2;
        final int HEAL_OPTION = 3;

        // Objects are created
        Scanner keyboard = new Scanner(System.in); // Keyboard object
        characters.Pokemon pokemon = new characters.Pokemon(); // Father Pokemon class object
        characters.Pokemon enemyPokemon = new characters.Pokemon(); // Enemy Pokemon class object
        Random r = new Random(); // Random numer generator object
        Random enemyOption = new Random(); // Enemy option generator object

        // Returns a random value between 0 and 19 to get a random Pokémon name
        int aleatoryNumber = r.nextInt(19);

        // Create the name for your Pokémon
        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = keyboard.nextLine();
        pokemon.setName(enteredPokemonName);

        // Initializations for enemy Pokémon stats
        int enemyAttack = enemyPokemon.enemyAttack();
        int enemyLife = enemyPokemon.enemyLife();
        int enemybuff = enemyPokemon.enemyBuff();
        int enemyheal = enemyPokemon.enemyHead();

        // Initializations for the player Pokémon stats
        int myPokemonAttack = enemyPokemon.enemyAttack();
        int myPokemonLife = enemyPokemon.enemyLife();
        int myPokemonbuff = enemyPokemon.enemyBuff();
        int myPokemonheal = enemyPokemon.enemyHead();

        // The presentation of the computer character
        System.out.println("\nYour enemy will be " + enemyPokemon.Pokemos(aleatoryNumber));
        System.out.println("Life: " + enemyLife + "\nAttack: " + enemyAttack);

        // The presentation of the player character
        System.out.println("\nYour pokemon is " + pokemon.getName());
        System.out.println("\nLife: " + myPokemonLife + "\nAttack: " + myPokemonAttack + "\nBuff: " + myPokemonbuff);

        // The fight system
        do {
            // Check if either Pokémon has lost all its life
            if ((enemyLife <= 0) || (myPokemonLife <= 0)) {
                isBattleOngoing = false; // If one of the Pokémon has lost, end the fight
            } else {
                if (contador % 2 != 0) { // Your turn
                    System.out.println("\nChoose an attack option" + "\n" + ATTACK_OPTION + ". Attack" + "\n"
                            + BUFF_OPTION + ". Buff" + "\n" + HEAL_OPTION + ". Heal");
                    int option = keyboard.nextInt();

                    switch (option) {
                        case ATTACK_OPTION:
                            // Attack
                            enemyLife -= myPokemonAttack;
                            System.out.println("\nThe life of your opponent is " + enemyLife);
                            break;
                        case BUFF_OPTION:
                            // Buff
                            if (contadorbuff == 3) {
                                enemyLife -= (myPokemonbuff + myPokemonAttack);
                                System.out.println("\nThe life of your opponent is " + enemyLife);
                                contadorbuff = -1; // Reset the buff counter after using it three times
                            } else {
                                enemyLife -= myPokemonAttack;
                                System.out.println("\nThe life of your opponent is " + enemyLife);
                            }
                            break;
                        case HEAL_OPTION:
                            // Heal
                            if (healOption) {
                                myPokemonLife += myPokemonheal;
                                System.out.println("\nYour life is " + myPokemonLife);
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
                    int enemyOp = enemyOption.nextInt(3) + 1;

                    switch (enemyOp) {
                        case 1:
                            // Enemy's attack
                            myPokemonLife -= enemyAttack;
                            System.out.println("Your life is " + myPokemonLife);
                            break;
                        case 2:
                            // Enemy's buff
                            if (contadorbuffO == 3) {
                                myPokemonLife -= (enemyAttack + enemybuff);
                                System.out.println("\nYour life is " + myPokemonLife);
                                contadorbuffO = -1; // Reset the enemy's buff counter after using it three times
                            } else {
                                myPokemonLife -= enemyAttack;
                                System.out.println("\nYour life is " + myPokemonLife);
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