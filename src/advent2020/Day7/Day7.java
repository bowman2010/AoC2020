package advent2020.Day7;

import advent.AdventClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day7 extends AdventClass {

    private static HashMap<String, Luggage> luggages;

    public Day7() {
        super("Day 7 - Handy Haversacks", "");
        luggages = new HashMap<>();
    }

    /**
     * getLuggage : self explanatory
     * @param color
     * @return the luggage of the specified color
     */
    public static Luggage getLuggage(String color) {
        return luggages.get(color);
    }

    /**
     * Add a new luggage from it's definition
     *
     * @param definition
     */
    public void addLuggage(String definition) {
        Luggage lug = new Luggage(definition);
        luggages.put(lug.getColor(), lug);
    }

    public void listing() {
        int count=0;
        for (String col: luggages.keySet()) {
            count++;
            System.out.printf("%03d : %s\n",count,col);
        }
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
        //listing();
        problem01();
    }

    /**
     * main method for testing
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        Day7 d7 = new Day7();
        d7.run();
    }

    /**
     * First part of AoC Day7
     */
    private void problem01() {
        int lugCount = 0;
        int okCount = 0;
        String wanted = "shiny gold";

        System.out.println("Problem 01");
        for (String acolor : luggages.keySet()) {
            Luggage lug = luggages.get(acolor);
            int n = lug.numberOf(wanted);
            if (n > 0) {
                okCount++;
            }
            lugCount += n;
        }
        System.out.println("Number of luggages that contains " + wanted + " : " + okCount);
        System.out.println("Total nb of " + wanted + " luggages : " + lugCount);
    }
}
