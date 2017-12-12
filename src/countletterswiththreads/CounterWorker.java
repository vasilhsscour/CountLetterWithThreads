/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countletterswiththreads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author vasilhs12
 */
public class CounterWorker {
    
    ArrayList<String> lines; // creates an arraylist
    
    public CounterWorker (ArrayList<String> words) { // initializes the list through the cunstructor
        this.lines = words;
    }
    
    
    //creates an atomicInteger
    //and for each list's word calculated how many characters have and adds in  variable numOfCharacters
    //end returns that variable
    public int increment () {
        AtomicInteger numOfCharacters = new AtomicInteger();
        
        
        for (int i=0;i<lines.size();i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
               char ch = lines.get(i).charAt(j);
            
                if (Character.isLetter(ch) ) {
                    numOfCharacters.incrementAndGet();
                }
            }
        }
        return numOfCharacters.get()    ;
        
    }

}
