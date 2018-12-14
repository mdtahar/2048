
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class Play extends  JFrame  implements ActionListener {
	public JPanel principalPan,panel1,panel2;
	public JButton Jouer,Continue,Aide,exit;
	
	public Play() 
	{
		setTitle("2048 Game BETA");
		setBounds(500,200, 300, 300);
		
		principalPan = new JPanel(new BorderLayout());
		
		ImageIcon icon0 = new ImageIcon("titre.png");
		JLabel headerlab = new JLabel(icon0);
		panel2 = new JPanel();
		panel2.add(headerlab);
		
		
		JSeparator s1 = new JSeparator();
		JSeparator s2 = new JSeparator();
		
		principalPan.add(panel2, BorderLayout.NORTH);
		headerlab.setFont(new Font("script",10,15));
		headerlab.setForeground(Color.red);
		
		
		this.add(principalPan);
		
		
		ImageIcon icon1 = new ImageIcon("jouer.png");
		Jouer = new JButton(icon1);
		Jouer.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon2 = new ImageIcon("conti.png");
		Continue = new JButton(icon2);
		Continue.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon3 = new ImageIcon("aide.png");
		Aide= new JButton(icon3);
		Aide.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon4 = new ImageIcon("exit.png");
		exit= new JButton(icon4);
		exit.setPreferredSize(new Dimension(100,40)); 
		
		
		
		
		JPanel pan2= new JPanel();
		pan2.add(Jouer);
		
		
		JPanel pan3= new JPanel();
		pan3.add(Continue);
	
		
		JPanel pan4= new JPanel();
		pan4.add(Aide);
	
		
		JPanel pan5= new JPanel();
		pan5.add(exit);
		pan2.setBackground(new java.awt.Color(128, 176, 186));
		pan3.setBackground(new java.awt.Color(128, 176, 186));
		pan4.setBackground(new java.awt.Color(128, 176, 186));
		pan5.setBackground(new java.awt.Color(128, 176, 186));
		panel2.setBackground(new java.awt.Color(128, 176, 186));
		panel1 = new JPanel(new GridLayout(0,1));
		panel1.add(s1);
		panel1.add(pan2);
		panel1.add(pan3);
		panel1.add(pan4);
		panel1.add(pan5);
		panel1.add(s2);
		principalPan.add(panel1);
		panel1.setBackground(new java.awt.Color(128, 176, 186));
		
		Jouer.addActionListener(this);
		Continue.addActionListener(this);
		Aide.addActionListener(this);
		exit.addActionListener(this);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	/*
	 * la fonction conti construi le jeu pour continue
	 */
	public static Jeu conti(){
		int typeRes  = DiskTools.chargerTypeJ();
		int numRes = DiskTools.chargerNumeroN();
		Jeu res = null; 
		if(typeRes== 1){
			if(numRes>3){
				Modele n = new Modele1(5);
				res = new Jeu(n, numRes, typeRes);
			}
			else{
				Modele n = new Modele1(4);
				res = new Jeu(n, numRes, typeRes);
			}
		}
		if(typeRes== 2){
			if(numRes>3){
				Modele n = new Modele2(5);
				res = new Jeu(n, numRes, typeRes);
			}
			else{
				Modele n = new Modele2(4);
				res = new Jeu(n, numRes, typeRes);
			}
		}
		
		return res;
	}
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource().equals(Jouer)){
			this.setVisible(false);
			new Choix();
		}
		if (e.getSource().equals(Continue)){
			this.setVisible(false);
			Jeu j = conti();
			new Start(j);
		}
		if (e.getSource().equals(Aide)){
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.open(new File("help.html")); 
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		if (e.getSource().equals(exit)){
			int x =JOptionPane.showConfirmDialog(this,"voulez_vous Quitter l'application" ,"la Ferméture", JOptionPane.YES_NO_OPTION);
	    	if (x==0) 
	    	{
	    		System.exit(0);
	    	}
		}
	}
	
}
