import java.io.*;
import java.util.*;

public class Lab03{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String comm = null;
        Box box = null;
        do{
            comm = sc.next();
            if(comm.equals("add")){
                if(box == null){
                    box = new Box(Point.read(sc));
                } else {
                    box.growBy(Point.read(sc));
                }
            } else if(comm.equals("box")){
                System.out.println(box.toString());
            } else if(comm.equals("map")){
                Point p = box.mapIntoUnitSquare(Point.read(sc));
                if(p == null){
                    System.out.println("error");
                } else {
                    System.out.println(p.toString());
                }
            }else if (!comm.equals("done")){
                System.out.println("Error! Unknown command "+ comm +"!");
            }
        }while(!comm.equals("done"));
    
    }
}