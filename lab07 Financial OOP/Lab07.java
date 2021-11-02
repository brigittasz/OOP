import java.io.*;
import java.util.*;

public class Lab07{
    public static void main(String[] args){
        //get 3 arguments
        if(args.length < 2){
            System.out.println("usage: java Lab7 <infilename> <numDays> <numLines>");
            System.exit(0);
        }
        // create a random object for use
        Random rand;
        if( args.length == 3 )
        rand = new Random(Long.parseLong(args[2]));
        else
        rand = new Random(System.currentTimeMillis());

        //initialize date
        MyDate date = MyDate.makeDate(2017,1,1);
        int numDaysToSimulate = Integer.valueOf(args[1]);
        
        //open file
        Scanner sc;
        //make list of events
        ArrayList <Event> E = new ArrayList<Event>();
        try{
            sc = new Scanner(new File(args[0]));
            while(sc.hasNext())
                E.add(readEvent(sc, rand));
            //System.out.println(event.toString()); 
            
            
            // print events on dates
            for( int i=0; i < numDaysToSimulate; i++ ) {
                ArrayList<String> occurringEvents = new ArrayList<String>();
                // ask each event whether they have something going on "today"
                for(Event event: E){
                    // if any do, add them to the list
                    if(event.occursOn(date)){
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
        } catch ( Throwable e){
            System.out.println(e.toString());
        }
    }

    //reads non-ending event
    public static Event readEvent(Scanner sc, Random rand){
        //read every from file
        String str     = sc.next();
        //read recurrence from file
        String recurrence = sc.next();
        //read type from file
        String type    = sc.next();
        //read next string from file
        str            = sc.next();
        //if string is for
        String occurrences = "0";
        if(str.equals("for")){
            //read occurrences
            occurrences = sc.next();
            str = sc.next();
        }
        //read currentDate
        String currentDate = sc.next();
        //read next string
        str            = sc.next();
        //if prob
        String prob = "1";
        if(str.equals("prob")){
            //read prob
            prob = sc.next();
            //read next string
            str = sc.next();
        }
        //read description
        String description = sc.nextLine();

        //construct new event
        Event event;
        if(occurrences.equals("0")){
            event = new Event(recurrence, type, currentDate, prob, description, rand);
        }
        else {
            event = new EndingEvent(recurrence, type, occurrences, currentDate, prob, description, rand);
        }
        return event;
    }

}