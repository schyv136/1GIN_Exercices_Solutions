package logic;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.BinaryStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author yvonschubert
 */
public class Grid {

    private Dots dots = new Dots();
    private int cols;
    private int rows;
    private int cellWidth;

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCellWidth() {
        return this.cellWidth;
    }

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public Grid() {
        this.cols = 10;
        this.rows = 15;
    }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    public void addDot(Dot dot) {
        dots.add(dot);
    }

    public void draw(Graphics g, int width, int height) {
        cellWidth = Math.min(width / cols, height / rows);
        g.setColor(Color.LIGHT_GRAY);
        //drawing the horizontal lines
        for (int r = 0; r <= rows; r++) {
            g.drawLine(0, r * cellWidth, cellWidth * cols, r * cellWidth);
        }
        //drawing the vertical lines
        for (int c = 0; c <= cols; c++) {
            g.drawLine(c * cellWidth, 0, c * cellWidth, cellWidth * rows);
        }
        dots.draw(g, cellWidth);
    }

    public void clear() {
        dots = new Dots();
    }
    //***************************** Text File ****************************************
    public void saveToTxtFile(String fileName) throws IOException {
        try ( PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            ArrayList<Dot> alDot=dots.getArrayList();
            for (int i = 0; i < alDot.size(); i++) {   
                out.println(alDot.get(i).getX()+" "+alDot.get(i).getY()+" "+alDot.get(i).getColorString());
            }
        }
    }

    public void loadFromTxtFile(String fileName) throws IOException {
        try ( BufferedReader in = (new BufferedReader(new FileReader(fileName)))) {
            clear();
            String line;
            while ((line = in.readLine()) != null) {
                String[] myDot = line.split(" ");
                dots.add(new Dot(Integer.valueOf(myDot[0]), Integer.valueOf(myDot[1]), myDot[2]));
            }
        }
    }
    //***************************** CSV File ****************************************
    public void saveToCSVFile(String fileName) throws IOException {
        try ( PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < dots.getArrayList().size(); i++) {              
                out.println(dots.getArrayList().get(i).toCsv());
            }
        }
    }

    public void loadFromCSVFile(String fileName) throws IOException {
        try ( BufferedReader in = (new BufferedReader(new FileReader(fileName)))) {
            clear();
            String line;
            while ((line = in.readLine()) != null) {
                String[] myDot = line.split(",");
                dots.add(new Dot(Integer.valueOf(myDot[0]), Integer.valueOf(myDot[1]), myDot[2]));
            }
        }
    }

    //***************************** Binary File ****************************************
    public void saveToBinaryFile(String fileName) throws IOException {
        try ( DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {

            for (int i = 0; i < dots.getArrayList().size(); i++) {
                out.writeInt(dots.getArrayList().get(i).getX());
                out.writeInt(dots.getArrayList().get(i).getY());
                out.writeUTF(dots.getArrayList().get(i).getColorString());
            }
        }
    }

    public void loadFromBinaryFile(String fileName) throws IOException {
        try ( DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    int x=in.readInt();
                    int y=in.readInt();
                    String color=in.readUTF();
                    dots.add(new Dot(x,y,color));
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }
    }
    //***************************** Binary Object ****************************************
    public void saveToBinaryObject(String fileName) throws IOException {
        try(ObjectOutputStream obj_out= new ObjectOutputStream(new FileOutputStream(fileName)))
        {       
                obj_out.writeObject(dots.getArrayList());
        }
    }
    
    public void loadFromBinaryObject(String fileName) throws IOException {
        try(ObjectInputStream obj_in=new ObjectInputStream(new FileInputStream(fileName)))
        {
            dots.setArrayList((ArrayList<Dot>)obj_in.readObject());
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error reading object File "+e);
        }
    }
}
