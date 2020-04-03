package projet1_7;

import java.awt.BorderLayout;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

//CLASS WindowDisplay
public class WindowDisplay extends JFrame {

    private static final long serialVersionUID = -3914578220391097071L;
    
    private CurveDisplay curveCanvas = new CurveDisplay();
    
    //DATA ANALYSEE
    	//NODES/TURN
//  static ArrayList<Double> tabNbNodesPlayer1 = Main.tabNbNodesPlayer1;
//  static ArrayList<Double> tabNbNodesPlayer2 = Main.tabNbNodesPlayer2;
//	static int[] tabTour1 = new int[Main.counter1];
//	static int[] tabTour2 = new int[Main.counter2];
	
		//STEP NODES/TURN
    static ArrayList<Double> tabNbNodesPlayer1 = Main.tabNbNodesPlayer1;
    static ArrayList<Double> tabNbNodesPlayer2 = Main.tabNbNodesPlayer2;
	static int[] tabTurn1 = new int[Main.counter1];
	static int[] tabTurn2 = new int[Main.counter2];
	
		//NODES/DEEP BIGINTEGER
//	static ArrayList<BigInteger> tabNodesPlayer = new ArrayList<BigInteger>() {
//		private static final long serialVersionUID = 1L;
//	{
//		add(BigInteger.valueOf(3_222));
//		add(BigInteger.valueOf(115_626));
//		add(BigInteger.valueOf(4_079_662));
//		add(BigInteger.valueOf(252_585_603));
//		BigInteger x = BigInteger.valueOf(2_000_000_000);
//		BigInteger z = x.multiply(BigInteger.valueOf(3));
//		z  = z.add(BigInteger.valueOf(1_855_453_012));
//		add(z);
//	}};
//	static int[] nbDeep = {0,1,2,3,4};
	
		//NODES/DEEP NORMAL
//	static ArrayList<Double> tabNodesPlayer = new ArrayList<Double>() {
//		private static final long serialVersionUID = 1L;
//	{
//		add(3_222.0);
//		add(115_626.0);
//		add(4_079_662.0);
//		add(252_585_603.0);
//	}};
//	static int[] nbDeep = {0,1,2,3};

	//CREATION DE LA FENETRE
    public WindowDisplay() {	 	
        super("CURVE ANALYSIS");    
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        JPanel contentPane = (JPanel) this.getContentPane();        
        contentPane.add(curveCanvas, BorderLayout.CENTER);    
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
    }

}