package main;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**\
 * 
 * Represents a deck of cards. Default constructor prompts for a new deck entry.
 * @author Kartesh
 *
 */
public class Deck extends JPanel{
	
	private String deckName;
	
	
	
	/**
	 * If isNew is true, a new deck is created and the user is prompted for a name.
	 * @param isNew
	 */
	public Deck(boolean isNew){
		
		if(isNew == true){
			deckName = JOptionPane.showInputDialog("Name the new deck:");
		}else{
			
		}
		
	}


}
