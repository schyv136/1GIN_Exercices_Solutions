
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * @author fred & scy
 */
public class Reversi {

    private static final int DIM = 8;
    private static final int EMPTY = 0;
    private static final int WHITE = 1;
    private static final int BLACK = 2;

    private int[][] grid = new int[8][8];

    private int player = WHITE;
    private int adversary = BLACK;

    private int cellWidth = 0; //calculée par draw et employée à plusieurs endroits

    public Reversi() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = EMPTY;
            }
        }
        grid[3][3] = WHITE;
        grid[4][4] = WHITE;
        grid[3][4] = BLACK;
        grid[4][3] = BLACK;
    }

    public void draw(Graphics g0, int width, int height) {

        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g.setStroke(new BasicStroke(1));
        //g.setFont  (new Font("Arial", Font.BOLD, 14));
        //g.setFont  (g.getFont().deriveFont((float)14));
        g.setFont(g.getFont().deriveFont(Font.BOLD, 14));

        cellWidth = Math.min(width, height - 30) / 8;

        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                //draw the grid
                g.setColor(new Color(0, 128, 0));
                g.fillRect(i * cellWidth, j * cellWidth, cellWidth, cellWidth);
                if (player == WHITE) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                //draw the outline
                g.drawRect(i * cellWidth, j * cellWidth, cellWidth, cellWidth);
                
                //draw the tokens
                if (grid[i][j] == WHITE) {
                    g.setColor(Color.WHITE);
                }
                if (grid[i][j] == BLACK) {
                    g.setColor(Color.BLACK);
                }
                if (grid[i][j] != EMPTY) {
                    g.fillOval(i * cellWidth + 3, j * cellWidth + 3, cellWidth - 6, cellWidth - 6);
                }
                   
                //Supplément: Marquer mouv. possibles
                if (validMove(i, j)) {
                    g.drawLine(i * cellWidth + 5, j * cellWidth + 5,
                            (i + 1) * cellWidth - 5, (j + 1) * cellWidth - 5);
                    g.drawLine((i + 1) * cellWidth - 5, j * cellWidth + 5,
                            i * cellWidth + 5, (j + 1) * cellWidth - 5);
                }

                //draw the game information (score & player's move) 
                g.setColor(Color.BLUE);
                g.drawString("White player: " + score(1), 2, height - 17);
                g.drawString("Black player: " + score(2), 2, height - 2);

                if (player == WHITE) {
                    g.drawString("White player's move", width / 2, height - 2);
                } else {
                    g.drawString("Black player's move", width / 2, height - 2);
                }
            }
        }
    }

        

    public int score(int player) {
        int result = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (grid[i][j] == player) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean checkLeft(int col, int row) { //Dir horiz gauche (1)
        int c = col - 1;
        while ((c >= 0) && (grid[c][row] == adversary)) {
            c--;
        }
        return (c >= 0) && (grid[c + 1][row] == adversary) && (grid[c][row] == player);
    }

    private boolean checkRight(int col, int row) { //Dir horiz droite (2)
        int c = col + 1;
        while ((c < DIM) && (grid[c][row] == adversary)) {
            c++;
        }
        return (c < DIM) && (grid[c - 1][row] == adversary) && (grid[c][row] == player);
    }

    private boolean checkUp(int col, int row) {    //Dir vertic haut (3)
        int r = row - 1;
        while ((r >= 0) && (grid[col][r] == adversary)) {
            r--;
        }
        return (r >= 0) && (grid[col][r + 1] == adversary) && (grid[col][r] == player);
    }

    private boolean checkDown(int col, int row) {    //Dir vertic bas (4)
        int r = row + 1;
        while ((r < DIM) && (grid[col][r] == adversary)) {
            r++;
        }
        return (r < DIM) && (grid[col][r - 1] == adversary) && (grid[col][r] == player);
    }

    private boolean checkDiag1(int col, int row) {    //Diagonale vers gauche haut (5)
        int c = col - 1;
        int r = row - 1;
        while ((c >= 0) && (r >= 0) && (grid[c][r] == adversary)) {
            c--;
            r--;
        }
        return (c >= 0) && (r >= 0) && (grid[c + 1][r + 1] == adversary) && (grid[c][r] == player);
    }

    private boolean checkDiag2(int col, int row) {    //Diagonale vers droite haut (6)
        int c = col + 1;
        int r = row - 1;
        while ((c < 8) && (r >= 0) && (grid[c][r] == adversary)) {
            c++;
            r--;
        }
        return (c < 8) && (r >= 0) && (grid[c - 1][r + 1] == adversary) && (grid[c][r] == player);
    }

    private boolean checkDiag3(int col, int row) {    //Diagonale vers gauche bas (7)
        int c = col - 1;
        int r = row + 1;
        while ((c >= 0) && (r < DIM) && (grid[c][r] == adversary)) {
            c--;
            r++;
        }
        return (c >= 0) && (r < DIM) && (grid[c + 1][r - 1] == adversary) && (grid[c][r] == player);
    }

    private boolean checkDiag4(int col, int row) {    //Diagonale vers droite bas (8)
        int c = col + 1;
        int r = row + 1;
        while ((c < DIM) && (r < DIM) && (grid[c][r] == adversary)) {
            c++;
            r++;
        }
        return (c < DIM) && (r < DIM) && (grid[c - 1][r - 1] == adversary) && (grid[c][r] == player);
    }

    private boolean validMove(int col, int row) {
        return (grid[col][row] == EMPTY)
                && (checkLeft(col, row) || checkRight(col, row)
                || checkUp(col, row) || checkDown(col, row)
                || checkDiag1(col, row) || checkDiag2(col, row)
                || checkDiag3(col, row) || checkDiag4(col, row));
    }

    private void swapPieces(int col, int row) {
        int c, r;
        if (grid[col][row] == EMPTY) {
            grid[col][row] = player;
            if (checkLeft(col, row)) { //Dir horiz gauche (1)
                c = col - 1;
                while (grid[c][row] == adversary) {
                    grid[c][row] = player;
                    c--;
                }
            }
            if (checkRight(col, row)) {   //Dir horiz droite (2)
                c = col + 1;
                while (grid[c][row] == adversary) {
                    grid[c][row] = player;
                    c++;
                }
            }
            if (checkUp(col, row)) {    //Dir verti haut (3)
                r = row - 1;
                while (grid[col][r] == adversary) {
                    grid[col][r] = player;
                    r--;
                }
            }
            if (checkDown(col, row)) {      //Dir verti bas (4)
                r = row + 1;
                while (grid[col][r] == adversary) {
                    grid[col][r] = player;
                    r++;
                }
            }

            //Diagonales                                               }
            if (checkDiag1(col, row)) {   //Dir diago gauche haut (5)
                c = col - 1;
                r = row - 1;
                while (grid[c][r] == adversary) {
                    grid[c][r] = player;
                    c--;
                    r++;
                }
            }
            if (checkDiag2(col, row)) {  //Dir diago droite haut (6)
                c = col + 1;
                r = row - 1;
                while (grid[c][r] == adversary) {
                    grid[c][r] = player;
                    c++;
                    r--;
                }
            }
            if (checkDiag3(col, row)) {  //Dir diago gauche bas (7)
                c = col - 1;
                r = row + 1;
                while (grid[c][r] == adversary) {
                    grid[c][r] = player;
                    c--;
                    r++;
                }
            }
            if (checkDiag4(col, row)) {  //Dir diago droite bas (8)
                c = col + 1;
                r = row + 1;
                while (grid[c][r] == adversary) {
                    grid[c][r] = player;
                    c++;
                    r++;
                }
            }
        }
    }

    public void changePlayer() {
        int help = player;
        player = adversary;
        adversary = help;
    }

    public boolean placePiece(int x, int y) {
        int c = x / cellWidth;
        int r = y / cellWidth;
        boolean result = validMove(c, r);
        if (result) {
            swapPieces(c, r);
            changePlayer();
        }
        return result;
    }

}
