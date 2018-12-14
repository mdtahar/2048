

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JSeparator;


public class Choix extends  JFrame  implements ActionListener {
	/**
	 * 
	 */
	public JPanel principalPan,panel1,panel2;
	public JButton gravity,pushing,menu;
	
	public Choix() {
		
		setTitle("2048 Game BETA");
		setBounds(500,200, 300, 300);
		
		principalPan = new JPanel(new BorderLayout());
		
		ImageIcon icon0 = new ImageIcon("choix.png");
		JLabel headerlab = new JLabel(icon0);
		panel2 = new JPanel();
		panel2.add(headerlab);
		
		
		JSeparator s1 = new JSeparator();
		JSeparator s2 = new JSeparator();
		
		principalPan.add(panel2, BorderLayout.NORTH);
		headerlab.setFont(new Font("script",10,15));
		headerlab.setForeground(Color.red);
		
		
		this.add(principalPan);
		
		
		ImageIcon icon1 = new ImageIcon("gravity.png");
		gravity = new JButton(icon1);
		gravity.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon2 = new ImageIcon("pushing.png");
		pushing = new JButton(icon2);
		pushing.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon3= new ImageIcon("menu.png");
		menu = new JButton(icon3);
		menu.setPreferredSize(new Dimension(100,40)); 
		menu.addActionListener(this);
		
		
		
		JPanel pan2= new JPanel();
		pan2.add(gravity);
		
		
		JPanel pan3= new JPanel();
		pan3.add(pushing);
	

		JPanel pan4= new JPanel();
		pan4.add(menu);
		
		pan2.setBackground(new java.awt.Color(128, 176, 186));
		pan3.setBackground(new java.awt.Color(128, 176, 186));
		pan4.setBackground(new java.awt.Color(128, 176, 186));
		
		panel2.setBackground(new java.awt.Color(128, 176, 186));
		panel1 = new JPanel(new GridLayout(0,1));
		panel1.add(s1);
		panel1.add(pan2);
		panel1.add(pan3);
		panel1.add(pan4);
		
		panel1.add(s2);
		principalPan.add(panel1);
		panel1.setBackground(new java.awt.Color(128, 176, 186));
		
		gravity.addActionListener(this);
		pushing.addActionListener(this);

	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource().equals(gravity)){
			this.setVisible(false);
			Jeu j = new Jeu(1);
			new Level();
		}
		if (e.getSource().equals(pushing)){
			this.setVisible(false);
			Jeu j = new Jeu(2);
			new Start(j);
		}
		if (e.getSource().equals(menu)){
			this.setVisible(false);
			new Play();
		}
	}
	
}