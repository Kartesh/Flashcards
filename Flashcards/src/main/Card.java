package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represents a card which is managed by the deck class. It has a front and back face. Additionally, it maintains 
 * statistical information, such as how easily the user recalls information on the card.
 * @author Kartesh
 *
 */
public class Card extends JPanel{

	//TODO Create a card editing window that allows for easy editing of the card.
	
	private JPanel frontPanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private JPanel editingPanel = new JPanel(); //Stores components used to add information to cards.
	
	
	private String cardTitle = "Nothing Entered";
	private String cardQuestion = "Nothing Entered";
	private String cardAnswer = "Nothing Entered";
	
	//Edit Panel Components
	private JLabel enterTitle = new JLabel("Enter Title:");
	private JLabel enterMainText = new JLabel("Additional Information:");
	private JLabel backText = new JLabel("Answer Text:");
	private JTextField editTitle = new JTextField();
	private JTextField editMainText = new JTextField();
	private JTextField editBackText = new JTextField();

	/**
	 * Creates a card, which implements JPanel. The Card's panel is then managed by the Deck
	 * class.
	 */
	Card(){
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		guiAdds();
		cardInitialization();
		
		
		//TEST CODE
		this.add(editingPanel);
	}
	
	
	private void cardInitialization() {
		// TODO Auto-generated method stub
		
		
		//editPanel components
		editTitle.setAutoscrolls(true);
		
		//Layouts
		editingPanel.setLayout(new GridLayout (0,2));
	}


	private void guiAdds() {
		// TODO Auto-generated method stub
		
		//Edit Panel adds
		editingPanel.add(enterTitle);
		editingPanel.add(editTitle);
		editingPanel.add(enterMainText);
		editingPanel.add(editMainText);
		editingPanel.add(backText);
		editingPanel.add(editBackText);
	
		
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
		refreshEditCardComponents(); //TODO Program Refresh components
		
	}
	
	
	/**
	 * Refreshes the text boxes in the editPanel so that they represent currently held
	 * information in the Card class.
	 * Method is only called by editCard method.
	 */
	private void refreshEditCardComponents(){
		
	}
	
	

}
