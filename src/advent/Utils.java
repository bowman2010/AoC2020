package advent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author bowman
 */
public class Utils {
    
    public static Scanner kbdScan() {
        return new Scanner(System.in);
    }


/**
 * askForInt : ask for a valid integer
 * @param prompt
 * @return an integer
 */    
    public static int askForInt(String prompt) {
        Scanner kbd=kbdScan();
        boolean isOkay = false;
        
        do {
            System.out.print(prompt);
            if (kbd.hasNextInt()) return kbd.nextInt();
            
            System.out.println("!!  Its not a valid integer .. retry");
                kbd.next();
        } while (true);  
    } 
    
/**
 * askForDouble : ask for a valid double
 * @param prompt : message to show
 * @return a double
 */    
    public static double askForDouble(String prompt) {
        Scanner kbd=kbdScan();        
        do {
            System.out.print(prompt);
            if (kbd.hasNextDouble()) return kbd.nextDouble();
            
            System.out.println("!!  Its not a valid real .. retry");
                kbd.next();
        } while (true);  
    } 
    
    /**
     * Show prompt and wait for a String;
     * @param prompt
     * @return a String
     */ 
    public static String askForString(String prompt) {
        Scanner kbd=kbdScan();
        System.out.print(prompt);

        return kbd.nextLine();
    }
    
    /**
     * Check if a number in 
     * @param number : number to check
     * @param min : minimal value
     * @param max : maximal value
     * @return true if in range, false otherwise
     */
    public static boolean inRange(int number, int min, int max) {
        return (number >= min && number <=max);
    }
    
    
       
/**
 * dotAligned - format a double 
 * Return a dot aligned double representation
 * @param iPlaces places for integer part
 * @param dPlaces places for decimal part
 * @param value   Formatted 
 * @return 
 */
    public static String dotAligned (
            int iPlaces, 
            int dPlaces, double value)
    {
      StringBuilder sb1 = new StringBuilder(iPlaces);
      StringBuilder sb2 = new StringBuilder(dPlaces);

      int iPart = (int) value;
      int dPart = (int) ((value-iPart)*Math.pow(10, dPlaces));
      
      sb1.append(iPart);
      while (sb1.length()<iPlaces) sb1.insert(0, ' ');
              
      sb2.append(dPart);
      if (sb2.length()>dPlaces) sb2.delete(dPlaces+1,2000);
      
      return sb1.toString()+'.'+sb2.toString();
    }
    
    
 
    
    public static String strPad(String s, int width, char p) {
        int len = s.length();
        String ts1 = "";
        for (int n=1; n<=(width-len); n++) {
            ts1 += p;
        }
        return ts1+s;
    }

    public static String binaryStrPadded(int n,int lg) {
        String bstring = Integer.toBinaryString(n);
        bstring = Utils.strPad(bstring, lg, '0');
        return bstring;
    }
   
    public static void horizLn(int n, char c) {
        for (int i=0; i<n; i++ ) 
            System.out.print(c);
        System.out.println();
    }
    
    public static void clearScreen() {
        for (int n=1;n<100;n++) {
            System.out.println();
        }
    }
    
    public static void print(String s) {
        System.out.print(s);
    }
    
    public static void println(String s) {
        System.out.println(s);
    }
    
    public static void printError(String s) {
        System.err.println(s);
    }
    
}
