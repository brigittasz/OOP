public class Event{
  private int recurrence;
  private MyDate currentDate;
  private String description;
  private String type;

  public Event(String recurrence, String type, String currentDate, String description){
    this.recurrence = Integer.valueOf(recurrence);
    this.type = type;
    String[] dates = currentDate.split("/");
    this.currentDate = MyDate.makeDate(Integer.valueOf(dates[2]),Integer.valueOf(dates[0]),Integer.valueOf(dates[1]));
    this.description = description;

  }

  public MyDate getDate(){
    return currentDate;
  }

  public void setNextDate(){
    if(type.equals("months")){
        currentDate.incMonth(recurrence);
    } else {
        currentDate.incDay(recurrence);
    }
  }

  public String toString(){
    return recurrence + " " + type + " " + currentDate + " " + description;
  }

  public String getDescription(){
    return description;
  }

  public boolean checkDate(MyDate date){
    return date.getYear() == currentDate.getYear() && date.getMonth() == currentDate.getMonth() && date.getDay() == currentDate.getDay();
  }

  public static void main(String[] args){
    Event event = new Event("2", "days", "1/7/2017", "Ta");
    System.out.println(event.toString());
    event.setNextDate();
    System.out.println(event.toString());
    Event event2 = new Event("1", "days", "8/12/2017", "Dum");
    System.out.println(event2.toString());

    MyDate date = MyDate.makeDate(2017, 1, 9);
    if(event.checkDate(date)){
        System.out.println("event "+event.getDescription()+" is happening today " + event.getDate());
    }
  }

}
