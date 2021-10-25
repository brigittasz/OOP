public class Rotor{
    private String rotor;

    public Rotor(String rotorText, char top){
        rotor = rotorText;
        while(this.peek()!=top){
            this.rotate();
        }
    }
    //rotates rotor one click clockwise
    public void rotate(){
        this.rotor = this.rotor.substring(this.rotor.length()-1, this.rotor.length()) + this.rotor.substring(0, this.rotor.length()-1);
    }

    public char peek(){
        return rotor.charAt(0);
    }
    public String toString(){
        return rotor;
    }
    public int getIndexOf(String character){
        return rotor.indexOf(character);
    }
    public String getCharacterAt(int index){
        return String.valueOf(rotor.charAt(index));
    }
    public static void main(String[] args){
        Rotor rotor = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", 'U');
        System.out.println(rotor.toString());
        System.out.println(rotor.getIndexOf("H"));
        System.out.println(rotor.getCharacterAt(5));

        
    }
}