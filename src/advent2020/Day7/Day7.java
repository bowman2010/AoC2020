package advent2020.Day7;

import advent.AdventClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day7 extends AdventClass {
    HashMap<String, Luggage> luggages; 
    
    public Day7() {
        super("Day 7 - Handy Haversacks","");
        luggages = new HashMap<>();
    }
    
    /**
     * Add a new luggage from it's definition
     * @param definition 
     */
    public void addLuggage(String definition) {
        Luggage lug = new Luggage(definition);
        luggages.put(lug.getColor(), lug);
    }

    /**
     * Load data from the file and populate
     */
    public void loadData() {
        try {
            String fn = inputFname("day7_input.txt");
            Scanner sc = new Scanner(new File(fn));
            while (sc.hasNextLine()) {
                addLuggage(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Main execution method
     */
    @Override
    public void run() {
        loadData();
        System.err.println("");
    }
    
    /**
     *  main method for testing 
     * @param args - not used
     */
    public static void main(String[] args) {
        Day7 d7 = new Day7();
        d7.run();
    }
}
