public class Strat
{
	//Represents a choice in a drop down menu and its attributes
    private String title;
    private double duration;
    
    public Strat(String title_, double duration_)
    {
        title = title_;
        duration = duration_;
    }
    
    public String toString()
    {
    	return title;
    }

    public double getDuration()
    {
        return duration;
    }
}