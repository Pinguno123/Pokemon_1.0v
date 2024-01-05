package characters;

public class enemyPokemon extends Pokemon {
    
    public String Pokemos (int EnemyNumber){
        String[] pokemons = {"Pikachu","Charizard","Bulbasaur","Squirtle","Jigglypuff","Meowth","Psyduck","Eevee"
        ,"Snorlax","Mewtwo","Mew","Gengar","Lapras","Gyarados","Alakazam","Vulpix","Ninetales","Machamp","Raichu","Golem",};
        
        String enemyname = pokemons[EnemyNumber];

        return enemyname;
    }
}
