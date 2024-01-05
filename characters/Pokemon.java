package characters;
import java.util.Random;

public class Pokemon {
    

    // Attributes for the Pokemon
    private int life;
    private int attack;
    private int defense;
    public String name;

    // Getters
    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        int Life = random.nextInt(50) + 1;

        return Life;   
    }

    public int enemyHead(){
        
        Random random = new Random();
        int Life = random.nextInt(100) + 1;

        return Life;   
    }
    
}