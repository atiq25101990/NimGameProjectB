package com.nimgameprojectb;

/*
 * This class is based on implementation logic which demonstrate 
 * methods like addPlayer() [to add player], removePlayer() [to remove player]
 * editPlayer() [to edit player], startGame(), play() [game logic] and its dependents methods
 * Mohammed Atiq Mohammed Mashaq Shaikh 1/05/2017
 * */

import java.util.Arrays;
import java.util.Scanner;

public class NimGame {

	String userName,familyName,givenName,player1UserName,player2UserName;
	int gamesPlayed=0,gamesWon=0,count=0,stoneLeft=0,upperBound=0;
	
	//declare NimPlayer object
	NimPlayer np;
	
	//declare array of object
	NimPlayer[] nimPlayer;
	
	public NimGame() {
		
		//create array
		nimPlayer = new NimPlayer[100];
		//initialize count
		count=0;
		
	}
	
	//addPlayer method signifies adding of player details like given name, family name and so on
	public void addPlayer(String commandDetails){
		
		//create NimPlayer object
		np = new NimPlayer(); 
		
		//splitting command details to get player details
		String[] splitCommandDetails =  commandDetails.trim().split(",");
		userName = splitCommandDetails[0];
		familyName = splitCommandDetails[1];
		givenName = splitCommandDetails[2];
		
		boolean duplicateFlag=false;
		
		//Checking for a player existence
		for(int i=0;i<count;i++)
		{
			if(	userName.equals(nimPlayer[i].getUserName()))
			{
				System.out.println("The player already exists.");
				duplicateFlag=true;
			}
			
		}
		
		//For new player add
		if(!duplicateFlag){
			//adding player details to object
			np.setUserName(userName);
			np.setFamilyName(familyName);
			np.setGivenName(givenName);
			np.setGamesPlayed(gamesPlayed);
			np.setGamesWon(gamesWon);
			
			//adding object to the array
			nimPlayer[count] = np;
			//increment the counter
			count++;
		}
		
		return ;
	}
	
	//removePlayer method signifies removal of individual or all players
	public void removePlayer(Scanner scanner,String commandDetails){
		
		//check if username or command details empty
		if(commandDetails != null && !commandDetails.isEmpty()){

		    boolean matchFlag=false;
		   
		    NimPlayer[] manipulatedNimPlayer = null;
		    
		    //if player found then remove and update the array of objects and its count
		    for (int i = 0;i < count; i++) {
		    	if(commandDetails.equals(nimPlayer[i].getUserName())){
		        	manipulatedNimPlayer = new NimPlayer[count - 1];
		            System.arraycopy(nimPlayer, 0, manipulatedNimPlayer, 0, i);
		            System.arraycopy(nimPlayer, i+1, manipulatedNimPlayer, i, count-i-1);
				    count=manipulatedNimPlayer.length;
		            matchFlag=true;    		
		    	}
		    	
			}

		    //If player does not found show the message and make a copy of reduced array of
		    //objects
		    if(!matchFlag)
			{
				System.out.println("The player does not exist.");
			}
		    else
		    {
			    nimPlayer=manipulatedNimPlayer;
			    nimPlayer = Arrays.copyOf(nimPlayer, 100);
		    }
		    
		}
		else
		{
			//remove all the players
			System.out.println("Are you sure you want to remove all players? (y/n)");
			String checkRemoveAll = scanner.nextLine();
			if(checkRemoveAll.equals("y"))
			{
			Arrays.fill( nimPlayer, null );
			count=0;
			}

		}
		return;
	}
	
	//editPLayer method signifies updation of player information
	public void editPlayer(String commandDetails){
		
		//splitting command details
		String[] splitCommandDetails =  commandDetails.split(",");
		userName = splitCommandDetails[0];
		familyName = splitCommandDetails[1];
		givenName = splitCommandDetails[2];
	    boolean matchFlag=false; 
		
	    //If match found the update player information
		for(int i=0;i<count;i++){
			if(	userName.equals(nimPlayer[i].getUserName())){
				nimPlayer[i].setFamilyName(familyName);
				nimPlayer[i].setGivenName(givenName);
				matchFlag=true;
			}
		}
		
		//If match not found show message
		if(!matchFlag)
		{
			System.out.println("The player does not exist.");
		}
		
		return ;
	}
	
