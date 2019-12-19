import java.util.Scanner;

public class Game {
	private int selection;
	private double event ;
	private int obstacle;
	private int water;
	private int food;
	private int days;
	private char play;
	private boolean infection;
	
	private static Scanner keyboard1 = ZombieMain.keyboard;
		//----------------------------------------------------------

		//Variable declarations
	
		//--------------------------------------------------------------------------
		//Introduction

	
	public char intro () {
	
		return this.play;
	} // intro
	
	public void play() {
		String playSelect="n";
		this.selection = 0;
		this.event = 0.0;
		this.obstacle = 0;
		this.water=3;
		this.food=7;
		this.days = 0;
		this.infection = false;
		//--------------------------------------------------------------------------
		//Start constructors
		Health player1 = new Health(1);
		Event survivalEvent = new Event();
		Scores score = new Scores();
		//------------------------------------------------------------------------		
	  survivalEvent.BiteEventGenerator(1);
	  event = survivalEvent.BiteEventGenerator(1)+1; //So we don't die on Day 1
	    
	  while (event > 1 && water > 0 && food > 0 && days <= 30 && infection == false) //while not Dead. Base 1% chance of bitten 
		  {
		   double multiplier = 1.0; //Normal Chance of being bitten
			//Obstacles
		   obstacle = survivalEvent.ObstacleGenerator();
		   
		   System.out.println("Event: "+survivalEvent.Obstacles());
			if (obstacle == 2)
			{ player1.resetStorage(); }
			if (obstacle == 3)
			{ player1.removeWater(2); 
			  player1.removeFood(2);
			}	
			if (obstacle == 4)
			{ player1.removeFoodStorage(2);}
			
			water = player1.getWaterDays();
			food = player1.getFoodDays();
			if (water <= 0)
			{                    
			System.out.println("Died of Dehydration");
			System.out.println(player1.toString());
			}
			if (food <= 0)
			{
			System.out.println("Died of Starvation");
			System.out.println(player1.toString());
			}
			else if (water > 0 && food > 0)
		   { System.out.println(player1.toString()); //display Status	
			 System.out.println();
		
			// Supply Selection
		
			
				 System.out.println("Will you get supplies today? "
				 		+ "\n Supply runs increase odds of infection"
				 		+ "\n Select 1 for 4 Days of Water"
				 		+ "\n Select 2 for 4 Days of Food"
				 		+ "\n Select 3 for Neither");
			
			 boolean valid = false; 
			 do {
				 System.out.print("Your Selection:");
				 selection = Integer.parseInt(keyboard1.nextLine());
				 System.out.println();
				 if (selection == 1)
					{ 
						System.out.println("4 Days of Water added");  
						player1.addWaterStorage(5);
						player1.resetWater();
						multiplier = 10;
						valid = true;  
					}
					
					if (selection == 2)
					{
						System.out.println("4 Days of food added");
						player1.addFoodStorage(5);
						player1.resetFood();
						multiplier = 10;
						valid = true;
					}
					
					if (selection == 3)
					{
						System.out.println("You added No Supplies");
						valid = true;
					}	
					if (selection != 1 && selection != 2 && selection != 3 )
					{
						System.out.println("Invalid Selection");
						valid = false;
					}
			 } while (valid == false);
		
			//-----------------------------------
		
		//--------------------------------------------
		// end of Day
	     
		player1.addDay(); //add 1 day
		player1.removeWater(1); //1 more day without water
		player1.removeFood(1); // 1 more day without food
		
		
		this.event = survivalEvent.BiteEventGenerator(multiplier); //see if bitten
		this.obstacle = survivalEvent.ObstacleGenerator();
		this.water = player1.getWaterDays();		
		this.food = player1.getFoodDays();
		if (event == 1)
		{ player1.infection();	
		System.out.println(survivalEvent.BiteDisplay());   //Display Death by Infection
	
		}
		else if (water <= 0)
		{                    
		System.out.println("Died of Dehydration");
		
		}
		else if (food <= 0)
		{
		System.out.println("Died of Starvation");
		
		}
		else if (days == 30)
		{
		System.out.println("Congrats! You Survived!");	
		}
		days = player1.getDay();
		if (days >= 15)
		{
		survivalEvent.supriseDisease();	
		int otherDisease = survivalEvent.supriseDisease();
		System.out.println(survivalEvent.OtherDisease());
		
			if (otherDisease == 50 || otherDisease == 42 || otherDisease == 69)
			{
			infection = true;
			player1.infection();
			System.out.println(player1.toString());
			} //if
		
			} // if
			
		//-------------------------------------------------		  
		   } //elseif
			
			
		   } //end while not dead by Infection


		
	
		
	} // end play method 

}// end Game class