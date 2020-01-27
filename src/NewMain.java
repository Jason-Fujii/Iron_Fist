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
        /*IFMA one = new IFMA();
        System.out.println(one.toString());
        LFA two = new LFA();
        two.addHonor(25);
        two.addCombat(50);
        System.out.println(two.toString());*/
        Student a = new IFMA("Jason Fujii", 22);
        Student b = new IFMA("Patrick Tatevossian", 30);
        Student c = new IFMA("Justin Fujii", 20);
        Student d = new IFMA("Camden Brundage", 22);
        Student e = new IFMA("Daisy Acosta", 17);
        Student f = new IFMA("Alex Berchow", 9);
        Student g = new IFMA("Zain Blah", 18);
        Student h = new IFMA("Cole Jane", 29);
        
        a.addIntelligence(1000);
        b.addCombat(50);
        c.addHonor(49);
        d.addIntelligence(50);
        e.addCombat(39);
        f.addCombat(345);
        g.addCombat(69);
        h.addCombat(34);
        
        StudentList list = new StudentList();
        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);
        list.insert(e);
        list.insert(f);
        list.insert(g);
        list.insert(h);
        
        //list.printList();
        
        XPList xpList = new XPList();
        xpList.insert(a);
        xpList.insert(b);
        xpList.insert(c);
        xpList.insert(d);
        xpList.insert(e);
        xpList.insert(f);
        xpList.insert(g);
        xpList.insert(h);
        
        //xpList.printList();
        
        //GUI IFMA = new GUI();
        //list.Search("Jason Fujii");
        //list.Search("Daisy Acosta");
        list.Search("Camden");
    }
    
}