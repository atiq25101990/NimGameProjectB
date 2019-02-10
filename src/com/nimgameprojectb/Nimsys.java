package com.nimgameprojectb;

/*
 * This is the Main class demonstrate 
 * the flow of the project by taking commands from the user
 * and send it for processing through various methods
 * Mohammed Atiq Mohammed Mashaq Shaikh 1/05/2017
 * */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nimsys {

	public static void main(String args[]){
	
		//declare variables and objects
		String input=null,command,commandDetails = null;
		boolean flag = false;
		NimGame nimGame = new NimGame();
		Scanner scanner= new Scanner(System.in);
		System.out.println("Welcome to Nim");

		//Iterating various commands such as addplayer, removeplayer, startgame and so on 
		do
		{
			
			//taking the input
			System.out.println();
			System.out.print("$");
			input=scanner.nextLine();
			if(input.equals(""))
			{
				input=null;
				input=scanner.nextLine();
			}
			
			//checking for space using regex
		    Pattern pattern = Pattern.compile("\\s");
		    Matcher matcher = pattern.matcher(input);
		    boolean found = matcher.find();
			if(found){
				String[] inputSplit = input.trim().split("\\s+");
				command=inputSplit[0];
				commandDetails=inputSplit[1];
			}
			else
			{
				command=input;
			}

			//sending methods to process			
		    if(command.equals("addplayer")){
		    //Add player case
		    nimGame.addPlayer(commandDetails);
		    command = null;
		    commandDetails = null;
		    }
		    else if(command.equals("removeplayer")){
		    //Remove player case
			nimGame.removePlayer(scanner,commandDetails);
		    command = null;
		    commandDetails = null;
		    }
		    else if(command.equals("editplayer")){
		    //Edit player case
			nimGame.editPlayer(commandDetails);
		    command = null;
		    commandDetails = null;
		    }
		    else if(command.equals("resetstats")){
		    //Reset status case
			nimGame.resetStatsPlayer(scanner,commandDetails);
		    command = null;
		    commandDetails = null;
		    }
			else if(command.equals("displayplayer")){
		    //Display player case
			nimGame.displayPlayer(commandDetails);
		    command = null;
		    commandDetails = null;
			}
			else if(command.equals("rankings")){
		    //Ranking case
		    nimGame.rankings(commandDetails);
		    command = null;
		    commandDetails = null;
			
			}
			else if(command.equals("startgame")){
		    //Start game case
			nimGame.startGame(scanner,commandDetails);
			command = null;
		    commandDetails = null;
			input=null;
			}
			else if(command.equals("exit")){
		    //Exit case
			System.out.println();
		    System.exit(0);
		        
			}
			else{
			//System.out.println("Incorrect Input. Please enter once again.");
			}
			
		}while(!flag);
	}

}