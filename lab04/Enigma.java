public class Enigma{
    private static String[] rotors = 
    {
    "#GNUAHOVBIPWCJQXDKRYELSZFMT",
    "#EJOTYCHMRWAFKPUZDINSXBGLQV",
    "#BDFHJLNPRTVXZACEGIKMOQSUWY",
    "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
    "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };
    private Rotor inner, middle, outer;
    private int innerCounter, middleCounter, outerCounter;

    public Enigma(int innerIndex, int middleIndex, int outerIndex, String top){
        inner = new Rotor(rotors[innerIndex-1], top.charAt(0));
        middle = new Rotor(rotors[middleIndex-1], top.charAt(1));
        outer = new Rotor(rotors[outerIndex-1], top.charAt(2));
        innerCounter = 0;
        middleCounter = 0;
        outerCounter = 0;
    }
    public String toString(){
        System.out.println(inner.toString());
        System.out.println(middle.toString());
        System.out.println(outer.toString());
        return null;
    }
    public String encrypt(String message){
        StringBuilder stringBuilder = new StringBuilder(message.length());
        int index;
        String encrypted;
        for(int i = 0; i<message.length(); i++){
            index = inner.getIndexOf(String.valueOf(message.charAt(i)));
            encrypted = outer.getCharacterAt(index);
            index = middle.getIndexOf(encrypted);
            encrypted = outer.getCharacterAt(index);
            stringBuilder.append(encrypted);
            inner.rotate();
            innerCounter++;
            if(innerCounter%27 == 0){
                middle.rotate();
                middleCounter++;
                if(middleCounter%27 == 0){
                    outer.rotate();
                    outerCounter++;
                    if(outerCounter%27 == 0){
                        innerCounter = 0;
                        middleCounter = 0;
                        outerCounter = 0;
                    }
                }
            }          
        }
        return stringBuilder.toString();
    }
    public String decrypt(String message){
        StringBuilder stringBuilder = new StringBuilder(message.length());
        int index;
        String encrypted;
        for(int i = 0; i<message.length(); i++){
            index = outer.getIndexOf(String.valueOf(message.charAt(i)));
            encrypted = middle.getCharacterAt(index);
            index = outer.getIndexOf(encrypted);
            encrypted = inner.getCharacterAt(index);
            stringBuilder.append(encrypted);
            inner.rotate();
            innerCounter++;
            if(innerCounter%27 == 0){
                middle.rotate();
                middleCounter++;
                if(middleCounter%27 == 0){
                    outer.rotate();
                    outerCounter++;
                    if(outerCounter%27 == 0){
                        innerCounter = 0;
                        middleCounter = 0;
                        outerCounter = 0;
                    }
                }
            }          
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        Enigma enigma = new Enigma(5, 2, 4, "EST");
        System.out.println(enigma.decrypt("CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ"));
    }
}
