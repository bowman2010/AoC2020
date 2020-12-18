/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day6;

import advent.AdventClass;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day6 extends AdventClass {

    public Day6() {
        super("Day 6 - Custom Customs","");
    }
    
    public void run()  {
        ArrayList<String> responses;
        try {
            responses = loadStringArray(inputFname("day6_input.txt"));
            PartOne(responses);
            PartTwo(responses);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void PartOne(ArrayList<String> responses) {
        boolean questions[] = null;
        questions = new boolean[26];
        int counter = 0;
        int totcounter = 0;

        for (int i=0; i<26; i++)  { questions[i]=false; }
        
        for (String s: responses) {
            if (s.matches("^\\s*$")) {
                counter=0;
                for (boolean b: questions)  if (b) counter++;
                totcounter+=counter; 
                for (int i=0; i<26; i++)  questions[i]=false;
            } 
            else {
                for (int j=0; j<s.length(); j++) {
                    questions[s.charAt(j)-'a']=true;
                }
            }
        }
        counter=0;
        for (boolean b: questions)  if (b) counter++;
        totcounter+=counter; 
        System.out.println("Part one Grand total: "+totcounter);
    }

    private void PartTwo(ArrayList<String> responses) {
        int  questions[] = new int[26];
        int counter;
        int totcounter = 0;
        int membercount = 0;

        for (int i=0; i<26; i++)  questions[i]=0;
        for (String s: responses) {
            if (s.matches("^\\s*$")) {
                counter = 0;
                for (int i=0; i<26; i++) 
                    if (questions[i]==membercount)  counter++;
                totcounter+=counter;
                membercount=0;
                for (int i=0; i<26; i++)  questions[i]=0;
            } 
            else {
                membercount++;
                for (int j=0; j<s.length(); j++) { questions[s.charAt(j)-'a']++;  }
            }
        }
        counter = 0;
        for (int i=0; i<26; i++)  if (questions[i]==membercount)  counter++;
        totcounter+=counter;
        System.out.println("Part two Grand total: "+totcounter);

    }
}
