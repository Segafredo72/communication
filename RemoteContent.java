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

/** 
 * Demo of a connection to a remote resource
 * 
 * @author the OpenClassrooms Education Team
 *
 */
public class RemoteContent {
	
	
	/** read the resource content line by line and add each line to a list
	 * 
	 * @param resource the connected resource
	 * @return a list of lines of content
	 * @throws IOException 
	 */
	public static List<String> getContent(URLConnection resource) throws IOException {
		List<String>lines=new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}
	
    /** establish a connection to a provided URL
     * 
     * @param urlString the string of the URL to connect to
     * @return an active connection 
     * @throws IOException if the connection cannot be established
     */
    public static URLConnection connectFromURL(String urlString) throws IOException {
        URL mySite = new URL(urlString);
        URLConnection myURLConnection= mySite.openConnection(); 
        myURLConnection.connect();
        return myURLConnection;
    }
	/**
	 * Connect to a resource from a URL and print its content type
	 * @param args not used in this example
	 */
	public static void main(String[] args){
		// define the string representation of the URL to connect to
		 String urlString=UserInput.askForUrl();

		// connect and print the content type of the retrieved resource
		try {	
			URLConnection myURLConnection=connectFromURL(urlString);
			System.out.println("Retrieved a resource of type: " + myURLConnection.getContentType() + " from " + myURLConnection.getURL());		
			System.out.println(getContent(myURLConnection));

		}
		// manage errors if the connection fails
		catch (MalformedURLException e) {
			System.err.println("Malformed URL - " + e.getLocalizedMessage());
		}
		catch(IOException e){
			System.err.println("Cannot establish connection - "+ e.toString());
		}
	}
}