public class Caesar implements Encryptor {
  private int shift;
  public String getAlgName() { return "caesar"; }
  public void   init(char[] key) { 
    int temp = 18;
    //set shift value
    for(int i = 0; i<key.length; i++){
      if((int)key[i]<42 || (int)key[i]>122){
        System.out.println("error "+ key[i] +" not allowed in key");
        System.exit(0);
      }
      temp = temp + (int)key[i] - 42;
    }
    shift = 42 + temp%81;
  }
  public String encrypt(String plain) { 
    char[] plainText = plain.toCharArray();

    //encrypt each character
    int constantK = shift -42;
    for(int i = 0; i<plainText.length; i++){
      if((int)plainText[i]<42 || (int)plainText[i]>122){
        System.out.println("error "+ plainText[i] +" not allowed in plaintext");
        System.exit(0);
      }
      int p = (int)plainText[i] - 42;
      int c = (p + constantK) %81;
      int cipherChar = 42 + c;
      plainText[i] = (char) cipherChar;
    }

    //create new String
    String cipherText = new String(plainText);

    //return String
    return cipherText; 
  }
  public String decrypt(String cipher){ 
    char[] cipherText = cipher.toCharArray();
    //decrypt each character
    int constantK = shift - 42;
    for(int i = 0; i<cipherText.length; i++){
      if((int)cipherText[i]<42 || (int)cipherText[i]>122){
        System.out.println("error "+ cipherText[i] +" not allowed in ciphertext");
        System.exit(0);
      }
      int c = (int)cipherText[i] -42;
      int p = (c + (81 - constantK))%81;
      cipherText[i] = (char) (42 + p);
    }
    //create new String
    String plainText = new String(cipherText);
    //return char array to String
    return plainText; 
  }
  public static void main(String[] args){
  }
}