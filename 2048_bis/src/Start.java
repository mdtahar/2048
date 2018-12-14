
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Start extends JFrame implements ActionListener,KeyListener {

	public JPanel p1; 
	public Jeu monJeu ;
	public int direction;
	
	JButton menu;
	JButton haut;
	JButton bas;
	JButton gauche;
	JButton droit;
	
	JLabel niveaul;
	JTextField numNt;
	
	JLabel bestscorel ;
	JTextField nbrbSt ;
	
	JLabel scorel ;
	JTextField nbrSt ;
	
	Plateau maGrille;
	
	public Start(Jeu j){
		super("2048 Game BETA");
		this.monJeu = j;
		p1 = new JPanel(new BorderLayout());
		
		//west
		JSeparator s1 = new JSeparator();
		JSeparator s2 = new JSeparator();
	
		
		
		JPanel statique = new JPanel(new GridLayout(0,1));
		
		JPanel pansA = new JPanel();
		JPanel pansB = new JPanel(new GridLayout(0,1));
		JPanel pansC = new JPanel();
		
		statique.add(pansA);
		
		statique.add(s1);
		
		JPanel pans1 = new JPanel(new GridLayout(1,0));
		JPanel pans2 = new JPanel(new GridLayout(1,0));
		JPanel pans3 = new JPanel(new GridLayout(1,0));
			
		// niveau
		JPanel pans1A= new JPanel(new BorderLayout());
		JPanel pans1B = new JPanel(new BorderLayout());
		
		JPanel s5= new JPanel();
		JPanel s6 = new JPanel();
		pans1A.add(s5,BorderLayout.SOUTH);
		pans1B.add(s6,BorderLayout.SOUTH);
		
		ImageIcon icon6 = new ImageIcon("niveau.png");
		niveaul = new JLabel(icon6);
		niveaul.setPreferredSize(new Dimension(100,40)); 
		
		numNt = new JTextField(3);
		numNt.setEditable(false);		
		pans1A.add(niveaul);
		pans1B.add(numNt);
		pans1.add(pans1A);
		pans1.add(pans1B);
		pansB.add(pans1);
		statique.add(pansB);
		
		// score
		JPanel pans2A= new JPanel(new BorderLayout());
		JPanel pans2B = new JPanel(new BorderLayout());
		JPanel s3= new JPanel();
		JPanel s4 = new JPanel();
		pans2A.add(s3,BorderLayout.SOUTH);
		pans2B.add(s4,BorderLayout.SOUTH);
		

		ImageIcon icon7= new ImageIcon("score.png");
		scorel = new JLabel(icon7);
		scorel.setPreferredSize(new Dimension(100,40)); 
		
		nbrSt = new JTextField(3);
		nbrSt.setEditable(false);		
		pans2A.add(scorel);
		pans2B.add(nbrSt);
		pans2.add(pans2A);
		pans2.add(pans2B);
		pansB.add(pans2);
		statique.add(pansB);
		
		// best score
		JPanel pans3A= new JPanel(new BorderLayout());
		JPanel pans3B = new JPanel(new BorderLayout());
		
		JPanel s7= new JPanel();
		JPanel s8 = new JPanel();
		pans3A.add(s7,BorderLayout.SOUTH);
		pans3B.add(s8,BorderLayout.SOUTH);
	
		ImageIcon icon8= new ImageIcon("bscore.png");
		bestscorel = new JLabel(icon8);
		bestscorel.setPreferredSize(new Dimension(100,40)); 
		
	
		
		nbrbSt = new JTextField(3);
		nbrbSt.setEditable(false);		
		pans3A.add(bestscorel);
		pans3B.add(nbrbSt);
		pans3.add(pans3A);
		pans3.add(pans3B);
		pansB.add(pans3);
		statique.add(pansB);
		statique.add(pansC);
		statique.add(s2);
		Border b1 = BorderFactory.createLineBorder(Color.blue,4);
		statique.setBorder(b1);
		
		p1.add(statique,BorderLayout.WEST);
		
		// south
			
		//le menu
		
		
		JPanel pave = new JPanel(new GridLayout(0,1));
		
		
		
		ImageIcon icon1 = new ImageIcon("menu.png");
		menu = new JButton(icon1);
		menu.setPreferredSize(new Dimension(100,40)); 
		menu.addActionListener(this);
		
		JPanel pan1= new JPanel(new GridLayout(0,1));
		JPanel pan1u = new JPanel();
		JPanel pan1d = new JPanel();
		JPanel pan1c= new JPanel();
		pan1d.add(menu);
		pan1.add(pan1u);
		pan1.add(pan1d);
		pan1.add(pan1c);
		pave.add(pan1);
			
		// les flèches
		
		ImageIcon icon2 = new ImageIcon("haut.png");
		haut = new JButton(icon2);
		haut.setPreferredSize(new Dimension(30,40)); 
		haut.addActionListener(this);
		
		ImageIcon icon3 = new ImageIcon("bas.png");
		bas = new JButton(icon3);
		bas.setPreferredSize(new Dimension(30,40)); 
		bas.addActionListener(this);
		
		ImageIcon icon4 = new ImageIcon("gauche.png");
		gauche = new JButton(icon4);
		gauche.setPreferredSize(new Dimension(40,30)); 
		gauche.addActionListener(this);
		
		ImageIcon icon5 = new ImageIcon("droit.png");
		droit = new JButton(icon5);
		droit.setPreferredSize(new Dimension(40,30)); 
		droit.addActionListener(this);
		
		JPanel pan2 = new JPanel(new GridLayout(0,5));
		JPanel pangg = new JPanel();
		JPanel pandd = new JPanel();
		JPanel pang = new JPanel(new GridLayout(3, 0));
		JPanel panm = new JPanel(new GridLayout(3,0));
		JPanel pand = new JPanel(new GridLayout(3, 0));
		
		//gauche
		JPanel pang1 = new JPanel();
		JPanel pang2 = new JPanel();
		JPanel pang3 = new JPanel();
		
		pang2.add(gauche);
		pang.add(pang1);
		pang.add(pang2);
		pang.add(pang2);
		//haut et bas 
		JPanel panm1 = new JPanel();
		JPanel panm2 = new JPanel();
		JPanel panm3 = new JPanel();
		
		panm1.add(haut);
		panm3.add(bas);
		panm.add(panm1);
		panm.add(panm2);
		panm.add(panm3);
		
		// droit
		JPanel pand1 = new JPanel();
		JPanel pand2 = new JPanel();
		JPanel pand3 = new JPanel();
		
		pand2.add(droit);
		pand.add(pand1);
		pand.add(pand2);
		pand.add(pand2);
		
		pan2.add(pangg);
		pan2.add(pang);
		pan2.add(panm);
		pan2.add(pand);
		pan2.add(pandd);
		
		pave.add(pan2);
		Border b2 = BorderFactory.createLineBorder(Color.black,4);
		pave.setBorder(b2);
		
		
		
		p1.add(pave,BorderLayout.EAST);
		
		//test plateau
		int h = p1.getHeight();
		int w = p1.getWidth();
		
		Border b3 = BorderFactory.createLineBorder(new java.awt.Color(187, 173, 160),15);
	
		int[][] t = grilleInt(monJeu.niveau.grille);
		//int [][] t = {{2,4,8,16},{32,64,128,256},{512,2049,0,1024},{0,0,2048,0}};
		maGrille = new Plateau(t,w,h);
		maGrille.setBorder(b3);
		this.p1.add(maGrille,BorderLayout.CENTER);
		this.addKeyListener(this);
	    this.setFocusable(true);
		// la fin 
		this.add(p1);
		
		//les evenements 
		
		this.stat();
		
		
		//--------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1336,768);
		this.setVisible(true);
	}
	
	
	public static int[][] grilleInt(Cellule [][] g){
        int[][] res = new int[g.length][g[0].length];
        for (int i = 0; i <g.length ; i++) {
            for (int j = 0; j<g.length; j++) {
            	if(g[i][j].getClass() == Vide.class){
                    res[i][j] = 0;
            	}
            	if(g[i][j].getClass() == Obstacle.class){
                    res[i][j] = 2049;
            	}
            	if(g[i][j].getClass() == Hole.class){
                    res[i][j] = 2050;
            	}
            	if(g[i][j].getClass() == Valeur.class){
            		res[i][j] = (((Valeur)g[i][j]).val);
            	}
            }
        }
	return res;
        
    }
	
	public void stat(){
		String n = String.valueOf(monJeu.numN);
		String sc = String.valueOf(monJeu.niveau.score);
		String bsc = String.valueOf(monJeu.niveau.BestScore);
		this.numNt.setText(n);
		this.nbrSt.setText(sc);
		this.nbrbSt.setText(bsc);
		this.numNt.setFont(new java.awt.Font("Arial", 1, 20));
		this.nbrSt.setFont(new java.awt.Font("Arial", 1, 20));
		this.nbrbSt.setFont(new java.awt.Font("Arial", 1, 20));
	}
	public void update(){
		int [][] t =  grilleInt(this.monJeu.niveau.grille);
		maGrille.sup();
		
		maGrille.validate();
		maGrille.revalidate();
		maGrille.paint2(t);
		this.stat();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(menu)){
			this.setVisible(false);
			new Play();
		}
		if (e.getSource().equals(bas)){
			this.monJeu.niveau.operation(4);
			this.update();
		}
		if (e.getSource().equals(haut)){
			this.monJeu.niveau.operation(3);
			this.update();
		}
		if (e.getSource().equals(gauche)){
			this.monJeu.niveau.operation(1);
			this.update();
		}
		if (e.getSource().equals(droit)){
			this.monJeu.niveau.operation(2);
			this.update();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
        	case 37 :
        		this.monJeu.niveau.operation(1);
        		this.update();
        		break;
        	case 39 : 
        		this.monJeu.niveau.operation(2);
        		this.update();
        		break;
        	case 38 : 
        		this.monJeu.niveau.operation(3);
        		this.update();
        		break;
        	case 40 : 
        		this.monJeu.niveau.operation(4);
        		this.update();
        		break;
        }
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

