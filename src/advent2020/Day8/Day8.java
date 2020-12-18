package advent2020.Day8;

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
public class Day8  extends AdventClass {
    
    public static final int MAXCODESIZE = 1000;
    int codesize = 0;
    String[] opcodes;
    int[] opcarg;
    boolean[] done;
    int accu = 0;
    
    public Day8() {
        super("Day 8 - Handheld Halting","");
        opcodes = new String[MAXCODESIZE];
        opcarg = new int[MAXCODESIZE];
        done = new boolean[MAXCODESIZE];
    }
 
    public void loadProgram() throws FileNotFoundException {
        String fn = inputFname("day8_input.txt");
        File file = new File(fn);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String  s = sc.nextLine();
            var spls = s.split(" ");
            opcodes[codesize] = spls[0];
            opcarg[codesize] = Integer.parseInt(spls[1]);
            done[codesize] = false;
            codesize++;
        }
    }
    
    
    private int executePrg() {
        int codeptr=0;
        
        while (true) {     
            if (done[codeptr]) return accu;

            String opc = opcodes[codeptr];
            int opca = opcarg[codeptr];
            System.out.printf("Addr:%05d op=%4s %8d  accu=%s\n", codeptr,opc,opca,accu);
            done[codeptr]=true;
            
            switch(opc) {
                
                case "nop" : {
                    codeptr++;
                }  break;
                
                case "acc" : {
                    accu+=opcarg[codeptr];
                    codeptr++;
                } break;

                case "jmp" : {
                    codeptr+=opcarg[codeptr];
                } break;
            }
        }
    }
    
    @Override
    public void run() {
        try {
            loadProgram();
            executePrg();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Day8 d8 = new Day8();
        d8.run();
    }

}
