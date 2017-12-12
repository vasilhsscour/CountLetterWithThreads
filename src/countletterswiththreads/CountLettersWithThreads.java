/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countletterswiththreads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vasilhs12
 */
public class CountLettersWithThreads {
    
    private static final int NTHREDS = 50;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            ArrayList<Future<Integer>> Futurelist = new ArrayList<>();
            ArrayList<ArrayList<String>> LineLists = new ArrayList<ArrayList<String>>();
            
            SplitArrayList Lists = new SplitArrayList(); // creates an instance of class SplitArrayList
            LineLists = Lists.SplitList(); // initializes the list
            
            
            long startTime = System.nanoTime(); // starts counting the time of execution of the program
            ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
            
            for(int i =0;i<LineLists.size();i++) {
                CounterWorker counter = new CounterWorker(LineLists.get(i)); // creates an instance of class CountWords
                Callable<Integer> worker = new  Callable<Integer>() {
            
                    @Override
                    public Integer call() throws Exception {
                        return counter.increment();
                    }
                };
                Future<Integer> submit= executor.submit(worker);
                Futurelist.add(submit);
            }
            
            
            
            executor.shutdown();

            while (!executor.isTerminated()) {
            }
            int sum = 0;
            for (Future<Integer> future : Futurelist) {
                try {
                    sum += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            
            long endTime = System.nanoTime(); // stops counts the time of execution of the program
            long totalTime = endTime - startTime; // count the total time
            
            System.out.println("The sum of characters is " +sum); // print the sum of characters
            System.out.println("The run time is : " + totalTime);// print the total run time     
            
        } catch (IOException ex) {
            Logger.getLogger(CountLettersWithThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
