package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**\
 * 
 * Represents a deck of cards. Default constructor prompts for a new deck entry if isNew == true
 * @author Kartesh
 *
 */
public class Deck extends JPanel{
	
	private String deckName = "deckName VOID"; //Defaults to a filler name for debugging.
	
	
	//GUI variables
	private JPanel buttonPanel = new JPanel();
	private JPanel contentPanel = new JPanel(); //Displays deck info and cards
	private JLabel deckTitle = new JLabel(deckName);
	public  JButton addCard = new JButton("Add Card");
	private JButton previousCard = new JButton("Previous Card");
	private JButton nextCard = new JButton("Next Card");
	private JButton deleteCard = new JButton("Delete Card");
	private JButton editCard = new JButton("Edit Card");
	private static int numButtons = 5;//How many buttons are on the buttonPanel
	
	/**
	 * If isNew is true, a new deck is created and the user is prompted for a name.
	 * @param isNew
	 */
	public Deck(boolean isNew){
	
		//Are we making a new deck, or simply loading one?
		if(isNew == true){
			deckName = JOptionPane.showInputDialog("What would you like to call this deck?");
			deckTitle.setText(deckName);
		}else{
			//TODO -- This code will load a previously created deck from a saved file.
		}
		
		addElements(this); //Place all GUI elements.
		setupElements(this);//Perform element configurations
		
	}

	
	public static void addElements(Deck activeDeck){
		
		activeDeck.add(activeDeck.buttonPanel);
		activeDeck.add(activeDeck.contentPanel); //Deck info and cards display here.
		//Adding edit and navigation buttons to the button panel of the deck
		activeDeck.buttonPanel.add(activeDeck.previousCard);
		activeDeck.buttonPanel.add(activeDeck.nextCard);
		activeDeck.buttonPanel.add(activeDeck.addCard);
		activeDeck.buttonPanel.add(activeDeck.editCard);
		activeDeck.buttonPanel.add(activeDeck.deleteCard);
		activeDeck.contentPanel.add(activeDeck.deckTitle);
		
		
	}
	
	public static void setupElements(Deck activeDeck){
		
		activeDeck.setLayout(new GridLayout(0,1));
	    activeDeck.buttonPanel.setLayout(new GridLayout(0,numButtons)); //Buttons Layout
		
	}
	
	

}
