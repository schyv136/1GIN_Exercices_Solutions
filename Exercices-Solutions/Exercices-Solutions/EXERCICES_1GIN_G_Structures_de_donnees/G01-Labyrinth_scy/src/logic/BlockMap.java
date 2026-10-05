package logic;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BlockMap {

    private int dim;
    private Block[][] map;
    private Point player;
    private int BlockSize;

    public static final int MOVE_UP = 0;
    public static final int MOVE_DOWN = 1;
    public static final int MOVE_LEFT = 2;
    public static final int MOVE_RIGHT = 3;

    public BlockMap(int dim, int BlockSize) {
        this.dim = dim;
        map = new Block[dim][dim];
        this.BlockSize = BlockSize;
    }

    public void setDim(int dim) {
        this.dim = dim;

        Block[][] oldMap = map;
        map = new Block[dim][dim];

        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                if (x < oldMap.length && y < oldMap[x].length) {
                    map[x][y] = oldMap[x][y];
                }
            }
        }
    }

    public void setBlockSize(int BlockSize) {
        this.BlockSize = BlockSize;
    }

    public void draw(Graphics g, int wWidth, int wHeight) {
        g.setColor(Color.WHITE);

        int wSize = Math.min(wWidth, wHeight);
        g.fillRect(0, 0, wSize, wSize);

        // loop over the map and draw each block
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                if (map[x][y] != null) {
                    map[x][y].draw(g, x * BlockSize, y * BlockSize, BlockSize);
                }
                if (player != null && player.x == x && player.y == y) {
                    g.setColor(Color.RED);
                    g.fillOval(x * BlockSize + BlockSize / 4, y * BlockSize + BlockSize / 6,
                            BlockSize / 2,
                            BlockSize / 2);
                    g.fillRect(x * BlockSize + BlockSize / 4, y * BlockSize + (int) (BlockSize
                            / 1.5), BlockSize / 2,
                            BlockSize / 4);
                    g.setColor(Color.BLACK);
                    g.drawOval(x * BlockSize + BlockSize / 4, y * BlockSize + BlockSize / 6,
                            BlockSize / 2,
                            BlockSize / 2);
                    g.drawRect(x * BlockSize + BlockSize / 4, y * BlockSize + (int) (BlockSize
                            / 1.5), BlockSize / 2,
                            BlockSize / 4);
                }
            }
        }

        if (player == null) {
            return;
        }
        // Find end block
        ArrayList<Point> ends = new ArrayList<Point>();
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                if (map[x][y] instanceof End) {
                    ends.add(new Point(x, y));
                }
            }
        }

        // call getShortestPath for each end block and draw the path for the shortest list
        ArrayList<Node> shortestPath = null;
        for (Point end : ends) {
            ArrayList<Node> path = getShortestPath(end);
            if (path != null && (shortestPath == null || path.size() < shortestPath.size())) {
                shortestPath = path;
            }
        }

        if (shortestPath == null) {
            return;
        }

        g.setColor(Color.YELLOW);
        for (int i = 0; i < shortestPath.size(); i++) {
            g.setColor(Color.YELLOW);
            g.fillOval(shortestPath.get(i).point.x * 40 + 15, shortestPath.get(i).point.y * 40 + 15, 10, 10);
            if (i > 0) {
                g.drawLine(shortestPath.get(i - 1).point.x * 40 + 20, shortestPath.get(i - 1).point.y * 40 + 20,
                        shortestPath.get(i).point.x * 40 + 20, shortestPath.get(i).point.y * 40 + 20);
            }
        }
    }

    public void addBlock(Block block, int x, int y) {
        x = x / BlockSize;
        y = y / BlockSize;

        if (x < 0 || x >= dim || y < 0 || y >= dim) {
            beep();
            return;
        }

        if (map[x][y] != null) {
            beep();
            return;
        }

        map[x][y] = block;
    }

    public void resetPlayer() {
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                if (map[x][y] instanceof Start) {
                    player = new Point(x, y);
                    return;
                }
            }
        }
        player = null;
    }

    public Boolean movePlayer(int pMove) {
        if (player == null) {
            beep();
            return false;
        }
        int x = player.x;
        int y = player.y;
        switch (pMove) {
            case MOVE_UP:
                y--;
                break;
            case MOVE_DOWN:
                y++;
                break;
            case MOVE_LEFT:
                x--;
                break;
            case MOVE_RIGHT:
                x++;
                break;
        }

        if (x < 0 || x >= dim || y < 0 || y >= dim) {
            beep();
            return false;
        }
        if (map[x][y] instanceof Brick || map[x][y] instanceof Water) {
            beep();
            return false;
        }

        if (map[x][y] == null || !map[x][y].isWalkable()) {
            return false;
        }

        player.x = x;
        player.y = y;
        if (map[x][y] instanceof End) {
            return true;
        }
        return false;
    }

    public void beep() {
        Toolkit.getDefaultToolkit().beep();
    }

    public int getDim() {
        return dim;
    }

    public void removeBlock(int i, int j) {
        i = i / BlockSize;
        j = j / BlockSize;
        if (i < 0 || i >= dim || j < 0 || j >= dim) {
            beep();
            return;
        }

        map[i][j] = null;
    }

    public boolean doesStartExist() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (map[i][j] instanceof Start) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWon() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (map[i][j] instanceof End && player.x == i && player.y == j) {
                    return true;
                }
            }
        }
        return false;
    }

    public void save(String fileName) {
        if (fileName == null) {
            return;
        }
        try ( FileWriter out = new FileWriter(new File(fileName))) {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    if (map[i][j] != null) {
                        out.write(map[i][j].toString() + "," + i + "," + j + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        if (fileName == null) {
            return;
        }
        map = new Block[dim][dim];
        try ( BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                switch (parts[0]) {
                    case "Brick":
                        map[x][y] = new Brick();
                        break;
                    case "Water":
                        map[x][y] = new Water();
                        break;
                    case "Start":
                        map[x][y] = new Start();
                        break;
                    case "End":
                        map[x][y] = new End();
                        break;
                    case "Grass":
                        map[x][y] = new Grass();
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
       if (i>=0 && j>=0 && i<dim && j<dim && map[i][j] != null &&   //if coords ok
           (map[i][j].isWalkable()) ){
                if (map[i][j] instanceof End) {   //if exit found
                    result=true;
                    wayout.add( new Point(i,j));
                }
                else if (!map[i][j].isMarked()) { //continue using the surrounding blocs:
                    map[i][j].mark();                              
                    result = 
                       ( findWayOut(i-1, j, wayout) ||  //recursive calls
                         findWayOut(i+1, j, wayout) ||   
                         findWayOut(i, j-1, wayout) || 
                         findWayOut(i, j+1, wayout) );  
                    if (result)   //if this field leads to an exit, add it to the path
                        wayout.add( new Point(i,j));   
                }  
       }
       return result;       
    }
    
    public void showWayOut(Graphics g) 
    {
        //reset all marks 
        for (int i=0 ; i<dim ; i++) 
             for (int j=0 ; j<dim ; j++) 
                 if  (map[i][j] != null)    
                      map[i][j].unmark();
        
        //this list will contain the coordinates of the path to the exit
        ArrayList<Point> way=new ArrayList<Point>();
        
        if (findWayOut(player.x, player.y, way))  //calls the recursive method
        
            for(int i=0 ; i<way.size() ; i++) { //draws the path on the map
                g.setColor(Color.YELLOW);
                g.fillOval(way.get(i).x*40+15, way.get(i).y*40+15, 10, 10);
                if (i>0) g.drawLine(way.get(i-1).x*40+20, way.get(i-1).y*40+20, 
                                    way.get(i  ).x*40+20, way.get(i  ).y*40+20);
                //System.out.println(way.get(i));
            }
    }

    //******************* Algorithm to find shortest Path *********************
    public Node getLowestF(ArrayList<Node> list) {
        Node lowest = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).f < lowest.f) {
                lowest = list.get(i);
            }
        }
        return lowest;
    }

    public ArrayList<Node> getNeighbours(Node parent, Point start, Point end) {
        ArrayList<Node> alNeighbours = new ArrayList<>();
        if (parent.point.x + 1 <= dim) {
            alNeighbours.add(new Node(new Point(parent.point.x + 1, parent.point.y), start, end));
        }
        if (parent.point.x > 0) {
            alNeighbours.add(new Node(new Point(parent.point.x - 1, parent.point.y), start, end));
        }
        if (parent.point.y + 1 <= dim) {
            alNeighbours.add(new Node(new Point(parent.point.x, parent.point.y + 1), start, end));
        }
        if (parent.point.y > 0) {
            alNeighbours.add(new Node(new Point(parent.point.x, parent.point.y - 1), start, end));
        }

        return alNeighbours;
    }

    public boolean findInList(ArrayList<Node> list, Node node) {
        for (Node n : list) {
            if (n.point.x == node.point.x && n.point.y == node.point.y) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Node> getShortestPath(Point end) {
        Node goal = new Node(end, player, end);
        ArrayList<Node> openList = new ArrayList<>();
        ArrayList<Node> closedList = new ArrayList<>();

        Node start = new Node(player, player, end);
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = getLowestF(openList);
            openList.remove(current);
            closedList.add(current);

            //path has been found
            if (current.isEqual(goal)) {
                ArrayList<Node> path = new ArrayList<>();
                Node n = closedList.get(closedList.size() - 1);
                while (closedList.indexOf(n) != -1) {
                    path.add(n);
                    n = n.parent;
                }
                return path;
            }
            //get all the neighbours of the current node
            ArrayList<Node> neighbours = getNeighbours(current, player, end);
            for (Node neighbour : neighbours) {
                Block block = map[neighbour.point.x][neighbour.point.y];
                //is block walkable and not null and neighbour not in closed list
                if (block != null && block.isWalkable() && !findInList(closedList, neighbour)) {

                    //if new path to neighbour is shorter OR neighbour is not in open
                    if (current.g < neighbour.g || !findInList(openList, neighbour)) {

                        neighbour.setFCost(current.point);
                        neighbour.parent = current;
                        //if neighbour is not in open add neighbour to open
                        if (!findInList(openList, neighbour)) {

                            openList.add(neighbour);
                        }
                    }
                }
            }
        }
        return null;
    }
}
