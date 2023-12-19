import java.awt.*;
import java.util.*;

public class SandLab {
    public static void main(String[] args) {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int ICE = 4;

    //do not add any more fields
    private int[][] grid;
    private SandDisplay display;

    public SandLab(int numRows, int numCols) {
        String[] names;
        names = new String[5];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[ICE] = "Ice";
        display = new SandDisplay("Cypress Ranch Lab: Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool) {
        this.grid[row][col] = tool;
    }

    //copies each element of grid into the display
    public void updateDisplay() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == EMPTY) {
                    display.setColor(i, j, Color.BLACK);
                }
                if (grid[i][j] == METAL) {
                    display.setColor(i, j, Color.GRAY);
                    Arrays.deepToString(grid);
                }
                if (grid[i][j] == SAND) {
                    display.setColor(i, j, Color.YELLOW);
                    Arrays.deepToString(grid);
                }
                if (grid[i][j] == WATER) {
                    display.setColor(i, j, Color.BLUE);
                    Arrays.deepToString(grid);
                }
                if (grid[i][j] == ICE) {
                    display.setColor(i, j, Color.CYAN);
                    Arrays.deepToString(grid);
                }


            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        Random random = new Random();
        int row = random.nextInt(118) +1;
        int col = random.nextInt(78) +1;
        int randWater = random.nextInt(3) +1;
        /*
        if(grid[row][col] == SAND){
            if((grid[row+1][col] != METAL) && (grid[row + 1][col] !=SAND)) {
                grid[row][col] = EMPTY;
                grid[row+1][col] = SAND;
            }
        }

        if(grid[row][col] == SAND ){
            if (randWater == 1){ //down
                if(grid[row+1][col] == EMPTY ){
                    grid[row][col] = EMPTY;
                    grid[row+1][col] = SAND;
                }
            }
            if (randWater == 2){ //down left
                if (grid[row+1][col-1] == EMPTY){
                    grid[row][col] = EMPTY;
                    grid[row+1][col-1] = SAND;
                }
            }
            if (randWater == 3){ //down right
                if (grid[row+1][col+1] == EMPTY) {
                    grid[row][col] = EMPTY;
                    grid[row + 1][col + 1] = SAND;
                }
            }
        }



//    if(grid[row][col] == WATER){
//      if(row < grid.length && (grid[row+1][col] != METAL) && (grid[row + 1][col] !=SAND)) {
//        grid[row][col] = EMPTY;
//        grid[row+1][col] = WATER;
//      }
//    }
        if(grid[row][col] == WATER ){
            if (randWater == 1){ //down
                if(grid[row+1][col] == EMPTY ){
                    grid[row][col] = EMPTY;
                    grid[row+1][col] = WATER;
                }
            }
            if (randWater == 2){ //down left
                if(grid[row][col-1] == EMPTY) {
                    if (grid[row + 1][col - 1] == EMPTY) {
                        grid[row][col] = EMPTY;
                        grid[row + 1][col - 1] = WATER;

                    }
                }
            }
            if (randWater == 3) { //down right
                if (grid[row][col + 1] == EMPTY) {

                    if (grid[row + 1][col + 1] == EMPTY) {
                        grid[row][col + 1] = WATER;
                        grid[row][col] = EMPTY;
                        grid[row + 1][col + 1] = WATER;
                    }
                }
            }
        }
        */
        if(grid[row][col] == SAND){
            if((grid[row+1][col] != METAL) && (grid[row + 1][col] !=SAND)) {
                grid[row][col] = EMPTY;
                grid[row+1][col] = SAND;
            }
        }
        //System.out.println(grid.length);
        if(grid[row][col] == SAND ){
            if (randWater == 1){ //down
                if(grid[row+1][col] == EMPTY ){
                    grid[row][col] = EMPTY;
                    grid[row+1][col] = SAND;
                }
            }
            if (randWater == 2){ //down left
                if (grid[row+1][col-1] == EMPTY){
                    grid[row][col] = EMPTY;
                    grid[row+1][col-1] = SAND;
                }
            }
            if (randWater == 3){ //down right
                if (grid[row+1][col+1] == EMPTY) {
                    grid[row][col] = EMPTY;
                    grid[row + 1][col + 1] = SAND;
                }
            }
        }
        if (grid[row][col] == WATER) {
            //DOWN
            if ((row + 1) < grid.length && EMPTY == grid[row + 1][col]) {
                // grid[row+1][col] = EMPTY;
                grid[row + 1][col] = grid[row][col];
                grid[row][col] = EMPTY;
            }
            //LEFT
            if ( col-1 >= 0 && grid[row][col-1] == EMPTY ) {
                grid[row][col-1] = grid[row][col];
                grid[row][col] = EMPTY;
            }
            //RIGHT
            if ( col+1 < grid[row].length && grid[row][col+1] == EMPTY) {
                grid[row][col+1] = grid[row][col];
                grid[row][col] = EMPTY;
            }
        }
        if (grid[row][col] == ICE){
            if ((grid[row][col] == ICE && grid[row+1][col] == WATER) ){
                grid[row+1][col] = grid[row][col];
                grid[row][col] = ICE;
            }
            if (grid[row+1][col-1] == WATER||grid[row+1][col] == WATER){ //

            }
        }


    }



    //do not modify
    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
/*
((grid[x + 1][y] == EMPTY) || (grid[x + 1][y] == WATER)) &&
                    ((grid[x][y + 1] == EMPTY) || (grid[x][y + 1] == WATER)) &&
                    ((grid[x][y - 1] == EMPTY) || (grid[x][y - 1] == WATER)))
 */