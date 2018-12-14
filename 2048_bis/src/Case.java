import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Case extends  JPanel {

	String valeur;
	int v ;
	public Case(int val,int w,int h){
		v = val;
		this.setSize(w, h);
		if(val == 0) this.valeur = "";
        else if(val == 2049) this.valeur ="?";
        else this.valeur =String.valueOf(val);
	
		this.repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
				switch (v) {
				case 0:
					this.setBackground(new java.awt.Color(204, 192, 179));
					break;
				case 2:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)+10));
					g.setColor(new java.awt.Color(119,110,101));
					g.drawString(valeur,((this.getHeight()/2)-20) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(238, 228, 218));
					break;	
				case 4 :
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)+10));
					g.setColor(new java.awt.Color(119,110,101));
					g.drawString(valeur,((this.getHeight()/2)-20) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(237, 224, 200));
					break;
				case 8:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)+10));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-20) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(242, 177, 121));
					break;
				case 16:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-42) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(245, 149, 99));
					break;
				case 32:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-42) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(246, 124, 95));
					break;
				case 64:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-42) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(246, 94, 59));
					break;
				case 128:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)-20));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-60) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(237, 207, 114));
					break;
				case 256:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)-20));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-60) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(237, 204, 97));
					break;
				case 512:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)-20));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-60) ,((this.getWidth()/2)+20));
					this.setBackground(new java.awt.Color(237, 200, 80));
					break;
				case 1024:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)-35));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-70) ,((this.getWidth()/2)+10));
					this.setBackground(new java.awt.Color(237, 197, 63));
					break;
				case 2048:
					g.setFont(new java.awt.Font("Arial", 1,(this.getWidth()/2)-35));
					g.setColor(new java.awt.Color(255,255,255));
					g.drawString(valeur,((this.getHeight()/2)-70) ,((this.getWidth()/2)+10));
					this.setBackground(new java.awt.Color(237, 194, 46));
					break;
				case 2050:
					this.setBackground(new java.awt.Color(0, 0, 0));
					break;	
				default:
					this.setBackground(new java.awt.Color(88,41,00));
					break;
				}
		}

			 		
	
}
