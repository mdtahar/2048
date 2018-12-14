
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


public class Level extends  JFrame  implements ActionListener {
	/**
	 * 
	 */
	public JPanel principalPan,panel1,panel2;
	public JButton level1,level2,level3,level4,back;
	
	public Level() {
		
		setTitle("2048 Game BETA");
		setBounds(500,200, 300, 300);
		
		principalPan = new JPanel(new BorderLayout());
		
		ImageIcon icon0 = new ImageIcon("Level.png");
		JLabel headerlab = new JLabel(icon0);
		panel2 = new JPanel();
		panel2.add(headerlab);
		
		
		JSeparator s1 = new JSeparator();
		JSeparator s2 = new JSeparator();
		
		principalPan.add(panel2, BorderLayout.NORTH);
		headerlab.setFont(new Font("script",10,15));
		headerlab.setForeground(Color.red);
		
		
		this.add(principalPan);
		
		
		ImageIcon icon1 = new ImageIcon("Level1.png");
		level1 = new JButton(icon1);
		level1.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon2 = new ImageIcon("Level2.png");
		level2 = new JButton(icon2);
		level2.setPreferredSize(new Dimension(100,40)); 
		
		
		
		ImageIcon icon3= new ImageIcon("Level3.png");
		level3 = new JButton(icon3);
		level3.setPreferredSize(new Dimension(100,40)); 
		level3.addActionListener(this);
		
		
		ImageIcon icon4 = new ImageIcon("Level4.png");
		level4 = new JButton(icon4);
		level4.setPreferredSize(new Dimension(100,40)); 
		
		ImageIcon icon5 = new ImageIcon("Back.png");
		back = new JButton(icon5);
		back.setPreferredSize(new Dimension(100,40)); 
		
		JPanel pan2= new JPanel();
		pan2.add(level1);
		
		
		JPanel pan3= new JPanel();
		pan3.add(level2);
	

		JPanel pan4= new JPanel();
		pan4.add(level3);
		
		JPanel pan5= new JPanel();
		pan5.add(level4);
		
		JPanel pan6= new JPanel();
		pan6.add(back);
		
		pan2.setBackground(new java.awt.Color(128, 176, 186));
		pan3.setBackground(new java.awt.Color(128, 176, 186));
		pan4.setBackground(new java.awt.Color(128, 176, 186));
		pan5.setBackground(new java.awt.Color(128, 176, 186));
		pan6.setBackground(new java.awt.Color(128, 176, 186));
		
		panel2.setBackground(new java.awt.Color(128, 176, 186));
		panel1 = new JPanel(new GridLayout(0,1));
		panel1.add(s1);
		panel1.add(pan2);
		panel1.add(pan3);
		panel1.add(pan4);
		panel1.add(pan5);
		panel1.add(pan6);
		
		panel1.add(s2);
		principalPan.add(panel1);
		panel1.setBackground(new java.awt.Color(128, 176, 186));
		
		level1.addActionListener(this);
		level2.addActionListener(this);
		level4.addActionListener(this);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,450);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource().equals(level1)){
			
		}
		if (e.getSource().equals(level2)){
			
		}
		if (e.getSource().equals(level3)){
		
		}
		if (e.getSource().equals(level4)){
			
		}
		if (e.getSource().equals(back)){
			
		}
	}
	
}