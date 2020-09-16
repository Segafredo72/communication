package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Demo of getting and checking User input
 * 
 * @author The OpenClassrooms Education Team
 *
 */
public class UserInput {
 
	 /** Check if a string is a well-formed URL
	 * 
	 * @param urlString
	 * @return true if the URL is well formed, else false
	 */
	private static boolean isValidURL(String urlString) {
		try{
			new URL(urlString); 
			// we will never get here if the URL is not well-formed 
			return true;
		}catch (IOException e) {
			return false;
		}
	}
	/** Prompt user for URL
	 * 
	 * @return a string representation of the URL entered by the user 
	 */

	public static String askForUrl() {
		Scanner readInput=new Scanner(System.in);
		System.out.println("Please enter a valid URL");
		String url=readInput.nextLine(); 
		readInput.close();
		return url;
	}
	/** Check if user has provided a URL from the command line
	 * If not prompt for one
	 * In both cases make sure the URL is well-formed!
	 * @param args either nothing or a URL string
	 */	
	public static void main(String[] args) {
		String urlString="";
		
		// assign a value to urlString or exit
		switch(args.length) {
		case 0:
			urlString=askForUrl();
			break;
		case 1:
			urlString=args[0];
			break;
		default:
			System.out.println("Please run the program with the desired URL or no argument at all");
			System.exit(-1);
		}
		
		System.out.println("Checking URL " + urlString);
		if (isValidURL(urlString)) {
			System.out.println(urlString + " is a well-formed URL");
		}else {
			System.out.println(urlString + " is not a well-formed URL");			
		}
	}
}
