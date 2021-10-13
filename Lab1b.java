import java.util.*;
public class Lab1b{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = in.nextLine();
    System.out.print("Please input an integer: ");
    int n = in.nextInt();
    System.out.print("Please input a second integer: ");
    int k = in.nextInt();
    System.out.println("The two ints were " + n + " and " + k);

    int numerator = n;
    for(int i = 1; i < k; i++){
      numerator = numerator * ( n - i );
    }
    System.out.println("numerator = " + numerator);

    int denominator = k;
    while( k > 1 ){
      denominator = denominator * ( k - 1 );
      k--;
    }
    System.out.println("denominator = " + denominator);

    denominator = numerator / denominator;
    System.out.println("odds = 1 in " + denominator + " = " + (double)1/denominator);
    System.out.println("Goodbye " + name + ".");
  }
}
