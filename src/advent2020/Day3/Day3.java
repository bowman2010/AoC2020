/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day3;

import advent.AdventClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day3  extends AdventClass {
    
    static ArrayList<String> forest;

    public Day3() {
        super("Day 3 - Toboggan Trajectory","");
    }

    /**
     *
     */
    @Override
    public void run() {
        File inf = new File(inputFname("day3_input.txt"));
        Scanner sc;
        try {
            sc = new Scanner(inf);
            forest=new ArrayList<>(2000);
            while (sc.hasNextLine()) {
                forest.add(sc.nextLine());
            }
            
            long mcr = 1;
            int crashes ;
            int dx,dy;

            dx=1; dy=1;
            crashes=countCrashes(dx,dy);
            mcr*=crashes;
            System.out.printf("<%d,%d> : %d\n", dx,dy,crashes);

            dx=3; dy=1;
            crashes=countCrashes(dx,dy);
            mcr*=crashes;
            System.out.printf("<%d,%d> : %d\n", dx,dy,crashes);

            dx=5; dy=1;
            crashes=countCrashes(dx,dy);
            mcr*=crashes;
            System.out.printf("<%d,%d> : %d\n", dx,dy,crashes);

            dx=7; dy=1;
            crashes=countCrashes(dx,dy);
            mcr*=crashes;
            System.out.printf("<%d,%d> : %d\n", dx,dy,crashes);

            dx=1; dy=2;
            crashes=countCrashes(dx,dy);
            mcr*=crashes;
            System.out.printf("<%d,%d> : %d\n", dx,dy,crashes);

            System.out.println("mcr="+mcr);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int countCrashes(int dx, int dy) {
            int posx=0;
            int crashCount=0;
            int height = forest.size();
            
            for (int i=0; i<height; i+=dy) {
                String fline = forest.get(i);
                int cx = posx%fline.length();
                if (fline.charAt(cx)=='#') crashCount++; 
                posx+=dx;
            }
            return crashCount;
    }
    
}
