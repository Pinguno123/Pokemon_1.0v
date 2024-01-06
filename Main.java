import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Variables for the loop
        boolean isBattleOngoing = true;
        boolean healOption = true;
        boolean healEnemyOption = true;
        int contador = 1;
        int contadorbuff = 0;
        int contadorbuffO = 0;

        // Constanst for the attack menu
        final int ATTACK_OPTION = 1;
        final int BUFF_OPTION = 2;
        final int HEAL_OPTION = 3;

        // Constants for the attack options
        final String ENEMY_LIFE_STATUS = ", now the life of your opponent is ";
        final String MY_LIFE_STATUS = ", now your life is ";

        // Objects are created
        Scanner keyboard = new Scanner(System.in); // Keyboard object b
        characters.Pokemon pokemon = new characters.Pokemon(); // Father Pokemon class object
        characters.Pokemon enemyPokemon = new characters.Pokemon(); // Enemy Pokemon class object
        Random numberGenerator = new Random(); // Random numer generator object

        // Returns a random value between 0 and 19 to get a random Pokémon name
        int aleatoryNumber = numberGenerator.nextInt(19);

        // Create the name for your Pokémon
        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = keyboard.nextLine();
        pokemon.setName(enteredPokemonName);

        // Initializations for enemy Pokémon stats
        int enemyAttack = enemyPokemon.enemyAttack();
        int enemyLife = enemyPokemon.enemyLife();
        int enemybuff = enemyPokemon.enemyBuff();
        int enemyheal = enemyPokemon.enemyHead();
        String enemyName = enemyPokemon.Pokemos(aleatoryNumber);

        // Initializations for the player Pokémon stats
        int myPokemonAttack = enemyPokemon.enemyAttack();
        int myPokemonLife = enemyPokemon.enemyLife();
        int myPokemonbuff = enemyPokemon.enemyBuff();
        int myPokemonheal = enemyPokemon.enemyHead();
        String myPokemonName = pokemon.getName();

        // The presentation of the computer character
        System.out.println("\nYour enemy will be " + enemyName);
        System.out.println("Life: " + enemyLife + "\nAttack: " + enemyAttack);

        // The presentation of the player character
        System.out.println("\nYour pokemon is " + myPokemonName);
        System.out.println("Life: " + myPokemonLife + "\nAttack: " + myPokemonAttack + "\nBuff: " + myPokemonbuff);

        // The fight system
        do {
            // Check if either Pokémon has lost all its life
            if ((enemyLife <= 0) || (myPokemonLife <= 0)) {
                isBattleOngoing = false; // If one of the Pokémon has lost, end the fight
            } else {
                if (contador % 2 != 0) { // Your turn
                    System.out.println("\nChoose an attack option" + "\n" + ATTACK_OPTION + ". Attack" + "\n"
                            + BUFF_OPTION + ". Buff" + "\n" + HEAL_OPTION + ". Heal");
                    System.out.print("Choosed option: ");
                    int option = keyboard.nextInt();

                    System.out.println("\n" + myPokemonName + " turn... ");

                    switch (option) {
                        case ATTACK_OPTION:

                            enemyLife -= myPokemonAttack;
                            System.out.println("You have attacked" + ENEMY_LIFE_STATUS + enemyLife);
                            break;

                        case BUFF_OPTION:

                            if (contadorbuff == 3) {

                                enemyLife -= (myPokemonbuff + myPokemonAttack); // Attack to the computer Pokémon
                                System.out.println("You have used a strong attack" + ENEMY_LIFE_STATUS + enemyLife); // Print the new enemy health
                                contadorbuff = -1; // Reset the buff counter after using it three times

                            } else { // If are not enough buff to use, just attack

                                enemyLife -= myPokemonAttack; // Attack to the computer Pokémon
                                System.out.println("You do not have any buff left" + ENEMY_LIFE_STATUS + enemyLife); // Print the new enemy health

                            }
                            break;
                        case HEAL_OPTION:

                            if (healOption) {

                                myPokemonLife += myPokemonheal; // The player's Pokémon is healed
                                System.out.println("You have healed yourself" + MY_LIFE_STATUS + myPokemonLife); // Print the new health
                                healOption = false; // Disable the heal option after using it once

                            } else { // If are not enough health to use print an error message

                                System.out.println("Your don't have more heal");
                                contador++; // Increment the counter to set the turn again

                            }
                            break;
                        default:
                            contador++;
                            break;
                    }
                    contadorbuff++;
                    contador++;
                } else { // Enemy's turn
                    int enemyOp = numberGenerator.nextInt(3) + 1;

                    System.out.println("\n" + enemyName + " turn... ");

                    switch (enemyOp) {
                        case 1:
                            // Enemy's attack
                            myPokemonLife -= enemyAttack;
                            System.out.println(enemyName + " attacked, now your life is " + myPokemonLife);
                            break;
                        case 2:
                            // Enemy's buff
                            if (contadorbuffO == 3) {
                                myPokemonLife -= (enemyAttack + enemybuff);
                                System.out
                                        .println(enemyName + " used a strong attack" + MY_LIFE_STATUS + myPokemonLife);
                                contadorbuffO = -1; // Reset the enemy's buff counter after using it three times
                            } else {
                                myPokemonLife -= enemyAttack;
                                System.out.println(enemyName + " has no buff left" + MY_LIFE_STATUS + myPokemonLife);
                            }
                            break;
                        case 3:
                            // Enemy's heal
                            if (healEnemyOption) {

                                enemyLife += enemyheal;
                                System.out.println("Your enemy was used the heal ability and his life is " + enemyLife);
                                healEnemyOption = false; // Disable the enemy's heal option after using it once

                            } else {

                                System.out.println("Your enemy can not use the heal ability, it is his turn again");
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
            System.out.println("\nYou lost against " + enemyName);
        }

        keyboard.close();
    }
}