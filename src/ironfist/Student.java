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
    //protected int rank;
    protected long TotalXP;
    protected long intelligence, honor, combat, experience;
        
    
    Student()
    {
        numStudents++;
        name = "Jason Fujii";
        TotalXP = 0;
        //rank = 0;
        intelligence = 0;
        honor = 0;
        combat = 0;
        experience = 0;
    }
    
    Student(String n)
    {
        name = n;
        TotalXP = 0;
        intelligence = 0;
        honor = 0;
        combat = 0;
        experience = 0;
        numStudents++;
    }
    
    
    Student(String n, long xp, long i, long h, long c, long e)
    {
        name = n;
        TotalXP = xp;
        intelligence = i;
        honor = h;
        combat = c;
        experience = e;
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
    
    public abstract void rankUp();
    
    public void setIntelligence(long x)
    {
        TotalXP -= intelligence;
        intelligence = x;
        TotalXP += intelligence;
    }
    
    public void setHonor(long x)
    {
        TotalXP -= honor;
        honor = x;
        TotalXP += honor;
    }
    
    public void setCombat(long x)
    {
        TotalXP -= combat;
        combat = x;
        TotalXP += combat;
    }
    
    public void setExperience(long x)
    {
        TotalXP -= experience;
        experience = x;
        TotalXP += experience;
    }
}
