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
        
        StudentList list = new StudentList();
        list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);
        list.insert(e);
        list.insert(f);
        list.insert(g);
        list.insert(h);
        
        list.printList();
        //System.out.println(list.NumStudents);
        /*System.out.println(list.root.left.item.toString()); // Patrick
        System.out.println(list.root.right.item.toString()); // Camden
        System.out.println(list.root.item.toString()); // Me
        System.out.println(list.root.right.left.item.toString());
        System.out.println(list.root.right.right.item.toString());*/
        
    }
    
}