package game;

import java.util.Scanner;
import java.lang.String;
import java.util.HashMap;
import java.util.Random;

public class Game {
    //Creating the player
    static Player player1 = new Player();
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        HashMap<String,Room> roomList = new HashMap<String,Room>();
        HashMap<String,Item> itemList = new HashMap<String,Item>();
        HashMap<String,Enemy> enemyList = new HashMap<String,Enemy>();

        //Creating rooms
        for(int x = 1; x <= 10; x++) {
            Room xx = new Room();
            xx.setName("Room" + x);
            roomList.put(xx.getName(), xx);
        }
        //Creating room information
        roomList.get("Room1").southRoom = roomList.get("Room2");
        roomList.get("Room1").setDescription("You're in a dark cell in the bottom of some sort of dungeon.Strangely,the cell door to the south is unlocked.");

        roomList.get("Room2").northRoom = roomList.get("Room1");
        roomList.get("Room2").westRoom = roomList.get("Room3");
        roomList.get("Room2").setDescription("This room has a pedestal with neon arrows pointing to the top of it.There are signs saying,'grab this.'");

        roomList.get("Room3").eastRoom = roomList.get("Room2");
        roomList.get("Room3").southRoom = roomList.get("Room4");
        roomList.get("Room3").setDescription("This room is entirely filled with dirt and has a molehill in the middle.");

        roomList.get("Room4").westRoom = roomList.get("Room5");
        roomList.get("Room4").northRoom = roomList.get("Room3");
        roomList.get("Room4").eastRoom = roomList.get("Room6");
        roomList.get("Room4").southRoom = roomList.get("Room7");
        roomList.get("Room4").setDescription("You are in some kind of weapons factory. There are 4 exits to this room.");

        roomList.get("Room5").eastRoom = roomList.get("Room4");
        roomList.get("Room5").southRoom = roomList.get("Room7");
        roomList.get("Room5").setDescription("");

        roomList.get("Room6").westRoom = roomList.get("Room4");
        roomList.get("Room6").southRoom = roomList.get("Room8");

        roomList.get("Room7").westRoom = roomList.get("Room5");
        roomList.get("Room7").southRoom = roomList.get("Room9");
        roomList.get("Room7").eastRoom = roomList.get("Room8");
        roomList.get("Room7").northRoom = roomList.get("Room4");

        roomList.get("Room8").westRoom = roomList.get("Room7");
        roomList.get("Room8").northRoom = roomList.get("Room6");
        roomList.get("Room8").southRoom = roomList.get("Room10");

        roomList.get("Room9").northRoom = roomList.get("Room7");

        roomList.get("Room10").northRoom = roomList.get("Room8");

        //Creating items
        Item missile = new Item();
        missile.setName("missile");

        Item key = new Item();
        key.setName("key");

        Item cleats = new Item();
        cleats.setName("cleats");

        //Creating item information
        itemList.put(missile.getName(),missile);
        roomList.get("Room2").addItem(missile.getName(),missile);
        missile.setDescription("There is a missile launcher laying conveniently on the pedestal that you can use to shoot at things.");

        itemList.put(key.getName(),key);
        roomList.get("Room5").addItem(key.getName(),key);
        key.setDescription("There is a small key that can be used to unlock doors.");

        itemList.put(cleats.getName(),cleats);
        roomList.get("Room5").addItem(cleats.getName(),cleats);
        cleats.setDescription("There is a pair of cleats with very sharp spikes on the bottom.");

        //Creating enemies
        Enemy mole = new Enemy();
        mole.name = ("mole");

        //Creating enemy information
        mole.health = 30;
        mole.power = 1;
        mole.setDescription("There is a weak, but grumpy mole in the room that doesn't like you very much.");
        enemyList.put(mole.getName(),mole);
        roomList.get("Room3").addEnemy(mole.getName(),mole);
        mole.setCurrentRoom(roomList.get("Room3"));

        //Creating player information
        player1.name = "Carson";
        player1.setCurrentRoom(roomList.get("Room1"));
        player1.setHealth(30);

        //Where game starts
        System.out.println("One day you come into existence.You don't know anything about who you are, or where you are(unless you've played this before). You do have some really cool looking mechanical arms though.(Type 'help' to see commands you can do.)");
        while(true) {
            player1.getCurrentRoom().printDescription();
            player1.getCurrentRoom().printItems();
            player1.getCurrentRoom().printEnemies();
            System.out.println(">> ");
            String input = s.nextLine();
            String[] words = input.split(" ");
            String command = words[0];
            String modifier = null;
            if (words.length > 1) {
                modifier = words[1];
            }
            
            //Creating commands player can use
            if(command.equals("quit")) {
                s.close();
                System.exit(0);
            } 
            else if(command.equals("help")) {
                System.out.println("Command List: go (letter of cardinal direction), grab (item), drop (item), fight, quit");
            } 
            else if(command.equals("go")) {
                if(modifier.equals("n")) {
                    player1.move("n");
                }
                else if(modifier.equals("s")) {
                    player1.move("s");
                }
                else if(modifier.equals("w")) {
                    player1.move("w");
                }
                else if(modifier.equals("e")) {
                    player1.move("e");
                }
            } 
            else if(command.equals("grab")) {
                player1.grab(modifier);
            } 
            else if(command.equals("drop")) {
                player1.drop(modifier);                
            } 

            else if(command.equals("fight")) {
                if(player1.currentRoom.getEnemy(modifier) != null) {

                    //When fight begins
                    System.out.println("You are attacked by the " + player1.currentRoom.getEnemy(modifier).getName() + "!");
                    while(player1.currentRoom.getEnemy(modifier).health > 0 && player1.getHealth() > 0) {

                        //Player's turn
                        System.out.println("What do you do?");
                        System.out.println(">> ");
                        String fightCommand = s.nextLine();

                        //Creating player actions
                        if(fightCommand.equals("punch")) {
                            player1.setPower(r.nextInt(6));
                            System.out.println("You punched the enemy for " + player1.getPower() + " damage!");
                        }
                        player1.currentRoom.getEnemy(modifier).health -= player1.getPower();
                        player1.setPower(0);
                        
                        //Enemy's turn
                        if(player1.currentRoom.getEnemy(modifier).health > 0) {
                            if(player1.currentRoom.getEnemy(modifier) == mole) {
                                int attack = r.nextInt(4);
                                if(attack == 3) {
                                    mole.setPower(r.nextInt(10) + 5);
                                    System.out.println("The mole attacks you with a giant drill and deals " + mole.getPower() + " damage!");
                                } else {
                                    mole.setPower(r.nextInt(6));
                                    System.out.println("The mole swipes its claws and deals " + mole.getPower() + " damage!");
                                }
                            }
                            player1.health -= player1.currentRoom.getEnemy(modifier).getPower();
                        }
                    }
                    //Fight ends
                    if(player1.health <= 0) {
                        System.out.println("Your health has dropped to 0!");
                    } else {
                        System.out.println("You defeated the enemy!");
                        player1.currentRoom.removeEnemy(player1.currentRoom.getEnemy(modifier).getName());
                    }
                }
            }
        }
    }
}