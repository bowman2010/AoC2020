/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day7;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bowman
 */
public class Luggage {
    private String color;
    private final HashMap<String,Integer> content;
    boolean done;

    /**
     * Constructor
     * @param definition     
     */
    public Luggage(String definition) {
        content = new HashMap<>();
        this.done = false;
        this.setup(definition);
    } // eof constructor

    /**
     * return the color of this bag
     * @return a string
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Parse contentStr and populate content HashMap
     * @param contentStr 
     */
    private void addContent(String contentStr) {
        if (contentStr.contains("no other")) return;
        Pattern pat = Pattern.compile("(\\d+)\\s*(.*)");
        
        String s1=contentStr.replace(".", ""); // remove final dot
        String[] splitted = s1.split(","); 
        for (String spl:splitted) {
            spl=spl.trim();
            Matcher m = pat.matcher(spl);
            if (m.matches()) {
                int count = Integer.parseInt(m.group(1));
                String bcolor = m.group(2);
                content.put(bcolor, count);
            }
        }
    } // eof addContent()

    private void setup(String definition) {
        String str;
        String separator = "contain";

        str = definition.replace("bags", "");
        str = str.replace(".", "");
        int n = str.indexOf(separator);
        String acolor = str.substring(0, n).trim();
        String acontent = str.substring(n+separator.length()).trim();

        this.color = acolor;
        addContent(acontent);
    }
    
} // eof class Luggage
