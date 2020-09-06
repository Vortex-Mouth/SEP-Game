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
        roomList.get("Room5").setDescription("You are in a very foreboding mechanical room.");

        roomList.get("Room6").westRoom = roomList.get("Room4");
        roomList.get("Room6").setDescription("You are in a very dark room. It needs to be lit in order to do anything in here.");

        roomList.get("Room7").westRoom = roomList.get("Room5");
        roomList.get("Room7").southRoom = roomList.get("Room9");
        roomList.get("Room7").eastRoom = roomList.get("Room8");
        roomList.get("Room7").northRoom = roomList.get("Room4");
        roomList.get("Room7").setDescription("You're in.....space? To the south are celestial objects,to the east is a manmade object,to the north is a planet with the factory from before.");

        roomList.get("Room8").westRoom = roomList.get("Room7");
        roomList.get("Room8").southRoom = roomList.get("Room10");
        roomList.get("Room8").setDescription("You have arrived at a space station.");

        roomList.get("Room9").northRoom = roomList.get("Room7");
        roomList.get("Room9").setDescription("You are now in deeper space and surrounded by stars that should be burning you right now, but I didn't feel like programming...I mean what?");

        roomList.get("Room10").northRoom = roomList.get("Room8");
        roomList.get("Room10").setDescription("Welcome to my throne room.If you know my name,type it when giving a command and I will let you reach the end of this game.Otherwise you will face the terrible fate of DISSATISFACTION!");
        

        //Creating items
        Item missileLauncher = new Item();
        missileLauncher.setName("missile launcher");

        Item key = new Item();
        key.setName("key");

        Item drill = new Item();
        drill.setName("drill");

        Item fire = new Item();
        fire.setName("fire");

        Item ice = new Item();
        ice.setName("ice");

        //Creating item information
        itemList.put(missileLauncher.getName(),missileLauncher);
        roomList.get("Room2").addItem(missileLauncher.getName(),missileLauncher);
        missileLauncher.setDescription("You picked up the missile launcher laying conveniently on the pedestal. You can use it to shoot at enemies and shatter certain things.(When using, just type 'missile')");

        itemList.put(key.getName(),key);
        key.setDescription("You pick up a small key Frank dropped. It can be used to unlock doors.");

        itemList.put(drill.getName(),drill);
        drill.setDescription("You pick up the mole's drill. It's a sharp tool useful in certain situations where other items are useless.");

        itemList.put(fire.getName(),fire);

        itemList.put(ice.getName(),ice);

        //Creating enemies
        Enemy mole = new Enemy();
        mole.setName("mole");

        Enemy frank = new Enemy();
        frank.setName("frank");

        Enemy moon = new Enemy();
        moon.setName("moon");

        Enemy sun = new Enemy();
        sun.setName("sun");

        Enemy carson = new Enemy();
        carson.setName("carson");

        //Creating enemy information
        mole.setHealth(30);
        mole.setDescription("There is a weak, but grumpy mole in the room that doesn't like you very much.");
        mole.setScan("Giant unnecessarily hostile mole. Uses claws and a powerful drill for attacking. Odds are against you unless you have a more powerful weapon than your fists.");
        enemyList.put(mole.getName(),mole);
        roomList.get("Room3").addEnemy(mole.getName(),mole);

        frank.setHealth(100);
        frank.setDescription("There is a strange robot saying, 'I MUST ELMINATE THE 16TH & 17TH AMENDMENTS!'");
        frank.setScan("Robot resembling a teenage boy with glasses. Attacks with the 1st & 2nd amendments and protects himself with the free market economy. The strongest weapon against him is one that will make it get the point the fastest.");
        enemyList.put(frank.getName(),frank);
        roomList.get("Room5").addEnemy(frank.getName(),frank);

        moon.setHealth(85);
        moon.setDescription("There is a moon about twice your body size with a disapproving face.");
        moon.setScan("This cold moon uses ice and meteor-based attacks. Its icy surface protects against all damage against the soft & breakable ground underneath. The ice can be broken by a certain weapon.");
        enemyList.put(moon.getName(),moon);
        roomList.get("Room9").addEnemy(moon.getName(),moon);

        sun.setHealth(85);
        sun.setDescription("There is a sun about twice your body size with an extremely angry face.");
        sun.setScan("This small star uses fire and heat-based atacks. It surprisingly doesn't have any resistances, but it also doesn't have any particular weaknesses.");
        enemyList.put(sun.getName(),sun);
        roomList.get("Room9").addEnemy(sun.getName(),sun);

        carson.setHealth(300);
        carson.setDescription("So you know who I am. I am the creator of everything you have seen. The purpose of all of it is to create a project that challenges and builds my skills. However, I need this game to serve some sort of purpose to get a good grade. That purpose is defeating me. Can you grant me an A+ performance?");
        carson.setScan("Why would I tell you my own weaknesses? Figure it out casual!");
        enemyList.put(carson.getName(),carson);

        //Creating player information
        player1.name = "Guy";
        player1.setCurrentRoom(roomList.get("Room1"));
        player1.setPrevRoom(roomList.get("Room1"));
        player1.setHealth(30);
        int maxHealth = player1.getHealth();

        //Puzzle/item/enemy status
        boolean dirtInSouth = true;
        boolean dirtInWest = true;
        boolean keyDoorOpen = false;
        boolean fireWall = true;

        boolean powerPunch = false;
        boolean healingItemGot = false;
        boolean missileGot = false;

        boolean iceShield = true;
        String carsonMode = "normal";

        //Where game starts
        System.out.println("One day you come into existence.You don't know anything about who you are, or where you are(unless you've played this before). You do have some really cool looking mechanical arms though.(Type 'help' to see commands you can do.)");
        while(true) {
            if(player1.getCurrentRoom().getEnemy("carson") == null) {
                player1.getCurrentRoom().printDescription();
            }
            if(player1.getCurrentRoom() == roomList.get("Room2") && missileGot == false) {
                missileLauncher.printDescription();
                player1.addItem("missile", missileLauncher);
                missileGot = true;
            }
            player1.getCurrentRoom().printEnemies();

            //Enemy fight begins
            if(player1.getCurrentRoom().getEnemy("mole") != null || player1.getCurrentRoom().getEnemy("frank") != null || player1.getCurrentRoom().getEnemy("moon") != null || player1.getCurrentRoom().getEnemy("carson") != null) {
                String enemy = " ";
                String enemy2 = " ";
                String defeatedEnemy = " ";

                //Figuring out which enemy it is
                if(player1.getCurrentRoom().getEnemy("mole") != null) {
                    enemy = "mole";
                } else if(player1.getCurrentRoom().getEnemy("frank") != null) {
                    enemy = "frank";
                } else if(player1.getCurrentRoom().getEnemy("moon") != null) {
                    enemy = "moon";
                    enemy2 = "sun";
                } else if(player1.getCurrentRoom().getEnemy("carson") != null) {
                    enemy = "carson";
                }

                //When fight begins
                System.out.println("You are attacked by the " + enemy + "!");
                if(player1.getCurrentRoom().getEnemy(enemy2) != null) {
                    System.out.println("You are attacked by the " + enemy2 + "!");
                }
                while(player1.currentRoom.getEnemy(enemy) != null && player1.getHealth() > 0 || player1.currentRoom.getEnemy(enemy2) != null && player1.getHealth() > 0 ) {

                    //Player's turn
                    System.out.println("What do you do?");
                    System.out.println(">> ");
                    String fightInput = s.nextLine();
                    String[] words = fightInput.split(" ");
                    String fightCommand = words[0];
                    String targetEnemy = null;
                    if (words.length > 1) {
                       targetEnemy = words[1];
                    }

                    //Creating player actions
                    while(fightCommand.equals("help") || fightCommand.equals("status") || fightCommand.equals("scan")) {
                        if(fightCommand.equals("help")) {
                            System.out.println("punch (enemy), status, scan (enemy), (You can also attack by typing in one of your acquired items, like missile, and then the enemy's name afterwards)");
                            System.out.println("What do you do?");
                            System.out.println(">> ");
                            fightInput = s.nextLine();
                            words = fightInput.split(" ");
                            fightCommand = words[0];
                            if (words.length > 1) {
                                targetEnemy = words[1];
                             }
                        } else if(fightCommand.equals("status")) {
                            System.out.println("Your HP: " + player1.getHealth());
                            if(player1.currentRoom.getEnemy(enemy) != null) {
                                if(player1.currentRoom.getEnemy(enemy).getHealth() > 0) {
                                    System.out.println(player1.currentRoom.getEnemy(enemy).getName() + " HP: " + player1.currentRoom.getEnemy(enemy).health);
                                }
                            }
                            if(player1.currentRoom.getEnemy(enemy2) != null) {
                                if(player1.currentRoom.getEnemy(enemy2).getHealth() > 0) {
                                    System.out.println(player1.currentRoom.getEnemy(enemy2).getName() + " HP: " + player1.currentRoom.getEnemy(enemy2).health);
                                }
                            }
                            System.out.println("What do you do?");
                            System.out.println(">> ");
                            fightInput = s.nextLine();
                            words = fightInput.split(" ");
                            fightCommand = words[0];
                            if (words.length > 1) {
                                targetEnemy = words[1];
                             }
                        } else if(fightCommand.equals("scan")) {
                            System.out.println("You scan the enemy!");
                            System.out.println("Scan: ");
                            player1.currentRoom.getEnemy(targetEnemy).printScan();
                            System.out.println("What do you do?");
                            System.out.println(">> ");
                            fightInput = s.nextLine();
                            words = fightInput.split(" ");
                            fightCommand = words[0];
                            if (words.length > 1) {
                                targetEnemy = words[1];
                            }
                        }
                    }

                    //Player attacking options
                    if(fightCommand.equals("punch")) {
                        if(powerPunch == false) {
                            player1.setPower(r.nextInt(6) + 1);
                        } else {
                            if(player1.currentRoom.getEnemy(targetEnemy) == carson && carsonMode == "normal") {
                                player1.setPower(r.nextInt(36) + 30);
                                System.out.println("It's effective!");
                            } else {
                                player1.setPower(r.nextInt(16) + 15);
                            }
                        }
                        System.out.println("You punched the enemy for " + player1.getPower() + " damage!");
                    } 
                    
                    else if(fightCommand.equals("missile") && player1.itsItems.get("missile") != null) {
                        if(player1.currentRoom.getEnemy(targetEnemy) == frank) {
                            player1.setPower(r.nextInt(12) + 6);
                            player1.health -= player1.getPower();
                            System.out.println("That's just foolish! The Frank Scholze Mech catches the missile and throws it at you for " + player1.getPower() + " damage!");
                            frank.health += player1.getPower();
                        } else if(player1.currentRoom.getEnemy(targetEnemy) == moon) {
                            if(iceShield == true) {
                                iceShield = false;
                                System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage and melted its ice shield!");
                            } else {
                                player1.setPower(r.nextInt(12) + 6);
                                System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage!");
                            }
                        } else if(player1.currentRoom.getEnemy(targetEnemy) == carson && carsonMode == "glass") {
                            player1.setPower(r.nextInt(36) + 30);
                            System.out.println("It's effective! You shot a missile at the enemy for " + player1.getPower() + " damage!");
                        }
                          else {
                            player1.setPower(r.nextInt(12) + 6);
                            System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage!");
                        }
                    } 
                    
                    else if(fightCommand.equals("drill") && player1.itsItems.get("drill") != null) {
                        if(player1.currentRoom.getEnemy(targetEnemy) == frank) {
                            player1.setPower(r.nextInt(18) + 9);
                            System.out.println("You showed Frank how wrong he was by explaining your biggest 'point' and dealed " + player1.getPower() + " damage!");
                        } else if(player1.currentRoom.getEnemy(targetEnemy) == moon) {
                            player1.setPower(r.nextInt(36) + 60);
                            System.out.println("It's super effective! You drilled into the enemy for " + player1.getPower() + " damage!");
                        } else if(player1.currentRoom.getEnemy(targetEnemy) == carson && carsonMode == "ground") {
                            player1.setPower(r.nextInt(36) + 30);
                            System.out.println("It's effective! You drilled into the enemy for " + player1.getPower() + " damage!");
                        }
                        else {
                            player1.setPower(r.nextInt(8) + 6);
                            System.out.println("You drilled into the enemy for " + player1.getPower() + " damage!");
                        }
                    }
                    
                    else if(fightCommand.equals("fire") && player1.itsItems.get("fire") != null) {
                        if(player1.currentRoom.getEnemy(targetEnemy) == carson && carsonMode == "ice") {
                            player1.setPower(r.nextInt(36) + 30);
                            System.out.println("It was effective!");
                        } else {
                            player1.setPower(r.nextInt(16) + 15);
                        }
                        System.out.println("You shot a blast of fire at the enemy for " + player1.getPower() + " damage!");
                    }

                    else if(fightCommand.equals("ice") && player1.itsItems.get("ice") != null) {
                        if(player1.currentRoom.getEnemy(targetEnemy) == carson && carsonMode == "fire") {
                            player1.setPower(r.nextInt(36) + 30);
                            System.out.println("It's effective!");
                        } else {
                            player1.setPower(r.nextInt(16) + 15);
                        }
                        System.out.println("You shot a blast of ice at the enemy for " + player1.getPower() + " damage!");
                    }
                    
                    //Use healing item
                    if(fightCommand.equals("heal") && healingItemGot == true) {
                        System.out.println("You used the healing capsule to restore 100 HP!");
                        player1.setHealth(player1.getHealth() + 100);
                        if(player1.getHealth() > 240) {
                            player1.setHealth(240);
                        }
                        healingItemGot = false;
                        targetEnemy = enemy;
                    } 
                    //Case of attack being blocked
                    else if(fightCommand != "heal") {
                        if(iceShield == true && player1.currentRoom.getEnemy(targetEnemy) == moon) {
                            player1.setPower(0);
                            System.out.println(".....Unfortunately, the enemy blocked all of it somehow.");
                        }
                    }
                    
                    if(player1.currentRoom.getEnemy(targetEnemy) != null) {
                        player1.currentRoom.getEnemy(targetEnemy).health -= player1.getPower();
                    } else if(player1.currentRoom.getEnemy(targetEnemy) == null && fightCommand != "heal") {
                        System.out.println("Unfortunately, the damage didn't register because you forgot to include the target enemy's name. Here's a phrase to help you remember in the future. 'Without the name, you are lame.''");
                    } 
                    player1.setPower(0);

                    //Enemy's turn
                    if(player1.currentRoom.getEnemy(enemy) != null) {
                        if(player1.currentRoom.getEnemy(enemy).health > 0) {

                            //mole's turn
                            if(player1.currentRoom.getEnemy(enemy) == mole) {
                                int attack = r.nextInt(4);
                                if(attack == 3) {
                                    mole.setPower(r.nextInt(10) + 5);
                                    System.out.println("The mole attacks you with a giant drill and deals " + mole.getPower() + " damage!");
                                } else {
                                    mole.setPower(r.nextInt(6) + 1);
                                    System.out.println("The mole swipes its claws and deals " + mole.getPower() + " damage!");
                                }
                            } 
    
                            //Frank Scholze Mech's turn
                            else if(player1.currentRoom.getEnemy(enemy) == frank) {
                                int attack = r.nextInt(8);
                                if(attack > 4) {
                                    frank.setPower(r.nextInt(18) + 8);
                                    System.out.println("The Frank Scholze Mech proudly fires you with his dual wielding AR-15's and deals " + frank.getPower() + " damage!");
                                } else {
                                    frank.setPower(r.nextInt(9) + 6);
                                    System.out.println("The Frank Scholze Mech uses his free speech to shout profanities and deals " + frank.getPower() + " damage!");
                                }
                            }
    
                            //Moon's turn
                            else if(player1.currentRoom.getEnemy(enemy) == moon) {
                                int attack = r.nextInt(8);
                                if(attack > 4) {
                                    moon.setPower(r.nextInt(8) + 6);
                                    moon.health += 20;
                                    System.out.println("The moon causes an ice shower that heals itself for 10 HP and deals " + moon.getPower() + " damage!");
                                } else {
                                    moon.setPower(r.nextInt(13) + 8);
                                    System.out.println("The moon spits out meteors and deals " + moon.getPower() + " damage!");
                                }
                            }

                            //Carson's turn
                            else if(player1.currentRoom.getEnemy(enemy) == carson) {
                                int attack = r.nextInt(16); 
                                if(attack == 15) {
                                    player1.setHealth(player1.getHealth() - 100);
                                    System.out.println("You can see me type 'player1.setHealth(player1.getHealth() - 100)'");
                                    carsonMode = "normal";
                                    carson.setPower(0);
                                } else if(attack < 15 && attack >= 12) {
                                    carson.setPower(r.nextInt(26) + 25);
                                    System.out.println("I summon a California wildfire to make you lit!");
                                    carsonMode = "fire";
                                } else if(attack < 12 && attack >= 9) {
                                    carson.setPower(r.nextInt(26) + 15);
                                    System.out.println("I summon a mid-April blizzard to give you the cold shoulder!");
                                    carsonMode = "ice";
                                } else if(attack < 9 && attack >= 6) {
                                    carson.setPower(r.nextInt(26) + 25);
                                    System.out.println("I create and throw mirror shards at you to make you reflect on your decisions!");
                                    carsonMode = "glass";
                                } else if(attack < 6 && attack >= 3) {
                                    carson.setPower(r.nextInt(26) + 25);
                                    System.out.println("I pick up the ground to make you eat dirt!");
                                    carsonMode = "ground";
                                } else {
                                    player1.setHealth(player1.getHealth() - (r.nextInt(30) + 36));
                                    System.out.println("I type on a computer and you mysteriously feel weaker!");
                                    carsonMode = "normal";
                                    carson.setPower(0);
                                }
                            }
    
                            player1.health -= player1.currentRoom.getEnemy(enemy).getPower();
                        } else {
                            defeatedEnemy = player1.currentRoom.getEnemy(enemy).getName();
                            player1.currentRoom.removeEnemy(player1.currentRoom.getEnemy(enemy).getName());
                            if(defeatedEnemy == "moon") {
                                System.out.println("You defeated the moon!");
                            }
                        }
                    }

                    //Second Enemy's turn
                    if(player1.currentRoom.getEnemy(enemy2) != null) {
                        if(player1.currentRoom.getEnemy(enemy2).health > 0) {

                            //Sun's turn
                            if(player1.currentRoom.getEnemy(enemy2) == sun) {
                                int attack = r.nextInt(8);
                                if(attack > 4) {
                                    sun.setPower(r.nextInt(18) + 8);
                                    System.out.println("The sun unleashes a solar flare and deals " + sun.getPower() + " damage!");
                                } else {
                                    sun.setPower(r.nextInt(13) + 8);
                                    System.out.println("The sun launches a wave of fireballs and deals " + sun.getPower() + " damage!");
                                }
                            }
    
                            player1.health -= player1.currentRoom.getEnemy(enemy2).getPower();
                        } else {
                            defeatedEnemy = player1.currentRoom.getEnemy(enemy2).getName();
                            player1.currentRoom.removeEnemy(player1.currentRoom.getEnemy(enemy2).getName());
                            if(defeatedEnemy == "sun") {
                                System.out.println("You defeated the sun!");
                            }
                        }
                    }
                }

                //Fight ends
                if(player1.health <= 0) {
                    System.out.println("Your health has dropped to 0! YOU LOSE! GOOD DAY HUMAN PERSON!");
                    System.out.println("You come back to life in a previous room.");
                    player1.setHealth(maxHealth);
                    if(player1.getCurrentRoom() == roomList.get("Room9")) {
                        if(player1.getCurrentRoom().getEnemy(enemy) == null) {
                            roomList.get("Room9").addEnemy(moon.getName(), moon);
                        } else if(player1.getCurrentRoom().getEnemy(enemy2) == null) {
                            roomList.get("Room9").addEnemy(sun.getName(), sun);
                        }
                    }
                    if(player1.currentRoom.getEnemy(enemy) == mole) {
                        mole.setHealth(30);
                    } else if(player1.currentRoom.getEnemy(enemy) == frank) {
                        frank.setHealth(100);
                    } else if(player1.currentRoom.getEnemy(enemy) == moon) {
                        moon.setHealth(85);
                        sun.setHealth(85);
                        iceShield = true;
                    } else if(player1.currentRoom.getEnemy(enemy) == carson) {
                        carson.setHealth(300);
                        healingItemGot = true;
                        carsonMode = "normal";
                        player1.getCurrentRoom().removeEnemy("carson");
                    }
                    player1.setCurrentRoom(player1.getPrevRoom());
                } else {

                    //End of mole fight
                    if(defeatedEnemy == "mole") {
                        System.out.println("You defeated the mole!");
                        player1.addItem("drill", drill);
                        //roomList.get("Room3").addItem(drill.getName(),drill);
                        System.out.println("For some reason, your health increased by 70! Your chest hair increased by 5! Your nail polish increased by 2!");
                        drill.printDescription();
                    } 

                    //End of Frank fight
                    else if(defeatedEnemy == "frank") {
                        System.out.println("You defeated the Frank Scholze Mech!");
                        System.out.println("Your health increased by 70! Your electoral votes increased by 47! Your political correctness increased by 4!");
                        player1.addItem("key", key);
                        //roomList.get("Room5").addItem(key.getName(),key);
                        powerPunch = true;
                        System.out.println("You use the remains of the Frank Scholze Mech to substantially increase the power of your punch attack!");
                        key.printDescription();
                    }

                    //End of Sun & Moon fight
                    else if(defeatedEnemy == "moon" || defeatedEnemy == "sun") {
                        System.out.println("Your health increased by 70! Your polarity increased by 8!(whatever that means) Your moon dust irritation increased by 20!");
                        System.out.println("You somehow absorb the remains of the sun and moon and gain access to fire and ice powers!(treat them as if they were items)");
                        player1.addItem("fire", fire);
                        player1.addItem("ice", ice);
                    }

                    //End of Carson fight & the game
                    else if(defeatedEnemy == "carson") {
                        System.out.println("It appears you have defeated me. Good, now you have proven that this game of mine is beatable. I will surely get an excellent grade now! With the power of good grades I shall become the ultimate lifeform and take over the universe, then I will unleash my ideal economic system called Capital Anarchism! As for you.....I don't know. You can go sniff the beer and drink roses I guess.");
                        System.out.println("THE END");
                        System.out.println("Credits");
                        System.out.println("Design: Carson Koenen");
                        System.out.println("Programming: Carson Koenen");
                        System.out.println("Music: Your imagination");
                        System.out.println("Graphics: VS code I guess?");
                        System.out.println("Special thanks: Scott Munns");
                        s.close();
                        System.exit(0);
                    }

                    player1.setHealth(maxHealth + 70);
                    maxHealth = player1.getHealth();
                }
            } else {
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
                System.out.println("Command List: go (letter of cardinal direction), use (name of item), quit. Type 'help' during a battle to get different commands.");
            } 
            else if(command.equals("go")) {
                if(modifier == null) {
                    System.out.println("Please type a direction.");
                }
                else if(modifier.equals("n")) {
                    player1.move("n");
                }
                else if(modifier.equals("s")) {
                    if(dirtInSouth == true && player1.getCurrentRoom() == roomList.get("Room4")) {
                        System.out.println("This pathway is blocked by obscene amounts of dirt.");
                    } else if(fireWall == true && player1.getCurrentRoom() == roomList.get("Room8")) {
                        System.out.println("The path to the center of the station is on fire for some reason. I wonder who could've done that? Heh heh heh...");
                    } else {
                        player1.move("s");
                    }
                }
                else if(modifier.equals("w")) {
                    if(dirtInWest == true && player1.getCurrentRoom() == roomList.get("Room4")) {
                        System.out.println("This pathway is blocked by obscene amounts of dirt.");
                    } else {
                        player1.move("w");
                    }
                }
                else if(modifier.equals("e")) {
                    if(keyDoorOpen == false && player1.getCurrentRoom() == roomList.get("Room4")) {
                        System.out.println("This door is locked.");
                    } else {
                        player1.move("e");
                    }
                }
            } 
            /*else if(command.equals("grab")) {
                player1.grab(modifier);
            } 
            else if(command.equals("drop")) {
                player1.drop(modifier);                
            }*/ 
            else if(command.equals("use")) {
                if(player1.itsItems.get(modifier) != null) {
                    if(modifier.equals("drill") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        dirtInWest = false;
                        dirtInSouth = false;
                        System.out.print("The drill utterly decimates the dirt blocking the west and south exits! ");
                    } else if(modifier.equals("key") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        keyDoorOpen = true;
                        System.out.print("The key opens the door while a nice jingle plays in the background! ");
                    } else if(modifier.equals("fire") && player1.getCurrentRoom() == roomList.get("Room6")) {
                        if(healingItemGot == false) {
                            System.out.print("You discovered a one-use healing capsule in the room! Type 'heal' during battle to use it.");
                            healingItemGot = true;
                        }
                        System.out.print("The room lights up, which reveals a computer screen that says 'Enemy carson = new Enemy();'");
                    } else if(modifier.equals("ice") && player1.getCurrentRoom() == roomList.get("Room8")) {
                        System.out.print("Your cold blast caused the fire to recede!");
                        fireWall = false;
                    }
                } 
            }
            
            //Initiates Final Boss
            else if(command.equals("carson")) {
                player1.getCurrentRoom().addEnemy(carson.getName(),carson);
            }
            } 
        }
    }
}