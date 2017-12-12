/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countletterswiththreads;

/**
 *
 * @author vasilhs12
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author vasilhs12
 */
public class TakeFile {
    private Scanner fileScanner; // creates a file

    public TakeFile() throws MalformedURLException, IOException {
        this.fileScanner = new Scanner(new File("RC_2008-07.txt"));
        
    }
    public ArrayList<String> TakeLines() throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        
        while(fileScanner.hasNextLine() ){
            line = fileScanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

}
