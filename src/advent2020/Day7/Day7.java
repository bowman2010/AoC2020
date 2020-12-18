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
    public static HashMap<String,Luggage> luggages;
    
    public Day7() {
        super("Day 7 - Handy Haversacks","");
        luggages = new HashMap<>();
    }
    
    public static void main(String[] args) {
        Day7 aoc;
        aoc = new Day7();
        aoc.run();
    }

    /**
     *
     */
    @Override
    public void run() {
        readData();
        list_data();
        countlug("shiny gold"); 
    }
    
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
                    String s1 = s.substring(0, a-1); // The Luggage color
                    String s2 = s.substring(a+separator.length(), s.length()); // Luggage content string
                    luggages.put(s1,new Luggage(s1, s2)); // add a new luggage
                }
            } // eo while
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int countlug(String s) {
        for (String luname: luggages.keySet()) {
            int jj = luggages.get(luname).findLuggage(s);
            System.out.println("luname:"+luname+" : "+jj);
        }
        return 9;
    }
    
    private void list_data() {
        for (String key:luggages.keySet()) {
            Luggage lu = luggages.get(key);
             lu.print();
        
        }
    
    }

}
