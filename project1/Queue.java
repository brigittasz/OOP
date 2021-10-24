import java.io.File;

public class Queue{
  Node head, tail;
  int length;
public Queue(){
  head = tail = null;
  length = 0;
}

public void enqueue(Tweet s) {
  Node node = new Node(s, null);
  length++;
  if(this.empty()){
    head = tail = node;
    return;
  }
  tail.next = node;
  tail = node;
}
/**
 * removes and returns string from the front of the queue
 */
public Tweet dequeue() {
  
  if(this.empty()){
    return null;
  }
  Node node = head;
  head = head.next;
  if(head == null){
    tail = null;
  }
  length--;
  return node.data;
}

public boolean empty() {
    return head == null;
}

public int length(){
  return length;
}

private class Node {
  public Tweet data;
  public Node next;
  public Node(Tweet d, Node n) {
    data = d;
    next = n;
  }

  public Tweet getTweet(){
    return data;
  }
}

public void printAll(){
  Node node = head;
  while(node!=null){
    System.out.println(node.data.toString());
    node = node.next;
  }
}

public Queue filterForKeyword(String keyword){
  Queue filteredQueue = new Queue();
  Node node = head;

  while(node!=null){
    Tweet tweet = node.data;
    if(tweet.containsKeyword(keyword)){
      filteredQueue.enqueue(tweet);
    }
    node = node.next;
  }

  return filteredQueue;
}
public Queue filterForNotKeyword(String keyword){
  Queue filteredQueue = new Queue();
  Node node = head;

  while(node!=null){
    Tweet tweet = node.data;
    if(!tweet.containsKeyword(keyword)){
      filteredQueue.enqueue(tweet);
    }
    node = node.next;
  }

  return filteredQueue;
}

public Queue filterForDate(String date){
  Queue filteredQueue = new Queue();
  Node node = head;
  String[] dates = date.split("-");
  while(node!=null){
    Tweet tweet = node.data;
    if(tweet.dateIs(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]))){
      filteredQueue.enqueue(tweet);
    }
    node = node.next;
  }

  return filteredQueue;
}

public static void main(String[] args){
  Queue queue = new Queue();
  System.out.println(queue.empty());
  Tweet t1 = new Tweet("new text1", "newsuer", "16-08-2013");
  Tweet t2 = new Tweet("new text2", "newsuer", "21-10-2012");
  System.out.println(queue.empty());
  Queue filteredQueue = new Queue();
  queue.enqueue(t1);
  queue.enqueue(t2);
  System.out.println(filteredQueue.length);
  queue.printAll();

  filteredQueue = queue.filterForKeyword("text");
  filteredQueue.printAll();
}
}