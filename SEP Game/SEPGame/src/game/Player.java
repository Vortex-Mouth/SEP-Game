package game;

import java.util.HashMap;

public class Player {
   public String name;
   protected Room currentRoom;
   protected HashMap<String,Item> itsItems = new HashMap<String,Item>();

   /*public void Player() {
    itsItems = new HashMap<String,Item>(); 
   }*/

   public void addItem(String pString, Item pItem) {
        itsItems.put(pString,pItem);
   }
   public void removeItem(String pString) {
        itsItems.remove(pString);
   }
   public Item getItem(String pString) {
        return itsItems.get(pString);
   }

   public void move(String direction) {
        if(direction == "n") {
            if(currentRoom.northRoom != null) {
                currentRoom = currentRoom.northRoom;
            }
        } else if(direction == "s") {
            if(currentRoom.southRoom != null) {
                currentRoom = currentRoom.southRoom;
            }
        } else if(direction == "w") {
            if(currentRoom.westRoom != null) {
                currentRoom = currentRoom.westRoom;
            }
        } else if(direction == "e") {
            if(currentRoom.eastRoom != null) {
                currentRoom = currentRoom.eastRoom;
            }
        }

        System.out.println("Room = " + currentRoom.name);
   }

   public void grab(String item) {
       if(currentRoom.getItem(item) != null) {
            itsItems.put(item, currentRoom.getItem(item));
            currentRoom.removeItem(item);
            System.out.println("you grabbed the " + item + "!");
       }
       else {
           System.out.println("There is no " + item + " here.");
       }
   }
   public void drop(String item) {
       if(itsItems.get(item) != null) {
            currentRoom.addItem(item, itsItems.get(item));
            itsItems.remove(item);
            System.out.println("you dropped the " + item + "!");
       }
       else {
           System.out.println("You don't have that!");
       }
   }

   public Room getCurrentRoom() {
       return currentRoom;
   }
   public void setCurrentRoom(Room pRoom) {
       currentRoom = pRoom;
   }
}