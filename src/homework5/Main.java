package homework5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import homework5.Rates.HIKE;

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
	private JRadioButton duration3;
	
	private JButton submit;
	
	private JPanel labels = new JPanel();
	private JPanel trailButtons = new JPanel();
	private JPanel durationButtons = new JPanel();
	private JPanel textFields = new JPanel();

	private ButtonGroup trailGroup = new ButtonGroup();
	private ButtonGroup durationGroup = new ButtonGroup(); 
	
	String durationText = "";
	String trailChosen = "";
	static Rates rate;
	
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
		
		roaring = new JRadioButton("HELLROARING");
		gardiner = new JRadioButton("GARDINER");
		beaten = new JRadioButton("BEATEN");
		
		trailGroup.add(roaring);
		trailGroup.add(gardiner);
		trailGroup.add(beaten);
		
		duration1 = new JRadioButton("_ days");
		duration2 = new JRadioButton("_ days");
		duration3 = new JRadioButton("_ days");
		
		durationGroup.add(duration1);
		durationGroup.add(duration2);
		durationGroup.add(duration3);
		
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
		durationButtons.add(duration3);
		duration1.setVisible(false);
		duration2.setVisible(false);
		duration3.setVisible(false);
		
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
		
		//Add listeners
		
		roaring.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				rate = new Rates(Rates.HIKE.HELLROARING);
				duration1.setText(rate.validDurations[0] + " days");
				duration2.setText(rate.validDurations[1] + " days");
				duration3.setText(rate.validDurations[2] + " days");
				duration1.setVisible(true);
				duration2.setVisible(true);
				duration3.setVisible(true);
				trailChosen = "roaring";
				
			}
			
			
		});
		
		gardiner.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				rate = new Rates(Rates.HIKE.GARDINER);
				duration1.setText(rate.validDurations[0] + " days");
				duration2.setText(rate.validDurations[1] + " days");
				duration1.setVisible(true);
				duration2.setVisible(true);
				duration3.setVisible(false);
				
				
			}
			
			
		});
		
		beaten.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				rate = new Rates(Rates.HIKE.BEATEN);
				duration1.setText(rate.validDurations[0] + " days");
				duration2.setText(rate.validDurations[1] + " days");
				duration1.setVisible(true);
				duration2.setVisible(true);
				duration3.setVisible(false);
				trailChosen = "beaten";
				
				
			}
			
			
		});
		
		duration1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				durationText = Character.toString(duration1.getText().toString().charAt(0));
				
			}
			
		});
		
		duration2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				durationText = Character.toString(duration2.getText().toString().charAt(0));
			
			}
			
		});
		
		duration3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				durationText = Character.toString(duration3.getText().toString().charAt(0));
				
			}
			
		});
		
		submit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				int m = -1;
				int d = -1;
				int y = -1;
				int length = Integer.parseInt(Character.toString(durationText.charAt(0)));
				System.out.println(length);
				
				try{
				
					 m = Integer.parseInt(month.getText());
					 d = Integer.parseInt(day.getText());
					 y = Integer.parseInt(year.getText());
					 
					 BookingDay start = new BookingDay(y,m,d);
					 
					
					 if(start.isValidDate()){
						 
						 rate.setBeginDate(start);
						 
						 if(rate.setDuration(length)){
							 
							 if(rate.isValidDates()){
							 
								costText.setText(String.format("$%.2f", rate.getCost()));
								costText.setVisible(true);
								
							 }else{
								 
								 JFrame errorFrame = new JFrame();
								 errorFrame.setTitle("Uh Oh!");
								 errorFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
								 JLabel errorInfo = new JLabel("The start date and duration you selected is not within the tour season! Please Try again :)");
								 errorFrame.add(errorInfo);
								 errorFrame.setVisible(true);
								 
							 }
							 
						 }else{
							 
							 // Shouldn't need this code since we limit the choices.
							 JFrame errorFrame = new JFrame();
							 errorFrame.setTitle("Uh Oh!");
							 JLabel errorInfo = new JLabel("You selected an invalid Trip Duration!");
							 errorFrame.add(errorInfo);

						 }
						 
					 }else{
						 
						 
						 
					 }
				
				} catch(Exception e){
					
					System.out.println("Error invalid date format entered.");
					e.printStackTrace();
					
				}
				
				
				
			}
			
		});
		
		pack();
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		
		Main test = new Main();
		
	}


}
