public class Run
{
	//Handles all the info that must be saved to a file
    private String title;
    private int[] stratList;
    
    public Run(String title_)
    {
    	if (title_ == "")
		{
			title = title_;
        	stratList = new int[15];
		}
    	else
    	{
    		stratList = new int[15];
    		for (int i = 0; i < stratList.length; i++)
    		{
    			stratList[i] = Character.getNumericValue(title_.charAt(i));
    		}
    		title = title_.substring(stratList.length);
    	}
	}
    
    public void setTitle(String title_)
    {
        title = title_;
    }
    
    public void setStrat(int starIndex, int stratIndex)
    {
    	stratList[starIndex] = stratIndex;
    }
    
    public String getTitle()
    {
    	return title;
    }
    
    public int getStrat(int stratIndex)
    {
    	return stratList[stratIndex];
    }
    
    public String toString()
    {
    	String result = "";
    	for (int i = 0; i < stratList.length; i++)
    	{
    		result = result + stratList[i];
    	}
    	result = result + title;
    	return result;
    }
}
