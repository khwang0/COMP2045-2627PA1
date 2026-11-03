import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Focused tests for the Board and Map responsibilities. */
public class TestCase {
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    @Before
    public void captureOutput() {
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void restoreOutput() {
        System.setOut(originalOut);
    }

    @Test
    public void testBoardPrintMap() throws IOException {
        Board board = new Board(loadMap("#####\n#o .#\n#####\n"));

        board.printMap();

        String newline = System.lineSeparator();
        assertEquals("#####" + newline + "#o .#" + newline + "#####" + newline,
                output.toString());
    }

    @Test
    public void testBoardIsValidMove() throws IOException {
        Board movableBoard = new Board(loadMap("#####\n#o@.#\n#####\n"));
        Board blockedBoard = new Board(loadMap("#####\n#o@##\n#####\n"));

        assertTrue(movableBoard.isValidMove(Sokoban.RIGHT));
        assertFalse(movableBoard.isValidMove(Sokoban.LEFT));
        assertFalse(blockedBoard.isValidMove(Sokoban.RIGHT));
    }

    @Test
    public void testBoardIsGameOver() throws IOException {
        Board unfinishedBoard = new Board(loadMap("#####\n#o .#\n#####\n"));
        Board completedBoard = new Board(loadMap("#####\n#o@%#\n#####\n"));

        assertFalse(unfinishedBoard.isGameOver());
        assertTrue(completedBoard.isGameOver());
    }

    @Test
    public void testMapNumberOfRows() throws Exception {
        Path mapFile = createMapFile("#####\n#o .#\n#####\n");
        Map map = new Map(mapFile.toString());
        Method numberOfRows = Map.class.getDeclaredMethod("numberOfRows", String.class);
        numberOfRows.setAccessible(true);

        assertEquals(3, numberOfRows.invoke(map, mapFile.toString()));
        assertEquals(-1, numberOfRows.invoke(map, mapFile.resolveSibling("missing-map.txt").toString()));
    }

    @Test
    public void testMapRestore() throws IOException {
        Map map = loadMap("#####\n#o@.#\n#####\n");
        Board board = new Board(map);
        char[][] originalCells = copyCells(map.getCells());

        board.makeMove(Sokoban.RIGHT);
        assertEquals(Sokoban.BOXONGOAL, map.getCell(1, 3));
        assertArrayEquals(new int[] { 1, 2 }, board.getPlayerPosition());

        board.restore();

        assertArrayEquals(new int[] { 1, 1 }, board.getPlayerPosition());
        assertCellsEqual(originalCells, map.getCells());
    }

    private Map loadMap(String contents) throws IOException {
        return new Map(createMapFile(contents).toString());
    }

    private Path createMapFile(String contents) throws IOException {
        Path mapFile = Files.createTempFile("sokoban-test-map", ".txt");
        mapFile.toFile().deleteOnExit();
        Files.write(mapFile, contents.getBytes(StandardCharsets.UTF_8));
        return mapFile;
    }

    private char[][] copyCells(char[][] cells) {
        char[][] copy = new char[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            copy[row] = cells[row].clone();
        }
        return copy;
    }

    private void assertCellsEqual(char[][] expected, char[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int row = 0; row < expected.length; row++) {
            assertArrayEquals(expected[row], actual[row]);
        }
    }
}
