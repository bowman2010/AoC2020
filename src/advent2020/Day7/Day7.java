package advent2020.Day7;

import advent.AdventClass;
import java.util.HashMap;

/**
 *
 * @author bowman
 */
public class Day7 extends AdventClass {
    HashMap<String, Luggage> luggages; 
    
    public Day7() {
        super("Day 7 - Handy Haversacks","");
        luggages = new HashMap<>();
    }

    
    public void addLuggage(String definition) {
        Luggage lug = new Luggage(definition);
        luggages.put(lug.getColor(), lug);
    }
    
    /**
     * Main execution method
     */
    @Override
    public void run() {
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
