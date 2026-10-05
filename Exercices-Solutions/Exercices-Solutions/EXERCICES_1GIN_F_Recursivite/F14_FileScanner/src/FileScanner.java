
import java.io.File;
import java.util.ArrayList;

public class FileScanner { //isFile, listFiles, isDirectory

    private static void scanDirectory(ArrayList<File> list, File file) { 

        if (file.isFile()) {  
            list.add(file);
        } 
        else if (file.isDirectory()){  
            File[] files = file.listFiles(); 
                for (int i = 0; i < files.length; i++) { 
                    scanDirectory(list, files[i]);       
                }
        }
    }

    public static ArrayList<File> scanDirectory(File file) { p
        ArrayList<File> alFiles = new ArrayList<>();
        scanDirectory(alFiles, file);
        return alFiles;
    }

}
