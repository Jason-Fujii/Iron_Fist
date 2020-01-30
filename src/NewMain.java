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
import java.io.*;
import java.util.*;

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
        
        
        /*Student a = new IFMA("Jason Fujii", 22);
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
        h.addCombat(34);*/
        
        StudentList list = new StudentList();
        /*list.insert(a);
        list.insert(b);
        list.insert(c);
        list.insert(d);
        list.insert(e);
        list.insert(f);
        list.insert(g);
        list.insert(h);*/
        
        //list.printList();
        
        /*XPList xpList = new XPList();
        xpList.insert(a);
        xpList.insert(b);
        xpList.insert(c);
        xpList.insert(d);
        xpList.insert(e);
        xpList.insert(f);
        xpList.insert(g);
        xpList.insert(h);*/
        
        //xpList.printList();
        
        //Read from Student_Info.txt
        
        try
        {
            list = list.FileRead("code.txt");
        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("File not found");
        }
        catch(IOException io)
        {
            System.out.println("IO Exception!");
        }
        
        list.printList();
        
        Student blah = new IFMA("Jonathan");
        Student ugh = new IFMA("Ezekiel");
        
        list.insert(blah);
        list.insert(ugh);
        
        list.printList();
        
        //print to Student_Info.txt
        try
        {
            list.PrintToFile("code.txt");
        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("File not found");
        }
        catch(IOException io)
        {
            System.out.println("IO Exception");
        }
        
        //GUI IFMA = new GUI();
        //list.Search("Jason Fujii");
        //list.Search("Daisy Acosta");
        //list.Search("Camden");
    }
    
    //Gives a GUI for the user to use the program
    public void mainSequence()
    {
        
        Scanner sc = new Scanner(System.in);
        int userIn = -1;
        boolean cont = true;
        String fileName = "";
        System.out.println("Enter the name of the file you want to upload");
        fileName = sc.next();
        while(cont)
        {
            System.out.println("What would you like to do?");
            System.out.println("Enter the number of the task you want to do");
            System.out.println("1) Print a student to the screen");
            System.out.println("2) Print multiple students to the screen");
            System.out.println("3) Add a student to the list");
            System.out.println("4) Update a current student's XP");
            System.out.println("5) Remove a student from this list");
            System.out.println("6) Update your file");
            System.out.println("NOTE: Rememer to update your file before you close the program");
            userIn = sc.nextInt();
            int count = 0;
            while (userIn > 4 || userIn < 1)
            {
                System.out.println("You can't choose that number...");
                System.out.println("Enter a valid option.");
                if(count%3 == 0)
                {
                    System.out.println("1) Add a student to the list");
                    System.out.println("2) Update a current student's XP");
                    System.out.println("3) Remove a student from this list");
                    System.out.println("4) Update your file");
                }
                userIn = sc.nextInt();
            }
        }
    }
    
    
    //Gives a GUI for the user to input a new student
    public void addStudent(StudentList list)
    {
        Scanner user = new Scanner(System.in);
        String n, b;
        long tXP, i, h, c, e;
        System.out.println("What is the student's name?");
        n = user.next();
        System.out.println("What is their belt");
        b = user.next();
        System.out.println("Do they have any XP?");
        if(user.next().equals("yes") || user.next().equals("Yes"))
        {
            System.out.println("How much Intelligence XP?");
            i = user.nextLong();
            System.out.println("How much Honor XP?");
            h = user.nextLong();
            System.out.println("How much Combat XP?");
            c = user.nextLong();
            System.out.println("How much Experience XP?");
            e = user.nextLong();
            tXP = i + h + c + e;
            Student a = new IFMA(n, b, tXP, i, h, c, e);
            list.insert(a);
        }
        else
        {
            Student a = new IFMA(n,b);
            list.insert(a);
        }
    }
    
    public void updateStudent(StudentList list)
    {
        String n;
        Scanner user = new Scanner(System.in);
        System.out.println("What is the student's name?");
        n = user.next();
        Student s = list.Search(n);
        System.out.println("What would you like to Update?");
        if(user.next().equals("name") || user.next().equals("Name"))
        {
            System.out.println("Input the correct name");
            s.setName(user.next());
        }
        else if(user.next().equals("belt") || user.next().equals("Belt"))
        {
            System.out.println("Would you like to promote them by one belt?");
            if(user.next().equals("yes") || user.next().equals("Yes"))
                s.rankUp();
            else
            {
                System.out.println("Input the correct belt");
                
            }
        }
        else if(user.next().equals("Intelligence") || user.next().equals("intelligence"))
        {
            System.out.println("Input the correct Intelligence XP");
            s.setIntelligence(user.nextLong());
        }
        else if(user.next().equals("Honor") || user.next().equals("honor"))
        {
            System.out.println("Input the correct Honor XP");
            s.setHonor(user.nextLong());
        }
        else if(user.next().equals("Combat") || user.next().equals("combat"))
        {
            System.out.println("Input the correct Combat XP");
            s.setCombat(user.nextLong());
        }
        else if(user.next().equals("experience") || user.next().equals("Experience"))
        {
            System.out.println("Input the correct Experience XP");
            s.setExperience(user.nextLong());
        }
        else
        {
            System.out.println("That is an invalid response.");
        }
        
        
    }
    
}