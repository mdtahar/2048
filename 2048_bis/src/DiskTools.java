import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 
 * @author bouali73
 *
 */

public class DiskTools {

	/**
	 * @param m un modele on va le sauvegarder
	 */
	public static void saveM(Modele m){
		File f = new File ("Grille");
		File t = new File("score");
		File obs = new File("obstacle");
		File  obj= new File("objectif");
		File best = new File("Bestscore");
		File nCL = new File("NbrCelLibre");
		try
		{
		    FileWriter fw = new FileWriter (f);
		    FileWriter tw = new FileWriter (t);
		    FileWriter obsw = new FileWriter (obs);
		    FileWriter objw = new FileWriter (obj);
		    FileWriter bestw = new FileWriter (best);
		    FileWriter nCLw = new FileWriter (nCL);
		    
		    for (int i=0 ;i<m.grille.length;i++)
		    {
		    	for (int j = 0; j <m.grille[0].length; j++) {
		    		if(m.grille[i][j].getClass()==Vide.class){
		    			fw.write (String.valueOf ("v"));
		    			if(j!=m.grille[0].length-1){
		    				fw.write ("\t");
		    			}	
		    		}
		    		else{
		    			fw.write (String.valueOf(m.grille[i][j].toString()));
		    			if(j!=m.grille[0].length-1){
		    				fw.write ("\t");
		    			}	
		    		}
		    	}
		    	fw.write ("\n");
		    	
		    }
		    fw.close();
		    tw.write(String.valueOf (m.score));
		    tw.close();
		    obsw.write(String.valueOf (m.nbrObstacle));
		    obsw.close();
		    objw.write(String.valueOf (m.objectif));
		    objw.close();
		    bestw.write(String.valueOf(m.BestScore));
		    bestw.close();
		    nCLw.write(String.valueOf(m.nbrCelLibre));
		    nCLw.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}
	/**
	 * 
	 * @param j le jeu qu'on va  sauvegarder
	 */
	public static void saveJ(Jeu j){
		File n = new File ("numeroN");
		File t = new File("typeJ");
		
		try
		{
		    FileWriter nw = new FileWriter (n);
		    FileWriter tw = new FileWriter (t);
		   
		    tw.write(String.valueOf (j.type));
		    tw.close();
		    nw.write(String.valueOf (j.numN));
		    nw.close(); 
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}
	/**
	 * 
	 * @param taille de notre grille
	 * @return charge la grille  du modele
	 */
	public static Cellule[][] chargerUneGrille(int taille){
		Cellule[][] res = new Cellule[taille][taille];
		try
		{
		    File f = new File ("Grille");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		    try
		    {
		       String line = br.readLine();
		       int i = 0;
		       
		        while (line != null)
		        {
		        	String[] t = line.split("\t");
		        	for (int k = 0; k < t.length; k++) {
		        		if(t[k].equals("v")){
		        			res[i][k] = new Vide();
		        		}
		        		else if(t[k].equals("Ob")){
		        			res[i][k] = new Obstacle();
		        		}
		        		else if(t[k].equals("T")){
		        			res[i][k] = new Hole();
		        		}
		        		else{
		        			if(!(t[k].equals("Ob"))){
		        				res[i][k] = new Valeur(Integer.parseInt(t[k]));
		        			}
		        			
		        		}
		        	}
		        	i++;
		        	line = br.readLine();
		        }
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge le score du modele
	 */
	public static int chargerScore(){
		int res=0;
		try
		{
		    File f = new File ("score");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge le best score du modele
	 */
	public static int chargerBestScore(){
		int res=0;
		try
		{
		    File f = new File ("Bestscore");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return cherge le nombre d'obstacle du modele
	 */
	public static int chargerNbrObstacles(){
		int res=0;
		try
		{
		    File f = new File ("obstacle");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge l'objectif du modele 
	 */
	public static int chargerObjectif(){
		int res=0;
		try
		{
		    File f = new File ("objectif");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge le nombre de cellule libre
	 */
	public static int chargerNbrCelLibre(){
		int res=0;
		try
		{
		    File f = new File ("NbrCelLibre");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge le numero du niveau(Modele) dans le jeu
	 */
	public static int chargerNumeroN(){
		int res=0;
		try
		{
		    File f = new File ("numeroN");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
	/**
	 * @return charge le type du jeu (1 ou 2 )
	 */
	public static int chargerTypeJ(){
		int res=0;
		try
		{
		    File f = new File ("typeJ");
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		   
		    try
		    {
		       String line = br.readLine();
		        	String[] t = line.split("\t");
		        	res = Integer.parseInt(t[0]);
		        
		        br.close();
		        fr.close();		       
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		return res;
	}
}
