/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day1;

import advent.AdventClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day1 extends AdventClass {

    public Day1() {
        super("Day 1 - Report Repair","");
    }

    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public void run () {
        File inf = new File(inputFname("day1_input.txt"));
        int[] table = new int[1000];
        int tsize = 0;

        try {
            Scanner sc = new Scanner(inf);
            while (sc.hasNextInt())  {
                table[tsize] = sc.nextInt();
                tsize++;
            }
            partOne(table,tsize);
            partTwo(table,tsize);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void partOne(int[] table, int tsize) {
            for (int i=0; i<tsize-1; i++) {
                for (int j=i+1; j<tsize; j++) {
                    int sum = table[i]+table[j];
                    if (sum==2020) {
                        System.out.println("a="+table[i]);
                        System.out.println("b="+table[j]);
                        System.out.println("p="+table[i]*table[j]);
                    }
                }
            }
    }

    private void partTwo(int[] table, int tsize) {
            for (int i=0; i<tsize-2; i++) {
                for (int j=i+1; j<tsize-1; j++) {
                    for (int k=j+1; k<tsize; k++) {
                        int sum = table[i]+table[j]+table[k];
                        if (sum==2020) {
                            System.out.println("");
                            System.out.println("a="+table[i]);
                            System.out.println("b="+table[j]);
                            System.out.println("c="+table[k]);
                            System.out.println("p="+table[i]*table[j]*table[k]);
                        }
                    }
                }
            }
    }
}
