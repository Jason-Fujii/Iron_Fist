/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasonfujii
 */
import ironfist.*;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IFMA one = new IFMA();
        System.out.println(one.toString());
        LFA two = new LFA();
        two.addHonor(25);
        two.addCombat(50);
        System.out.println(two.toString());
    }
    
}
