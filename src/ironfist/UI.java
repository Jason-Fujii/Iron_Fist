/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ironfist;

import java.io.*;
import java.util.*;

/**
 *
 * @author jasonfujii
 */
public class UI {
    private boolean cont;
    
    public UI()
    {
        cont = true;
    }
    
    public void mainSequence() 
    {
        StudentList s = new StudentList();
        Scanner sc = new Scanner(System.in);
        int userIn = -1;
        String fileName = "";
        System.out.println("Enter the name of the file you want to upload\n");
        fileName = sc.nextLine();
        s = openFile(fileName,s);
        while(cont)
        {
            System.out.println("What would you like to do?");
            System.out.println("Enter the number of the task you want to do");
            System.out.println("1) Print a student to the screen");             //DONE
            System.out.println("2) Print multiple students to the screen");     //DONE
            System.out.println("3) Add a student to the list");                 //DONE
            System.out.println("4) Update a current student's XP");             //DONE
            System.out.println("5) Remove a student from this list");
            System.out.println("6) Update your file");                          //DONE
            System.out.println("7) Print the entire list");
            System.out.println("NOTE: Rememer to update your file before you close the program\n");
            userIn = sc.nextInt(); sc.reset();
            int count = 1;
            while (userIn > 7 || userIn < 1)
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
                userIn = sc.nextInt(); sc.reset();
                count++;
            }
            
            switch(userIn)
            {
                case 1: printStudent(s); break;
                case 2: printMult(s); break; //PRINT MULTIPLE STUDENTS TO THE SCREEN
                case 3: addStudent(s); break;
                case 4: updateStudent(s); break;
                case 5: break; //REMOVE STUDENT FROM LIST
                case 6: 
                {   
                    try
                    {
                        updateFile(fileName, s, cont);
                    }
                    catch(FileNotFoundException fnf)
                    {
                        System.out.println("File Name is invalid");
                    }
                    catch(IOException io)
                    {
                        System.out.println("IO Exception");
                    }
                    break;
                }
                case 7: printList(s);
            }
        }
    }
    
    
    
    //Gives a GUI for the user to input a new student
    public void addStudent(StudentList list)
    {
        Scanner user = new Scanner(System.in);
        String n, b;
        long tXP, i, h, c, e;
        System.out.println("What is the student's name?\n");
        n = user.nextLine();
        System.out.println("What is their belt\n");
        b = user.nextLine();
        System.out.println("Do they have any XP?\n");
        String ans = user.nextLine();
        if(ans.equals("yes") || ans.equals("Yes"))
        {
            System.out.println("How much Intelligence XP?\n");
            i = user.nextLong();
            System.out.println("How much Honor XP?\n");
            h = user.nextLong();
            System.out.println("How much Combat XP?\n");
            c = user.nextLong();
            System.out.println("How much Experience XP?\n");
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
    }//End addStudent()
    
    //FIND OUT HOW TO MAKE THIS ON A JPANEL
    
    //Updates values of the requested student
    public void updateStudent(StudentList list)
    {
        String n;
        Scanner user = new Scanner(System.in);
        System.out.println("What is the student's name?\n");
        n = user.nextLine();
        Student s = list.Search(n);
        System.out.println("What would you like to Update?\n");
        String ans = user.nextLine();
        if(ans.equals("name") || ans.equals("Name"))
        {
            System.out.println("Input the correct name\n");
            s.setName(user.nextLine());
        }
        else if(ans.equals("belt") || ans.equals("Belt"))
        {
            System.out.println("Would you like to promote them by one belt?\n");
            if(ans.equals("yes") || ans.equals("Yes"))
                s.rankUp();
            else
            {
                System.out.println("Input the correct belt");
                
            }
        }
        else if(ans.equals("Intelligence") || ans.equals("intelligence"))
        {
            System.out.println("Input the correct Intelligence XP\n");
            s.setIntelligence(user.nextLong());
        }
        else if(ans.equals("Honor") || ans.equals("honor"))
        {
            System.out.println("Input the correct Honor XP\n");
            s.setHonor(user.nextLong());
        }
        else if(ans.equals("Combat") || ans.equals("combat"))
        {
            System.out.println("Input the correct Combat XP\n");
            s.setCombat(user.nextLong());
        }
        else if(ans.equals("experience") || ans.equals("Experience"))
        {
            System.out.println("Input the correct Experience XP\n");
            s.setExperience(user.nextLong());
        }
        else
        {
            System.out.println("That is an invalid response.\n");
        }
    }//End UpdateStudent
    
    //Prints out the requested student
    public void printStudent(StudentList s)
    {
        Scanner user = new Scanner(System.in);
        Scanner next = new Scanner(System.in);
        System.out.println("Enter the name of the student you want to see.\n");
        String n = user.nextLine();
        
        Student student = s.Search(n);
        System.out.println(student.toString());
        System.out.println("Press \"Enter\" to continue\n");
        next.nextLine();
    }//End printStudent()
    
    public void printMult(StudentList s)
    {
        Scanner user = new Scanner(System.in);
        boolean again = true;
        while(again)
        {
            printStudent(s);
            System.out.println("Do you want to see another student?\n");
            String ans = user.nextLine();
            if(ans.equals("Yes") || ans.equals("yes"))
            {
                
            }
            else
                again = false;
        }
    }
    
    public void updateFile(String fileName, StudentList s, boolean b) throws FileNotFoundException, IOException
    {
        Scanner user = new Scanner(System.in);
        try
        {
            s.PrintToFile(fileName);
            System.out.println("Would you like to quit the program?\n");
            String ans = user.nextLine();
            if(ans.equals("Yes") || ans.equals("yes"))
                cont = false;
        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("File wasn't found");
            System.out.println("Please re-enter the name of the file you want to update.\n");
            updateFile(user.nextLine(), s, b);
        }
        catch(IOException io)
        { 
            System.out.println("IO Exception!");
            System.out.println("Please re-enter the name of the file you want to update.\n");
            updateFile(user.nextLine(), s, b);
        }
    }//End UpdateFile()
    
    public StudentList openFile(String fileName, StudentList s)
    {
        Scanner user = new Scanner(System.in);
        File f = new File(fileName);
        if(f.exists())
        {
            System.out.println("File is good!\n");
            try
            {
                s = s.FileRead(fileName);
            }
            catch(FileNotFoundException fnf)
            {
                System.out.println("File Not Found");
            }
            catch(IOException io)
            {
                System.out.println("IO Exception");
            }
        }
        else
        {
            System.out.println("File doesn't exist!");
            System.out.println("Enter a valid file name please\n");
            openFile(user.nextLine(), s);
        }
        return s;
    }
    
    public void printList(StudentList s)
    {
        s.printList();
    }
}
