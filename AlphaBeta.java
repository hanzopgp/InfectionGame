package projet1_7;

//CLASS AlphaBeta
public class AlphaBeta {

	//ATTRIBUTS
	private int alpha = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	
	//CONSTRUCTEUR
	public AlphaBeta() {};
	
	//ACCESSEURS ALPHA
	public int getAlpha(){
		return this.alpha;
	}
	public void setAlpha(int alpha){
		this.alpha = alpha;
	}

	//ACCESSEURS BETA
	public int getBeta(){
		return this.beta;
	}
	public void setBeta(int beta){
		this.beta = beta;
	}

}
