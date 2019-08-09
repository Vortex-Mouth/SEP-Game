package game;

import java.util.*;
import java.lang.String;

public class Room {
    public String name;
    protected String description;
    protected HashMap<String,Item> itsItems = new HashMap<String,Item>();
    protected HashMap<String,Enemy> itsEnemies = new HashMap<String,Enemy>();
    public Room northRoom;
    public Room southRoom;
    public Room westRoom;
    public Room eastRoom;

    /*public void Room() {
        itsItems = new HashMap<String,Item>(); 
    }*/

    public String getName() {
        return name;
    }
    public void setName(String pString) {
        name = pString;
    }

    public void addItem(String pString, Item pItem) {
        itsItems.put(pString,pItem);
    }
    public void removeItem(String pString) {
        itsItems.remove(pString);
    }
    public Item getItem(String pString) {
        return itsItems.get(pString);
    }

    public void addEnemy(String pString, Enemy pEnemy) {
        itsEnemies.put(pString,pEnemy);
    }
    public void removeEnemy(String pString) {
        itsEnemies.remove(pString);
    }
    public Enemy getEnemy(String pString) {
        return itsEnemies.get(pString);
    }

    public void printDescription() {
        System.out.println(description);
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }

    public void printItems() { 
        Iterator<Map.Entry<String,Item>> itemIterator = itsItems.entrySet().iterator(); 
   
        System.out.println("Items in room: "); 
  
        while (itemIterator.hasNext()) { 
            Map.Entry<String,Item> mapElement = (Map.Entry<String,Item>)itemIterator.next(); 
            Item item = (Item)mapElement.getValue();
            System.out.println((String)mapElement.getKey() + " : " + item.getDescription()); 
        } 
    }
}