package projet1_7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//CLASS Board CONTENANT LE JEU
public class Board {
	
	//VARIABLES GLOBALES
	public static BigInteger nbNodesPlayer1 = BigInteger.ZERO;
	public static BigInteger nbNodesPlayer2 = BigInteger.ZERO;
	public static int breakN = 0;

	//VARIABLES FINAL
	public static final int NOPLAYER = 0;
	public static final int PLAYER1 = 1;
	public static final int PLAYER2 = 2;
	public static final int WALL = 3;
	
	//ATTRIBUTS
	private int nbRows;
	private int nbCols;
	private int [][] board;
	
	//CONSTRUCTEUR
	public Board(int nbRows, int nbCols) {
		this.nbRows = nbRows;
		this.nbCols = nbCols;
		board = new int [nbRows][nbCols];
	}
	
	//ACCESSEURS
	public int[][] getBoard() {
		return this.board;
	}
	
	//METHODES
	//ACTION : REMPLIT LE board DE 0 (NOPLAYER), DE 1 (PLAYER1), DE 2 (PLAYER2)
	public void buildBoard() {
		//PLACEMENT DES CASES VIDES
		for(int i = 0; i < nbRows; i++) {
			for(int j = 0; j < nbRows; j++) {
				board[i][j] = NOPLAYER;
			}
		}
		//DELIMITATION DE LA GRILLE
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < nbCols; j++) {
				board[i][j] = WALL;
			}
		}
		for(int i = nbRows - 1; i > nbRows - 3; i--) {
			for(int j = 0; j < nbCols; j++) {
				board[i][j] = WALL;
			}
		}
		for(int i=0; i<nbRows; i++) {
			for(int j=0; j<2; j++) {
				board[i][j] = WALL;
			}
		}
		for(int i = 0; i < nbRows; i++) {
			for(int j = nbCols - 1; j > nbCols - 3; j--) {
				board[i][j] = WALL;
			}
		}
		//PLACEMENT DES JOUEURS
		board[2][nbRows - 3] = PLAYER1;
		board[nbCols - 3][2] = PLAYER2;
	}
	
	//ACTION : AFFICHE LE BOARD
	public void displayBoard() {
		System.out.println();
		for(int i = 0; i < nbRows; i++) {
			for(int j = 0; j < nbCols; j++) {
				String str = " ";
				if(board[i][j] == NOPLAYER) {
					str = " ";
				}
				else if(board[i][j] == PLAYER1) {
					str = "1";
				}
				else if(board[i][j] == PLAYER2) {
					str = "2";
				}
				else if(board[i][j] == WALL) {
					str = "#";
					//LES CONDITIONS SUIVANTES PERMETTENT DE NUMEROTER LES COTES DE LA GRILLE POUR UNE MEILLEUR VISUALISATION
					if(j == 0) {
						if(i >= 10) {
							str = Integer.toString(i%10);
						}
						else{
							str = Integer.toString(i);
						}
					}
					else if(i == 0) {
						if(j >= 10) {
							str = Integer.toString(j%10);
						}
						else {
							str = Integer.toString(j);
						}			
					}
				}
				System.out.print("|" + str);			
			}	
			System.out.println("|");
		}
		System.out.println();
	}
	
	//RETURN : copieGrille UNE COPIE DE LA board
	public Board getCopy(){
		Board copieGrille = new Board(nbRows, nbCols);
	    for(int i = 0; i < board.length; i++){
	      for(int j = 0; j < board[i].length; j++){
	        copieGrille.board[i][j] = this.board[i][j];
	      }
	    }
		return copieGrille;
	}
	
	//ENTREE : point A JOUER ET player LE JOUEUR
	//ACTION : JOUE
	public void play(Point point, int player) { 
		int x = point.x;
		int y = point.y;
		int move = point.move;
		//COUPS DE TYPE 1
		if(player == PLAYER1 && move == 1) { //POUR JOUEUR1
			board[x][y] = player;
			if(board[x+1][y] == PLAYER2 && board[x+1][y] != WALL) {
				board[x+1][y] = player;
			}
			if(board[x][y+1] == PLAYER2 && board[x][y+1] != WALL) {
				board[x][y+1] = player;
			}
			if(board[x-1][y] == PLAYER2 && board[x-1][y] != WALL) {
				board[x-1][y] = player;
			}
			if(board[x][y-1] == PLAYER2 && board[x][y-1] != WALL) {
				board[x][y-1] = player;
			}
		}
		else if(player == PLAYER2 && move == 1) { //POUR JOUEUR2
			board[x][y] = player;
			if(board[x+1][y] == PLAYER1 && board[x+1][y] != WALL) {
				board[x+1][y] = player;
			}
			if(board[x][y+1] == PLAYER1 && board[x][y+1] != WALL) {
				board[x][y+1] = player;
			}
			if(board[x-1][y] == PLAYER1 && board[x-1][y] != WALL) {
				board[x-1][y] = player;
			}
			if(board[x][y-1] == PLAYER1 && board[x][y-1] != WALL) {
				board[x][y-1] = player;
			}
		} 
		//COUPS DE TYPE 2
		if(player == PLAYER1 && move == 2) { //POUR JOUEUR1
			board[x][y] = player;
		}
		if(player == PLAYER2 && move == 2) { //POUR JOUEUR2
			board[x][y] = player;
		}
	}
	
	//RETURN 1 SI PARTIE FINIT
	//RETURN 2 SI PARTIE EGALITE
	//RETURN 0 SI PARTIE PAS FINIE
	public int isOver() {
		int res1 = 0;
		int res2 = 0;
		for(int i = 0; i < nbRows; i++) {
			for(int j=0; j<nbCols; j++){
				if(board[i][j] == 1) {
					res1++;
				}
				if(board[i][j] == 2) {
					res2++;
				}
			}
		}
		if(res1 == res2) {
			return 2;
		}
		for(int i = 0; i < nbRows; i++) {
			for(int j = 0; j < nbCols; j++) {
				if(board[i][j] == 0) {
					return 0; 
				}
			}
		}
		return 1;
	}
	
	//ENTREE : 1 OU 2 (player)
	//RETURN : NOMBRE DE 1 OU NOMBRE DE 2 DANS LA board
	public int calculateScore(int player) {
		int res = 0;
		for(int i = 0; i < nbRows; i++) {
			for(int j = 0; j < nbRows; j++) {
				if(board[i][j] == player) {
					res++;
				}
			}
		}
		return res;
	}
	
	//ENTREE : 1 OU 2 (player)
	//RETURN : List<Point> CONTENANT LES COUPS VALIDES POUR LE JOUEUR 1 OU LE JOUEUR 2
	public List<Point> getValidMoves(int player){
		List<Point> validMoves = new ArrayList<>();
		for(int i = 0; i < nbRows; i++) {
			for(int j = 0; j < nbCols; j++) {     //ON REGARDE POUR LES COUPS A 2 CASES
				if(board[i][j] == 1 && player == 1) { //POUR LE JOUEUR 1
					if(board[i+2][j] == 0) {
						validMoves.add(new Point(i+2,j,2));
					}
					if(board[i-2][j] == 0) {
						validMoves.add(new Point(i-2,j,2));
					}
					if(board[i][j+2] == 0) {
						validMoves.add(new Point(i,j+2,2));
					}
					if(board[i][j-2] == 0) {
						validMoves.add(new Point(i,j-2,2));
					}
				}
				if(board[i][j] == 2 && player == 2) { //POUR LE JOUEUR 2
					if(board[i+2][j] == 0) {
						validMoves.add(new Point(i+2,j,2));
					}
					if(board[i-2][j] == 0) {
						validMoves.add(new Point(i-2,j,2));
					}
					if(board[i][j+2] == 0) {
						validMoves.add(new Point(i,j+2,2));
					}
					if(board[i][j-2] == 0) {
						validMoves.add(new Point(i,j-2,2));
					}
				}
													  //ON REGARDE POUR LES COUPS A 1 CASES
				if(board[i][j] == 1 && player == 1) { //POUR LE JOUEUR 1
					if(board[i+1][j] == 0) { 
						validMoves.add(new Point(i+1,j,1));
					}
					if(board[i-1][j] == 0) {
						validMoves.add(new Point(i-1,j,1));;
					}
					if(board[i][j+1] == 0) {
						validMoves.add(new Point(i,j+1,1));
					}
					if(board[i][j-1] == 0) {
						validMoves.add(new Point(i,j-1,1));
					}
				}									  
				if(board[i][j] == 2 && player == 2) { //POUR LE JOUEUR 2
					if(board[i+1][j] == 0) { 
						validMoves.add(new Point(i+1,j,1));
					}
					if(board[i-1][j] == 0) {
						validMoves.add(new Point(i-1,j,1));;
					}
					if(board[i][j+1] == 0) {
						validMoves.add(new Point(i,j+1,1));
					}
					if(board[i][j-1] == 0) {
						validMoves.add(new Point(i,j-1,1));
					}
				}
			}
		}
		return validMoves;
	}
	
	//ENTREE : 1 OU 2 (player)
	//ACTION : MET LE MOVE ALEATOIRE DU JOUEUR player DANS LA VARIABLE randomMove
	public Point randomMove(int player) {
		Point res;
		List<Point> tmp = getValidMoves(player);
		Random r = new Random();
		int n;
		n = r.nextInt(tmp.size());
		res = tmp.get(n);
		return res;
	}
	
	//ENTREE : tab LISTE D'OBJET POINTANDSCORE
	//RETURN : index DE L'OBJET POINTANDSCORE POUR LEQUEL LE PARAMETRE SCORE EST MINIMUM
	public PointAndScore min(ArrayList<PointAndScore> tab) {
		int min = tab.get(0).getScore();
		List<PointAndScore> indexTab = new ArrayList<>();
		int tabSize = tab.size();
		for(int i = 0; i < tabSize; i++) {
			if(tab.get(i).getScore() < min) {
				min = tab.get(i).getScore();
			}
		}
		for(int i = 0; i < tabSize; i++) {
			if(tab.get(i).getScore() == min) {
				indexTab.add(tab.get(i));
			}
		}
		//CES DEUX LIGNES SERVENT A RENDRE LES PARTIES RANDOM
		//CAR SINON ON PEUT RELANCER MINMAX1 VS MINMAX1 SUR UNE BOARD DE MEME TAILLE
		//LA PARTIE SERA TOUJOURS LA MEME !
		Random r = new Random();
		return indexTab.get(r.nextInt(indexTab.size()));
	}
	
	//ENTREE : tab LISTE D'OBJET POINTANDSCORE
	//RETURN : index DE L'OBJET POINTANDSCORE POUR LEQUEL LE PARAMETRE SCORE EST MAXIMUM
	public PointAndScore max(ArrayList<PointAndScore> tab) { 
		int max = tab.get(0).getScore();
		List<PointAndScore> indexTab = new ArrayList<>();
		int tabSize = tab.size();
		for(int i = 0; i < tabSize; i++) {
			if(tab.get(i).getScore() > max) {          
				max = tab.get(i).getScore();
			}
		}	
		for(int i = 0; i < tabSize; i++) {
			if(tab.get(i).getScore() == max) {
				indexTab.add(tab.get(i));
			}
		}
		//CES DEUX LIGNES SERVENT A RENDRE LES PARTIES RANDOM
		//CAR SINON ON PEUT RELANCER MINMAX1 VS MINMAX1 SUR UNE BOARD DE MEME TAILLE
		//LA PARTIE SERA TOUJOURS LA MEME !
		Random r = new Random();
		return indexTab.get(r.nextInt(indexTab.size()));
	}
	
	//ENTREE : valideMove UN COUP VALIDE
	//RETURN : UN POINTANDSCORE CONTENANT LE COUP VALIDE EN ENTREE ASSOCIE AU SCORE SUR LA BOARD
	public PointAndScore getScoreOnBoard(Point valideMove) {
		int scoreVirtuelPlayer = calculateScore(PLAYER1);
		int scoreVirtuelOtherPlayer = calculateScore(PLAYER2);
		return new PointAndScore(valideMove,  (scoreVirtuelPlayer - scoreVirtuelOtherPlayer)); 
	}
	
	//ENTREE : ab OBJET ALPHABETA, toEval LA VALEUR A EVALUER, player LE JOUEUR ACTUEL
	//RETURN : true ou false SUIVANT SI BETA EST INFERIEUR OU PAS A ALPHA
	public boolean alphabetaCompare(AlphaBeta ab, int toEval, boolean player, boolean alphabetaUse, Point valideMove) {
//		System.out.println(
//				"Point : " + valideMove +
//				"\nBeta : " + ab.getBeta() + "  Alpha : " +  ab.getAlpha() +
//				"\nTo eval : " + toEval + "  " + "Player : " + player);
		if(!alphabetaUse) {
			return false;
		}
		if(player) {
			ab.setAlpha(Integer.max(ab.getAlpha(), toEval));
		}
		else {
			ab.setBeta(Integer.min(ab.getBeta(), toEval));
		}
//		System.out.println("return : " + (ab.getBeta() <= ab.getAlpha()));
		return ab.getBeta() <= ab.getAlpha();
	}
	
	//ENTREE : depth PROFONDEUR DE RECHERCHE, player JOUEUR UTILISANT L'ALGO, virtualBoard COPIE DE LA BORDE AU MOMENT DE L'APPEL DE MINIMAX, ab OBJET CONTENANT ALPHA BETA
	//ENTREE : alphabetaUse BOOLEAN UTILISATION DE L'ALGO, playerInitial RENVOYANT LE JOUEUR DE BASE MEME APRES RECURSION
	//RETURN : UN OBJET PointAndScore CONTENANT LE POINT POUR LEQUEL LE SCORE EST MAXIMISE OU MINIMISE SUIVANT LE player
	public PointAndScore miniMax(int depth, boolean player, Board virtualBoard, AlphaBeta ab, boolean alphabetaUse, boolean playerInitial) {
		Board virtualBoardN;
		PointAndScore current;
		AlphaBeta AlphaBetaN = new AlphaBeta();
		ArrayList<PointAndScore> tab = new ArrayList<PointAndScore>();
		List<Point> valideMoves = virtualBoard.getValidMoves((player ? 1 : 2));
		int lenght = valideMoves.size();
		//EVITE BUG FIN DE PARTIE
		if (lenght == 0) {
			return null;
		}		
		//ON ITERE SUR LES COUPS VALIDES DU JOUEUR1/JOUEUR2
		for(int i = 0; i < lenght; i++) {	
			//COMPTAGE NOMBRE DE NOEUDS PARCOURUS JOUEUR1 ET JOUEUR2
			if(player) {
				if(playerInitial) {nbNodesPlayer1 = nbNodesPlayer1.add(BigInteger.ONE);}
				else {nbNodesPlayer2 = nbNodesPlayer2.add(BigInteger.ONE);}
			}
			else {
				if(playerInitial) {nbNodesPlayer1 = nbNodesPlayer1.add(BigInteger.ONE);}
				else {nbNodesPlayer2 = nbNodesPlayer2.add(BigInteger.ONE);}
			}
			//ON JOUE LES COUPS VALIDES 1 PAR 1 SUR UNE COPIE A CHAQUE ITERATION
			virtualBoardN = virtualBoard.getCopy();
			virtualBoardN.play(valideMoves.get(i), (player ? 1 : 2));
			//PROFONDEUR 0
			if (depth == 0) {
				//ON REMONTE LA VALEUR EVALUER EN DEPTH 0
				current = virtualBoardN.getScoreOnBoard(valideMoves.get(i));
				tab.add(current);
				//ON BREAK SI alphabetaCompare EST true
				if(alphabetaCompare(ab, current.getScore(), player, alphabetaUse, valideMoves.get(i))) {
					breakN++;
					break;
				}
			//PROFONDEUR != 0
			} else {
				//UTILISATION DE LA RECURISON EN depth-1 SUR L'AUTRE JOUEUR
				current = miniMax(depth - 1, !player, virtualBoardN, AlphaBetaN, alphabetaUse, playerInitial);
				//SI L'APPEL DE MINIMAX RENVOIE null CAR PLUS DE COUPS VALIDES ON MET LA VALEUR ACTUEL DANS current
				if (current == null) {
					current = virtualBoardN.getScoreOnBoard(valideMoves.get(i));
				}
				//SINON ON CREER UN NOUVEAU PointAndScore CONTENANT LE COUP VALIDE ET SON EVALUATION
				current = new PointAndScore(valideMoves.get(i), current.getScore());
				//ON AJOUTE CETTE VALEUR A LA LISTE
				tab.add(current);
				//ON BREAK SI alphabetaCompare EST true
				if(alphabetaCompare(ab, current.getScore(), player, alphabetaUse, valideMoves.get(i))) {
					breakN++;
					break;
				}
			}
		}
		//ON RETOURNE LE PointAndScore MAX SI JOUEUR MAX OU MIN SI JOUEUR MIN
		return player ? max(tab) : min(tab);
	}
	
}
