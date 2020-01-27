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
    
    public void Search(String name)
    {
        System.out.println(Search(name, root));
    }
    
    private Student Search(String n, TreeNode tr)
    {
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
    
}
