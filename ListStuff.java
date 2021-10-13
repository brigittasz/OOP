public class ListStuff{
  // addToFront(s,Nold) returns a StringNode reference representing the list obtained by adding s to the front of list Nold
  public static StringNode addToFront(String s, StringNode Nold) {
  // you will fill this in
      StringNode temp = new StringNode();
      temp.data = s;
      temp.next = Nold;
      return temp;
  }

  // listToArray(N) returns a reference to an array containing the same strings as in the list N (in order)
  public static String[] listToArray(StringNode N) {
  // you will fill this in
    int counter = 0;
    StringNode iterator = N;
    while (iterator != null){
      iterator = iterator.next;
      counter++;
    }
    //count items in list
    System.out.println("Counted " + counter);

    //fill array list
    String[] arr = new String[counter];
    int i = 0;
    iterator = N;
    while ( iterator != null){
      arr[i] = iterator.data;
      System.out.println(arr[i]);
      iterator = iterator.next;
      i++;
    }
    return arr;

  }
  public static void main(String[] args){
    StringNode N = null;      // at this point N *is* an empty list
    N = addToFront("rat",N);  // at this point N *is* the list ("rat")
    N = addToFront("dog",N);  // at this point N *is* the list ("dog","rat")
    N = addToFront("pig",N);  // at this point N *is* the list ("pig","dog","rat")
    String[] A = listToArray(N);
    for(int i = 0; i < A.length; i++) {
      System.out.println(A[i]);
    }
  }
}
