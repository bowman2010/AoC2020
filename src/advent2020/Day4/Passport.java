/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day4;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bowman
 */
class Passport {

    String[] required = { "byr", "iyr", "eyr", "hgt","hcl","ecl","pid" };
    HashMap<String,String> fields;

    public Passport() {
        fields = new HashMap<>();
    }
    
    public void setField(String s) {
        String[] fi = s.split(":");
        this.fields.put(fi[0],fi[1]);
    }
    
    public void setFields(String s) {
        for (String fielddef: s.split("\\s+")) {
            setField(fielddef);
        }
    }
    

    public boolean isValid() {
        return checkRequiredFields(required);
    }

    public boolean isValid2() {
        if (!checkRequiredFields(required)) return false;
        
        if (!between(fields.get("byr"),1920,2002)) return false; // four digits; at least 1920 and at most 2002.
        if (!between(fields.get("iyr"),2010,2020)) return false;  // four digits; at least 2010 and at most 2020.
        if (!between(fields.get("eyr"),2020,2030)) return false; // four digits; at least 2020 and at most 2030.
        
        if (!checkHair(fields.get("hcl"))) return false;
        if (!checkEyeColor(fields.get("ecl"))) return false;
        if (!checkPassportId(fields.get("pid"))) return false;
        if (!checkHeight(fields.get("hgt"))) return false;
        return true;
    }
    
    public boolean checkRequiredFields(String[] required) {
        for (String reqf: required) {
            if (! fields.containsKey(reqf)) return false;
        }
        return true;
    }
    
    private boolean checkPassportId(String ppid) {
        return ppid.matches("\\d{9}");
    }

    private boolean checkEyeColor(String eyecol) {
    // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
       return ( 
                    (eyecol.compareTo("amb")==0)
               || (eyecol.compareTo("blu")==0)
               || (eyecol.compareTo("brn")==0)
               || (eyecol.compareTo("gry")==0)
               || (eyecol.compareTo("grn")==0)
               || (eyecol.compareTo("hzl")==0)
               || (eyecol.compareTo("oth")==0)
       );
    }
    
    private boolean checkHair(String str) {
        Pattern p; 
        p = Pattern.compile("#\\p{XDigit}{6}");
        Matcher m = p.matcher(str);
        boolean ok = m.find();
        return (ok);
    }

    private boolean checkHeight(String s) {
                // If cm, the number must be at least 150 and at most 193.
                // If in, the number must be at least 59 and at most 76.
        Pattern p;
        Matcher m;
        
        p = Pattern.compile("(\\d+)(cm)");
        m = p.matcher(s);
        if (m.find()) {
            return (between(m.group(1), 150, 193));
        } 
        
        p = Pattern.compile("(\\d+)(in)");
        m = p.matcher(s);
        if (m.find()) {
            return (between(m.group(1), 56, 76));
        } 
        return false;
    }
    
    
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        if (isValid()) sb.append("  VALID: "); 
            else sb.append("INVALID: ");
        for (String k: fields.keySet()) {
            sb.append(' ');
            sb.append(k); 
            sb.append(':');
            sb.append(fields.get(k));
        }
        return sb.toString();
    }

    private boolean between(String vs, int min, int max) {
        int vsi = Integer.parseInt(vs);
        return ((vsi>=min)&&(vsi<=max));
    }


}
