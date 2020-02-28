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
        roomList.get("Room5").setDescription("You are in a very dark and foreboding mechanical room.");

        roomList.get("Room6").westRoom = roomList.get("Room4");
        roomList.get("Room6").southRoom = roomList.get("Room8");
        roomList.get("Room6").setDescription("This appears to be a storage room for some helpful items.");

        roomList.get("Room7").westRoom = roomList.get("Room5");
        roomList.get("Room7").southRoom = roomList.get("Room9");
        roomList.get("Room7").eastRoom = roomList.get("Room8");
        roomList.get("Room7").northRoom = roomList.get("Room4");
        roomList.get("Room7").setDescription("You're in.....space? To the south are celestial objects,to the east is a manmade object,to the north is a planet with the factory from before.");

        roomList.get("Room8").westRoom = roomList.get("Room7");
        roomList.get("Room8").northRoom = roomList.get("Room6");
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

        //Creating item information
        itemList.put(missileLauncher.getName(),missileLauncher);
        roomList.get("Room2").addItem(missileLauncher.getName(),missileLauncher);
        missileLauncher.setDescription("There is a missile launcher laying conveniently on the pedestal that you can use to shoot at things.");

        itemList.put(key.getName(),key);
        roomList.get("Room5").addItem(key.getName(),key);
        key.setDescription("There is a small key that can be used to unlock doors.");

        itemList.put(drill.getName(),drill);
        drill.setDescription("The mole dropped his drill. It's a sharp and powerful tool.");

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
        mole.setCurrentRoom(roomList.get("Room3"));

        frank.setHealth(100);
        frank.setDescription("There is a strange robot saying, 'I MUST ELMINATE THE 16TH & 17TH AMENDMENTS!'");
        frank.setScan("Robot resembling a teenage boy with glasses. Attacks with the 1st & 2nd amendments and protects himself with the free market economy. The strongest weapon against him is one that will make it get the point the fastest.");
        enemyList.put(frank.getName(),frank);
        roomList.get("Room5").addEnemy(frank.getName(),frank);
        frank.setCurrentRoom(roomList.get("Room5"));

        moon.setHealth(85);
        moon.setDescription("There is a moon about twice your body size with a disapproving face.");
        moon.setScan("This cold moon uses ice and meteor-based attacks. Its icy surface protects against all damage against the soft & breakable ground underneath. The ice is vulnerable to an explosion-based attack.");
        enemyList.put(moon.getName(),moon);
        roomList.get("Room9").addEnemy(moon.getName(),moon);
        moon.setCurrentRoom(roomList.get("Room9"));

        sun.setHealth(85);
        sun.setDescription("There is a sun about twice your body size with an extremely angry face.");
        sun.setScan("This small star uses fire and heat-based atacks. It surprisingly doesn't have any resistances, but it also doesn't have any particular weaknesses.");
        enemyList.put(sun.getName(),sun);
        roomList.get("Room10").addEnemy(sun.getName(),sun);
        sun.setCurrentRoom(roomList.get("Room9"));

        carson.setHealth(240);
        carson.setDescription("So you know who I am. I am the creator of everything you have seen. The purpose of all of it is to create a project that challenges and builds my skills. However, I need this game to serve some sort of purpose to get a good grade. That purpose is defeating me. Can you grant me an A+ performance?");
        enemyList.put(carson.getName(),carson);

        //Creating player information
        player1.name = "Guy";
        player1.setCurrentRoom(roomList.get("Room9"));
        player1.setHealth(100);
        int maxHealth = player1.getHealth();

        //Puzzle status
        boolean dirtInSouth = true;
        boolean dirtInWest = true;
        boolean powerPunch = false;
        boolean keyDoorOpen = false;
        boolean iceShield = true;

        //Where game starts
        System.out.println("One day you come into existence.You don't know anything about who you are, or where you are(unless you've played this before). You do have some really cool looking mechanical arms though.(Type 'help' to see commands you can do.)");
        while(true) {
            player1.getCurrentRoom().printDescription();
            player1.getCurrentRoom().printItems();
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
                            System.out.println("punch (enemy), status, scan (enemy), (You can also attack by typing in an item, like missile and then the enemy's name afterwards)");
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
                            if(player1.currentRoom.getEnemy(enemy).getHealth() > 0) {
                                System.out.println(player1.currentRoom.getEnemy(enemy).getName() + " HP: " + player1.currentRoom.getEnemy(enemy).health);
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
                            player1.setPower(r.nextInt(18) + 10);
                        }
                        System.out.println("You punched the enemy for " + player1.getPower() + " damage!");

                    } 
                    
                    else if(fightCommand.equals("missile")) {
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
                        } else {
                            player1.setPower(r.nextInt(12) + 6);
                            System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage!");
                        }
                    } 
                    
                    else if(fightCommand.equals("drill")) {
                        if(player1.currentRoom.getEnemy(targetEnemy) == frank) {
                            player1.setPower(r.nextInt(18) + 9);
                            System.out.println("You showed Frank how wrong he was by explaining your biggest 'point' and dealed " + player1.getPower() + " damage!");
                        } else if(player1.currentRoom.getEnemy(targetEnemy) == moon) {
                            player1.setPower(r.nextInt(36) + 18);
                            System.out.println("It's super effective! You drilled into the enemy for " + player1.getPower() + " damage!");
                        }
                        else {
                            player1.setPower(r.nextInt(8) + 6);
                            System.out.println("You drilled into the enemy for " + player1.getPower() + " damage!");
                        }
                    }

                    if(iceShield == true && player1.currentRoom.getEnemy(targetEnemy) == moon) {
                        player1.setPower(0);
                        System.out.println(".....Unfortunately, the enemy blocked all of it somehow.");
                    }
                    player1.currentRoom.getEnemy(targetEnemy).health -= player1.getPower();
                    player1.setPower(0);

                    //Enemy's turn
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

                        player1.health -= player1.currentRoom.getEnemy(enemy).getPower();
                    } else {
                        defeatedEnemy = player1.currentRoom.getEnemy(enemy).getName();
                        player1.currentRoom.removeEnemy(player1.currentRoom.getEnemy(enemy).getName());
                    }
                }
                //Fight ends
                if(player1.health <= 0) {
                    System.out.println("Your health has dropped to 0! YOU LOSE! GOOD DAY HUMAN PERSON!");
                    s.close();
                    System.exit(0);
                } else {
                    System.out.println("You defeated the enemy!");

                    //End of mole fight
                    if(defeatedEnemy == "mole") {
                        roomList.get("Room3").addItem(drill.getName(),drill);
                        System.out.println("For some reason, your health increased by 70! Your chest hair increased by 5! Your nail polish increased by 2");
                    } 

                    //End of Frank fight
                    else if(defeatedEnemy == "frank") {
                        System.out.println("Your health increased by 70! Your election votes raised by 2,000! Your political correctness increased by 4!");
                        roomList.get("Room5").addItem(key.getName(),key);
                        powerPunch = true;
                        System.out.println("You use the remains of the Frank Scholze Mech to substantially increase the power of your punch attack!");
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
                System.out.println("Command List: go (letter of cardinal direction), grab (item), drop (item), fight, quit");
            } 
            else if(command.equals("go")) {
                if(modifier.equals("n")) {
                    player1.move("n");
                }
                else if(modifier.equals("s")) {
                    if(dirtInSouth == true && player1.getCurrentRoom() == roomList.get("Room4")) {
                        System.out.println("This pathway is blocked by obscene amounts of dirt.");
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
            else if(command.equals("grab")) {
                player1.grab(modifier);
            } 
            else if(command.equals("drop")) {
                player1.drop(modifier);                
            } 
            else if(command.equals("use")) {
                if(player1.itsItems.get(modifier) != null) {
                    if(modifier.equals("drill") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        dirtInWest = false;
                        dirtInSouth = false;
                        System.out.print("The drill utterly decimates the dirt blocking the west and south exits! ");
                    } else if(modifier.equals("key") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        keyDoorOpen = true;
                        System.out.print("The key opens the door while a nice jingle plays in the background! ");
                    } 
                }
            }
            
            //Initiates Final Boss
            else if(command.equals("carson")) {
                player1.getCurrentRoom().addEnemy(carson.getName(),carson);
                carson.printDescription();
            }
            }

            /*System.out.println(">> ");
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
                    if(dirtInSouth == true && player1.getCurrentRoom() == roomList.get("Room4")) {
                        System.out.println("This pathway is blocked by obscene amounts of dirt.");
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
            else if(command.equals("grab")) {
                player1.grab(modifier);
            } 
            else if(command.equals("drop")) {
                player1.drop(modifier);                
            } 
            else if(command.equals("use")) {
                if(player1.itsItems.get(modifier) != null) {
                    if(modifier.equals("drill") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        dirtInWest = false;
                        dirtInSouth = false;
                        System.out.print("The drill utterly decimates the dirt blocking the west and south exits! ");
                    } else if(modifier.equals("key") && player1.getCurrentRoom() == roomList.get("Room4")) {
                        keyDoorOpen = true;
                        System.out.print("The key opens the door while a nice jingle plays in the background! ");
                    } 
                }
            }

            //Initiates Final Boss
            else if(command.equals("carson")) {
                player1.getCurrentRoom().addEnemy(carson.getName(),carson);
                carson.printDescription();

                //When final fight begins
                /*System.out.println("You are attacked by me! You also hear some really good boss music.");
                while(carson.health > 0 && player1.getHealth() > 0) {

                    //Player's turn in final boss
                    System.out.println("What do you do?");
                    System.out.println(">> ");
                    String fightCommand = s.nextLine();

                    //Creating player actions
                while(fightCommand.equals("help") || fightCommand.equals("status")) {
                    if(fightCommand.equals("help")) {
                        System.out.println("punch, status, scan, (You can also attack by typing in one of your items, like missile)");
                        System.out.println("What do you do?");
                        System.out.println(">> ");
                        fightCommand = s.nextLine();
                    } else if(fightCommand.equals("status")) {
                        System.out.println("Your HP: " + player1.getHealth());
                        System.out.println("Carson's HP: " + carson.getHealth());
                        System.out.println("What do you do?");
                        System.out.println(">> ");
                        fightCommand = s.nextLine();
                    }
                }
                    if(fightCommand.equals("punch")) {
                        if(powerPunch == false) {
                            player1.setPower(r.nextInt(6) + 1);
                        } else {
                            player1.setPower(r.nextInt(18) + 10);
                        }
                        System.out.println("You punched the enemy for " + player1.getPower() + " damage!");

                    } else if(fightCommand.equals("missile")) {
                        player1.setPower(r.nextInt(12) + 6);
                        System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage!");
                    }
                    carson.health -= player1.getPower();
                    player1.setPower(0);

                if(carson.health > 0) {
                    //Final boss's turn
                    int attack = r.nextInt(10); 
                        if(attack == 10) {
                            player1.setHealth(1);
                            System.out.println("You can see me type 'player.setHealth(1)'");
                        } else {
                             carson.setPower(r.nextInt(25) + 20);
                            System.out.println("I type on a computer and you feel like you have less health!");
                        }
                    player1.health -= carson.getPower();
                }
                }
                //Final fight ends
                if(player1.health <= 0) {
                    System.out.println("Your health has dropped to 0! YOU LOSE! GOOD DAY HUMAN PERSON!");
                    s.close();
                    System.exit(0);
                } else {
                    System.out.println("It appears you have defeated me. Good, now you have proven that this game of mine is beatable. I will surely get an excellent grade now! With the power of good grades I shall become the ultimate lifeform and take over the universe, then I will unleash my ideal economic system called Capital Anarchism! As for you.....I don't know. You can go sniff the beer and drink roses I guess.");
                    System.out.println("THE END");
                    s.close();
                    System.exit(0);
                }*/
            }

            //Non-final boss enemy encounters
            /*else if(command.equals("fight")) {
                if(player1.currentRoom.getEnemy(modifier) != null) {

                    //When fight begins
                    System.out.println("You are attacked by the " + player1.currentRoom.getEnemy(modifier).getName() + "!");
                    while(player1.currentRoom.getEnemy(modifier).health > 0 && player1.getHealth() > 0) {

                        //Player's turn
                        System.out.println("What do you do?");
                        System.out.println(">> ");
                        String fightCommand = s.nextLine();

                        //Creating player actions
                        while(fightCommand.equals("help") || fightCommand.equals("status") || fightCommand.equals("scan")) {
                            if(fightCommand.equals("help")) {
                                System.out.println("punch, check, scan, (You can also attack by typing in an item, like missile)");
                                System.out.println("What do you do?");
                                System.out.println(">> ");
                                fightCommand = s.nextLine();
                            } else if(fightCommand.equals("status")) {
                                System.out.println("Your HP: " + player1.getHealth());
                                System.out.println("Enemy HP: " + player1.currentRoom.getEnemy(modifier).health);
                                System.out.println("What do you do?");
                                System.out.println(">> ");
                                fightCommand = s.nextLine();
                            } else if(fightCommand.equals("scan")) {
                                System.out.println("You scan the enemy!");
                                System.out.println("Scan: ");
                                player1.currentRoom.getEnemy(modifier).printScan();
                                System.out.println("What do you do?");
                                System.out.println(">> ");
                                fightCommand = s.nextLine();
                            }
                        }
                        if(fightCommand.equals("punch")) {
                            if(powerPunch == false) {
                                player1.setPower(r.nextInt(6) + 1);
                            } else {
                                player1.setPower(r.nextInt(18) + 10);
                            }
                            System.out.println("You punched the enemy for " + player1.getPower() + " damage!");

                        } else if(fightCommand.equals("missile")) {
                            if(player1.currentRoom.getEnemy(modifier) != frank) {
                                player1.setPower(r.nextInt(12) + 6);
                                System.out.println("You shot a missile at the enemy for " + player1.getPower() + " damage!");
                            } else {
                                player1.setPower(r.nextInt(12) + 6);
                                player1.health -= player1.getPower();
                                System.out.println("That's just foolish! The Frank Scholze Mech catches the missile and throws it at you for " + player1.getPower() + " damage!");
                                frank.health += player1.getPower();
                            }
                        } else if(fightCommand.equals("drill")) {
                            if(player1.currentRoom.getEnemy(modifier) != frank) {
                                player1.setPower(r.nextInt(8) + 6);
                                System.out.println("You drilled into the enemy for " + player1.getPower() + " damage!");
                            } else {
                                player1.setPower(r.nextInt(18) + 9);
                                System.out.println("You showed Frank how wrong he was by explaining your biggest 'point' and dealed " + player1.getPower() + " damage!");
                            }
                        }
                        player1.currentRoom.getEnemy(modifier).health -= player1.getPower();
                        player1.setPower(0);
                        
                        //Enemy's turn
                        if(player1.currentRoom.getEnemy(modifier).health > 0) {

                            //mole's turn
                            if(player1.currentRoom.getEnemy(modifier) == mole) {
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
                            else if(player1.currentRoom.getEnemy(modifier) == frank) {
                                int attack = r.nextInt(8);
                                if(attack > 4) {
                                    frank.setPower(r.nextInt(18) + 8);
                                    System.out.println("The Frank Scholze Mech proudly fires you with his dual wielding AR-15's and deals " + frank.getPower() + " damage!");
                                } else {
                                    frank.setPower(r.nextInt(9) + 6);
                                    System.out.println("The Frank Scholze Mech uses his free speech to shout profanities and deals " + frank.getPower() + " damage!");
                                }
                            }

                            player1.health -= player1.currentRoom.getEnemy(modifier).getPower();
                        } 
                    }
                    //Fight ends
                    if(player1.health <= 0) {
                        System.out.println("Your health has dropped to 0! YOU LOSE! GOOD DAY HUMAN PERSON!");
                        s.close();
                        System.exit(0);
                    } else {
                        System.out.println("You defeated the enemy!");
                        String defeatedEnemy = player1.currentRoom.getEnemy(modifier).getName();

                        //End of mole fight
                        if(defeatedEnemy == "mole") {
                            roomList.get("Room3").addItem(drill.getName(),drill);
                            System.out.println("For some reason, your health increased by 70! Your chest hair increased by 5! Your nail polish increased by 2");
                        } 

                        //End of Frank fight
                        else if(defeatedEnemy == "frank") {
                            System.out.println("Your health increased by 70! Your election votes raised by 2,000! Your political correctness increased by 4!");
                            roomList.get("Room5").addItem(key.getName(),key);
                            powerPunch = true;
                            System.out.println("You use the remains of the Frank Scholze Mech to substantially increase the power of your punch attack!");
                        }
                        player1.setHealth(maxHealth + 70);
                        maxHealth = player1.getHealth();
                        player1.currentRoom.removeEnemy(player1.currentRoom.getEnemy(modifier).getName());
                    }
                }
            }*/
        }
    }