/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ironfist;

import java.util.*;

/**
 *
 * @author jasonfujii
 */
public abstract class Student {

    /**
     * @param args the command line arguments
     */
    private static int numStudents;
    protected String name;
    //Profile picture
        //private img pic;
    protected int rank;
    protected long TotalXP;
    protected long intelligence, honor, combat;
        
    
    Student()
    {
        numStudents++;
        name = "Jason Fujii";
        TotalXP = 0;
        rank = 0;
        intelligence = 0;
        honor = 0;
        combat = 0;
    }
    
    Student(String n, String r)
    {
        numStudents++;
    }
    
    
    public int getNumStudents()
    {
        return numStudents;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String f)
    {
        Scanner sc = new Scanner(System.in);
            name = f;
    }
    
    public void resetStats()
    {
        TotalXP = 0;
        intelligence = 0;
        honor = 0;
        combat = 0;
    }
    
    public String toString()
    {
        return "Student is named: " +name+ "\nTotal XP: "  +TotalXP+
                "\nIntelligence: " +intelligence+ "\nHonor: " +honor+
                "\nCombat: " +combat;
    }
    
    public long getXP()
    {
        return TotalXP;
    }
    
    public long getIntelligence()
    {
        return intelligence;
    }
    
    public long getHonor()
    {
        return honor;
    }
    
    public long getCombat()
    {
        return combat;
    }
    
    public void addIntelligence(int x)
    {
        intelligence += x;
        TotalXP += x;
    }
    
    public void addHonor(int x)
    {
        honor += x;
        TotalXP += x;
    }
    
    public void addCombat(int x)
    {
        combat += x;
        TotalXP += x;
    }
    
    
}
