import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Board Class. This class contains the information of the game board, including the map, 
 * the player position, and the methods to manipulate the board.
 * 
 * Complete the TODO methods in this class according to the specification. You cannot 
 * change the method signature of any methods in this class. You can add private methods if you need to.
 * 
 */

public class Board {
    /**
     * This represents the map of the game. It is a 2D array of characters, where each character represents a cell in the map.
     * The map is initialized from a Map object, which is passed to the constructor of the Board class. 
     * The map is used to determine the valid moves of the player and the boxes, and to check if the game is over.
     */
    private final Map map;
    /**
     * The position of the player on the board. You need to update the player position when the player moves. 
     */
    private int playerRow;
    private int playerCol;

    /**
     * The filename that save the current state of the game. 
     */
    private static final String SAVE_FILE = "save.txt";

    /**
     * This method shall have no use for you. It is mainly for our grading purpose.
     * This has been completed for you. You should not change any code in this method.
     */
    public int[] getPlayerPosition() {
        return new int[] { playerRow, playerCol };
    }
    /**
     * This method shall have no use for you. It is mainly for our grading purpose.
     * This has been completed for you. You should not change any code in this method.
     */
    public Map getMap() {
        return map;
    }


    /**
     * Constructor of the Board class. It initializes the board with a given map.
     * You need also initialize the position of the player.
     */
    public Board(Map map) {
        //TODO
    }


    /**
     * Print the map. This method should print the map to the console.
     * It should also print the player at the correct position. The player is represented by the character 'o'.
     * 
     * Be careful, there should be only one player (o) on the map. 
     * If there are more than one player, it means you are doing something wrong.
     */
    public void printMap() {
        //TODO
    }



    /**
     * When the user type r, it should restore the map to its original state and 
     * also bringing the player back to its original position.
     */
    public void restore() {
        //TODO
    }

    /**
     * Check if the game is over.
     * The game is over if all goals are filled with boxes.
     */
    public boolean isGameOver() {
        //TODO
    }

    /**
     * To check if a move is valid. 
     * The direction is represented by a character, which can only be 
     * 'W', 'A', 'S', 'D' for up, left, down, right respectively.
     * 
     * The definition of a valid move:
     * 
     * 1. The player can only move to a position that is not occupied by a 
     *    wall or a box.
     * 2. If the player is moving to a position that is occupied by a box, 
     *    the box can only be moved to a position that is not occupied by a wall or a box.
     * 
     * Thus, in the following condition, the player can move to the right
     * o #   <-- there is a space
     * o@ #  <-- there is a space right to the box.
     * In the following condition, the player cannot move to the right
     * o#    <-- there is a wall
     * o@#   <-- there is a wall right to the box.
     * o@@ # <-- there is a box right to the box.
     */
    public boolean isValidMove(char direction) {
        //TODO
    }



    /**
     * Make a move in the specified direction.
     * You can assume that the move is valid when this method is called.
     * 
     * @param direction The direction to move.
     */
    public void makeMove(char direction) {
        //TODO
    }


    /**
     * To move a box in a map.
     * 
     * 
     * This method will move a box in the map. The box will be moved to 
     * the direction specified by the parameter "direction".
     * 
     * You must call this method from makeMove() when the player pushes a box.
     * 
     * After this method, a box should be moved to the new position 
     * from the coordinate [row, col] according to the direction.
     * For example, if [row, col] is [2, 5] and the direction is 'S', 
     * the box should be moved to [3, 5].
     * 
     * If a box is moved to a goal, the box should be marked as BOXONGOAL.
     * If a box is moved to a non-goal, the box should be marked as BOX.
     * You should set the original position of the box to 
     * Sokoban.EMPTY or Sokoban.GOAL in this method.
     * 
     * Note, you may always assume that this method is called when 
     * the box can be moved to the direction. During grading, we will 
     * never call this method when the box cannot be moved to the direction. 
     */
    public void moveBox(int row, int col, char direction) {
        //TODO
    }


    /**
     * To save the current state of the game to a file. The file name is specified 
     * by the constant SAVE_FILE.
     * 
     * The new file shall contain also the current position of the player.
     * 
     * It is a known problem that if a player is on a goal, the goal will 
     * not be saved in the file. You don't need to worry about this problem.
     */
    public void saveMap() {
        //TODO
    }
    /**
     * To load the game state from the file SAVE_FILE.
     * The position of the player should also be restored to the position 
     * when the game was saved.
     * 
     * It is not the same as restore where restore will load the map
     * to the very beginning of the game. This method will load the map to 
     * the state when the game was saved.
     * 
     * But if the file does not exist, it should be able to handle the 
     * issue and continue with the current game state. You can optionally
     * print a message to inform the user that the file does not exist.
     */
    public void loadMap() {
        //TODO
    }



    
}
