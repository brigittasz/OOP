import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Box {
    private double minX, minY, maxX, maxY;
    // constructor for Box that consists of a single point
    public Box(Point p) {
      minX = p.getX();
      maxX = p.getX();
      minY = p.getY();
      maxY = p.getY();
    }

    // constructor for the Box containing two initial points
    public Box(Point a, Point b) {
        if(a.getX()<b.getX()){
            minX = a.getX();
            maxX = b.getX();
        } else {
            minX = b.getX();
            maxX = a.getX();
        }
        if(a.getY()<b.getY()){
            minY = a.getY();
            maxY = b.getY();
        } else {
            minY = b.getY();
            maxY = a.getY();
        }
    }

    // growBy(p) expands the bounding box (if needed) to include point p
    public void growBy(Point p) {
        if(p.getX()< minX){
            minX = p.getX();
        } 
        if(p.getX() > maxX){
            maxX = p.getX();
        }
        if(p.getY()< minY){
            minY = p.getY();
        }
        if(p.getY()> maxY){
            maxY = p.getY();
        }
    }

    // given point p in the bounding box, returns associated point in the
    // unit square (see notes); returns null if p is not inside the bounding box.
    public Point mapIntoUnitSquare(Point p) {
        double mapX, mapY;

        if(p.getX() < minX){
            return null;
        }
        if(p.getX() > maxX){
            return null;
        }
        if(p.getY() < minY){
            return null;
        }
        if(p.getY() > maxY){
            return null;
        }

        mapX = (double)Math.abs(p.getX() - minX)/Math.abs(maxX - minX);
        mapY = (double)Math.abs(p.getY() - minY)/Math.abs(maxY - minY);
        Point newPoint = new Point(mapX, mapY);
        return newPoint;
    }

    // returns string representation like: 2.0 < x < 9.0, 3.0 < y < 7.0
    public String toString() {
        return minX + " < x < " + maxX + ", " + minY + " < y < " + maxY;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String comm = sc.next();
        System.out.println("My command is: "+comm);
        //test reader and constructor
        Point newP = Point.read(sc);
        //test Box(Point p)
        Box newB = new Box(newP);
        System.out.println(newB);        

        comm = sc.next();
        System.out.println("My command is: "+comm);
        Point newP2 = Point.read(sc);
        Box newTwoPointsB = new Box(newP, newP2);
        System.out.println("Printing two point Box: " + newTwoPointsB.toString());

        //map 0 0, print error
        comm = sc.next();
        System.out.println("My command is: "+comm);
        Point newP3 = newTwoPointsB.mapIntoUnitSquare(Point.read(sc));
        if(newP3 == null){
            System.out.println("error");
        } else {
            System.out.println(newP3);
        }
    }
}
