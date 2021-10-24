import java.util.*;

public class Tweet{
    private String text;
    private String username;
    private int day, month, year;

    public Tweet(String newtext, String newuser, String newdate) {
        text = newtext;
        username = newuser;
        String[] reg = newdate.split("-");
        year = Integer.parseInt(reg[0]);
        month = Integer.parseInt(reg[1]);
        day = Integer.parseInt(reg[2]);
    }
    public String toString(){
        return text + "\t[" + username + "]\t" + month + "/" + day + "/" + year;
    }
    public boolean containsKeyword(String keyword){
        String tempText = text.toLowerCase();
        String tempKeyword = keyword.toLowerCase();
        return tempText.contains(tempKeyword);
    }
    public boolean dateIs(int year, int month, int day){
        return this.year == year && this.month == month && this.day == day;
    }
    

    public static void main(String[] args){
        Tweet tweet = new Tweet("omg i can't believe you said that!!! #whoknows", "stargazerz", "2013-03-20");
        System.out.println(tweet.toString());
        System.out.println(tweet.containsKeyword("believe"));
        System.out.println(tweet.containsKeyword("bell"));


    }
}

