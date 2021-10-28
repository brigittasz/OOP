public class Vigenere implements Encryptor {
    private char[] key;
    public String getAlgName() { return "vigenere"; }
    public void   init(char[] key) {
      for(char ch : key){
        if((int) ch<42 || (int) ch>123){
          System.out.println("error "+ ch +" not allowed in key");
          System.exit(0);
        }
      }
      this.key = key;
    }
    public String encrypt(String plain) { 
      char[] plainText = plain.toCharArray();
      int n = key.length;
      //encrypt each character
      for(int i = 0; i<plainText.length; i++){
        if((int)plainText[i]<42 || (int)plainText[i]>122){
          System.out.println("error "+ plainText[i] +" not allowed in plaintext");
          System.exit(0);
        }
        if((int)key[i%n]<42 || (int)key[i%n]>122){
          System.out.println("error "+ key[i%n] +" not allowed in key");
          System.exit(0);
        }
        int constantK = key[i%n] -42;
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
      int n = key.length;

      //decrypt each character
      for(int i = 0; i<cipherText.length; i++){
        if((int)cipherText[i]<42 || (int)cipherText[i]>122){
          System.out.println("error "+ cipherText[i] +" not allowed in ciphertext");
          System.exit(0);
        }
        int constantK = key[i%n] -42;
        int c = (int)cipherText[i] -42;
        int p = (c + (81 - constantK))%81;
        cipherText[i] = (char) (42 + p);
      }
      //create new String
      String plainText = new String(cipherText);
      //return char array to String
      return plainText; 
    }
  }