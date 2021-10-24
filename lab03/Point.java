import java.io.*;
import java.util.*;

public class Point{
    private double x, y;
    //constructor that initializes the points x & y
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    //the method that reads an x and a y value from 
    //the scanner and returns the associated point
    public static Point read(Scanner sc){
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point(x, y);
    }
    //the method that returns a String consisting of the 
    //x-coordinate, a space, and a y-coordinate
    public String toString(){
        return x + " " + y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String comm = sc.next();
        System.out.println("My command is: "+comm);
        //test reader and constructor
        Point newP = Point.read(sc);
        //test toString
        System.out.println("My x and y is: "+newP.toString());



    }
}