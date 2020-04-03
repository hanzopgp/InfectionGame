package projet1_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

//CLASS Main
public class Main {
	
	//TABLEAU ANALYSE DATA
	static ArrayList<Double> tabNbNodesPlayer1 = new ArrayList<Double>();
	static ArrayList<Double> tabNbNodesPlayer2 = new ArrayList<Double>();
	static int counter1 = 0;
	static int counter2 = 0;
	static int nbRows;
	static int nbCols;
	
	//MAIN
	public static void main(String[] args)  throws Exception {
		
		//GERER LES INPUTS
		Scanner sc = new Scanner(System.in);

		//PARAMETRES DE BASE
		int deepnessPlayer1 = 0;
		int deepnessPlayer2 = 0;
		boolean alphabetaUse = false;
		boolean pause = false;
		int counter = 1;
		ArrayList<Double> tabMaxJoueur1 = new ArrayList<Double>();
		ArrayList<Double> tabMaxJoueur2 = new ArrayList<Double>();
		int currentPlayer = Board.PLAYER1;

		//ARGUMENTS DONNE A MAIN
		nbRows = Integer.parseInt(args[0]);
		nbCols = Integer.parseInt(args[1]);
		String typePlayer1 = args[2];
		String typePlayer2 = args[3];
		int avanceJoueur1 = Integer.parseInt(args[4]);
		
		//AFFICHAGE DEBUT
		System.out.println(
				"  ******** ******** ********** ********** ** ****     **   ********   ********\r\n" + 
				" **////// /**///// /////**/// /////**/// /**/**/**   /**  **//////** **////// \r\n" + 
				"/**       /**          /**        /**    /**/**//**  /** **      // /**       \r\n" + 
				"/*********/*******     /**        /**    /**/** //** /**/**         /*********\r\n" + 
				"////////**/**////      /**        /**    /**/**  //**/**/**    *****////////**\r\n" + 
				"       /**/**          /**        /**    /**/**   //****//**  ////**       /**\r\n" + 
				" ******** /********    /**        /**    /**/**    //*** //********  ******** \r\n" + 
				"////////  ////////     //         //     // //      ///   ////////  ////////  \r\n");
		System.out.println("***** Partie lancee sur grille de taille : (" + nbRows + "," + nbCols + ")");
		System.out.println("***** Type joueur 1 : " + typePlayer1);
		System.out.println("***** Type joueur 2 : " + typePlayer2);
		if(avanceJoueur1 != 0) {
			System.out.println("***** Coups d'avance joueur 1 : " + avanceJoueur1);
		}

		//PARAMETRES D'ENTREES
		if(typePlayer1.equals("minmax")) {
			System.out.println("-----> Entrez une profondeur pour le joueur 1");
			deepnessPlayer1 = Integer.parseInt(sc.nextLine());	
		}
		if(typePlayer2.equals("minmax")) {
			System.out.println("-----> Entrez une profondeur pour le joueur 2");
			deepnessPlayer2 = Integer.parseInt(sc.nextLine());
		}
		if(typePlayer1.equals("minmax") || typePlayer2.equals("minmax")) {
			System.out.println("-----> Voulez vous utiliser l'elagage AlphaBeta ? (0/1)");
			alphabetaUse = (Integer.parseInt(sc.nextLine()) == 1 ? true : false);
		}
		System.out.println("-----> Pause entre les tours ? (0/1)");
		pause = (Integer.parseInt(sc.nextLine()) == 1 ? true : false);
		
		//SUIVIS DU TEMPS D'EXECUTION TOTAL DE LA PARTIE
		long tempsDebut = System.currentTimeMillis();
	
		//CREATION ET INITIALISATION DE LA GRILLE
		Board b = new Board(nbRows,nbCols);
		b.buildBoard();
		
		//AFFICHAGE DEBUT PARTIE
		System.out.println();
		System.out.println(
				"    ********      **     ****        **** ********  ******** **********     **     *******   **********  ********\r\n" + 
				"  **//////**     ****    /**/**   **/** /**/////     **////// /////**///    ****    /**////** /////**///  **////// \r\n" + 
				" **      //     **//**   /**//** ** /** /**         /**           /**      **//**   /**   /**     /**    /**       \r\n" + 
				"/**            **  //**  /** //***  /** /*******    /*********    /**     **  //**  /*******      /**    /*********\r\n" + 
				"/**    *****  ********** /**  //*  /**  /**////     ////////**    /**    ********** /**///**      /**    ////////**\r\n" + 
				"//**  ////** /**//////** /**   /    /** /**               /**    /**   /**//////**  /**  //**     /**           /**\r\n" + 
				" //********  /**     /** /**        /** /********   ********     /**   /**     /**  /**   //**    /**     ******** \r\n" + 
				"  ////////   //      //  //         //  ////////   ////////      //    //      //   //     //     //     ////////    ");
		System.out.println();
		
		//FENETRE DE JEU
//		UIManager.setLookAndFeel(new NimbusLookAndFeel());
//		GameWindow gameWindow = new GameWindow();
//		gameWindow.setVisible(true);
//		BoardDisplay boardDisplay = new BoardDisplay();
//		boardDisplay.setBoard(b);
		
		//COUPS D'AVANCES DU JOUEUR 1
		if(typePlayer1.equals("minmax") && avanceJoueur1 != 0) {
			for(int i = 0; i < avanceJoueur1 - 1; i++) {
				AlphaBeta ab = new AlphaBeta();
				Point tmp;
				tmp = b.miniMax(deepnessPlayer1, true, b, ab, alphabetaUse, true).getPoint();
				System.out.println("---> Le joueur 1 (minmax) a joue le coup : " + tmp);
				b.play(tmp , Board.PLAYER1);
			}
		}
		
		if(typePlayer1.equals("human") && avanceJoueur1 != 0) {
			for(int i = 0; i < avanceJoueur1 - 1; i++) {
				b.displayBoard();
				System.out.println("Coups valides pour le joueur 1" + b.getValidMoves(Board.PLAYER1));
				System.out.println("Veuillez saisir un x et un y et un type de coup");
				System.out.println("---> x ? ");
				int x = Integer.parseInt(sc.nextLine());
				System.out.println("---> y ? ");
				int y = Integer.parseInt(sc.nextLine());
				System.out.println("---> type de coup ? ");
				int type = Integer.parseInt(sc.nextLine());
				Point humanMove = new Point(x, y, type);
				System.out.println("---> Le joueur 1 (human) a choisit le coups : " + humanMove);
				b.play(humanMove, Board.PLAYER1);
			}
		}	
		
		if(typePlayer1.equals("random") && avanceJoueur1 != 0) {
			for(int i = 0; i < avanceJoueur1 - 1; i++) {
				System.out.println("---> Coups valides pour le joueur 1 : " + b.getValidMoves(Board.PLAYER1));
				Point tmp = b.randomMove(Board.PLAYER1);
				System.out.println("---> Le joueur 1 (random) a choisit le coups : " + tmp);
				b.play(tmp, Board.PLAYER1);
			}
		}

		//BOUCLE DE JEU
		while(b.isOver() != 1 && (!b.getValidMoves(Board.PLAYER1).isEmpty()) && (!b.getValidMoves(Board.PLAYER2).isEmpty())) {		
		
			//CURRENT PLAYER
			List<Point> validMovesCurrentPlayer = (currentPlayer == Board.PLAYER1 ? b.getValidMoves(Board.PLAYER1) : b.getValidMoves(Board.PLAYER2));
			int deepnessCurrentPlayer = (currentPlayer == Board.PLAYER1 ? deepnessPlayer1 : deepnessPlayer2);
			boolean currentPlayerBool = (currentPlayer == Board.PLAYER1 ? true : false);
			String typeCurrentPlayer = (currentPlayer == Board.PLAYER1 ? typePlayer1 : typePlayer2);
			String strCurrentPlayer = (currentPlayer == Board.PLAYER1 ? "1" : "2");
			ArrayList<Double> tabMaxCurrentPlayer = (currentPlayer == Board.PLAYER1 ? tabMaxJoueur1 : tabMaxJoueur2);	
			
			//DEBUT TOUR 1
			if(!validMovesCurrentPlayer.isEmpty()) {
				
				//PAUSE
				if(pause) {
					Thread.sleep(500);
				}
				
				//AFFICHAGE NOMBRE DE TOUR
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("-------------------------------- TOUR : "+counter+" ------------------------------------------------");
				System.out.println("----------------------------------------------------------------------------------------");
				counter++;
				//COMPTEUR TOUR PAR JOUEUR PAR ANALYSE
				if(currentPlayer == Board.PLAYER1) {counter1++;}
				else {counter2++;}
				
				//HUMAN
				if(typeCurrentPlayer.equals("human")) {
					b.displayBoard();
					System.out.println("Coups valides pour le joueur " + strCurrentPlayer + " : " + validMovesCurrentPlayer);
					System.out.println("Veuillez saisir un x et un y et un type de coup");
					System.out.println("---> x ? ");
					int x = Integer.parseInt(sc.nextLine());
					System.out.println("---> y ? ");
					int y = Integer.parseInt(sc.nextLine());
					System.out.println("---> type de coup ? ");
					int type = Integer.parseInt(sc.nextLine());
					Point humanMove = new Point(x, y, type);
					System.out.println("---> Le joueur " + strCurrentPlayer + " (human) a choisit le coups : " + humanMove);
					b.play(humanMove, currentPlayer);
				}		

				//RANDOM
				if(typeCurrentPlayer.equals("random")) {
					System.out.println("---> Coups valides pour le joueur " + strCurrentPlayer + " : " + validMovesCurrentPlayer);
					Point tmp = b.randomMove(currentPlayer);
					System.out.println("---> Le joueur " + strCurrentPlayer + " (random) a choisit le coups : " + tmp);
					b.play(tmp, currentPlayer);
				}
				
				//MINMAX
				if(typeCurrentPlayer.equals("minmax")) {
					System.out.println("---> Coups valides pour le joueur " + strCurrentPlayer + " : " + validMovesCurrentPlayer);
					AlphaBeta ab = new AlphaBeta();
					Point tmp;
					long tempsDebutMinMax = System.currentTimeMillis();
					tmp = b.miniMax(deepnessCurrentPlayer, currentPlayerBool, b, ab, alphabetaUse, currentPlayerBool).getPoint();
					long tempsFinMinMax = System.currentTimeMillis();
					double secondsMinMax = (tempsFinMinMax - tempsDebutMinMax) / 1000F;
					tabMaxCurrentPlayer.add(secondsMinMax);	
					System.out.println("---> Le joueur " + strCurrentPlayer + " (minmax) a joue le coup : " + tmp);
					b.play(tmp , currentPlayer);
					System.out.println("---> Nombre de noeuds parcouru par le joueur " + strCurrentPlayer + " ( profondeur " + deepnessCurrentPlayer + ") : " + (currentPlayer == Board.PLAYER1 ? Board.nbNodesPlayer1 : Board.nbNodesPlayer2));
					(currentPlayer == Board.PLAYER1 ? tabNbNodesPlayer1: tabNbNodesPlayer2).add((currentPlayer == Board.PLAYER1 ? Board.nbNodesPlayer1 : Board.nbNodesPlayer2).doubleValue());
				}	
				
				//AFFICHAGE CONSOLE
				b.displayBoard();
				//AFFICHAGE GRAPHIQUE
//				boardDisplay.setBoard(b);
//				boardDisplay.paintComponent(gameWindow.getGraphics());
				
				//CHANGEMENT DE JOUEUR
				currentPlayer = currentPlayer == Board.PLAYER1 ? Board.PLAYER2 : Board.PLAYER1;
				
			}
			//PLUS DE COUPS POSSIBLES
			else {
  				System.out.println("---> Le joueur " + strCurrentPlayer + " ne peut pas jouer car il n'a plus de coups valides !");
  			}
			
			//AFFICHAGE SCORES
			System.out.println("---> Score Joueur 1 : " + b.calculateScore(Board.PLAYER1));
			System.out.println("---> Score Joueur 2 : " + b.calculateScore(Board.PLAYER2));
			
		}
		
		//SUIVIS DU TEMPS D'EXECUTION TOTAL DE LA PARTIE
		long tempsFin = System.currentTimeMillis();
		double seconds = (tempsFin - tempsDebut) / 1000F;
		
		//TEMPS MAX D'UN APPEL DE MINMAX
		Object timeMaxPlayer1 = 0;
		Object timeMaxPlayer2 = 0;
		if(typePlayer1.equals("minmax")) {
			timeMaxPlayer1 = Collections.max(tabMaxJoueur1);
		}
		if(typePlayer2.equals("minmax")) {
			timeMaxPlayer2 = Collections.max(tabMaxJoueur2);
		}	
		
		//GAGNANT
		String strWin;
		if(b.isOver() == 2) {
			strWin = "EGALITE";
		}
		else {
			strWin = (b.calculateScore(Board.PLAYER1)>b.calculateScore(Board.PLAYER2) ? "JOUEUR 1" : "JOUEUR 2");
		}
		
		//ON CLOSE LE SCANNER ET LA WINDOW
//		gameWindow.dispose();
		sc.close();
		
		//AFFICHAGE FINAL
		System.out.println();
		System.out.println(
				"EEEEEEEEEEEEEEEEEEEEEENNNNNNNN        NNNNNNNNDDDDDDDDDDDDD        \r\n" + 
				"E::::::::::::::::::::EN:::::::N       N::::::ND::::::::::::DDD     \r\n" + 
				"E::::::::::::::::::::EN::::::::N      N::::::ND:::::::::::::::DD   \r\n" + 
				"EE::::::EEEEEEEEE::::EN:::::::::N     N::::::NDDD:::::DDDDD:::::D  \r\n" + 
				"  E:::::E       EEEEEEN::::::::::N    N::::::N  D:::::D    D:::::D \r\n" + 
				"  E:::::E             N:::::::::::N   N::::::N  D:::::D     D:::::D\r\n" + 
				"  E::::::EEEEEEEEEE   N:::::::N::::N  N::::::N  D:::::D     D:::::D\r\n" + 
				"  E:::::::::::::::E   N::::::N N::::N N::::::N  D:::::D     D:::::D\r\n" + 
				"  E:::::::::::::::E   N::::::N  N::::N:::::::N  D:::::D     D:::::D\r\n" + 
				"  E::::::EEEEEEEEEE   N::::::N   N:::::::::::N  D:::::D     D:::::D\r\n" + 
				"  E:::::E             N::::::N    N::::::::::N  D:::::D     D:::::D\r\n" + 
				"  E:::::E       EEEEEEN::::::N     N:::::::::N  D:::::D    D:::::D \r\n" + 
				"EE::::::EEEEEEEE:::::EN::::::N      N::::::::NDDD:::::DDDDD:::::D  \r\n" + 
				"E::::::::::::::::::::EN::::::N       N:::::::ND:::::::::::::::DD   \r\n" + 
				"E::::::::::::::::::::EN::::::N        N::::::ND::::::::::::DDD     \r\n" + 
				"EEEEEEEEEEEEEEEEEEEEEENNNNNNNN         NNNNNNNDDDDDDDDDDDDD        ");
		System.out.println();
		System.out.println("---> SCORES : ");
		System.out.println("---> Score final Joueur 1 (" + typePlayer1 + (typePlayer1.equals("minmax") ? ", " + deepnessPlayer1 : "") + ") : " + b.calculateScore(Board.PLAYER1));
		System.out.println("---> Score final Joueur 2 (" + typePlayer2 + (typePlayer2.equals("minmax") ? ", " + deepnessPlayer2 : "") + ") : " + b.calculateScore(Board.PLAYER2));
		System.out.println("---> Grand gagnant : " + strWin);
		System.out.println();
		if(typePlayer1.equals("minmax") || typePlayer2.equals("minmax")) {
			System.out.println("---> MINMAX :");
			if(alphabetaUse) {
				System.out.println("---> Nombre de noeuds evite grace a AlphaBeta : " + Board.breakN);
			}		
			System.out.println("---> Nombre de noeuds parcouru par le joueur 1 (profondeur " + deepnessPlayer1 + ") : " + Board.nbNodesPlayer1);
			System.out.println("---> Nombre de noeuds parcouru par le joueur 2 (profondeur " + deepnessPlayer2 + ") : " + Board.nbNodesPlayer2);
			System.out.println();
		}	
		System.out.println("---> DUREES : ");
		System.out.println("---> Duree de la partie : " + Double.toString(seconds) + " secondes (" + (Double.toString(seconds/60)) + " minutes)");
		if(typePlayer1.equals("minmax")){
			System.out.println("---> Duree maximum de fonction minimax (profondeur " + deepnessPlayer1 + ") : " + timeMaxPlayer1.toString() + " secondes (" + Double.parseDouble(timeMaxPlayer1.toString())*1000 + " ms)");
		}
		if(typePlayer2.equals("minmax")){
			System.out.println("---> Duree maximum de fonction minimax (profondeur " + deepnessPlayer2 + ") : " + timeMaxPlayer2.toString() + " secondes (" + Double.parseDouble(timeMaxPlayer2.toString())*1000 + " ms)");
		}
		
		//AFFICHAGE DES COURBES SI LES DEUX JOUEURS SONT MINMAX
		if(typePlayer1.equals("minmax") && typePlayer2.equals("minmax")) {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			WindowDisplay window = new WindowDisplay();
			window.setVisible(true);
		}	
        
	}
	
}
