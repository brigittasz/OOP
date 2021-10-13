import java.io.*;
import java.util.*;
public class WordRead{
  public static String[] get(String fname){
    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(fname));
    } catch(IOException e) {
      e.printStackTrace(); System.exit(1);
    }
    StringNode N = null;
    while(sc.hasNext()){
      N = ListStuff.addToFront(sc.next(), N);
    }

    String[] A = ListStuff.listToArray(N);
    String[] B = new String[A.length];
    for ( int i = 0; i<A.length; i++){
      B[A.length-i-1] = A[i];
    }
    return B;
  }
  public static void main(String[] args){
    String[] A = get("nouns.txt");
    for (String str: A){
      System.out.println(str);
    }
  }
}
