import java.awt.GridLayout;

import javax.swing.JPanel;


public class Plateau extends JPanel{
	GridLayout g ;
	int hh;
	public Plateau(int[] [] t,int w,int h){
		g = new GridLayout(t.length,t.length,15,15);
		hh = t.length;
		this.setLayout(g);
		this.setSize(w, h);
		paint2(t);
		g.setVgap(15);
	    g.setHgap(15);
	    this.setBackground(new java.awt.Color(187, 173, 160));
	   
	}
	
	public void paint2(int[][] a){
		int t = ((a.length*2)*15);
		int hCase = (this.getHeight()-t)/a.length;
		int wCase = (this.getWidth()-t)/a.length;
	       for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < a[0].length; j++) {
	            	this.add(new Case(a[i][j],wCase,hCase));
	            }
	       }
	}
	public void sup(){
		for (int i = 0; i < hh; i++) {
            for (int j = 0; j < hh; j++) {
            	this.removeAll();
            	this.repaint();
            }
       }
	}
}

