package com.nimgameprojectb;

public class Test1 {

	public static void main(String args[]){
	int per1= 100,g1=3;
	String name1="AAA PPPP";
	int per2= 75,g2=4;
	String name2="BBB QQQ";
	int per3= 14,g3=7;
	String name3="CCC RRRRR";

	System.out.println(String.format("%d%%\t|\t%02d strike\t|\t%s",per1,g1,name1));
	System.out.println(String.format("%d%%\t|\t%02d strike\t|\t%s",(per2*23),g2,name2));
	System.out.println(String.format("%d%%\t|\t%02d strike\t|\t%s",per3,g3,name3));
	
	}
	
}
