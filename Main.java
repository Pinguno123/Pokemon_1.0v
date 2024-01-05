import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        // Variables for the loop
        boolean pelea = true, heal = true, healO = true;
        int contador = 1, contadorbuff = 0, contadorbuffO = 0; 

        Scanner kb = new Scanner(System.in);
        characters.Pokemon pokemon = new characters.Pokemon();
        characters.Pokemon enemyPokemon = new characters.Pokemon();

        final int max = 19, min = 0, range = max - min + 1;
        int aleatoryNumber = (int) (Math.random() * range) + min;

        System.out.println("Enter the name of your Pokémon ");
        String enteredPokemonName = kb.nextLine();
        pokemon.setName(enteredPokemonName);

        int enemyAttack = enemyPokemon.enemyAttack();
        int enemyLife = enemyPokemon.enemyLife();
        int enemybuff = enemyPokemon.enemyBuff();
        int enemyheal = enemyPokemon.enemyHead();
        int MyPokemonAttack = enemyPokemon.enemyAttack();
        int MyPokemonLife = enemyPokemon.enemyLife();
        int MyPokemonbuff = enemyPokemon.enemyBuff();
        int MyPokemonheal = enemyPokemon.enemyHead();

        System.out.println("\nYour enemy will be "+ enemyPokemon.Pokemos(aleatoryNumber));
        System.out.println("Life: " + enemyLife + "\nAttack: " + enemyAttack);

        System.out.println("\nYour pokemon is " + pokemon.getName() + "\nLife: " + MyPokemonLife + "\nAttack: " + MyPokemonAttack + "\nBuff: " + MyPokemonbuff);

    do {
        if((enemyLife <= 0) || (MyPokemonLife <= 0)){
                pelea = false;
        }
        else{
            if(contador % 2 != 0){ //Tu turno
                System.out.println("\nChoose an attack option"
                +"\n1.Attack"+"\n2.Buff"+"\n3.Heal");
                int option = kb.nextInt();

                switch (option) {
                    case 1:
                        //Attack
                        enemyLife -= MyPokemonAttack;
                        System.out.println("\nThe life of your opponet is "+enemyLife);
                        break;
                    case 2:
                        //Buff
                        if (contadorbuff == 3){
                            enemyLife -= (MyPokemonbuff+MyPokemonAttack);
                            System.out.println("\nThe life of your opponet is "+enemyLife);
                            contadorbuff = -1;

                        }
                        else{
                            enemyLife -= MyPokemonAttack;
                            System.out.println("\nThe life of your opponet is "+enemyLife);
                        }

                        break;
                    case 3:
                        //heal
                        if(heal){
                            MyPokemonLife += MyPokemonheal;
                            System.out.println("\nYour life is "+MyPokemonLife);
                            heal = false;
                        }
                        else{
                            System.out.println("Your don't have more heal");
                            contador++;
                        }
                        break;
                
                    default:
                        contador++;
                        break;
                }
            contadorbuff ++;
            contador++;
            }
            else{ //Turno del rival
                Random enemyOption = new Random();
                int enemyOp = enemyOption.nextInt(3) + 1;
                
                switch (enemyOp) {
                    case 1:
                        MyPokemonLife -= enemyAttack;
                        System.out.println("Your life is " + MyPokemonLife);
                        break;
                    case 2:
                        //Buff
                        if (contadorbuffO == 3){
                            MyPokemonLife -= (enemyAttack + enemybuff);
                            System.out.println("\nYour life is "+MyPokemonLife);
                            contadorbuffO = -1;
                        }
                        else{
                            MyPokemonLife -= enemyAttack;
                            System.out.println("\nYour life is "+MyPokemonLife);
                            
                        }
                        break;
                    case 3:
                        //Heal
                        if(healO){
                            enemyLife += enemyheal;
                            System.out.println("\nYour enemy was used the heal ability and his life is "+enemyLife);
                            healO = false;
                        }
                        else{
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
    } while (pelea);
    
    if(enemyLife <=0){
        System.out.println("\nCongratulation you won!!!!!");
    }
    else{
        System.out.println("\nYou lost against " + enemyPokemon.Pokemos(aleatoryNumber));
    }
    }
}