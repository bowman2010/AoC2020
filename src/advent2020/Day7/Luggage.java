package advent2020.Day7;

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
    HashMap<Luggage,Integer> content;
    
    public Luggage(String selfcolor, String contentString) {
        this.selfcolor = selfcolor;
        this.contentString = contentString;
        content = new HashMap<>();
    }
    
    public String color() {
        return this.color();
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
                Luggage olu = Day7.getLuggage(spl);
                content.put(olu, count);
            }
        }                                                                                                                                                                         
    } // eof resolveContent

    
    public void dump() {
        System.out.println("----------------------------------------------");
        System.out.println("luggage "+this.selfcolor+" contains");
        
        content.forEach(
                (K,V) -> System.out.printf("%d %s\n",V,K.color())
        );
        
        
        System.out.println("");
    }
}
