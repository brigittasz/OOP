import java.util.*;

public class EndingEvent extends Event{
    private int occurrences;
    public EndingEvent(String recurrence, String type, String occurrences, String currentDate, String probability, String description, Random rand){
        super(recurrence, type, currentDate, probability, description, rand);
        this.occurrences = Integer.valueOf(occurrences);
    }
    //sets next date of event occurrence then decrements occurrences
    public void setNextDate(){
        if(occurrences > 0){
            super.setNextDate();
            occurrences--;
        }
    }
    //prints ending event string
    public String toString(){
        return super.toString() + " Occurrences: " + occurrences;
    }

    public MyDate getCurrentDate(){
        return super.getDate();
    }

    public static void main(String[] args){
        EndingEvent event = new EndingEvent("14", "days", "2", "1/6/2017", "1", "paycheck", new Random() );
        System.out.println(event.toString());
        event.setNextDate();
        System.out.println(event.toString());
        event.setNextDate();
        System.out.println(event.toString());
        event.setNextDate();
        System.out.println(event.toString());
        event.setNextDate();
        System.out.println(event.toString());


    }
}