/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ironfist;
/**
 *
 * @author jasonfujii
 */

import java.io.*;
import java.util.*;
public class StudentList {
    private TreeNode root;
    private int NumStudents;
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    
    //takes a Student and turns it into a TreeNode
    //checks the root and inserts it into the root if it's null
    //if not, take comparison, then place it into the left or right node if available
    //if not, call the private insert(TreeNode, TreeNode)
    public void insert(Student s)
    {
        TreeNode tr = new TreeNode(s);
        if(isEmpty())
        {
            root = tr;
            NumStudents++;
        }
        else
        {
            if(tr.compareTo(root) > 0)
            {
                //insert(tr, root.right);
                if(root.right == null)
                {
                    root.right = tr;
                    NumStudents++;
                }
                else
                    insert(tr, root.right);
            }
            else if(tr.compareTo(root) < 0)
            {
                if(root.left == null)
                {
                    root.left = tr;
                    NumStudents++;
                }
                else
                    insert(tr, root.left);
            }
            else
                System.out.println("This person already exists in the database.");
        }
    }
    
    //Takes a TreeNode to insert, and a TreeNode to compareTo
    //compares and places the node into the proper left or right node space, if available
    //if not, recursively call insert() with the proper space (head.left/.right)
    private void insert(TreeNode tr, TreeNode head)
    {
        if(head == null)
        {
            head = tr;
            NumStudents++;
        }
        else
        {
            if(tr.compareTo(head) > 0)
            {
                //right side
                if(head.right == null)
                    head.right = tr;
                else
                    insert(tr, head.right);
                NumStudents++;
            }
            else if(tr.compareTo(head) < 0)
            {
                //left side
                if(head.left == null)
                {
                    head.left = tr;
                    NumStudents++;
                }
                else
                    insert(tr, head.left);
                NumStudents++;
            }
            else
                System.out.println("This person already exists in the database.");
        }
        
    }
    
    //The public call for printList. Calls the private printList(TreeNode)
    public void printList()
    {
        printList(root);
    }
    
    
    //recursively traverses the tree and outputs an inorder representation onto 
    //the command line.
    private void printList(TreeNode tr) throws StudentListException
    {
        if(isEmpty())
            throw new StudentListException("The list is empty");
        //L r R
        else
        {
            if(tr.left != null)
            {
                printList(tr.left);
            }
            
            //Student print
            System.out.println(tr.item.toString());
            
            if(tr.right != null)
                printList(tr.right);
        }
        
    }
    
    //returns the number of students
    public int getNumStudents()
    {
        return NumStudents;
    }
    
    //deletes all students. I don't know why we would need this...
    private void deleteAll()
    {
        root = null;
        NumStudents = 0;
    }
    
    public Student Search(String name)
    {
        return Search(name, root);
    }
    
    private Student Search(String n, TreeNode tr) throws StudentListException
    {
        if(isEmpty())
            throw new StudentListException("List is Empty");
        
        if(n.equals(tr.item.name))
        {
            return tr.item;
        }
        else if(n.compareTo(tr.item.name) > 0)
        {
            //right side
            if(tr.right != null)
                return Search(n, tr.right);
        }
        else if(n.compareTo(tr.item.name) < 0)
        {
            //left side
            if(tr.left != null)
                return Search(n, tr.left);
        }
        
        Student DNE = new IFMA("Student does not exist");
        return DNE;
    }
    //public void IOList
    //sends the StudentList to a file that can be saved to the computer
    public void PrintToFile(String fileName) throws IOException, FileNotFoundException
    {
        //File slFile = new File("Student_Info.txt");
        PrintWriter out = new PrintWriter(fileName);
        FilePrint(root,out);
        out.close();
    }
    
    private void FilePrint(TreeNode tr, PrintWriter out) throws StudentListException
    {
        if(isEmpty())
            throw new StudentListException("The list is empty");
        //L r R
        else
        {
            if(tr.left != null)
            {
                FilePrint(tr.left, out);
            }
            
            //Student print
            out.println(tr.item.toString());
            
            if(tr.right != null)
                FilePrint(tr.right, out);
        }
    }
    
    public StudentList FileRead(String fileName) throws FileNotFoundException, IOException
    {
        StudentList IFMAStudents = new StudentList();
        StringBuilder builder = new StringBuilder();
        //This string will take one line at a time.
        //Use this to determine which line of input this is:
            //name, total XP, or other XPs
        String line = " ";
        File in = new File(fileName);
        Scanner read = new Scanner(in);
        if(in.exists())
        {
            while(read.hasNextLine())
            {
                line = read.nextLine();
                String name = "Name not found";
                String belt = "Belt not found";
                long Totalxp = -1;
                long intel = -1;
                long hon = -1;
                long com = -1;
                long exp = -1;
                for(int i = 0; i < 7; i++)
                {
                    if(line.contains("Belt"))
                    {
                        belt = line.substring(6);
                    }
                    else if(line.contains("Total XP"))
                    {
                        Totalxp = Long.parseLong(line.substring(10));
                    }
                    else if(line.contains("Experience"))
                    {
                         exp = Long.parseLong(line.substring(12));
                    }
                    else if(line.contains("Intelligence"))
                    {
                        intel = Long.parseLong(line.substring(14));
                    }
                    else if(line.contains("Honor"))
                    {
                        hon = Long.parseLong(line.substring(7));
                    }
                    else if(line.contains("Combat"))
                    {
                        com = Long.parseLong(line.substring(8));
                    }
                    //contains name
                    else if(!line.equals("\n"))
                    {
                        name = line;
                    }
                    if(read.hasNextLine())
                        line = read.nextLine();
                }
                Student newStudent = new IFMA(name, belt, Totalxp, intel, hon, com, exp);
                IFMAStudents.insert(newStudent);
            }
            return IFMAStudents;
        }
        else
        {
            System.out.println("The file does not exist!");
            return IFMAStudents;
        }
            
    }
}
