import java.util.Scanner;
import java.io.IOException;
/**
 * @author: ______your name here (SID)_________
 *
 *          For the instruction of the assignment please refer to the assignment
 *          GitHub.
 * 
 *          Plagiarism is a serious offense and can be easily detected. Please
 *          don't share your code to your classmate even if they are threatening
 *          you with your friendship. If they don't have the ability to work on
 *          something that can compile, they would not be able to change your
 *          code to a state that we can't detect the act of plagiarism. For the
 *          first commit of plagiarism, regardless you shared your code or
 *          copied code from others, you will receive 0 with an addition of 5
 *          mark penalty. If you commit plagiarism twice, your case will be
 *          presented in the exam board and you will receive a F directly.
 *
 *          Terms about generative AI:
 *          You are not allowed to use any generative AI in this assignment.
 *          The reason is straight forward. If you use generative AI, you are
 *          unable to practice your coding skills. We would like you to get
 *          familiar with the syntax and the logic of the Java programming.
 *          We will examine your code using detection software as well as 
 *          inspecting your code with our eyes. Using generative AI tool 
 *          may fail your assignment.
 * 
 *          If you cannot work out the logic of the assignment, simply contact
 *          us on Discord. The teaching team is more the eager to provide
 *          you help. We can extend your submission due if it is really
 *          necessary. Just please, don't give up.
 */


/**
 * This file has been provided to you and it is completed.
 * You are not supposed to add or change any code in this file. You can read the
 * code to understand how the game works. You can also use this file to test your
 * code. However, you are not supposed to submit this file. 
 * 
 */
public class Sokoban {
    /**
     * The following constants are variables that you can use in your code.
     * Use them whenever possible. Try to avoid writing something like:
     * if (input == 'W') ...
     * instead
     * if (input == UP) ...
     */
    public static final char UP = 'W';
    public static final char DOWN = 'S';
    public static final char LEFT = 'A';
    public static final char RIGHT = 'D';
    public static final char PLAYER = 'o';
    public static final char BOX = '@';
    public static final char WALL = '#';
    public static final char GOAL = '.';
    public static final char EMPTY = ' ';
    public static final char BOXONGOAL = '%';

    private Scanner scanner = new Scanner(System.in);

    private Board board;
    /**
     * Finished. You are not allowed to touch this method.
     * The main method.
     */
    public static void main(String[] args) {
        new Sokoban().runApp();
    }
    /**
     * All coding of this method has been finished.
     * You are not supposed to add or change any code in this method.
     * However, you are required to add comments after every // to explain the code below.
     */
    public Sokoban() {
        String mapfile = "map1.txt"; //change this to test other maps
        try {
            Map map = new Map(mapfile);
            board = new Board(map);
        } catch (IOException e) {
            System.out.println("Error reading map file: " + e.getMessage());
            board = null;
        }
        
    }
    public void runApp() {
        if (board == null) {
            System.out.println("Board is not initialized. Exiting.");
            return;
        }
        board.printMap(); //print the map
        while (!board.isGameOver()) {
            System.out.println("\nPlease enter a move (WASD) or h for help: ");
            char input = readValidInput();
            if (input == 'q' || input == 'Q')
                return;
            if (input == 'r' || input == 'R') {
                board.restore();
                continue;
            }
            if (input == 'h' || input == 'H') {
                printHelp();
                continue;
            }
            if (input == 'V' || input == 'v') {
                System.out.println("Save map");
                board.saveMap();
                continue;
            }
            if (input == 'l' || input == 'L') {
                System.out.println("Load map");
                board.loadMap();
                board.printMap();
                continue;
            }
            if (!board.isValidMove(input)) {
                System.out.println("This move is invalid, please enter again: ");
                continue;
            }
            board.makeMove(input);
            board.printMap(); //print the map
        }
        board.printMap();
        System.out.println("Bye!");
    }
    /**
     * Print the Help menu. 
     * 
     * Inspect the code in runApp() and find out the function of each characters. 
     * The first one has been done for you.
     */
    public void printHelp() {
        System.out.println("Sokoban Help:"); 
        System.out.println("Move up: W");
        System.out.println("Move down: S");
        System.out.println("Move left: A");
        System.out.println("Move right: D");
        System.out.println("Restart level: r/R");
        System.out.println("Quit game: q/Q");
        System.out.println("Save map: V/v");
        System.out.println("Load map: L/l");
        System.out.println("Help: h/H");
    }
    /**
     * Reading a valid input from the user.
     * 
     * 
     * This method has been finished. You are not supposed to add or change any code in this method.
     */
    public char readValidInput() {
        char input;
        while (true)  {
            String line = scanner.nextLine();
            if (line.length() == 0) 
                continue;
            input = line.charAt(0);
            if (input == UP || input == DOWN || input == LEFT || input == RIGHT || 
                input == 'q' || input == 'r' || input == 'h' || 
                input == 'Q' || input == 'R' || input == 'H' ||
                input == 'V' || input == 'v' || input == 'L' || input == 'l')
                break;
            System.out.println("Invalid input, please enter again: ");
        }
        return input;
    }


    /**
     * This method is used to clone a char array. 
     * Because this is a static method, you can call it like
     * char[] newArray = Sokoban.clone(oldArray);
     */
    public static char[] clone(char[] array) {
        char[] newArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

}
