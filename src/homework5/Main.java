package homework5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
	
	private JLabel cost;
	private JLabel trail;
	private JLabel duration;
	private JLabel startDate;
	private JLabel costText;
	
	private JTextField month;
	private JTextField day;
	private JTextField year;
	
	private JRadioButton roaring;
	private JRadioButton gardiner;
	private JRadioButton beaten;
	private JRadioButton duration1;
	private JRadioButton duration2;
	
	private JButton submit;
	
	private JPanel labels = new JPanel();
	private JPanel trailButtons = new JPanel();
	private JPanel durationButtons = new JPanel();
	private JPanel textFields = new JPanel();

	private ButtonGroup trailGroup = new ButtonGroup();
	private ButtonGroup durationGroup = new ButtonGroup(); 
	
	String durationText = "";
	
	public Main(){
		
		setLayout(new GridBagLayout()); //Layout for the frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize Labels
		
		trail = new JLabel("Select a Trail: ");
		duration = new JLabel("Select duration (Days): ");
		startDate = new JLabel("Enter Start Date: ");
		cost = new JLabel("Cost: ");
		costText = new JLabel("HAHAHAHAHA"); // place holder
		
		//Initialize Buttons & add them to proper group
		
		roaring = new JRadioButton("HellRoaring");
		gardiner = new JRadioButton("Gardiner");
		beaten = new JRadioButton("Beaten");
		
		trailGroup.add(roaring);
		trailGroup.add(gardiner);
		trailGroup.add(beaten);
		
		duration1 = new JRadioButton("_days");
		duration2 = new JRadioButton("_days");
		
		durationGroup.add(duration1);
		durationGroup.add(duration2);
		
		submit = new JButton("Submit");
		
		//Initialize TextFields
		
		month = new JTextField("mm", 10);
		day = new JTextField("dd", 10);
		year = new JTextField("yyyy", 10);
		
		//Generate the layout constraints
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.EAST;
		
		add(trail, gbc);
		add(duration, gbc);
		add(startDate, gbc);
		add(cost, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		
		add(trailButtons,gbc);
		trailButtons.setLayout(new GridLayout(1,3,2,2));
		
		trailButtons.add(roaring);
		trailButtons.add(gardiner);
		trailButtons.add(beaten);
	
		gbc.gridy = GridBagConstraints.RELATIVE;
		add(durationButtons,gbc);
		durationButtons.setLayout(new GridLayout(1,2,2,2));
		
		durationButtons.add(duration1);
		durationButtons.add(duration2);
		
		add(textFields, gbc);
		add(costText,gbc);
		gbc.fill = GridBagConstraints.NONE;
		textFields.setLayout(new GridLayout(1,3,2,2));
		textFields.add(month, gbc);
		textFields.add(day, gbc);
		textFields.add(year, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		add(submit, gbc);
		
		pack();
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		
		Main test = new Main();
		
	}


}
