/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bowman
 */
public class AdventClass {
    public String title;
    public String description;

    public AdventClass() {
        this.title = "Dummy title";
        this.description= "";
    }

    public AdventClass(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    public void run() {
        System.out.println("running dummy prog");
    }
    
    public void printTable(int[] intable, String name) {
        System.out.print(name+"= [ ");
        for (int idx=0; idx<intable.length; idx++) {
            System.out.print(intable[idx]);
            if (idx<intable.length-1) System.out.print(",");
        }
        System.out.println(" ]");
    }
    
    public void printStrIdx(String s, int idx) {
        System.out.println("["+s+"]");
        System.out.print(" ");
        for (int i=0; i<idx; i++) System.out.print("_");
        System.out.println("^("+idx+")\n");
    }
    
     public boolean between(int a, int ba, int bb ) {
        return ((a>=ba)&&(a<=bb))||((a>=bb)&&(a<=ba));
    }

     public String inputFname(String inf) {
        return AdventClass.class.getClassLoader().getResource("advent2020/inputs/"+inf).getPath();
    }

    public ArrayList<String> loadStringArray(String fname) throws FileNotFoundException {
        ArrayList<String> strs = new ArrayList<>();
        File f = new File(fname);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            strs.add(sc.nextLine());
        }
        return strs;
    }
}
