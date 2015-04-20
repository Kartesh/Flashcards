package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Represents a card which is managed by the deck class. It has a front and back face. Additionally, it maintains 
 * statistical information, such as how easily the user recalls information on the card.
 * @author Kartesh
 *
 */
public class Card extends JPanel implements ActionListener{
	
	private JPanel frontPanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private JPanel editingPanel = new JPanel(); //Stores components used to add information to cards.
	
	
	public Deck workingDeck;
	private int cardIndex;
	private String cardTitle = "Nothing Entered";
	private String cardQuestion = "Nothing Entered";
	private String cardAnswer = "Nothing Entered";
	
	//Edit Panel Components
	private JLabel enterTitle = new JLabel("Enter Title:");
	private JLabel enterMainText = new JLabel("Additional Information:");
	private JLabel backText = new JLabel("Answer Text:");
	
	private JTextField editTitle = new JTextField();
	private JTextArea editMainText = new JTextArea();
	private JScrollPane editMainTextScrollPane = new JScrollPane(editMainText);
	private JTextArea editBackText = new JTextArea();
	private JScrollPane editBackTextScrollPane = new JScrollPane(editBackText);
	private JButton saveCard = new JButton("Save");
	private JButton cancelCard = new JButton("Cancel");

	/**
	 * Creates a card, which implements JPanel. The Card's panel is then managed by the Deck
	 * class.
	 * @param workingDeck - Required so that the card can delete itself if necessary from the deck.
	 * @param deckIndex - used so that the card has knowledge of its location within the deck.
	 */
	Card(Deck workingDeck, int deckIndex){
		
		this.workingDeck = workingDeck;
		this.cardIndex = deckIndex;
		//this.debug = workingDeck.getDebug();
		
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		guiAdds();
		cardInitialization();
		

		//TEST CODE TODO This is to be removed once supporting functions implemented.
		this.add(editingPanel);
	}
	
	
	private void cardInitialization() {	
		
		//editPanel components
		editTitle.setAutoscrolls(true);
		editMainText.setToolTipText("Enter a question, or any information for the front of your card.");
		editMainText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		editMainText.setRows(5);
		editMainText.setLineWrap(true);
		editBackText.setLineWrap(true);
		
		//Layouts
		editingPanel.setLayout(new GridLayout (0,2));
	}


	private void guiAdds() {
		
		//Edit Panel adds
		editingPanel.add(enterTitle);
		editingPanel.add(editTitle);
		editingPanel.add(enterMainText);
		editingPanel.add(editMainTextScrollPane);
		editingPanel.add(backText);
		editingPanel.add(editBackTextScrollPane);
		editingPanel.add(saveCard);
		editingPanel.add(cancelCard);
	
		//ActionListeners
		saveCard.addActionListener(this);
		cancelCard.addActionListener(this);
		
	}
	//Generated setters and getters
	public String getCardTitle() {
		return cardTitle;
	}
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
	public String getCardQuestion() {
		return cardQuestion;
	}
	public void setCardQuestion(String cardQuestion) {
		this.cardQuestion = cardQuestion;
	}
	public String getCardAnswer() {
		return cardAnswer;
	}
	public void setCardAnswer(String cardAnswer) {
		this.cardAnswer = cardAnswer;
	}
	public JPanel getBackPanel() {
		return backPanel;
	}
	public void setBackPanel(JPanel backPanel) {
		this.backPanel = backPanel;
	}
	public JPanel getFrontPanel() {
		return frontPanel;
	}
	public void setFrontPanel(JPanel frontPanel) {
		this.frontPanel = frontPanel;
	}
	/**
	 * Calls the edit panel used for editing a Card's displayed information.
	 */
	public void editCard(){
		//TODO implement this function
	}
	/**
	 * This method is called when a card is to be saved. It finishes the object setup so that it can be displayed.
	 */
	private void saveCard(){
		//TODO This function needs to write to the object variabels based on what is inputed by the user text box's.
		
		//TODO Algorythm
		//make layout adjustments for the text areas without buttons and labels.
		
		this.editingPanel.remove(this.saveCard);
		this.editingPanel.remove(this.cancelCard);
		this.editingPanel.remove(this.enterMainText);
		this.editingPanel.remove(this.enterTitle);
		this.editingPanel.remove(this.backText);
		
		this.editingPanel.setLayout(new GridLayout(0,1));
		
		this.editTitle.setEditable(false);
		this.editMainText.setEditable(false);
		this.editBackText.setEditable(false);
		
		this.cardTitle = editTitle.getText();
		this.cardQuestion = editMainText.getText();
		this.cardAnswer = editBackText.getText();
		
		this.workingDeck.setIsAddCardOpen(false);
		this.workingDeck.refreshDeckTitle();
		this.workingDeck.updatePanels();
	}
	/**
	 * This is the method used to display a card that has already been created.
	 */
	private void displayCard(){
		//TODO Implement this function
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "Save"){
			if(this.workingDeck.getDebug()) System.out.println("Clicked Save... Calling saveCard method, followed by displayCard method.");
			this.workingDeck.setIsAddCardOpen(false);
			this.workingDeck.setCardIndex(this.workingDeck.getCardIndex() + 1); //Incriment the cardIndex by one in the workingDeck.
			//TODO we need to account for iterations on the array list for additional cards to be added.
			saveCard();
			displayCard();
		}
		else if(e.getActionCommand() == "Cancel"){
						
			if(workingDeck.getDebug() == true){
				System.out.println("Clicked Cancel.. removing card.");
			}
			this.workingDeck.getContentPanel().remove(this.workingDeck.getCardList().get(cardIndex));
			this.workingDeck.getCardList().remove(cardIndex);
			
			//clear text boxes
			this.editTitle.setText("");
			this.editMainText.setText("");
			this.editBackText.setText("");
			
			this.workingDeck.updatePanels();
			this.workingDeck.setIsAddCardOpen(false);
		}
		
	}
	
	

}
