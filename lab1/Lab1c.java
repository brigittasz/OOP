import java.util.*;
public class Lab1c{
  public static void main(String[] args){
    Random rand = new Random(System.currentTimeMillis());
    int k = rand.nextInt(11);
    System.out.println("Guess a number between 0 and 10: ");
    Scanner in = new Scanner(System.in);
    int guess = in.nextInt();

    int guesses = 0;
    while ( guess != k ){
      System.out.print( "Guess again: " );
      guess = in.nextInt();
      guesses++;
    }
    System.out.println("Right after " + guesses + " guesses!");
  }
}
