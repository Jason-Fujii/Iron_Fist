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
    public TreeNode root;
    public int NumStudents;
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    
    //takes a Student and turns it into a 
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
    
    public void printList()
    {
        printList(root);
    }
    
    
    //CHECK THIS ONE OUT
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
    
    public int getNumStudents()
    {
        return NumStudents;
    }
}
