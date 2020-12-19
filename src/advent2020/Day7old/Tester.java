/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day7old;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bowman
 */
public class Tester {
    
    public static void dmpstr(String s) {
        System.out.println("["+s+"] ( "+s.length()+")");
    }

    public void test01() {
        String input = "  \t2 faded gray , 4 posh orange , 3 dull teal , 4 shiny plum     ";
        Pattern pat = Pattern.compile("(\\d*)\\s*(.*)");

        String[] content = input.split(",");
        for (String s:content) {
            s=s.trim();
            Matcher matcher = pat.matcher(s);
            if (matcher.matches()) {
                int count = Integer.parseInt(matcher.group(1));
                String color = matcher.group(2);
                System.out.printf("count:%3s color: %s\n",count,color);
            } else  { System.out.println("No match"); }
        }    
    }

    
    public static void test02() {
        String s1 = " 2 mirrored green , 5 dotted beige , 5 faded white , 3 mirrored fuchsia .";
        Pattern pat = Pattern.compile("(\\d+)\\s*(.*)");
        
        dmpstr(s1);
        s1=s1.replace(".", ""); // remove final dot
        String[] splitted = s1.split(",");
        for (String spl:splitted) {
            spl=spl.trim();
            Matcher m = pat.matcher(spl);
            if (m.matches()) {
                int count = Integer.parseInt(m.group(1));
                String color = m.group(2);
                System.out.printf("count=%d , color=%s\n",count,color);
            }
        }
    }
    
    public static void main(String[] args) {
        test02();
    }
    
}
