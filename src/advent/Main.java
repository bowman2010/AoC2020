/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent;

import advent2020.Day1.Day1;
import advent2020.Day2.Day2;
import advent2020.Day3.Day3;
import advent2020.Day4.Day4;
import advent2020.Day5.Day5;
import advent2020.Day6.Day6;
import java.util.ArrayList;

/**
 *
 * @author bowman
 */
public class Main {


    public static void main(String[] args) {
        ArrayList<AdventClass> calendar;
        
        calendar=new ArrayList<>();
        calendar.add(new InfoClass());
        calendar.add(new Day1());
        calendar.add(new Day2());
        calendar.add(new Day3());
        calendar.add(new Day4());
        calendar.add(new Day5());
        calendar.add(new Day6());

        while (true) {
            clearScreen();
            for (int i=0; i<calendar.size(); i++) {
                System.out.println(i+" - "+calendar.get(i).title);   
            }
            int mc = Utils.askForInt("Make our choice [0-"+(calendar.size()-1)+"] : ");
            clearScreen();
            if (mc>=0 && mc<calendar.size()) {
                AdventClass ac = calendar.get(mc);
                if (ac!=null) ac.run();
                Utils.askForString("--- Press enter ---");
            }
        }
    }

    private static void clearScreen() {
        for (int i=0; i<30; i++) System.out.println("");
    }

}
