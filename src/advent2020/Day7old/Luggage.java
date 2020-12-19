package advent2020.Day7old;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author bowman
 */
class Luggage {
    String selfcolor;
    String contentString;
    HashMap<String,Integer> content;
    boolean checked = false;
    
    public Luggage(String selfcolor, String contentString) {
        this.selfcolor = selfcolor;
        this.contentString = contentString;
        content = new HashMap<>();
    }
    
    public String color() {
        return this.selfcolor;
    }
    
    public boolean unCheck() {
         this.checked = false;
        return this.checked;
    }
    
    public int contains(String col) {
        int counter = 0;
        
        Day7.addTrace(this.selfcolor);
        if (checked) return 0;
        this.checked=true;
        if (col.compareTo(this.selfcolor)==0) return 1;

        for (String c:content.keySet()) {
            Luggage lug = Day7.getLuggage(c);
            int count = content.get(c);
            counter+=count*lug.contains(col);
        }
        
        return counter;
    }
/**
 *  populate content  map  using contentString
 */    
    public void resolveContent() {
        if (contentString.contains("no other")) return;
        Pattern pat = Pattern.compile("(\\d+)\\s*(.*)");
        
        String s1=contentString.replace(".", ""); 
        String[] splitted = s1.split(",");
        for (String spl:splitted) {
            spl=spl.trim();
            Matcher m = pat.matcher(spl);
            if (m.matches()) {
                int count = Integer.parseInt(m.group(1));
                String color = m.group(2);
                content.put(color, count);
            }
        }                                                                                                                                                                         
    } // eof resolveContent

}