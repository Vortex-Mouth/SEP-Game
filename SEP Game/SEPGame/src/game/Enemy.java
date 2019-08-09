package game;

public class Enemy {
    public String name;
    public String description;
    public int health;
    public int power;

    public String getName() {
        return name;
    } 
    /*public void setName(String pString) {
        name = pString;
    }*/

    public void printDescription() {
        System.out.println(description);
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public String getDescription() {
        return description;
    }
}