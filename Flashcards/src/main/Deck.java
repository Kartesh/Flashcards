package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**\
 * 
 * Represents a deck of cards. Default constructor prompts for a new deck entry.
 * @author Kartesh
 *
 */
public class Deck extends JPanel{
	
	private String deckName = "deckName VOID"; //Defaults to a filler name for debugging.
	
	private JPanel buttonPanel = new JPanel();
	private JPanel contentPanel = new JPanel();
	
	//GUI Elements of the deck
	public JButton addCard = new JButton("Add Card");
	private JButton previousCard = new JButton("Previous Card");
	private JButton nextCard = new JButton("Next Card");
	private JButton deleteCard = new JButton("Delete Card");
	private JButton editCard = new JButton("Edit Card");
	private static int numButtons = 5;
	/**
	 * If isNew is true, a new deck is created and the user is prompted for a name.
	 * @param isNew
	 */
	public Deck(boolean isNew){
		
		this.buttonPanel.setLayout(new GridLayout(0,numButtons)); //Buttons Layout
		
		if(isNew == true){
			deckName = JOptionPane.showInputDialog("Name the new deck:");
		}else{
			
		}
		
		addElements(this);
		
	}

	
	public static void addElements(Deck activeDeck){
		
		activeDeck.add(activeDeck.buttonPanel);
		
		//Adding edit and navigation buttons to the button panel of the deck
		activeDeck.buttonPanel.add(activeDeck.previousCard);
		activeDeck.buttonPanel.add(activeDeck.nextCard);
		activeDeck.buttonPanel.add(activeDeck.addCard);
		activeDeck.buttonPanel.add(activeDeck.editCard);
		activeDeck.buttonPanel.add(activeDeck.deleteCard);
		System.out.println("This is not working");
		
		
	}
	
	

}
