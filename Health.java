
public class Health {

//Declare variables	
private int dayCount;	
private int waterDays;
private int foodDays;
private boolean infected;
private int waterStorage;
private int foodStorage;

//constructor
public Health(int count)
{ dayCount = count;
  waterDays = 3;
  foodDays = 7;
  infected = false;
 waterStorage = 0;
 foodStorage = 0;
}	

//Display current status
public String toString()
{
String status = "\n Day: " + dayCount 
+ "\n Days of Water Stored: " + waterStorage
+ "\n Days of Food Stored: " + foodStorage
+ "\n Days Until Death by Dehydration: " + waterDays 
+ "\n Days Until Death by Starvation: " + foodDays
+ "\n Infection Status: "+infected;
	
return status;	
}

// Returns days until dehydration death
public int getWaterDays()
{
return waterDays;	
}

//Returns days until death by starvation
public int getFoodDays()
{
return foodDays;	
}

//Adds 1 day
public void addDay()
{
dayCount++;	
}

//removes foodStorage ONLY
public void removeFoodStorage(int days)
{
if (foodStorage >= days)
	{foodStorage -= days;}
else if(foodStorage < days)
{foodStorage = 0;}	
}

//Returns the current day
public int getDay()
{
return dayCount;
}

//Resets days until death by dehydration
public void resetWater()
{
waterDays = 3;	
}
//Resets days until death by starvation
public void resetFood()
{
foodDays = 7;	
}	

//Removes water from storage if available, otherwise, removes days until dehydration
public void removeWater(int days)
{

if (waterStorage == 0)
{ waterDays -= days; }
else if (waterStorage > 0 && waterStorage >= days)
{ waterStorage -= days;  }
else if (waterStorage > 0 && waterStorage < days)
{
int temp = 0;
temp = days - waterStorage;
waterStorage = 0;
waterDays -= temp;
}
}
//Removes food from storage if available, otherwise, removes days until starvation
public void removeFood(int days)
{
	if (foodStorage == 0)
	{ foodDays -= days; }
	else if (foodStorage > 0 && foodStorage >= days)
	{ foodStorage -= days;  }
	else if (foodStorage > 0 && foodStorage < days)
	{
	int temp = 0;
	temp = days - foodStorage;
	foodStorage = 0;
	foodDays -= temp;
	}
}




//Adds to water storage
public void addWaterStorage(int days)
{
 
	waterStorage += days;	
}

//Adds to food storage
public void addFoodStorage(int days)
{
foodStorage += days;	
}

//Resets storage to 0
public void resetStorage()
{
waterStorage = 0;
foodStorage = 0;
}
//Infection
public void infection()
{
infected = true;
}

} //end HealthClass