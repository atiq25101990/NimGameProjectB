package com.nimgameprojectb;

import java.util.Scanner;

public class Test {

		public static void main(String[] args) { 
			String input,command,commandDetails;
			
			Scanner src = new Scanner(System.in);
			System.out.println("Welcome to Nim");
			System.out.println();
			System.out.print("$");
			input=src.nextLine();
		    System.out.println(input);
		    String[] inputSplit = input.trim().split("\\s+");
		    command=inputSplit[0];
			commandDetails=inputSplit[1];

			
		    switch(command){  
		    
		    //Add player case
		    case "addplayer": 
		    System.out.println(command);
		    System.out.println(commandDetails);
		    
		    break;  
		    
		    //Remove player case
		    case "removeplayer": 
			System.out.println(command);
			System.out.println(commandDetails);
		    break;  
		    
		    //Edit player case
		    case "editplayer":
			System.out.println(command);
			System.out.println(commandDetails);
		    break;
		    
		    //Reset status case
		    case "resetstats":
			System.out.println(command);
			System.out.println(commandDetails);
		    break;  
		    
		    //Display player case
		    case "displayplayer":
			System.out.println(command);
			System.out.println(commandDetails);
		    break;  
		    
		    //Ranking case
		    case "rankings":
			System.out.println(command);
			System.out.println(commandDetails);
		    break;  
		    
		    //Start game case
		    case "startgame":
			System.out.println(command);
			System.out.println(commandDetails);
		    break;  
		    
		    //Exit case
		    case "exit":
		    System.exit(0);
		    break;    
		    }  
		}  
		
	
}
