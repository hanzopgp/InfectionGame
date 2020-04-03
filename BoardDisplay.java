package projet1_7;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

//CLASSE NON FINIT
public class BoardDisplay extends JComponent{

	private static final long serialVersionUID = 6399932414859126486L;

	//ATTRIBUTS
	Board b;
	int[][] tmpBoard = new int[Main.nbRows][Main.nbCols];

	//CONSTRUCTEUR
	public BoardDisplay() {}
	
	//ACCESSEUR
	public void setBoard(Board b) {
		this.b = b;
	}
	
	//METHODES
	//OVERRIDE DE LA FONCTION paintComponent
	@Override
	protected void paintComponent(Graphics graphics) {  
		super.paintComponent(graphics);
		
		//BACKGROUND
		graphics.setColor(Color.BLACK);
		graphics.fillRect(-1, -1, getWidth(), getHeight());
		
		//GAME
		for(int i = 0; i < Main.nbRows; i++) {
			for(int j = 0; j < Main.nbCols; j++) {
				graphics.setColor(Color.WHITE);
				graphics.drawRect(0, 0, i*(getWidth()/Main.nbRows+4), j*(getHeight()/Main.nbCols+4));
				if(b != null) {
					//ICI EST LE PROBLEME LE TMPBOARD EST VIDE!!!!!
					tmpBoard = b.getBoard();
				}
				else {
					Board tmp = new Board(Main.nbRows,Main.nbCols);
					tmp.buildBoard();
					tmpBoard = tmp.getBoard();
				}	
				if(tmpBoard[i][j] == Board.PLAYER1) {
					graphics.setColor(Color.RED);
					graphics.fillRect(getWidth() - (i + (getHeight()/Main.nbCols)), j-10, ((getWidth()-20)/Main.nbRows), (getHeight()-20)/Main.nbCols);
				}	
				
			}
		}
		

	}

}
