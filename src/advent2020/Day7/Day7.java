package advent2020.Day7;

import advent.AdventClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day7 extends AdventClass
{
     static HashMap<String,Luggage> luggages; // List of defined luggages
    
    public Day7() {
        super("Day 7 - Handy Haversacks","");
        luggages = new HashMap<>();
    }
    

    @Override
    public void run() {
        readData();
    }
    
    
    /**
     *  read datafile and create each luggage
     */
    public void readData() {
        try {
            String fn = inputFname("day7_input_1.txt");
             Scanner sc = new Scanner(new File(fn));
            String separator = " contain";
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                s = s.replaceAll("bags*", "");
                int a = s.indexOf(separator);
                if (a<0) { System.out.println("Invalid Line"); }
                else {
                    String s1 = s.substring(0, a-1); // The Luggage color string
                    String s2 = s.substring(a+separator.length(), s.length()); // Luggage content string
                    
                    luggages.put(s1,new Luggage(s1, s2)); // add a new luggage
                }
            } // eo while
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**
 *  main method for testing
 * @param args 
 */    
    public static void main(String[] args) {
        Day7 d7= new Day7();
        d7.run();
    }

} // eof class
