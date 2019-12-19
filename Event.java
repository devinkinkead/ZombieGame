

//Instance variables
public class Event {
private double BiteeventMarker;	
private int obstacle;
private boolean infection;
private int bonusDisease;

public Event()
{

BiteeventMarker = 0;
}

//Generates a number that determines event. multiplier determines probability
public double BiteEventGenerator(double multiplier)
{
double Biteevent = Math.random()*(100/multiplier)+1;
BiteeventMarker = (int)Biteevent;


return BiteeventMarker;}

//Generates an number that determines obstacle
public int ObstacleGenerator()
{
	double ObstacleEvent = Math.random()*15+1;
	obstacle =(int) ObstacleEvent;	
return (int)ObstacleEvent;}

//Shows if user has been bitten
public String BiteDisplay()
{
String display = "";	
	switch ((int)BiteeventMarker)
	{
case 1: 
{                  
display = "You have been bitten. You died";
}
break;

	} //end switch

return display;
} // end BiteDisplay

public int supriseDisease()
{
double otherDisease = Math.random()*300+1;	

bonusDisease = (int)otherDisease;
return bonusDisease;
}

public String OtherDisease()
{
String display = "";
switch(bonusDisease)
{
case 42: display = "The Heat Death of the Universe happened sooner than we expected. Sorry :(.";
this.infection = true;
break;
case 50: display= "Suprise! You've been infected by Ebola!";
this.infection = true;
break;
case 69: display = "Death by...I'll let you guess";
this.infection = true;
break;
default: display ="";

}


return display;
}

//Displays obstacle	
public String Obstacles()
{
String display = "";

switch(obstacle)
{
case 2: 
{
display = "Food and Water Stores Raided by Survivors. No storage remains";	
}
break;
case 3: 
{
display = "Projectile Vomiting. 2 days worth of Food and Water used";	
}
break;
case 4:
{
display = "Coyotes Raided Food Stores. 2 days worth of food lost.";	
}
break;
default:
display ="No Issues Today";	

}
	
return display;
}


} //end Event class