	//resetStatsPlayer method signifies reseting individual or all player game statistics
	public void resetStatsPlayer(Scanner scanner,String commandDetails){
		
		//check if username or commandDetails empty 
		if(commandDetails != null && !commandDetails.isEmpty()){

			boolean matchFlag=false;		    
			//If match found setting the player details to zero
		    for (int i = 0;i < count; i++) {
		    	if(commandDetails.equals(nimPlayer[i].getUserName())){
		    		nimPlayer[i].setGamesPlayed(0);
		    		nimPlayer[i].setGamesWon(0);
		            matchFlag=true;    		
		    	}
			}

		    //If match not found then show message
			if(!matchFlag)
			{
				System.out.println("The player does not exist.");
			}
			
		}
		else
		{
			//Reset all player statistics
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			String checkResetStatsAll = scanner.nextLine();
			if(checkResetStatsAll.equals("y"))
			{
				for(int i=0;i<count;i++){
					
						nimPlayer[i].setGamesPlayed(0);
						nimPlayer[i].setGamesWon(0);
					
				}
			}

		}
		return;
	}
	
	//displayPlayer method signifies to show individual or all players information
	public void displayPlayer(String commandDetails){
		
		//Check if username or commandDetails empty
		if(commandDetails != null && !commandDetails.isEmpty()){
			
		    boolean matchFlag=false; 
			
		    //If match found then showing individual player details
			for(int i=0;i<count;i++){
				if(	commandDetails.equals(nimPlayer[i].getUserName())){
					System.out.println(nimPlayer[i].getUserName() +","+ nimPlayer[i].getGivenName()
					+","+ nimPlayer[i].getFamilyName() +","+ nimPlayer[i].getGamesPlayed() +" games,"
					+ nimPlayer[i].getGamesWon() +" wins");
					matchFlag=true;
				}
			}
			
			//If match not found then show message
			if(!matchFlag)
			{
				System.out.println("The player does not exist.");
			}
		}
		else
		{
		//show all players with its details
			
		nimPlayer = alphaSelectionSort(nimPlayer);
		
		if(count!=0){
		
		for(int i=0;i<count;i++){
			System.out.println(nimPlayer[i].getUserName() +","+ nimPlayer[i].getGivenName()
					+","+ nimPlayer[i].getFamilyName() +","+ nimPlayer[i].getGamesPlayed() +" games,"
					+ nimPlayer[i].getGamesWon() +" wins");
		}
		}

		
		}
		
		return ;
		
	}
	
	//rankings method signifies player current status in the game as compare to others
	public void rankings(String commandDetails){
		
		//Check if command details empty or desc else asc
		if(commandDetails == null || commandDetails.isEmpty() || commandDetails.equals("desc")){
			
			//setting up player percentage
			for(int i=0;i<count;i++){
				int gameswon = nimPlayer[i].getGamesWon();
				int gamesplayed = nimPlayer[i].getGamesPlayed();
				int percentage = calculatePercentage(gameswon,gamesplayed);
				nimPlayer[i].setPercentage(percentage);
			}

			nimPlayer = descSelectionSort(nimPlayer);
			
/*			for(int j=0;j<count;j++)
				for(int k=j+1;k<count;k++)
				    if(k!=j && nimPlayer[k].getGamesPlayed() == nimPlayer[j].getGamesPlayed())*/	
			
			for(int j=0;j<count;j++){
				for(int k=j+1;k<count;k++)
				    if(k!=j && nimPlayer[k].getGamesPlayed() == 0 && nimPlayer[j].getGamesPlayed() == 0)
					nimPlayer = alphaSelectionSort(nimPlayer);
			}
			
			String space="";
			//"%d%%\t|\t%02d games\t|\t%s %s"
			//showing ranking in descending order
			for(int i=0;i<count;i++){
				System.out.println(String.format("%d%%%-" + (4 - String.valueOf(
						nimPlayer[i].getPercentage()).length())+ "s| %02d games | %s %s",
						nimPlayer[i].getPercentage(),space,nimPlayer[i].getGamesPlayed(),
						nimPlayer[i].getGivenName(),nimPlayer[i].getFamilyName()));
			}
			

			
		}
		else if(commandDetails.equals("asc")){
			
			//setting up player percentage
			for(int i=0;i<count;i++){
				int gameswon = nimPlayer[i].getGamesWon();
				int gamesplayed = nimPlayer[i].getGamesPlayed();
				int percentage = calculatePercentage(gameswon,gamesplayed);
				nimPlayer[i].setPercentage(percentage);
			}
			
			nimPlayer = ascSelectionSort(nimPlayer);
			
			for(int j=0;j<count;j++){
				for(int k=j+1;k<count;k++)
				    if(k!=j && nimPlayer[k].getGamesPlayed() == 0 && nimPlayer[j].getGamesPlayed() == 0)
					nimPlayer = alphaSelectionSort(nimPlayer);
			}
			
			String space="";
			//showing ranking in ascending order
			for(int i=0;i<count;i++){
				System.out.println(String.format("%d%%%-" + (4 - String.valueOf(
						nimPlayer[i].getPercentage()).length())+ "s| %02d games | %s %s",
						nimPlayer[i].getPercentage(),space,nimPlayer[i].getGamesPlayed(),
						nimPlayer[i].getGivenName(),nimPlayer[i].getFamilyName()));
			}
			

			
		}
	}
	
