package advent2020.Day7;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Luggage {
    String color;
    HashMap <String,Integer> content;

    Luggage(String color, String content) {
        this.color = color;
        this.content = new HashMap<>();
        addContent(content);
    }

    /**
     *  Add luggages inside this one
     * @param content 
     */
    public final void addContent(String content) {
        String[] items;
        Pattern p;
        p = Pattern.compile("\\s*(\\d+)\\s*([\\s\\w]*)");
  
        items = content.split(",");
        for (String item:items) {
            Matcher m = p.matcher(item);
            if (m.find()) {
                String lcolor = m.group(2);
                Integer lcount = new Integer(m.group(1));
                this.content.put(lcolor,lcount);
            }
        }       
    }

    void print() {
        System.out.println("Luggage type : "+this.color+"  contains");
        for (String key :content.keySet()) {
            Integer nb = content.get(key);
            System.out.println("\t\t"+nb+"  ["+key+"]");
        }
        System.out.println("");
    }
    
   public  int findLuggage(String s) {
        int cnt = 0;
        if (color.compareTo(s)==0) return 1;
        
        for (String lu:content.keySet()) {
            Integer contentcount = content.get(lu);
            cnt+=contentcount*Day7.luggages.get(lu).findLuggage(s);
        }
        return cnt;
    }
    
}
