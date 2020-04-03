package projet1_7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;

//CLASS CurveDisplay
public class CurveDisplay extends JComponent {

	private static final long serialVersionUID = 7800853645256601960L;

	//OVERRIDE DE LA FONCTION paintComponent
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		//ANTIALIASING
		((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//BACKGROUND
		graphics.setColor(new Color(20,20,20));
		graphics.fillRect(0, 0, getWidth(), getHeight());

		//AXES
		graphics.setColor(Color.WHITE);
		graphics.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		graphics.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());

		//COURBES
		
			//COURBE NODES PER TURN
//		double step = 1;
//		graphics.setColor(Color.WHITE); 
//		graphics.drawString("NODES PER TURNTOTAL", 20, 20);
//		graphics.drawString("NODES", (getWidth()/2) - 60, 20);
//		graphics.drawString("TURN", getWidth() - 60, getHeight()/2 + 60);
//		graphics.drawString("0", (int)(getWidth()*0.5) + 2, (int)(getHeight()*0.54));
//		for(double lx = 0; lx <= WindowDisplay.tabTurn1.length - 2; lx += step) {
//			graphics.setColor(Color.WHITE);
//			double maxTab1 = (Collections.max(WindowDisplay.tabNbNodesPlayer1));
//			double maxTab2 = (Collections.max(WindowDisplay.tabNbNodesPlayer2));
//			double maxTab = (maxTab1 > maxTab2 ? maxTab1 : maxTab2);
//			double maxTabCounter = (double)WindowDisplay.tabTurn1.length;
//			int prevx = xToPixel(lx/(maxTabCounter/Main.counter1)-1);
//			int x = xToPixel(lx/(maxTabCounter/Main.counter1));
//			int prevy1 = 0;
//			int prevy2 = 0;
//			if(lx != 0) {
//				prevy1 = yToPixel(WindowDisplay.tabNbNodesPlayer1.get((int)lx - 1)/maxTab);
//				prevy2 = yToPixel(WindowDisplay.tabNbNodesPlayer2.get((int)lx - 1)/maxTab);
//			}		
//			int y1 = yToPixel(WindowDisplay.tabNbNodesPlayer1.get((int)lx)/maxTab);
//			int y2 = yToPixel(WindowDisplay.tabNbNodesPlayer2.get((int)lx)/maxTab);
//			if(lx != 0) {
//				//X
//				graphics.drawString(Integer.toString((int)(lx*(2*Math.PI))), (int)lx*(getWidth()/20) + getWidth()/2, (int)(getHeight()*0.54));
//				//Y
//				graphics.drawString(Integer.toString(WindowDisplay.tabNbNodesPlayer1.get((int)lx).intValue()), (int)(getWidth()*0.51), (int)-lx*(getHeight()/20) + getHeight()/2);		
//			}     	
//			graphics.drawString("|", (int)lx*(getWidth()/20) + getWidth()/2, (int)(getHeight()*0.505));
//			graphics.drawString("_", (int)(getWidth()*0.495), (int)-lx*(getHeight()/20) + getHeight()/2);
//			graphics.setColor(Color.RED); 
//			graphics.fillOval(x-1, y1-1, 4, 4);
//			if(lx != 0) {
//				graphics.drawLine(prevx, prevy1, x, y1);
//			}	
//			graphics.setColor(Color.GREEN);
//			graphics.fillOval(x-1, y2-1, 4, 4);
//			if(lx != 0) {
//				graphics.drawLine(prevx, prevy2, x, y2);
//			}	
//		} 
		
			//COURBE STEP NODES PER TURN
		double step = 1;
		graphics.setColor(Color.WHITE); 
		graphics.drawString("STEPNODES PER TURN", 20, 20);
		graphics.drawString("NODES", (getWidth()/2) - 60, 20);
		graphics.drawString("TURN", getWidth() - 60, getHeight()/2 + 60);
		graphics.drawString("0", (int)(getWidth()*0.5) + 2, (int)(getHeight()*0.54));
		
		ArrayList<Double> tabNbStepNodesPlayer1 = new ArrayList<Double>();
	    for(int i = 0; i < WindowDisplay.tabNbNodesPlayer1.size() - 1; i++) {
	    	tabNbStepNodesPlayer1.add(WindowDisplay.tabNbNodesPlayer1.get(i+1) - WindowDisplay.tabNbNodesPlayer1.get(i));;
	    }	
	    ArrayList<Double> tabNbNoeudsStepJoueur2 = new ArrayList<Double>();
	    for(int j = 0; j < WindowDisplay.tabNbNodesPlayer2.size() - 1; j++) {
	    	tabNbNoeudsStepJoueur2.add(WindowDisplay.tabNbNodesPlayer2.get(j+1) - WindowDisplay.tabNbNodesPlayer2.get(j));;
	    }
	    
		for(double lx = 0; lx <= (WindowDisplay.tabTurn1.length >= WindowDisplay.tabTurn2.length ? WindowDisplay.tabTurn1.length : WindowDisplay.tabTurn2.length) - 3; lx += step) {
			graphics.setColor(Color.WHITE);
			double maxTab1 = (Collections.max(tabNbStepNodesPlayer1));
			double maxTab2 = (Collections.max(tabNbNoeudsStepJoueur2));
			double maxTab = (maxTab1 > maxTab2 ? maxTab1 : maxTab2);
			double maxTabCounter = (double)WindowDisplay.tabTurn1.length;
			int prevx = xToPixel(lx/(maxTabCounter/Main.counter1)-1);
			int x = xToPixel(lx/(maxTabCounter/Main.counter1));
			int prevy1 = 0;
			int prevy2 = 0;
			if(lx != 0) {
				prevy1 = yToPixel(tabNbStepNodesPlayer1.get((int)lx - 1)/maxTab);
				prevy2 = yToPixel(tabNbNoeudsStepJoueur2.get((int)lx - 1)/maxTab);
			}		
			int y1 = yToPixel(tabNbStepNodesPlayer1.get((int)lx)/maxTab);
			int y2 = yToPixel(tabNbNoeudsStepJoueur2.get((int)lx)/maxTab);
			if(lx != 0) {
				//X
				graphics.drawString(Integer.toString((int)(lx*(2*Math.PI))), (int)lx*(getWidth()/20) + getWidth()/2, (int)(getHeight()*0.54));
				//Y
				graphics.drawString(Integer.toString(tabNbStepNodesPlayer1.get((int)lx).intValue()), (int)(getWidth()*0.51), (int)-lx*(getHeight()/20) + getHeight()/2);		
			}     	
			graphics.drawString("|", (int)lx*(getWidth()/20) + getWidth()/2, (int)(getHeight()*0.505));
			graphics.drawString("_", (int)(getWidth()*0.495), (int)-lx*(getHeight()/20) + getHeight()/2);
			graphics.setColor(Color.RED); 
			graphics.fillOval(x-1, y1-1, 4, 4);
			if(lx != 0) {
				graphics.drawLine(prevx, prevy1, x, y1);
			}	
			graphics.setColor(Color.GREEN);
			graphics.fillOval(x-1, y2-1, 4, 4);
			if(lx != 0) {
				graphics.drawLine(prevx, prevy2, x, y2);
			}	
		} 
		
//			//COURBE NODES PER DEEP
//		//PROBLEME AVEC LE VALEUR MINMAX4 TROP GRANDE PR RENTRER DANS UN BIGINTEGER
//		double step = 1;
//		double maxTab1 = (Collections.max(WindowDisplay.tabNodesPlayer));
//		double maxTabCounter = (double)WindowDisplay.nbDeep.length;
//		graphics.setColor(Color.WHITE); 
//		graphics.drawString("NODES PER DEEP", 20, 20);
//		graphics.drawString("NODES", (getWidth()/2) - 60, 20);
//		graphics.drawString("DEEP", getWidth() - 60, getHeight()/2 + 60);
//		graphics.drawString("0", (int)(getWidth()*0.5) + 2, (int)(getHeight()*0.54));
//		graphics.drawString("0", (int)(getWidth()*0.51), (getHeight()/50)-20 + getHeight()/2);
//		for(int i = 1; i < 5; i++) {
//			graphics.drawString("_", (int)(getWidth()*0.495), -i*(getHeight()/10) + getHeight()/2);
//			//Y
//			graphics.drawString(Integer.toString((int) (maxTab1/5*i)), (int)(getWidth()*0.51), -i*(getHeight()/10) + getHeight()/2);
//		}
//		for(int j = 1; j < 5; j++) {
//			graphics.drawString("|", (int)(j*(getWidth()/(maxTabCounter*2)) + getWidth()/2), (int)(getHeight()*0.505)); // /8 pr 3 /6 pr 2 /4 pr 1
//			//X
//			graphics.drawString(Integer.toString(j), (int)(j*(getWidth()/(maxTabCounter*2))) + getWidth()/2, (int)(getHeight()*0.54));
//		}		
//		for(double lx = 0; lx <= WindowDisplay.nbDeep.length-1; lx += step) {
//			graphics.setColor(Color.WHITE);
//			int prevx = xToPixel(lx/(maxTabCounter/WindowDisplay.nbDeep.length)-1);
//			int x = xToPixel(lx/(maxTabCounter/WindowDisplay.nbDeep.length));
//			int prevy = 0;
//			if(lx != 0) {
//				prevy = yToPixel((WindowDisplay.tabNodesPlayer.get((int)lx - 1))/maxTab1);
//			}		
//			int y = yToPixel(WindowDisplay.tabNodesPlayer.get((int)lx)/maxTab1);
//			if(lx != 0) {
//	
//			}     	
//			graphics.setColor(Color.RED);
//			Double tmpBI = WindowDisplay.tabNodesPlayer.get((int)lx);
//			String tmpStr = tmpBI.toString();
//			graphics.drawString("(" + tmpStr + ")", x+5, y+25);
//			graphics.setColor(Color.yellow); 
//			graphics.fillOval(x-1, y-1, 7, 7);
//			if(lx != 0) {
//				graphics.drawLine(prevx, prevy, x, y);
//			}	
//		} 
		
//			//COURBE NODES PER DEEP BIGINTEGER
//		//PROBLEME AVEC LE VALEUR MINMAX4 TROP GRANDE PR RENTRER DANS UN BIGINTEGER
//		double step = 1;
//		graphics.setColor(Color.WHITE); 
//		graphics.drawString("NODES PER DEEP", 20, 20);
//		graphics.drawString("NODES", (getWidth()/2) - 60, 20);
//		graphics.drawString("DEEP", getWidth() - 60, getHeight()/2 + 60);
//		graphics.drawString("0", (int)(getWidth()*0.5) + 2, (int)(getHeight()*0.54));
//		graphics.drawString("0", (int)(getWidth()*0.51), (getHeight()/50)-20 + getHeight()/2);
//		for(double lx = 0; lx <= WindowDisplay.nbDeep.length-1; lx += step) {
//			graphics.setColor(Color.WHITE);
//			BigInteger maxTab1 = (Collections.max(WindowDisplay.tabNodesPlayer));
//			double maxTabCounter = (double)WindowDisplay.nbDeep.length;
//			double prevx = xToPixel(lx/(maxTabCounter/WindowDisplay.nbDeep.length)-1);
//			int x = xToPixel(lx/(maxTabCounter/WindowDisplay.nbDeep.length));
//			BigInteger prevy;
//			if(lx != 0) {
//				prevy = yToPixel((WindowDisplay.tabNodesPlayer.get((int)lx - 1)).divide(maxTab1));
//			}		
//			BigInteger y = yToPixel(WindowDisplay.tabNodesPlayer.get((int)lx).divide(maxTab1));
//			if(lx != 0) {
//				//X
//				graphics.drawString(Integer.toString((int)(lx)), (int)lx*(getWidth()/5) + getWidth()/2, (int)(getHeight()*0.54));
//				//Y
//				BigInteger tmp1 = (maxTab1.divide(BigInteger.valueOf(5).multiply(BigInteger.valueOf((long)lx))));
//				String tmp2 = tmp1.toString();
//				graphics.drawString(tmp2, (int)(getWidth()*0.51), (int)-lx*(getHeight()/10) + getHeight()/2);		
//			}     	
//			graphics.drawString("|", (int)lx*(getWidth()/5) + getWidth()/2, (int)(getHeight()*0.505));
//			graphics.drawString("_", (int)(getWidth()*0.495), (int)-lx*(getHeight()/10) + getHeight()/2);
//			graphics.setColor(Color.RED);
//			BigInteger tmpBI = WindowDisplay.tabNodesPlayer.get((int)lx);
//			String tmpStr = tmpBI.toString();
//			graphics.drawString("(" + tmpStr + ")", x+5, y.add(BigInteger.valueOf(25)));
//			graphics.setColor(Color.yellow); 
//			graphics.fillOval(x-1, y.subtract(BigInteger.ONE), 7, 7);
//			if(lx != 0) {
//				graphics.drawLine(prevx, prevy, x, y);
//			}	
//		} 

	}

	private int xToPixel(double x) {
		return (int)(getWidth() * (x + (int)Main.counter1)/(2*(int)Main.counter1)); //Main.counter1 //WindowDisplay.nbDeep.length
	}

	private int yToPixel(double y) {
		return (int)(getHeight() * (1 - (y + 1)/2.0));
	}

	private BigInteger yToPixel(BigInteger y) {
		BigInteger tmp = (BigInteger.valueOf(getHeight()).multiply((BigInteger.ONE.subtract((y.add(BigInteger.ONE))).divide(BigInteger.valueOf(2)))));
		return tmp;
	}

}