/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day7;


/**
 *
 * @author bowman
 */
public class Tester {
    
    public static void dmpstr(String s) {
        System.out.println("["+s+"] ( "+s.length()+")");
    }


    public static void test03() {
        String separator = "contain";
        
        str = bbb.replace("bags", "");
        str = str.replace(".", "");
        int n = str.indexOf(separator);
        System.out.println(n);
        String str1 = str.substring(0, n).trim();
        String str2 = str.substring(n+separator.length()).trim();
    }
    public static void main(String[] args) {
        test03();
    }
    
}
