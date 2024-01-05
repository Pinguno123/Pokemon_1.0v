package characters;
import java.util.Random;

public class enemyPokemon extends Pokemon {
    
    public String Pokemos (int EnemyNumber){
        String[] pokemons = {"Pikachu","Charizard","Bulbasaur","Squirtle","Jigglypuff","Meowth","Psyduck","Eevee"
        ,"Snorlax","Mewtwo","Mew","Gengar","Lapras","Gyarados","Alakazam","Vulpix","Ninetales","Machamp","Raichu","Golem",};
        
        String enemyname = pokemons[EnemyNumber];

        return enemyname;
    }

    public int enemyAttack(){
        
        Random random = new Random();
        int Attack = random.nextInt(100) + 1;

        return Attack;   
    }

    public int enemyLife(){
        
        Random random = new Random();
        int Life = random.nextInt(500) + 1;

        return Life;   
    }

    public int enemyBuff(){
        
        Random random = new Random();
        int Life = random.nextInt(500) + 1;

        return Life;   
    }

    public int enemy(){
        
        Random random = new Random();
        int Life = random.nextInt(500) + 1;

        return Life;   
    }


    /*
    vida 500
    ataque 100

    Curacion
    potenciacion (mas ataque)
     */
    
}
