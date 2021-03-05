import java.util.ArrayList;

public class Star
{
	//Represents one of the groups in which to choose a strategy
    private String title;
    private ArrayList<Strat> stratList;
    private int starIndex;

    public Star(String title_, int starIndex_)
    {
        title = title_;
        stratList = new ArrayList<Strat>();
        starIndex = starIndex_;
    }
    
    public String getTitle()
    {
    	return title;
    }
    
    public ArrayList<Strat> getStratList()
    {
    	return stratList;
    }
    
    public int getStarIndex()
    {
    	return starIndex;
    }
    
    public void addStrat(Strat newStrat)
    {
    	stratList.add(newStrat);
    }
}