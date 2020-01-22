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
public class LFA extends Student{
    private double XP;
    private String level;
    
    public LFA(){
        super();
        setLevel(super.rank);
    }
    
    public String getLevel()
    {
        return level;
    }
    public void setLevel(String l)
    {
        level = l;
    }
    
    public void setLevel(int rank)
    {
        switch(rank)
        {
            case 0: level = "Initiate"; break;
            case 1: level = "Apprentice"; break;
            case 2: level = "Ranger"; break;
            case 3: level = "Paladin"; break;
            case 4: level = "FIND"; break;
            case 5: level = "FIND"; break;
            case 6: level = "FIND"; break;
            default: level = "No level found";
        }
    }
    
    public String toString()
    {
        return name + "\nRank: " +level+ "\nTotal XP: " +TotalXP+ "\nIntelligence: " 
                +intelligence+ "\nHonor: " +honor+ "\nCombat: " +combat+ "\n";
    }
}
