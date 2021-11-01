import java.util.*;
public class Lab7{
    public static void main (String[] args){
        if(args.length != 2){
            System.out.println("usage: java Lab7 <infilename> <numDays>");
            System.exit(0);
        }
        //initialize date
        MyDate date = MyDate.makeDate(2017,1,1);
        int numDaysToSimulate = Integer.valueOf(args[1]);
        
        //make list of events
        ArrayList <Event> E = new ArrayList<Event>();
        E.add(new Event("2", "days", "1/7/2017", "Ta"));
        E.add(new Event("1", "days", "1/6/2017", "Dum"));
        
        // print events on dates
        for( int i=0; i < numDaysToSimulate; i++ ) {
            ArrayList<String> occurringEvents = new ArrayList<String>();
            // ask each event whether they have something going on "today"
            for(Event event: E){
                // if any do, add them to the list
                if(event.checkDate(date)){
                    occurringEvents.add(event.getDescription());
                    event.setNextDate();
                }
            }
            //format and print events on this day
            if(occurringEvents.size()!=0){
                System.out.print(date.toString() + ": ");
                System.out.println(String.join(", ", occurringEvents));
            }
            // increment "today"
            date.incDay(1);
        }
    }
}