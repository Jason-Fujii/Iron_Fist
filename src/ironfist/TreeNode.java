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
public class TreeNode {
    public Student item;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(Student data, TreeNode l, TreeNode r)
    {
        item = data;
        left = l;
        right = r;
    }
    
    public TreeNode(Student data)
    {
        item = data;
        left = null;
        right = null;
    }
    
    
    //a.compareTo(b) ---> -1
    //b.compareTo(a) --->  1
    //node.compareTo(root) 
    //root = "Jason"
    //node = "Albert" 
    //Albert goes to the left
    public int compareTo(TreeNode s)
    {
        if(this.item.name.compareTo(s.item.name) > 0)
            return 1;
        else if(this.item.name.compareTo(s.item.name) < 0)
            return -1;
        else 
            return 0;
    }
}