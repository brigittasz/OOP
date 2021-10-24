import java.util.Scanner;
import java.io.*;
import java.lang.Iterable;

public class Search{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String path = args[0];
        Queue tweets = readfile(path);
        Queue queue = tweets;
        System.out.print("Queue size: "+ queue.length + "\n? ");
        String command = null;
        while(sc.hasNext()){
            command = sc.nextLine();
            if(command.equals("!dump")){
                queue.printAll();
            } else if (command.equals("!quit")){
                System.out.println("Goodbye!");
                break;
            
            } else if (command.equals("reset")) {
                queue = tweets;
                System.out.println("Queue size: "+ queue.length);
            }else if (command.charAt(0)=='-'){
                command = command.substring(1);
                queue = queue.filterForNotKeyword(command);
                System.out.println("Queue size: "+ queue.length);
            
            } else if(command.charAt(0)=='+'){
                command = command.substring(1);
                queue = queue.filterForDate(command);
                System.out.println("Queue size: "+ queue.length);
            } else {
                queue = queue.filterForKeyword(command);
                System.out.println("Queue size: "+ queue.length);
            }
            System.out.print("? ");
        }
    }
    public static Queue readfile(String path){
        Queue tweets = new Queue();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(path));
          } catch(IOException e) {
            e.printStackTrace(); System.exit(1);
          }

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split("\t");
            Tweet tweet = new Tweet(temp[0], temp[1], temp[2]);
            tweets.enqueue(tweet);
        }        
        return tweets;
    }
}
