package com.nimgameprojectb;

/*
 * This is the Model class which demonstrate 
 * methods like getter and setter methods of player that will be used in the game for  
 * various functionality like adding, removing, editting, ranking, in game and so on
 * Mohammed Atiq Mohammed Mashaq Shaikh 1/05/2017
 * */

public class NimPlayer{

	private String userName,givenName,familyName;
	private int gamesPlayed,gamesWon,percentage;
	
	public NimPlayer(){
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public int getGamesWon() {
		return gamesWon;
	}
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
    public String toString() {
        return (userName + "," + givenName + "," + familyName + "," + gamesPlayed + " games,"
        		+gamesWon+" wins");
    }
    
	
	
}
