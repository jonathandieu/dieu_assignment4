package dieu_problem2;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter 
{
	private Map < String, Integer > wordCounter;
	public DuplicateCounter() 
	{
		wordCounter = new HashMap < String, Integer > ();
	}
		 
	public void count(String dataFile) 
	{
		Scanner scan = null;
		  
		try 
		{
			scan = new Scanner(new File(dataFile));
		}
		
		catch (Exception e) 
		{
		   System.out.println("An error has occured when attempting to open the file.");
		   System.out.printf("Exception thrown: %s", e);
		}
		
       	while (scan.hasNext()) 
       	{
		   String next = scan.next().toLowerCase();
		   Integer count = wordCounter.get(next);
		   
		   if (wordCounter.get(next) == null)
		    count = 1;
		   else
		    count = wordCounter.get(next) + 1;
		   wordCounter.put(next, count);
       	}
		 
		  scan.close();
	 }
	
	 public void write(String outputFile) 
	 {
		 try 
		 {
		   FileWriter output = new FileWriter(outputFile);
		   for (String s: wordCounter.keySet()) 
		   {
		    output.write(s + " " + wordCounter.get(s) + "\n");
		   }
		    output.close();
		  } 
		  
		 catch (Exception e) 
		 {
		   System.out.println("An error has occured when attempting to print the file.");
		   System.out.printf("Exception thrown: %s", e);
		 }
		  
	  }
}
	 

		 
	 