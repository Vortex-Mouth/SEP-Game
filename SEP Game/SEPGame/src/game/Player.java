package game;

//import java.util.Scanner;
import java.util.HashMap;

public class Player {
   public String name;
   protected Room currentRoom;
   protected int health;
   protected int power;
   protected HashMap<String,Item> itsItems = new HashMap<String,Item>();
   
   String room1 = "Room1";
   String room2 = "Room2";
   String room3 = "Room3";
   String room4 = "Room4";
   String room5 = "Room5";
   String room6 = "Room6";
   String room7 = "Room7";
   String room8 = "Room8";
   String room9 = "Room9";
   String room10 = "Room10";
   

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

   public void move(String direction) {
        if(direction == "n") {
            if(currentRoom.northRoom != null) {
                currentRoom = currentRoom.northRoom;
            } else {
                System.out.println("You smash your face against a wall.");
            }
        } else if(direction == "s") {
            if(currentRoom.southRoom != null) {
                currentRoom = currentRoom.southRoom;
            } else {
                System.out.println("You smash your face against a wall.");
            }
        } else if(direction == "w") {
            if(currentRoom.westRoom != null) {
                currentRoom = currentRoom.westRoom;
            } else {
                System.out.println("You smash your face against a wall.");
            }
        } else if(direction == "e") {
            if(currentRoom.eastRoom != null) {
                currentRoom = currentRoom.eastRoom;
            } else {
                System.out.println("You smash your face against a wall.");
            }
        }

        System.out.println("Room = " + currentRoom.name);
   }

   public void grab(String item) {
       if(currentRoom.getItem(item) != null) {
            itsItems.put(item, currentRoom.getItem(item));
            currentRoom.removeItem(item);
            System.out.println("You grabbed the " + item + "!");
       }
       else {
           System.out.println("There is no " + item + " here.");
       }
   }
   public void drop(String item) {
       if(itsItems.get(item) != null) {
            currentRoom.addItem(item, itsItems.get(item));
            itsItems.remove(item);
            System.out.println("You dropped the " + item + "!");
       }
       else {
           System.out.println("You don't have that!");
       }
   }

   public void use(String item) {
       if(itsItems.get(item) != null) {
           Item useableItem = new Item();
           if(useableItem.getName() == itsItems.get("drill").getName() && currentRoom.getName() == room4) {

           }
       }
   }

   /*public void fight(String enemy) {
       Scanner s = new Scanner(System.in);

       if(currentRoom.getEnemy(enemy) != null) {
           System.out.println("What do you do?");
           System.out.println(">> ");
           String input = s.nextLine();
           String[] words = input.split(" ");
           String command = words[0];
           if(input.equals("punch")) {
               player1.setPower(1);
           }
       }
   }*/

   public Room getCurrentRoom() {
       return currentRoom;
   }
   public void setCurrentRoom(Room pRoom) {
       currentRoom = pRoom;
   }
}