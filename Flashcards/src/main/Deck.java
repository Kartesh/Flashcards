package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**\
 * 
 * Represents a deck of cards. Default constructor prompts for a new deck entry if isNew == true
 * @author Kartesh
 *
 */
public class Deck extends JPanel implements ActionListener{
	
	private JFrame mainWindow = null; //ONLY used for the .pack() method of the parent JFrame to keep program sized appropriately.
	
	
	private String deckName = "deckName VOID"; //Defaults to a filler name for debugging.
	private ArrayList<Card> cardList = new ArrayList<Card>();
	
	//GUI variables
	private JPanel buttonPanel = new JPanel();
	private JPanel contentPanel = new JPanel(); //Displays deck info and cards
	private JLabel deckTitle = new JLabel(deckName);
	private  JButton addCard = new JButton("Add Card");
	private JButton previousCard = new JButton("Previous Card");
	private JButton nextCard = new JButton("Next Card");
	private JButton deleteCard = new JButton("Delete Card");
	private JButton editCard = new JButton("Edit Card");
	private static int numButtons = 5;//How many buttons are on the buttonPanel
	
	/**
	 * If isNew is true, a new deck is created and the user is prompted for a name.
	 * @param isNew - Is this a new deck, or are we loading a previously created one?
	 * @param parentFrame - The parent JFrame is needed to adjust window size after GUI additions and edits.
	 */
	public Deck(boolean isNew, JFrame parentFrame){
		mainWindow = parentFrame;
		//Are we making a new deck, or simply loading one?
		if(isNew == true){
			deckName = JOptionPane.showInputDialog("What would you like to call this deck?");
			deckTitle.setText(deckName);
		}else{
			//TODO -- This code will load a previously created deck from a saved file.
		}
		
		addElements(this); //Place all GUI elements.
		setupElements(this);//Perform element configurations
		addActionListeners(this);//Add the action listeners
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
	
	public static void addActionListeners(Deck activeDeck){
		activeDeck.addCard.addActionListener(activeDeck);
		activeDeck.previousCard.addActionListener(activeDeck);
		activeDeck.nextCard.addActionListener(activeDeck);
		activeDeck.editCard.addActionListener(activeDeck);
		activeDeck.deleteCard.addActionListener(activeDeck);
		
		
	}
	
	public static void setupElements(Deck activeDeck){
		
		//Setting element sizes
		activeDeck.addCard.setSize(100, 20);
		
		activeDeck.setLayout(new GridLayout(2,0));
	    activeDeck.buttonPanel.setLayout(new GridLayout(0,numButtons)); //Buttons Layout
		activeDeck.contentPanel.setLayout(new BoxLayout(activeDeck.contentPanel, BoxLayout.Y_AXIS));
		activeDeck.deckTitle.setAlignmentX(CENTER_ALIGNMENT); //Aligning the title to center of panel
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Implement the deck menu button logic
		
		//Deck Button action events
		if(e.getActionCommand() == "Add Card"){
			System.out.println("Adding Card...");
			addCard();
		}
		else if(e.getActionCommand() == "Next Card"){
			System.out.println("Clicked Next Card");
		}
		else if(e.getActionCommand() == "Previous Card"){
			System.out.println("Previous Card clicked");
		}
		else if(e.getActionCommand() == "Delete Card"){
			System.out.println("Delete card clicked");
		}
		else if(e.getActionCommand() == "Edit Card"){
			System.out.println("Edit Card Clicked");
		}
		
	}


	private void addCard() {
		// TODO Auto-generated method stub
		cardList.add(new Card());
		contentPanel.add(cardList.get(0));
		contentPanel.repaint();
		contentPanel.revalidate();
		contentPanel.repaint();
		
		mainWindow.pack();
	}
	
	

}
