/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advent;

/**
 *
 * @author bowman
 */
public class InfoClass extends AdventClass {

    
    public InfoClass() {
        super("Help","This is the help page");
        
    }

    @Override
    public void run() {
           System.out.println("title: "+title);
           System.out.println("desc:"+description);
    }
}
