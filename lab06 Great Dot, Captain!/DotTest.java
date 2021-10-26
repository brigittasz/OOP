/**
A Class to test Dots for functionality.
*/
public class DotTest{
/**
A main to test Dot class functionality.  To display the Dots, send the output
of this program into Plotter.jar using the following: <br>
java Dot | java -cp Plotter.jar Plotter
@param args not used
*/
  public static void main(String[] args){
    BlueDot blue    = new BlueDot( 0,  0);
    Dot pink    = new Dot( 0, 99);
    RedDot red     = new RedDot(99, 99);
    Dot green   = new Dot(99,  0);
    Dot magenta = new Dot(49, 49);
    int count = 0;
    while(true){
      System.out.println(blue.toString());
      System.out.println(pink    + " p");
      System.out.println(red.toString());
      System.out.println(green   + " g");
      System.out.println(magenta + " m");
      System.out.println("done");
        
      blue.step();
      red.step();
      if (count < 20){
        magenta.incRow();
        magenta.incCol();
      }
      else if (count < 40){
        magenta.incRow();
        magenta.decCol();
      }
      else if (count < 60){
        magenta.decRow();
        magenta.decCol();
      }
      else if (count < 80){
        magenta.decRow();
        magenta.incCol();
      }
      count++;
      count = count % 80;
    }
  }
}