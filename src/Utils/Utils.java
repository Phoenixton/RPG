package Utils;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Utils { //bunch of helper fonctions

	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
	
		try{
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line; //current line working on
			while((line = br.readLine()) != null) //as long as next line != null
				builder.append(line + "\n"); //ajoute un retour à la ligne
			br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	
		return builder.toString(); //convert everything appended into a string
		
	}
	
	public static int parseInt(String number){ //transforms string "5" in int 5
		try{
			return Integer.parseInt(number);
		} catch(NumberFormatException e){
			e.printStackTrace(); //dit s'il y a une erreur
			return 0; //return une tile random pour eviter un crash
		}
	}
	
	
}
