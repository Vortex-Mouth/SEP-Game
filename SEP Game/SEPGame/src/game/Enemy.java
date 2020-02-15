package game;

public class Enemy {
    public String name;
    public String description;
    public String scan;
    protected Room currentRoom;
    protected int health;
    protected int power;

    public String getName() {
        return name;
    } 
    public void setName(String pString) {
        name = pString;
    }

    public void printDescription() {
        System.out.println(description);
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public String getDescription() {
        return description;
    }

    public void printScan() {
        System.out.println(scan);
    }
    public void setScan(String pScan) {
        scan = pScan;
    }
    public String getScan() {
        return scan;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room pRoom) {
        currentRoom = pRoom;
    }

    public void printHealth() {
        System.out.println(health);
    }
    public void setHealth(int pHealth) {
        health = pHealth;
    }
    public int getHealth() {
        return health;
    }

    public void printPower() {
        System.out.println(power);
    }
    public void setPower(int pPower) {
        power = pPower;
    }
    public int getPower() {
        return power;
    }
}