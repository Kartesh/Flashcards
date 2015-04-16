package main;

import javax.swing.JPanel;

/**
 * Represents a card which is managed by the deck class. It has a front and back face. Additionally, it maintains 
 * statistical information, such as how easily the user recalls information on the card.
 * @author Kartesh
 *
 */
public class Card extends JPanel{

	private JPanel frontPanel = new JPanel();
	private JPanel backPanel = new JPanel();
	
	private String cardTitle = "Nothing Entered";
	private String cardQuestion = "Nothing Entered";
	private String cardAnswer = "Nothing Entered";
	

	/**
	 * Default Constructor, placing the GUI items on the card.
	 */
	Card(){
		
		guiAdds();
		cardInitialization();
		
	}
	
	
	private void cardInitialization() {
		// TODO Auto-generated method stub
		
	}


	private void guiAdds() {
		// TODO Auto-generated method stub
		
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
	
	

}