	//startGame method signifies get the player details and setting up for play
	public void startGame(Scanner scanner,String commandDetails){
		
		//splitting the game or command details
		String[] splitCommandDetails =  commandDetails.split(",");
		stoneLeft = Integer.parseInt(splitCommandDetails[0]);
		upperBound = Integer.parseInt(splitCommandDetails[1]);
		player1UserName = splitCommandDetails[2];
		player2UserName = splitCommandDetails[3];
		boolean checkPlayer1UserName = checkPlayerUserName(player1UserName);
		boolean checkPlayer2UserName = checkPlayerUserName(player2UserName);
		
		//check player's username existence if no show message, if yes get details and play
		if(!checkPlayer1UserName || !checkPlayer2UserName){
			System.out.println("One of the players does not exist.");
		}
		else
		{
		String[] player1Details = getPlayerDetails(player1UserName);
		String[] player2Details = getPlayerDetails(player2UserName);
		play(scanner,stoneLeft,upperBound,player1Details,player2Details);		
		}
		
		return;
	}
	
	//Method to check whether the player is there or not in the array of objects
	public boolean checkPlayerUserName(String playerUserName){
	    boolean matchFlag=false; 
		
		for(int i=0;i<count;i++){
			if(	playerUserName.equals(nimPlayer[i].getUserName())){
				matchFlag=true;
			}
		} 
		return matchFlag;
	}
	
	//Method to get the player details if the player is available in array of objects
	public String[] getPlayerDetails(String playerUserName){
		
		String userName=null,givenName=null,familyName=null;
		
		for(int i=0;i<count;i++){
			if(	playerUserName.equals(nimPlayer[i].getUserName())){
				userName = nimPlayer[i].getUserName();
				givenName = nimPlayer[i].getGivenName();
				familyName = nimPlayer[i].getFamilyName();
			}
		}
		
		return new String[] {userName, givenName, familyName};	
	}
	
	//play method actually implements nim game playing logic
	public void play(Scanner scanner,int stoneLeft,int upperBound,String[] player1Details,
					 String[] player2Details){
		
		String p1UserName = player1Details[0];
		String p2UserName = player2Details[0];
		int removeStone=0;
		boolean flag=true;
		
		//Show both the player details
		System.out.println();
		System.out.println("Initial stone count: "+stoneLeft);
		System.out.println("Maximum stone removal: "+upperBound);
		System.out.println("Player 1: "+player1Details[1]+" "+player1Details[2]);
		System.out.println("Player 2: "+player2Details[1]+" "+player2Details[2]);
		
		//check stone availability
		while(stoneLeft>0){
			
			//Check for player turn, print corresponding number of stones, 
			//remove player inputted no of stones and declare winner
			if(flag==true){
				String player1GivenName = player1Details[1];
				printStone(stoneLeft);
				stoneLeft = checkStoneAndRemove(scanner,player1GivenName,removeStone,upperBound,stoneLeft);
				checkAndDeclareWinner(stoneLeft,player2Details[1],player2Details[2],p1UserName,
									  p2UserName);

			flag=false;
			}
			else{
				String player2GivenName = player2Details[1];
				printStone(stoneLeft);
				stoneLeft = checkStoneAndRemove(scanner,player2GivenName,removeStone,upperBound,stoneLeft);
				checkAndDeclareWinner(stoneLeft,player1Details[1],player1Details[2],p1UserName,
									  p2UserName);
				
			flag=true;
			}
		} //end of while
		
		
	}

	//Method to print no of available stones 
	public void printStone(int stoneLeft){
		System.out.println();
		System.out.print(stoneLeft +" stones left:");
			for(int i=0;i<stoneLeft;i++)
				System.out.print(" *"); 
		System.out.println();
	}
	
