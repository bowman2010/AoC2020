/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent2020.Day5;

import advent.AdventClass;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bowman
 */
public class Day5 extends AdventClass {

    public Day5() {
        super("Day 5 - Binary Boarding","");
    }
    
    public void run() {
        ConcurrentSkipListSet<Integer> seatslist = new ConcurrentSkipListSet<>();
        ArrayList<String> tickets;
        int maxseatid = 0;

        try {
            tickets=loadStringArray(inputFname("day5_input.txt"));

            for (String ticket: tickets) {
                String fbs = ticket.substring(0, 7);
                String rls  = ticket.substring(7, 10);
                int row = calc_fb(fbs);
                int col = calc_rl(rls);
                int seatid = row*8+col;
                if (seatid>maxseatid) maxseatid=seatid;
                seatslist.add(seatid);
                System.out.println(ticket+":  seat id "+seatid);
            }
            System.out.println("Max seatid = "+maxseatid);

            int lastSeat = seatslist.first()-1;
            for (Integer n: seatslist) {
                if (n!=lastSeat+1) System.out.print("missing seat "+(lastSeat+1)+"\n");
                lastSeat=n;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static int calc_fb(String fbs) {
        int min=0, max=127;
        for (int i=0; i<fbs.length(); i++) {
            switch(fbs.charAt(i)) {
                case 'F': // lower half
                    max=max-(max-min)/2-1;
                    break;
                case 'B': // upper half
                    min=min+(max-min)/2+1;
                    break;
            }
        }
        return min;
    }

    private static int calc_rl(String fbs) {
        int min=0, max=7;
        for (int i=0; i<fbs.length(); i++) {
            switch(fbs.charAt(i)) {
                case 'L': // lower half
                    max=max-(max-min)/2-1;
                    break;
                case 'R': // upper half
                    min=min+(max-min)/2+1;
                    break;
            }
        }
        return min;
    }


}
