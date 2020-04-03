package projet1_7;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

//CLASSE NON FINIT
public class GameWindow extends JFrame{

	private static final long serialVersionUID = -1063703158557222535L;
	
	//ATTRIBUTS
	int[][] tmpBoard = new int[Main.nbRows][Main.nbCols];
	private BoardDisplay boardDisplay = new BoardDisplay();

	//CONSTRUCTEUR
	public GameWindow() {
		super("GAME DISPLAY"); 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel contentPane = (JPanel) this.getContentPane();  
		contentPane.add(boardDisplay, BorderLayout.CENTER);
		this.setSize(800, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	};

}
