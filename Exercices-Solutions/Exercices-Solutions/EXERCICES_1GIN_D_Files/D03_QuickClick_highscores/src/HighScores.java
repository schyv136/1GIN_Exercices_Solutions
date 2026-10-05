
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fred
 */
public class HighScores {
    
    private ArrayList<HighScore> alHighScores = new ArrayList<>();
    private final static int MAX_SIZE = 10;
    
    public HighScores() {
        load();
    }    
    
    public void add(int score) {        
        if (alHighScores.size()<MAX_SIZE || 
            score > alHighScores.get(alHighScores.size()-1).getScore())  
        {
            String name = JOptionPane.showInputDialog(null, "Please enter our name : ", 
                    "Congratulations!", 
                     JOptionPane.PLAIN_MESSAGE);
            
            //insert score at correct position 
            int p=alHighScores.size();
            while(p>0 && score > alHighScores.get(p-1).getScore()) p--;
            alHighScores.add(p, new HighScore(name, score));    
            
            //delete last record if necessary
            if (alHighScores.size()>MAX_SIZE) 
                alHighScores.remove(alHighScores.size()-1);            
        }
        //saveToTextFile("highscores.txt"); //save each time the score is changed
    }
    
    
    @Override
    public String toString() {
    	   String result="";
    	   for (int i=0 ; i<alHighScores.size() ; i++)
    	   		result = result + alHighScores.get(i).toString() +'\n';
        return result;
    }
    
    /*
    public HighScore get(int i) {
        return alHighScores.get(i);
    }
    
    public int size() {
        return alHighScores.size();
    }
    
    */
    
    public void draw(Graphics g, int x, int y) {
        
        g.setFont(g.getFont().deriveFont(Font.BOLD, (float)16.0));
        g.setColor(Color.GREEN);
        g.drawString(">> HIGHSCORES <<", x+1 - 30, y + 18 +1);
        g.setColor(Color.YELLOW);
        g.drawString(">> HIGHSCORES <<", x-1 - 30, y + 18 -1);
        g.setColor(Color.BLACK);
        g.drawString(">> HIGHSCORES <<", x - 30  , y + 18);
        
        for (int i=0 ; i<alHighScores.size() ; i++) {
            g.setColor(Color.GRAY);
            g.drawString(alHighScores.get(i).toString(), x+1, y + (i+3)*18 +1);
            g.setColor(Color.black);
            g.drawString(alHighScores.get(i).toString(), x, y + (i+3)*18);
        }
    }

    
    //********************************** File Operations **************************

    public void save() {
        saveToTextFile("highscores.txt");
    }
    
    private void saveToTextFile(String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < alHighScores.size(); i++) {
                HighScore hs = alHighScores.get(i);
                out.println(hs.getName() + ";" + hs.getScore()); 
                
            }
            System.out.println("Highscores saved!");
        } catch (IOException e) {
            System.out.println(e);
        }       
    }

    public void load() {
       try {        
            loadFromTextFile("Highscores.txt");
        } catch (IOException ex) {
            System.err.println("Error reading Highscores file!");
        } 
    }
    
    private void loadFromTextFile(String fileName) throws IOException {
        alHighScores = new ArrayList<>(); //remove current scores - anyway, even if no file is found
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = in.readLine()) != null) {  //!!lecture, affectation ET comparaision!!
                int p = line.indexOf(";");
                String name = line.substring(0, p);
                int score = Integer.valueOf(line.substring(p + 1));
                alHighScores.add(new HighScore(name, score));
                
            }
            System.out.println("Highscores loaded!");
        } catch (FileNotFoundException e) {
            //ignore - a new highscore file will be created
            System.out.println("No highscore file found - will create a new one!");
        }        
    }

    
}