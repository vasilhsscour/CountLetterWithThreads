/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countletterswiththreads;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vasilhs12
 */

//splitting of the original list into smaller
public class SplitArrayList {
    
    TakeFile mFile ;
            
    ArrayList<String> wordsList;
    ArrayList<ArrayList<String>> lists ;
    
    public SplitArrayList () throws IOException { // gets through the initial list of class ModifiFile, initializes a list that contains children of this list
        this.mFile = new TakeFile();
        wordsList = mFile.TakeLines();
        this.lists = new ArrayList<ArrayList<String>>();
    }
    
            
    //breaks the initial list into smaller and stored in a list
    //end returns that list
    public ArrayList<ArrayList<String>> SplitList() {
        int numOfLists = -1;
        for (int i=0;i<wordsList.size();i++) {
                
            if ( i % 240 == 0) {
                ArrayList<String> tmpList = new ArrayList<String>();
                lists.add(tmpList);
                numOfLists ++;
                if (i==0) {
                    lists.get(numOfLists).add(wordsList.get(i));
                }
            }
            if ( i!= 0) {
                lists.get(numOfLists).add(wordsList.get(i));
            }   
                
        }
        return lists;
    
    }
            
    
}
