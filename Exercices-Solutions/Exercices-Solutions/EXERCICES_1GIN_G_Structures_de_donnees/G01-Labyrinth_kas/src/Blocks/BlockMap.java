package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author fred
 */
public class BlockMap {

    private int dim;
    private Block[][] map;
    private int playerI, playerJ;

    public static final int MOVE_UP = 0;
    public static final int MOVE_DOWN = 1;
    public static final int MOVE_LEFT = 2;
    public static final int MOVE_RIGHT = 3;

    public BlockMap(int dim) {
        //create 2 dimensional map of blocks
        this.dim = dim;
        map = new Block[dim][dim];
        //reset player
        playerI = -1;
        playerJ = -1;
    }

    public void addBlock(int i, int j, Block b) {
        //add bloc if position valid and empty
        if (i >= 0 && j >= 0 && i < dim && j < dim && map[i][j] == null) {
            map[i][j] = b;
        }
    }

    public void deleteBlock(int i, int j) {
        //delete bloc if position valid and used
        if (i >= 0 && j >= 0 && i < dim && j < dim && map[i][j] != null) {
            map[i][j] = null;
        }
    }

    //returns true if there is a Start block on the map
    public boolean hasStart() {
        boolean result = false;
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                if (map[i][j] instanceof Start) {
                    result = true;
                }
            }
        }
        return result;
    }

    public void draw(Graphics g) {
        //clear background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dim * 40, dim * 40);

        //draw all blocs
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (map[i][j] != null) {
                    map[i][j].draw(i * 40, j * 40, g);
                }
            }
        }
        //draw player (if already set)
        if (playerI > -1) {
            g.setColor(new Color(255, 0, 0));
            g.fillOval(playerI * 40 + 10, playerJ * 40 + 5, 21, 21); //Windows: fillOval and drawOval do not match
            g.fillRect(playerI * 40 + 10, playerJ * 40 + 25, 21, 11);
            g.setColor(new Color(128, 0, 0));
            g.drawOval(playerI * 40 + 10, playerJ * 40 + 5, 20, 20);
            g.drawRect(playerI * 40 + 10, playerJ * 40 + 25, 20, 10);
        }

        //draw a line to an exit if possible and if player is set
        showWayOut(g);
    }

    //put player on the Start bloc if present
    public void resetPlayer() {
        playerI = -1;
        playerJ = -1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (map[i][j] instanceof Start) {
                    playerI = i;
                    playerJ = j;
                }
            }
        }
    }

    //move player if possible
    public void movePlayer(int move) {
        int i = playerI;
        int j = playerJ;
        //check position
        if (move == MOVE_UP && j > 0) {
            j--;
        } else if (move == MOVE_DOWN && j < dim - 1) {
            j++;
        } else if (move == MOVE_LEFT && i > 0) {
            i--;
        } else if (move == MOVE_RIGHT && i < dim - 1) {
            i++;
        }
        
        if (map[i][j] != null && map[i][j].isWalkable()) {
            playerI = i;
            playerJ = j;
        }
        if (map[i][j] instanceof End) {
            JOptionPane.showMessageDialog(null, "YOU WON!");
        }
    }

    //*********************** FILE OPERATIONS *****************************************
    //save the map to a text file (player position is also saved)
    public void saveToFile(String fileName) throws FileNotFoundException, IOException {
        PrintWriter out = null; // not initialized yet
        try {
            out = new PrintWriter(new FileWriter(fileName));
            //write dimension first 
            out.println(dim);
            //write block codes to file (line per line)
            for (int i = 0; i < dim; i++) {
                String line = "";
                for (int j = 0; j < dim; j++) {
                    if (map[i][j] == null) {
                        line = line + ".";
                    } else if (map[i][j] instanceof Brick) {
                        line = line + "B";
                    } else if (map[i][j] instanceof End) {
                        line = line + "E";
                    } else if (map[i][j] instanceof Grass) {
                        line = line + "G";
                    } else if (map[i][j] instanceof Start) {
                        line = line + "S";
                    } else if (map[i][j] instanceof Water) {
                        line = line + "W";
                    }
                }
                out.println(line);
                System.out.println("wrote : " + line);
            }
            //write player position
            out.println(playerI);
            out.println(playerJ);
        } finally {
            if (out != null) {
                out.close(); // that's why 'out' has to be known outside the first try block
                System.out.println("saved file closed");
            }
        }

    }

    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName)); //->FileNotFoundException

            String line;
            //read dimension first
            dim = Integer.valueOf(in.readLine());
            //make a new map
            map = new Block[dim][dim];
            //fill the map
            for (int i = 0; i < dim; i++) {
                line = in.readLine();
                for (int j = 0; j < dim; j++) {
                    if (line.charAt(j) == '.') {
                        map[i][j] = null;
                    } else if (line.charAt(j) == 'B') {
                        map[i][j] = new Brick();
                    } else if (line.charAt(j) == 'E') {
                        map[i][j] = new End();
                    } else if (line.charAt(j) == 'G') {
                        map[i][j] = new Grass();
                    } else if (line.charAt(j) == 'S') {
                        map[i][j] = new Start();
                    } else if (line.charAt(j) == 'W') {
                        map[i][j] = new Water();
                    }
                }
            }
            //read player position
            playerI = Integer.valueOf(in.readLine());
            playerJ = Integer.valueOf(in.readLine());
        } finally {
            if (in != null) {
                in.close(); // that's why 'in' has to be known outside the first try block
            }
        }
    }

    //********************** FIND AND SHOW A WAY TO AN EXIT ******************************
    /*
     * Recursively finds a way from the player's position to an exit (End Block).
     * @return true if a path was found to the exit
     * @param i   x position of player (hypothetical player during recursive calls)
     * @param j   y position of player (hypothetical player during recursive calls)
     * @param way an arraylist with all the block positions from the player to the exit
     */
    private boolean findWayOut(int i, int j, ArrayList<Point> wayout) {
        //System.out.println(i+","+j);
        boolean result = false;
        if (i >= 0 && j >= 0 && map[i][j] != null
                && //if coords ok
                (map[i][j].isWalkable())) {
            if (map[i][j] instanceof End) {   //if exit found
                result = true;
                wayout.add(new Point(i, j));
            } else if (!map[i][j].isMarked()) { //continue using the surrounding blocs:
                map[i][j].mark();
                result
                        = ((i > 0 && findWayOut(i - 1, j, wayout))
                        || //recursive calls
                        (i < dim - 1 && findWayOut(i + 1, j, wayout))
                        || (j > 0 && findWayOut(i, j - 1, wayout))
                        || (j < dim - 1 && findWayOut(i, j + 1, wayout)));
                if (result) //if this field leads to an exit, add it to the path
                {
                    wayout.add(new Point(i, j));
                }
            }
        }
        return result;
    }

    public void showWayOut(Graphics g) {
        //reset all marks 
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (map[i][j] != null) {
                    map[i][j].unmark();
                }
            }
        }

        //this list will contain the coordinates of the path to the exit
        ArrayList<Point> way = new ArrayList<Point>();

        if (findWayOut(playerI, playerJ, way)) //calls the recursive method
        {
            for (int i = 0; i < way.size(); i++) { //draws the path on the map
                g.setColor(Color.YELLOW);
                g.fillOval(way.get(i).x * 40 + 15, way.get(i).y * 40 + 15, 10, 10);
                if (i > 0) {
                    g.drawLine(way.get(i - 1).x * 40 + 20, way.get(i - 1).y * 40 + 20,
                            way.get(i).x * 40 + 20, way.get(i).y * 40 + 20);
                }
                //System.out.println(way.get(i));
            }
        }
    }

}
