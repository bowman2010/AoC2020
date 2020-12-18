/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day2;

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
public class Day2 extends AdventClass {

    public Day2() {
        super("Day 2 - Password Philosophy","");
    }
    
    /**
     *
     * @throws FileNotFoundException
     */
    @Override
    public void run() {
        int count = 0;
        int pw1ok=0;
        int pw2ok=0;

        File inf = new File(inputFname("day2_input.txt"));
        Scanner sc;
        try {
            sc = new Scanner(inf);
            while (sc.hasNextLine()) {
                String pwline = sc.nextLine();
                if (checkPw1(pwline)) {
                    pw1ok++;
                }
                if (checkPw2(pwline)) {
                    pw2ok++;
                }
                count++;
            }

            System.out.println("Read "+count+" password lines");
            System.out.println(pw1ok+" password lines passes policy 1");
            System.out.println(pw2ok+" password lines passes policy 2");
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Day2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

    private static int countChars(String s, char c) {
        int count=0;
        
        for (int i=0; i<s.length();i++) {
            if (s.charAt(i)==c) { count++; }
        }
        return count;
    }

    private static boolean checkPw1(String pwline) {
                String[] t = pwline.split(" ");
                char pwc = t[1].charAt(0);
                String[] sminmax = t[0].split("-");
                int min = Integer.parseInt(sminmax[0]);
                int max = Integer.parseInt(sminmax[1]);
                String pwstr = t[2];
                int n = countChars(pwstr, pwc);
                boolean rv = (n>=min && n<=max);
                return rv;
    }

    private static boolean checkPw2(String pwline) {
                String[] t = pwline.split(" ");
                char pwc = t[1].charAt(0);
                String[] sval = t[0].split("-");
                int pos1 = Integer.parseInt(sval[0]);
                int pos2 = Integer.parseInt(sval[1]);
                String pwstr = t[2];
                
                boolean rv = (
                         (pwstr.charAt(pos1-1)==pwc && pwstr.charAt(pos2-1)!=pwc)
                    || (pwstr.charAt(pos1-1)!=pwc && pwstr.charAt(pos2-1)==pwc)
                );
                
                return rv;
    }
}
