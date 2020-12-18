/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day4;

import advent.AdventClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day4 extends AdventClass {

    public Day4() {
        super("Day 4 - Passport Processing","");
    }

    
    
    public void run() {
        ArrayList<Passport>  passports;
        try {
            passports = readPassportsFile(inputFname("day4_input.txt"));
            System.out.println("check #1: "+check1(passports));
            System.out.println("check #2: "+check2(passports));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    private static long check1(ArrayList<Passport> passports) {
        long rslt = 0;
        for (Passport pp: passports) {
            if (pp.isValid()) rslt++;
        }
        return rslt;
    }

    private static long check2(ArrayList<Passport> passports) {
        long rslt = 0;
        for (Passport pp: passports) {
            if (pp.isValid2()) rslt++;
        }
        return rslt;
    }


    private static ArrayList<Passport> readPassportsFile(String fn) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(fn));
        Passport curpassport = null;
      
        ArrayList<Passport> passports = new ArrayList<>();

        while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.matches("^\\s*$")) {
                    if (curpassport != null) {
                        passports.add(curpassport);
                        System.out.println(curpassport.toString());
                    }
                    curpassport=null;
                } else {
                    if (curpassport==null) curpassport=new Passport();
                    curpassport.setFields(s);
                }
         }
        return passports;
    }

    
}
