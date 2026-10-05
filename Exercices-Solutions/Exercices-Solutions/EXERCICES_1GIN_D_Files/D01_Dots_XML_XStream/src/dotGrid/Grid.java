package dotGrid;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * @author fabfr
 */
public class Grid {
    
    private Dots dots = new Dots();
    
    private int cols;      //set by constructor
    private int rows;      //set by constructor
    private int cellWidth; //set by draw method
    
    public int getRows() {        return rows;    }
    public int getCols() {        return cols;    }
    public int getCellWidth() {   return cellWidth;   }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }
    
    public Grid() {
        this.cols = 0;
        this.rows = 0;
    }
    
    public void addDot(Dot dot) {
        dots.add(dot);
    }    
        
    public void draw(Graphics g, int width, int height) {
        cellWidth = Math.min(width/cols, height/rows);
        for(int r=0 ; r<rows ; r++){
            for(int c=0 ; c<cols ; c++) {
                g.setColor(Color.WHITE);        
                g.fillRect(c*cellWidth, r*cellWidth, cellWidth, cellWidth);
                g.setColor(Color.LIGHT_GRAY);        
                g.drawRect(c*cellWidth, r*cellWidth, cellWidth, cellWidth);
            }         
        }
        dots.draw(g, cellWidth);
    }  
    
    
    public void clear() {
        dots = new Dots();
    }
    
    
    public void saveToXml(String fileName)  throws IOException   {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        xstream.alias("dot", Dot.class); //to avoid xml tags like <dotGrid.Dot>
        xstream.alias("dots", Dots.class);

        //does not always work  --> risk of circular reference exception
        xstream.setMode(XStream.NO_REFERENCES); //references to same objects are added as different objects (here: colors)
        
        String xml = xstream.toXML(dots);
        
        try (PrintWriter out =  new PrintWriter(new FileWriter(fileName))) {
                out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
                out.println(xml);
        }
    }
    

    public void loadFromXmlDom(String fileName) throws IOException {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        xstream.alias("dot",  Dot.class);  //to avoid xml tags like <dotGrid.Dot>
        xstream.alias("dots", Dots.class); 
            
        try (BufferedReader in =  new BufferedReader(new FileReader(fileName))) {
                dots = (Dots)xstream.fromXML(in);
        }
        catch (com.thoughtworks.xstream.mapper.CannotResolveClassException e) {
            JOptionPane.showMessageDialog(null, 
                    "Cannot resolve XML Tags in file '"+fileName+"'", 
                    "XML read Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public void loadFromXmlSax(String fileName) throws ParserConfigurationException, SAXException, IOException {
        //not implemented
    }
        
    
//************************************ JSON Text File ***************************************
        
    /** JSON with gson: read/write the whole class in one Instruction. 
     * gson uses the reflection engine to get the objects structure!
     * static method -> returns the new Object from inside the class.
     * n had to be declared as Integer (not int) to get the correct JSON structure
     * @param fileName
     * @return  the new Persons object read from the file
     * @throws IOException 
     */
//    public static Grid loadFromJsonFile(String fileName) throws IOException {
//        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
//            return new Gson().fromJson(in, (new TypeToken<Grid>(){}.getType()));       
//        }             
//    }

//    public void saveToJsonFile(String fileName) throws IOException {
//        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //to get the correct formatting
//            gson.toJson(this,out);
//        }
//    }    
}
