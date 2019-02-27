import java.util.*;
import java.io.*;

public class Maze {
    public static void main(String[]args){   
        String filename = "data2.dat";
        try{
          Maze f;
          f = new Maze(filename);
        }catch(FileNotFoundException e){
          System.out.println("Invalid filename: "+filename);
        }
      }


    private char[][] maze;
    // Default: False
    private boolean animate;

    /*
     * Constructor loads a maze text file, and sets animate to false by default. 1.
     * The file contains a rectangular ascii maze, made with the following 4
     * characters:
     * '#' - Walls - locations that cannot be moved onto
     * 
     * ' ' - Empty Space - locations that can be moved onto
     * 
     * 'E' - the location of the goal (exactly 1 per file)
     * 
     * 'S' - the location of the start(exactly 1 per file)
     * 
     * 2. The maze has a border of '#' around the edges. So you don't have to check
     * for out of bounds!
     * 
     * 3. When the file is not found OR the file is invalid (not exactly 1 E and 1
     * S) then: throw a FileNotFoundException or IllegalStateException
     */
    public Maze(String filename) throws FileNotFoundException {
        animate = false;
        File f = new File(filename);
        Scanner s = new Scanner(f);
        StringBuilder sb = new StringBuilder();
        int numLines = 0;
        int lenLines = 0;
        while(s.hasNextLine()){
            String line = s.nextLine();
            sb.append(line+"\n");
            lenLines = line.length();
            numLines++;
        }
        maze = new char[numLines][lenLines];
        System.out.println(sb.toString());
        int curLine = 0;
        for(String line : sb.toString().split("\n")){
            for(int i = 0; i < line.length(); i++){
                maze[curLine][i]=line.charAt(i);
            }
            curLine++;
        }
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public void setAnimate(boolean b) {

        animate = b;

    }

    public void clearTerminal() {

        // erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

    /*
     * Wrapper Solve Function returns the helper function
     * 
     * Note the helper function has the same name, but different parameters. Since
     * the constructor exits when the file is not found or is missing an E or S, we
     * can assume it exists.
     * 
     */
    public int solve() {
        return 0;
        // find the location of the S.

        // erase the S

        // and start solving at the location of the s.

        // return solve(???,???);

    }

    /*
     * Recursive Solve function:
     * 
     * A solved maze has a path marked with '@' from S to E.
     * 
     * Returns the number of @ symbols from S to E when the maze is solved, Returns
     * -1 when the maze has no solution.
     * 
     * 
     * Postcondition:
     * 
     * The S is replaced with '@' but the 'E' is not.
     * 
     * All visited spots that were not part of the solution are changed to '.'
     * 
     * All visited spots that are part of the solution are changed to '@'
     */
    private int solve(int row, int col) { // you can add more parameters since this is private

        // automatic animation! You are welcome.
        if (animate) {

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        // COMPLETE SOLVE

        return -1; // so it compiles
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int y =0; y < maze.length; y++){
            for (int x = 0; x < maze[y].length; x++){
                sb.append(maze[y][x]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}