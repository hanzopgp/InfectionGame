package projet1_7;

//CLASS Point PERMETTANT DE FACILITER LA MANIPULATION DES COORDONNES DANS LA GRILLE
public class PointAndScore {

	//ATTRIBUTS
	private Point point;
	private int score;
	
	//CONSTRUCTEUR
	public PointAndScore(Point point, int score) {
		this.point = point;
		this.score = score;
	}
	
	//ACCESSEURS
	public Point getPoint() {
		return point;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//METHODES
	public String toString() {
		return point.toString() + ", SCORE MINIMAX : " + score;
	}
	
}