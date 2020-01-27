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
public class IFMA extends Student {
    
    private String belt;
    
    public IFMA()
    {
        super();
        setBelt(0);
    }
    
    public IFMA(String n, String b)
    {
        super(n);
        belt = b;
    }
    
    public IFMA(String n, int b)
    {
        super(n);
        setBelt(b);
    }
    
    public IFMA(String n)
    {
        super(n);
        setBelt(0);
    }
    
    public String getBelt(){
        return belt;
    }
    
    public void rankUp()
    {
        setBelt(belt + 1);
    }
    
    public void setBelt(String b){
        belt = b;
    }
    
    public void setBelt(int x)
    {
        switch(x)
        {
            case 0: belt = "White"; break;
            case 1: belt = "White-Black"; break;
            case 2: belt = "Yellow-White"; break;
            case 3: belt = "Yellow"; break;
            case 4: belt = "Yellow-Black"; break;
            case 5: belt = "Purple-White"; break;
            case 6: belt = "Purple"; break;
            case 7: belt = "Purple-Black"; break;
            case 8: belt = "Orange-White"; break;
            case 9: belt = "Orange"; break;
            case 10: belt = "Orange-Black"; break;
            case 11: belt = "Green-White"; break;
            case 12: belt = "Green"; break;
            case 13: belt = "Green-Black"; break;
            case 14: belt = "Blue-White"; break;
            case 15: belt = "Blue"; break;
            case 16: belt = "Blue-Black"; break;
            case 17: belt = "Brown-White"; break;
            case 18: belt = "Brown"; break;
            case 19: belt = "Brown-Black"; break;
            case 20: belt = "Red-White"; break;
            case 21: belt = "Red"; break;
            case 22: belt = "Red-Black"; break;
            case 23: belt = "Black - Dan I"; break;
            case 24: belt = "Black - Dan II"; break;
            case 25: belt = "Black - Dan III"; break;
            case 26: belt = "Black - Dan IV"; break;
            case 27: belt = "Black - Dan V"; break;
            case 28: belt = "Black - Dan VI"; break;
            case 29: belt = "Black - Dan VII"; break;
            case 30: belt = "Black - Dan VIII"; break;
            case 31: belt = "Black - Dan IX"; break;
            default: belt = "No belt found";
        }
    }
    
    public String toString()
    {
        return name + "\nBelt: " +belt+ "\nTotal XP: " +TotalXP+ "\nExperience: " +experience+ "\nIntelligence: " 
                +intelligence+ "\nHonor: " +honor+ "\nCombat: " + combat + "\n";
    }
}
