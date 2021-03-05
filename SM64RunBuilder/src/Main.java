import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Main
{
	private static Run run = new Run("");
	private static JTextField runNameField = new JTextField(run.getTitle());
	private static JFileChooser fileChooser = new JFileChooser();
	
    public static void main(String[] args)
    {
    	//Set up program
    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    	fileChooser.setDialogTitle("Run");
    	
        JFrame frame = new JFrame("SM64 Run Comparator");
        JPanel background = new JPanel();
        background.setBackground(new Color(0.7f, 0.5f, 0.5f));
        background.setBounds(0, 0, 495, 675);
        background.setLayout(null);
        frame.add(background);
        
        JLabel runNameLabel = new JLabel("Run Name");
        runNameLabel.setFont(new Font("Arial", 1, 12));
        runNameLabel.setBounds(0, 0, 480, 20);
        runNameLabel.setHorizontalAlignment(JLabel.CENTER);
        background.add(runNameLabel);
        
        runNameField.setFont(new Font("Arial", 0, 12));
        runNameField.setBounds(0, 20, 480, 20);
        background.add(runNameField);
        
        JButton newRunButton = new JButton("New Run");
        newRunButton.setFont(new Font("Arial", 0, 12));
        newRunButton.setBounds(0, 40, 130, 20);
        background.add(newRunButton);
        
        JButton saveRunButton = new JButton("Save Run");
        saveRunButton.setFont(new Font("Arial", 0, 12));
        saveRunButton.setBounds(175, 40, 130, 20);
        background.add(saveRunButton);
        
        JButton openRunButton = new JButton("Open Run");
        openRunButton.setFont(new Font("Arial", 0, 12));
        openRunButton.setBounds(350, 40, 130, 20);
        background.add(openRunButton);
        
        //Handle all of the included stars
        Strat lakituA = new Strat("None", 0.0);
        Strat lakituB = new Strat("Lakitu Skip", 6.4);
        Strat lakituC = new Strat("Standard", 13.3);
        Star lakituStar = new Star("Lakitu", 0);
        lakituStar.addStrat(lakituA);
        lakituStar.addStrat(lakituB);
        lakituStar.addStrat(lakituC);
        
        Strat bitDWA = new Strat("None", 0.0);
        Strat bitDWB = new Strat("Reds - Advanced", 48.3);
        Strat bitDWC = new Strat("Reds - Beginner", 53.5);
        Star bitDWStar = new Star("Bowser in the Dark World", 1);
        bitDWStar.addStrat(bitDWA);
        bitDWStar.addStrat(bitDWB);
        bitDWStar.addStrat(bitDWC);
        
        Strat vanishCapA = new Strat("None", 0.0);
        Strat vanishCapB = new Strat("Fast Saws", 30.2);
        Strat vanishCapC = new Strat("Beginner", 37.3);
        Star vanishStar = new Star("Vanish Cap", 2);
        vanishStar.addStrat(vanishCapA);
        vanishStar.addStrat(vanishCapB);
        vanishStar.addStrat(vanishCapC);
        
        Strat bitFSA = new Strat("None", 0.0);
        Strat bitFSB = new Strat("Reds - Advanced", 52.4);
        Strat bitFSC = new Strat("Reds - Beginner", 81.0);
        Star bitFSStar = new Star("Bowser in the Fire Sea", 3);
        bitFSStar.addStrat(bitFSA);
        bitFSStar.addStrat(bitFSB);
        bitFSStar.addStrat(bitFSC);
        
        Strat wmotrA = new Strat("None", 0.0);
        Strat wmotrB = new Strat("Advanced", 58.4);
        Strat wmotrC = new Strat("Beginner", 65.6);
        Star wmotrStar = new Star("Wing Mario Over the Rainbow", 4);
        wmotrStar.addStrat(wmotrA);
        wmotrStar.addStrat(wmotrB);
        wmotrStar.addStrat(wmotrC);
        
        Strat bitSA = new Strat("None", 0.0);
        Strat bitSB = new Strat("No Reds - TJWK", 40.9);
        Strat bitSC = new Strat("No Reds - No TJWK", 53.7);
        Strat bitSD = new Strat("Reds - Advanced", 65.7);
        Strat bitSE = new Strat("Reds - Beginner", 75.1);
        Star bitSStar = new Star("Bowser in the Sky", 5);
        bitSStar.addStrat(bitSA);
        bitSStar.addStrat(bitSB);
        bitSStar.addStrat(bitSC);
        bitSStar.addStrat(bitSD);
        bitSStar.addStrat(bitSE);

        World castleWorld = new World("Castle", background, new Color(0.5f, 0.7f, 0.7f), 0, 60);
        castleWorld.addStar(lakituStar);
        castleWorld.addStar(bitDWStar);
        castleWorld.addStar(vanishStar);
        castleWorld.addStar(bitFSStar);
        castleWorld.addStar(wmotrStar);
        castleWorld.addStar(bitSStar);
        
        
        Strat wingtoSkyA = new Strat("None", 0.0);
        Strat wingtoSkyB = new Strat("Fence Clip", 19.3);
        Strat wingtoSkyC = new Strat("No Fence Clip", 20.0);
        Star wingtoSkyStar = new Star("Shoot to the Island in the Sky", 6);
        wingtoSkyStar.addStrat(wingtoSkyA);
        wingtoSkyStar.addStrat(wingtoSkyB);
        wingtoSkyStar.addStrat(wingtoSkyC);
        
        World bobWorld = new World("Bob-Omb Battlefield", background, new Color(0.5f, 0.7f, 0.0f), 0, 390);
        bobWorld.addStar(wingtoSkyStar);
        
        
        Strat owlA = new Strat("None", 0.0);
        Strat owlB = new Strat("Owlless", 12.2);
        Strat owlC = new Strat("Owl", 17.0);
        Star owlStar = new Star("Fall Onto the Caged Island", 7);
        owlStar.addStrat(owlA);
        owlStar.addStrat(owlB);
        owlStar.addStrat(owlC);
        
        World wfWorld = new World("Whomp's Fortress", background, new Color(0.7f, 0.6f, 0.3f), 0, 470);
        wfWorld.addStar(owlStar);
        
        
        Strat wkA = new Strat("None", 0.0);
        Strat wkB = new Strat("Backflip", 8.7);
        Strat wkC = new Strat("Wall Kick", 11.4);
        Star wkStar = new Star("Wall Kicks Will Work", 8);
        wkStar.addStrat(wkA);
        wkStar.addStrat(wkB);
        wkStar.addStrat(wkC);
        
        World ccmWorld = new World("Cool Cool Mountain", background, new Color(0.6f, 0.6f, 0.8f), 0, 550);
        ccmWorld.addStar(wkStar);
        
        
        Strat pyramidA = new Strat("None", 0.0);
        Strat pyramidB = new Strat("Pillarless", 16.5);
        Strat pyramidC = new Strat("Pillar", 32.0);
        Star pyramidStar = new Star("Inside the Ancient Pyramid", 9);
        pyramidStar.addStrat(pyramidA);
        pyramidStar.addStrat(pyramidB);
        pyramidStar.addStrat(pyramidC);
        
        Strat eyeA = new Strat("None", 0.0);
        Strat eyeB = new Strat("Advanced", 45.0);
        Strat eyeC = new Strat("Beginner", 55.6);
        Star eyeStar = new Star("Stand Tall on the Four Pillars", 10);
        eyeStar.addStrat(eyeA);
        eyeStar.addStrat(eyeB);
        eyeStar.addStrat(eyeC);
        
        World sslWorld = new World("Shifting Sand Land", background, new Color(0.8f, 0.8f, 0.7f), 240, 60);
        sslWorld.addStar(pyramidStar);
        sslWorld.addStar(eyeStar);
        
        
        Strat slideA = new Strat("None", 0.0);
        Strat slideB = new Strat("Breezeless", 7.0);
        Strat slideC = new Strat("Breeze", 10.2);
        Star slideStar = new Star("Mysterious Mountainside", 11);
        slideStar.addStrat(slideA);
        slideStar.addStrat(slideB);
        slideStar.addStrat(slideC);
        
        World ttmWorld = new World("Tall Tall Mountain", background, new Color(0.8f, 0.6f, 0.5f), 240, 190);
        ttmWorld.addStar(slideStar);
        
        
        Strat secretA = new Strat("None", 0.0);
        Strat secretB = new Strat("Advanced", 19.4);
        Strat secretC = new Strat("Beginner", 26.8);
        Star secretStar = new Star("Five Itty Bitty Secrets", 12);
        secretStar.addStrat(secretA);
        secretStar.addStrat(secretB);
        secretStar.addStrat(secretC);
        
        World thiWorld = new World("Tiny Huge Island", background, new Color(0.4f, 0.7f, 0.6f), 240, 270);
        thiWorld.addStar(secretStar);
        
        
        Strat pitA = new Strat("None", 0.0);
        Strat pitB = new Strat("No Time Stop", 0.2);
        Strat pitC = new Strat("Time Stop", 1.7);
        Star pitStar = new Star("The Pit and the Pendulums/Stop Time for Red Coins", 13);
        pitStar.addStrat(pitA);
        pitStar.addStrat(pitB);
        pitStar.addStrat(pitC);
        
        World ttcWorld = new World("Tick Tock Clock", background, new Color(0.5f, 0.4f, 0.3f), 240, 350);
        ttcWorld.addStar(pitStar);
        
        
        Strat cruiseA = new Strat("None", 0.0);
        Strat cruiseB = new Strat("Lakitu Bounce", 32.9);
        Strat cruiseC = new Strat("Beginner", 42.8);
        Star cruiseStar = new Star("Cruiser Crossing the Rainbow/Somewhere Over the Rainbow", 14);
        cruiseStar.addStrat(cruiseA);
        cruiseStar.addStrat(cruiseB);
        cruiseStar.addStrat(cruiseC);
        
        World rrWorld = new World("Rainbow Ride", background, new Color(0.8f, 0.6f, 0.6f), 240, 430);
        rrWorld.addStar(cruiseStar);
        
        //Finish program setup
        JButton compareRunButton = new JButton("Compare Run");
        compareRunButton.setFont(new Font("Arial", 0, 12));
        compareRunButton.setBounds(295, 560, 130, 20);
        background.add(compareRunButton);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(495, 665);
        frame.setResizable(false);
        frame.setLayout(null);
    	frame.setVisible(true);
    	
    	//Add behaviors for buttons
    	newRunButton.addActionListener(new ActionListener()
    	{
            public void actionPerformed(ActionEvent e) {
               run = new Run("");
               World.runChange();
               World.deleteDeltas();
            }
        });
    	
    	saveRunButton.addActionListener(new ActionListener()
    	{
            public void actionPerformed(ActionEvent e) {
            	run.setTitle(runNameField.getText());
            	int saveResult = fileChooser.showSaveDialog(frame);
            	if (saveResult == JFileChooser.APPROVE_OPTION) {
            		File savedFile = fileChooser.getSelectedFile();
            		try
            		{
            			FileWriter saveWriter = new FileWriter(savedFile + ".txt");
            			for (int i = 0; i < run.toString().length(); i++)
            			{
            				saveWriter.write((int) run.toString().charAt(i));
            			}
            			saveWriter.flush();
        				saveWriter.close();
            		}
            		catch (IOException exception) {}
            	}
            }
         });
    	
    	openRunButton.addActionListener(new ActionListener()
    	{
            public void actionPerformed(ActionEvent e) {
            	int openResult = fileChooser.showOpenDialog(frame);
            	if (openResult == JFileChooser.APPROVE_OPTION) {
            		File openedFile = fileChooser.getSelectedFile();
            		try
            		{
            			FileReader openReader = new FileReader(openedFile);
            			String fileContents = "";
            			int i;
            			try
            			{
	            			while ((i = openReader.read()) != -1)
	            			{
	            				fileContents = fileContents + (char) i;
	            			}
	            			run = new Run(fileContents);
            			}
            			catch (IOException exception) {}
            		}
            		catch (FileNotFoundException exception) {}
            	}
                World.runChange();
            }
         });
    	
    	compareRunButton.addActionListener(new ActionListener()
    	{
            public void actionPerformed(ActionEvent e) {
            	int compareResult = fileChooser.showOpenDialog(frame);
            	if (compareResult == JFileChooser.APPROVE_OPTION) {
            		File comparedFile = fileChooser.getSelectedFile();
            		try
            		{
            			FileReader compareReader = new FileReader(comparedFile);
            			String compareContents = "";
            			int i;
            			try
            			{
	            			while ((i = compareReader.read()) != -1)
	            			{
	            				compareContents = compareContents + (char) i;
	            			}
	            			World.compareRun(compareContents);
            			}
            			catch (IOException exception) {}
            		}
            		catch (FileNotFoundException exception) {}
            	}
            }
         });
    }
    
    public static Run getCurrentRun()
    {
    	return run;
    }
    
    public static JTextField getRunNameField()
    {
    	return runNameField;
    }
}