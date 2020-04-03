package projet1_7;

//CLASS Point PERMETTANT DE FACILITER LA MANIPULATION DES COORDONNES DANS LA GRILLE
public class Point {

	//ATTRIBUTS
	public int x,y,move;
	
	//CONSTRUCTEUR
	public Point(int x, int y, int move) {
		this.x = x;
		this.y = y;
		this.move = move;
	}
	
	//METHODES
	public String toString() {
		return "[" + x + ", " + y + "] , Type de move : " + move;
	}
	
}