	//Method to check number of stones available and remove stones
	public int checkStoneAndRemove(Scanner scanner,String playerGivenName,int removeStone,
									int upperBound,int stoneLeft){
		
		while(true)
		{
			System.out.println(playerGivenName+"'s turn - remove how many?");
			removeStone = scanner.nextInt();
			
			//Check whether the stone is available or not and upper bound of stone removal 
			//from input provided
			if(removeStone <= upperBound && removeStone > 0){
				stoneLeft = removeStone(removeStone, stoneLeft);
				break;
			}
			else
			{
				System.out.println();
				if(removeStone>upperBound)
				System.out.println("Invalid move. You must remove between 1 and "+upperBound+" stones.");
				else
				System.out.println("Invalid move. You must remove between 1 and "+stoneLeft+" stones.");
				printStone(stoneLeft);
			}
		}
		return stoneLeft;
	}
	
	//Method to remove stone from the stone which are left
    int removeStone(int removeStone,int stoneLeft)
	{
		stoneLeft = stoneLeft - removeStone;
		return stoneLeft;
	}
    
    //Method to check, declare winner and update player's gameplayed and gamewo count
    public void checkAndDeclareWinner(int stoneLeft,String playerGivenName,
    				String playerFamilyName,String p1UserName,String p2UserName){
		
    	//check whether stone left is equal to 0 to declare the winner
		if(stoneLeft==0){
				System.out.println();
				System.out.println("Game Over");
				updatePlayerGameCount(p1UserName);
				updatePlayerGameCount(p2UserName);
				updatePlayerWonCount(playerGivenName);
				System.out.println(playerGivenName+" "+playerFamilyName+" wins!");
		}    	
		return ;
    }
    
	//Method to update player's game played count
    public void updatePlayerGameCount(String playerUserName){
    	
		for(int i=0;i<count;i++){
			if(playerUserName.equals(nimPlayer[i].getUserName())){
				nimPlayer[i].setGamesPlayed(nimPlayer[i].getGamesPlayed()+1);
			}
		}
    }
    
    //Method to update player's game won count
    public void updatePlayerWonCount(String playerGivenName){

		for(int i=0;i<count;i++){
			if(playerGivenName.equals(nimPlayer[i].getGivenName())){
				nimPlayer[i].setGamesWon(nimPlayer[i].getGamesWon()+1);
			}
		}
    }

    //Method to calculate percentage used for ranking
    public int calculatePercentage(int gameswon,int gamesplayed){
    	if(gamesplayed==0)
    	return 0;
    	else
    	return (int)Math.round((double)(gameswon * 100)/gamesplayed);
    }
    
    //Method for sorting the player's won percentage in ascending order by Selection Sort 
    public NimPlayer[] ascSelectionSort(NimPlayer[] nimPlayer){
    
        for (int i = 0; i < count - 1; i++)  
        {  
            int min = i;  
            for (int j = i + 1; j < count; j++){  
                if (nimPlayer[j].getPercentage() < nimPlayer[min].getPercentage()){  
                    min = j;//searching for min   
                }  
            }  
            NimPlayer minNumber = nimPlayer[min];   
            nimPlayer[min] = nimPlayer[i];  
            nimPlayer[i] = minNumber;  
        }  
    	
    	return nimPlayer;
    }
    
    //Method for sorting the player's won percentage in ascending order
    public NimPlayer[] descSelectionSort(NimPlayer[] nimPlayer){
        
        for (int i = 0; i < count - 1; i++)  
        {  
            int max = i;  
            for (int j = i + 1; j < count; j++){  
                if (nimPlayer[j].getPercentage() > nimPlayer[max].getPercentage()){  
                    max = j;//searching for max
                }  
            }  
            NimPlayer maxNumber = nimPlayer[max];   
            nimPlayer[max] = nimPlayer[i];  
            nimPlayer[i] = maxNumber;  
        }  
    	
    	return nimPlayer;
    }
	
    //Method to sort alphabetically
    public NimPlayer[] alphaSelectionSort(NimPlayer[] nimPlayer)
    {
    	 for (int i = 0; i < count - 1; i++)  
         {  
             int min = i;  
             for (int j = i+1; j < count; j++){  
                 if ((nimPlayer[j].getUserName()).compareTo(nimPlayer[min].getUserName()) <0){  
                     min = j;//searching for min   
                 }  
             }  
             NimPlayer minName = nimPlayer[min];   
             nimPlayer[min] = nimPlayer[i];  
             nimPlayer[i] = minName; 
         }  
     	
     	return nimPlayer;
    }
    
    
}
