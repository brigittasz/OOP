import java.util.*;

public class Event{
    private int recurrence;
    private MyDate currentDate;
    private double probability;
    private String description;
    private String type;
    private Random rand;
  
    //constructs event
    public Event(String recurrence, String type, String currentDate, String probability, String description, Random rand){
      this.recurrence = Integer.valueOf(recurrence);
      this.type = type;
      String[] dates = currentDate.split("/");
      this.currentDate = MyDate.makeDate(Integer.valueOf(dates[2]),Integer.valueOf(dates[0]),Integer.valueOf(dates[1]));
      this.description = description;
      this.probability = Double.valueOf(probability);
      this.rand = rand;
    }

    //returns MyDate for current date 
    public MyDate getDate(){
      return currentDate;
    }
          
    //Sets next day of event occurrence
    public void setNextDate(){
      if(type.equals("months")){
          currentDate.incMonth(recurrence);
      } else {
          currentDate.incDay(recurrence);
      }
    }
  
    //Returns string in the format Recurrence + Type + CurrentDate + Description
    public String toString(){
      return recurrence + " " + type + " " + currentDate + " " + probability + " " + description;
    }
  
    //Returns string for Description
    public String getDescription(){
      return description;
    }
  
    //returns whether event occurs on given date given probability
    public boolean occursOn(MyDate date){
      if(this.rand.nextDouble() < probability)
        return date.getYear() == currentDate.getYear() && date.getMonth() == currentDate.getMonth() && date.getDay() == currentDate.getDay();
      else
        return false;
    }
  
    public static void main(String[] args){
      
    }
  
  }