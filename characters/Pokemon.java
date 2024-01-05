package characters;

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
}