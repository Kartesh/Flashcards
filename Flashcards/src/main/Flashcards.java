package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class Flashcards {
	
	private static String mainWindowTitle = "Flashcards";
	
	//UI Variables
	private static JFrame mainWindow = new JFrame(mainWindowTitle);
	private static JMenuBar mainMenu = new JMenuBar();
	private static JMenu fileMenu = new JMenu("File");
	private static JMenuItem openDeck = new JMenuItem("Open Deck");
	private static JMenuItem newDeck = new JMenuItem("New Deck");
	private static JMenuItem closeDeck = new JMenuItem("Close Deck");
	private static JMenuItem exitProgram = new JMenuItem("Exit");
		
	public static void main(String[] args) {
		
		guiInit();
}
	
	/**
	 * Initializes GUI elements and configures their properties.
	 */
	public static void guiInit(){			
		
		mainWindow.setResizable(true);
		mainWindow.setLayout(new GridLayout(2,0));
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Main Menu Adds
		mainMenu.add(fileMenu);
		fileMenu.add(openDeck);
		fileMenu.add(newDeck);
		fileMenu.add(closeDeck);
		fileMenu.add(exitProgram);

		mainWindow.setJMenuBar(mainMenu);
		
		//Temporary Testing Code for the deck functionality.
		mainWindow.add(new Deck(true));
		
		mainWindow.pack();
	
	}
}
