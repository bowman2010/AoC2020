package advent2020.Day7;

import java.util.HashMap;

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

/**
 *  populate content  map  using contentString
 */    
    public void resolveContent() {
        
    }
    
}
