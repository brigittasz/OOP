import java.util.Random;

public class RedDot extends MovingDot{
    private int pastRow, pastCol;
    // a constructor that takes row and column position as integers
    public RedDot(int r, int c){
        super(r, c);
        pastCol = c;
        pastRow = r;
    }
    public void step(){
        this.setFace();
        super.step();
    }
    public void setFace(){
        Random rand = new Random();
        int back = super.getBack();
        int newFace;
        do{
            newFace = rand.nextInt(4);
        }while(newFace == back);
        super.setFace(newFace);
    }
    public String toString(){
        return super.toString()+ " r";
    }
}