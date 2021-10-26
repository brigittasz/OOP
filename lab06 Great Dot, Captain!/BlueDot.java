import java.util.Random;

public class BlueDot extends MovingDot{
    private int pastRow, pastCol;
    private int counter;
    // a constructor that takes row and column position as integers
    public BlueDot(int r, int c){
        super(r, c);
        pastCol = c;
        pastRow = r;
        counter = 0;
    }
    public void step(){
        counter++;
        if(counter%10==0){
            this.setFace();
        }
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
        return super.toString()+ " b";
    }
}