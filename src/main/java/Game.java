import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

        // Create Scanner for collecting user input.
        Scanner scanner = new Scanner(System.in);

        // Collect character name from user.
        System.out.print("Name: ");
        String name = scanner.nextLine();

        // Collect character role from user.
        System.out.print("Role: ");
        String role = scanner.nextLine();

        Player player = new Player(name, role);

        System.out.println("Your name is " + player.name + " and your role is " + player.role + ".");
        
        // TODO Create character by collecting user input (name + role.)



        // TODO Print character sheet.

        // Start the adventure.
        printDramaticText("Our adventure begins in an old barn ...");

        int requirement = generateMonster();

        // Roll a d20
        int roll = 0;
        System.out.print("Press Enter to roll a d20 or A to roll advantage.");
        String option = scanner.nextLine();
        if(option.toLowerCase().equals("a")) {
            roll = Player.rollAdvantage();
            Ascii.drawD20(roll);
            printDramaticText(player.name + " rolled a " + roll + ".");
        } else {
            roll = Player.rollD20();
            Ascii.drawD20(roll);
            printDramaticText(player.name + " rolled a " + roll + ".");
        }

        if(roll > requirement) {
            printDramaticText("You successfuly defeated the monster!");
        } else {
            printDramaticText("You did NOT defeat the monster!");
        }
    }
        
        

    public static void printDramaticText(String text) {;
        // Delay in milliseconds
        int delay = 100;

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Draws a monster and returns an int which represents the difficulty of roll required.
    public static int generateMonster() {
        int r = (int)(Math.random() * 6) + 1;
        if(r == 1 || r == 2 || r == 3) {
            String zombie = Character.toString(0x1F9DF);
            System.out.println("++++++++ " + zombie + " A HORDE OF ZOMBIES " + zombie + " ++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  8            +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 8;
        }
        if(r == 4 || r == 5) {
            String mask = Character.toString(0x1F3AD);
            System.out.println("++++++++++ " + mask + " DISGUISED MIMIC " + mask + " +++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  12           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 12;
        }
        if(r == 6) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + " ++++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 18;
        }
        return -1;
    } 
}
