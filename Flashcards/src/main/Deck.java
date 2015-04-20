package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
	
	private boolean debug = true; //Only used for debugging, provides System.out lines 
	
	private JFrame mainWindow = null; //ONLY used for the .pack() method of the parent JFrame to keep program sized appropriately	
	private static String deckName = null;
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private boolean isAddCardOpen = false;
	private int cardIndex = 0;
	
	//GUI variables
	private String deckTitleString = "";
	private JPanel buttonPanel = new JPanel();
	private JPanel contentPanel = new JPanel(); //Displays deck info and cards
	private JLabel deckTitle = new JLabel(deckName);
	private  JButton addCard = new JButton("Add Card");
	private JButton previousCard = new JButton("Previous Card");
	private JButton nextCard = new JButton("Next Card");
	private JButton deleteCard = new JButton("Delete Card");
	private JButton editCard = new JButton("Edit Card");
	//private static int numButtons = 5;//How many buttons are on the buttonPanel
	
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
			deckTitleString = deckTitle.getText();
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
		
		//activeDeck.contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Setting element sizes
		//activeDeck.addCard.setSize(100, 20);
		
		activeDeck.setLayout(new BoxLayout(activeDeck, BoxLayout.Y_AXIS));
	    activeDeck.buttonPanel.setLayout(new FlowLayout()); //Buttons Layout
	    activeDeck.buttonPanel.setMaximumSize(new Dimension(activeDeck.buttonPanel.getPreferredSize().width,activeDeck.buttonPanel.getPreferredSize().height));
		activeDeck.contentPanel.setLayout(new BoxLayout(activeDeck.contentPanel, BoxLayout.Y_AXIS));
		activeDeck.deckTitle.setAlignmentX(CENTER_ALIGNMENT); //Aligning the title to center of panel
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Implement the deck menu button logic
		
		//Deck Button action events
		if(e.getActionCommand() == "Add Card"){
			
			if(isAddCardOpen){
				if(debug)System.out.println("Add card is currently open, Add Card button click ignored...");				
			}else{
				if(debug)System.out.println("Adding Card...");
				addCard();
				isAddCardOpen = true; //so the user cannot click on add card if it is open.
			}
			
			
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
		
		if(!isAddCardOpen){
			
		if(!cardList.isEmpty()){
			contentPanel.removeAll(); //Clear the content panel if something is already on it.	
			contentPanel.add(deckTitle);
		}	
	
		cardList.add(new Card(this, cardIndex)); 
		contentPanel.add(cardList.get(cardIndex));
		updatePanels();
		
		mainWindow.pack();
		
		}
	}
	
	
	
	public boolean getDebug(){
		return debug;
	}
	public ArrayList<Card> getCardList(){
		return cardList;
	}
	public JPanel getContentPanel(){
		return contentPanel;
	}
	/**
	 * Refreshes the deck panels so that changes are seen on the screen. 
	 */
	public void updatePanels(){
		contentPanel.revalidate();
		contentPanel.repaint();
	}
	/**
	 * Called to refresh the deck title to represent the number of cards currently in the deck.
	 * This can be called by the card class' activeDeck pointer.
	 */
	public void refreshDeckTitle(){
		
		if(cardList.size() > 1)deckTitleString = deckName + " contains " + this.cardList.size() + " cards.";
		else if(cardList.size() == 1)deckTitleString = deckName + " contains " + this.cardList.size() + " card.";
		deckTitle.setText(deckTitleString);
	}
	public void setIsAddCardOpen(boolean isCardOpen){
		this.isAddCardOpen = isCardOpen;
	}
	public boolean getIsAddCardOpen(){
		return this.isAddCardOpen;
	}
	public int getCardIndex(){
		return this.cardIndex;
	}
	public void setCardIndex(int index){
		this.cardIndex = index;
	}
	

}
