import java.util.Random;
public class MovingDot extends Dot{
    private int face;
    private int back;
    // a constructor that takes row and 
    //column position as integers
    public MovingDot(int r, int c){
        super(r, c);
        this.setFace();
    }

    // a step method that moves the Dot in the 
    //direction that it is facing
    public void step(){
        if(face == 0){
            super.incRow();
        } else if (face == 1){
            super.incCol();
        } else if (face == 2){
            super.decRow();
        } else if (face == 3){
            super.decCol();
        }
    }
    public int getFace(){
        return face;
    }
    public void setFace(){
        Random rand = new Random();
        face = rand.nextInt(4);
        this.setBack();
    }
    public void setFace(int num){
        face = num;
        this.setBack();
    }
    private void setBack(){
        if(face == 0)
            back = 2;
        if(face == 1)
            back = 3;
        if(face == 2)
            back = 0;
        if(face == 3)
            back = 1;
    }
    public int getBack(){
        return back;
    }
    public String toString(){
        return super.toString();
    }

    public static void main(String[] args){
        MovingDot movingDot = new MovingDot(50, 50);
        movingDot.step();
        movingDot.step();
        movingDot.step();
        movingDot.step();

    }
}
