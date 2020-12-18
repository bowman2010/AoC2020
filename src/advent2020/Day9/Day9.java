package advent2020.Day9;

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
public class Day9 extends AdventClass {
    ArrayList<Long> numbers;
    
    public Day9() {
        super("Day 9 - Encoding Error","");
        numbers = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Day9 d9 = new Day9();
        d9.run();
    }
   
    @Override
    public void run() {
        readData();
        long invalid = partOne();
        if (0<invalid) {
            int idx=partTwo(invalid);
            checkSerie(idx,invalid);
        }
    }
    
    public void readData() {
        int linecount = 0;
        String fn = inputFname("day9_input.txt");
        File file = new File(fn);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLong()) {
                linecount++;
                numbers.add(sc.nextLong());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day9.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("read "+linecount+" lines");
    }

    private long partOne() {
        for (int n=25; n<numbers.size(); n++) {
            if (checkOk(n)==false) {
                System.out.println("found an issue with index :"+n+" Value : "+numbers.get(n));
                return numbers.get(n);
            }
        }
        return -1;
    }

    private boolean checkOk(int n1) {
        long wanted = numbers.get(n1);
        long sum;
        
        //System.out.println("method checkOk("+n1+")");
        
        for (int idx1=n1-25;  idx1<n1;  idx1++) {
            for (int idx2=idx1+1; idx2<n1; idx2++ ) {
                long val1 = numbers.get(idx1);
                long val2 = numbers.get(idx2);
                sum = val1+val2;
/*
                System.out.print("checking between ");
                System.out.printf("numbers[%d](%d)",idx1,val1);
                System.out.print(" and ");
                System.out.printf("numbers[%d](%d)",idx2,val2);
                System.out.println("  sum="+sum);
*/
                if (sum==wanted) {
//                    System.out.println("Found ok");
                    return true;
                }
             }
         }
        return false;
    }

    private int partTwo(long invalid) {
        long sum;
        
        System.out.println("partTwo("+invalid+")");
        // check from index n=0 up to numbers.size
        // add from this point to end until found invalid number
        
        for (int n=0; n<numbers.size(); n++) {
            sum=numbers.get(n);
            for (int j=n+1;j<numbers.size();j++) {
                sum+=numbers.get(j);
                if (sum>invalid) break;
                if (sum==invalid) {
                    System.out.println("serie found starting from "+n);
                    return n;
                }
            }
        }
        return -1;
    }

    private void checkSerie(int idx, long inval) {
        long sum,min,max;
        sum=0; 
        min=Long.MAX_VALUE;
        max=0;
        while (sum!=inval) {
            long locval = numbers.get(idx);
            sum+=locval;
            if (locval>max) max=locval;
            if (locval<min) min=locval;
            idx++;
        }
        System.out.println("serie min="+min+" max="+max);
        System.out.println("min+max="+(min+max));
    }

} //eof class