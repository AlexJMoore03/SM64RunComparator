import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class World
{
	private static JComboBox[] boxList = new JComboBox[15];
	private static JLabel[] deltaList = new JLabel[15];
	
    private String title;
    private int starCount;
    private JPanel worldPanel;
    private int xPos;
    private int yPos;

    public World(String title_, JPanel background, Color worldColor, int xPos_, int yPos_)
    {
    	//Create world and set up related graphics
        title = title_;
        starCount = 0;
        xPos = xPos_;
        yPos = yPos_;
        
        worldPanel = new JPanel();
        worldPanel.setBackground(worldColor);
        worldPanel.setBounds(xPos, yPos, 240, 30);
        worldPanel.setLayout(null);
        background.add(worldPanel);
        
        JLabel worldLabel = new JLabel(title);
        worldLabel.setFont(new Font("Arial", 1, 12));
        worldLabel.setBounds(0, 0, 240, 30);
        worldLabel.setHorizontalAlignment(JLabel.CENTER);
        worldPanel.add(worldLabel);
    }
    
    public void addStar(Star newStar)
    {
    	//Adds a star's functionality and graphics to the world
    	JLabel starLabel = new JLabel(newStar.getTitle());
    	starLabel.setFont(new Font("Arial", 0, 12));
    	starLabel.setBounds(0, (50 * starCount) + 30, 240, 20);
    	starLabel.setHorizontalAlignment(JLabel.CENTER);
        worldPanel.add(starLabel);
        
        JLabel timeLabel = new JLabel((int)Math.floor(newStar.getStratList().get(0).getDuration() / 60) + "'" + (int)Math.floor(newStar.getStratList().get(0).getDuration() % 60) + "\"" + (int)Math.floor(newStar.getStratList().get(0).getDuration() % 1 * 10));
        if ((int)Math.floor(newStar.getStratList().get(0).getDuration() % 60) < 10)
        {
        	timeLabel.setText((int)Math.floor(newStar.getStratList().get(0).getDuration() / 60) + "'0" + (int)Math.floor(newStar.getStratList().get(0).getDuration() % 60) + "\"" + (int)Math.floor(newStar.getStratList().get(0).getDuration() % 1 * 10));
        }
        timeLabel.setFont(new Font("Arial", 0, 12));
        timeLabel.setBounds(120, (50 * starCount) + 50, 60, 20);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        worldPanel.add(timeLabel);
        
        JComboBox starBox = new JComboBox();
        starBox.setFont(new Font("Arial", 0, 12));
        starBox.setBounds(0, (50 * starCount) + 50, 120, 20);
        for (int i = 0; i < newStar.getStratList().size(); i++)
        {
        	starBox.addItem(newStar.getStratList().get(i));
        }
        starBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                boxChange(starBox, newStar.getStarIndex(), timeLabel);
            }
        });
        boxList[newStar.getStarIndex()] = starBox;
        worldPanel.add(starBox);
        
        starCount += 1;
    	worldPanel.setBounds(xPos, yPos, 240, (50 * starCount) + 30);
    }
    
    public void boxChange(JComboBox changedBox, int starIndex, JLabel updateLabel)
    {
    	//Handle drop-down selection
    	Main.getCurrentRun().setStrat(starIndex, changedBox.getSelectedIndex());
    	if ((int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() % 60) < 10)
    	{
    		updateLabel.setText((int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() / 60) + "'0" + (int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() % 60) + "\"" + (int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() % 1 * 10));
    	}
    	else
    	{
    		updateLabel.setText((int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() / 60) + "'" + (int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() % 60) + "\"" + (int)Math.floor(((Strat)changedBox.getSelectedItem()).getDuration() % 1 * 10));
    	}
    }
    
    public static void runChange()
    {
    	//Set up program for a new run
    	for (int i = 0; i < boxList.length; i++)
    	{
    		boxList[i].setSelectedIndex(Main.getCurrentRun().getStrat(i));
    		Main.getRunNameField().setText(Main.getCurrentRun().getTitle());
    	}
    }
    
    public static void deleteDeltas()
    {
    	//Delete the time difference text
    	for (int i = 0; i < deltaList.length; i++)
    	{
    		if (deltaList[i] != null)
    		{
    			deltaList[i].getParent().remove(deltaList[i]);
    			boxList[i].getParent().repaint();
    		}
    	}
    }
    
    public static void compareRun(String otherRun)
    {
    	//Behavior for the run comparison
    	deleteDeltas();
    	for (int i = 0; i < boxList.length; i++)
    	{
    		if (boxList[i].getSelectedIndex() != Character.getNumericValue(otherRun.charAt(i)))
    		{
    			
    			double delta = ((Strat)boxList[i].getSelectedItem()).getDuration() - ((Strat)boxList[i].getItemAt(Character.getNumericValue(otherRun.charAt(i)))).getDuration();
    			String plus = "";
    			if (delta >= 0.0)
    			{
    				plus = "+";
    			}
    			JLabel deltaLabel = new JLabel(plus + String.valueOf(delta));
    			deltaLabel.setFont(new Font("Arial", 1, 12));
    			Rectangle boxRect = boxList[i].getBounds();
    			deltaLabel.setBounds((int)boxRect.getX() + 180, (int)boxRect.getY(), 60, 20);
    			deltaLabel.setHorizontalAlignment(JLabel.CENTER);
    			deltaList[i] = deltaLabel;
    			boxList[i].getParent().add(deltaLabel);
    			boxList[i].getParent().repaint();
    		}
    	}
    }
}