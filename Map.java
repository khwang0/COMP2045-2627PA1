import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class represents the map of the game. It is responsible for loading 
 * the map from a file, storing the map in a 2D array, and providing methods 
 * to access and modify the map.
 */
public class Map {
    /**
     * The 2D array that stores the map. Each cell in the array represents a
     * character in the map. 
     */
    private final char[][] cells;
    /**
     * A backup of the original map to restore the game state. This is useful for
     * restarting the game or loading a saved state.
     */
    private final char[][] originalCells;  

    /**
     * The starting position of the player in the map.
     * When the player moves, this will NOT change.
     */
    private final int playerRow, playerCol;  


    /**
     * Returns the cells array used by this map.
     * Changes made to the returned array directly change the map.
     * @return the 2D array of characters representing the map
     */
    public char[][] getCells() {
        //TODO
    }



    /**
     * Returns the row of the player in the map.
     * @return the row of the player in the map
     */
    public int getPlayerRow() {
        //TODO        
    }
    /**
     * Returns the column of the player in the map.
     * @return the column of the player in the map
     */
    public int getPlayerCol() {
        //TODO        
    }

    /**
     * Creates a new Map instance by loading the map from a file. Goal:
     * initialize the following variables:
     * - cells
     * - originalCells
     * - playerRow
     * - playerCol
     * 
     * The 2D array cells should be read from the file which filename is 
     * stated in the argument. If the file is not found, it should throw 
     * an IOException.
     * 
     * The number of columns in each row may be different. Use an irregular
     * 2D array (char[][]): allocate the outer array using the number of lines
     * in the file, then allocate each row separately using that line's
     * length after removing trailing space characters (' ') if there is any. 
     * Preserve leading spaces. Do not truncate or pad rows to a common width.
     * The last column of each row must be a WALL character.
     * 
     * That is, if the map is as follow,
     * ####
     * #.@o#
     * #  #
     * ###
     * your array have to be declared as
     * char[][] map = {{'#', '#', '#', '#'},
     *                 {'#', '.', '@', 'o', '#'},
     *                 {'#', ' ', ' ', '#'},
     *                 {'#', '#', '#'} };
     * 
     * 
     * You should also initialize a separate copy of the original map to 
     * restore the game state when the player restarts the game.
     * 
     * @param fileName the name of the file to load the map from
     * @throws IOException if an I/O error occurs while reading the file
     */
    public Map(String fileName) throws IOException {
        //TODO

    }



    /**
     * Returns the number of rows in the map file. If the file is not found, it returns -1.
     * @param fileName the name of the file to read
     * @return the number of rows in the map file, or -1 if the file is not found
     */
    private int numberOfRows(String fileName) {
        //TODO
    }

    /**
     * Returns the character at the specified row and column in the map.
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the character at the specified position
     */
    public char getCell(int row, int col) {
        //TODO

    }
    /**
     * Sets the character at the specified row and column in the map.
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the character to set
     */
    public void setCell(int row, int col, char value) {
        //TODO

    }

    /**
     * Restores the map to its original state.
     */
    public void restore() {
        //TODO
    }


}
