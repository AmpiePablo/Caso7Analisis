package logica;
import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * laita
 * @author Pablo Ampie
 * 29dh120_dk1_3
 */
public class AES {
   // private ArrayList<Integer> numeros;
    private static ArrayList<String> abecedario;
    private static SecretKeySpec secretKey;
    private static ArrayList<Letra> total;
    //private ArrayList<ArrayList<Letra>> subConjuntosTotales;
    private static ArrayList<Numero> numeros ;
    
    
    
/*Description:
Dado el siguiente código para definir una llave de AES
configurado com
o AES/ECB/PKCS5Padding,
private static SecretKeySpec secretKey;
*/
public static void setKey(String myKey) throws UnsupportedEncodingException  {
  MessageDigest sha = null;
  try {
      byte[] key = myKey.getBytes("UTF-8");
    sha = MessageDigest.getInstance("SHA-1");
    key = sha.digest(key);
    key = Arrays.copyOf(key, 16);
    secretKey = new SecretKeySpec(key, "AES");
  }
  catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
  }
  catch (UnsupportedEncodingException e) {
    e.printStackTrace();
  }

}
  public static String decrypt(String strToDecrypt, String secret)  {
    try {
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
    catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }
  
  public static String encrypt(String strToEncrypt, String secret)  {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
  
  
  public static void main(String args[]){
      String textoEncriptada="xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
      tomaLetrasNumeros();
      /*String decryptedString = AES.decrypt(textoEncriptada, "29dh120_dk1_3") ;
      if(decryptedString==null){
          System.out.println("laita");
      }
      System.out.println(decryptedString); 
       */
  }

  public static void tomaLetrasNumeros(){
      String abecedario[]={"a","b","c","d","e","f","g","h","i","j","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
      total=new ArrayList<Letra>();
      for(int i=0;i<abecedario.length;i++){
          Letra nueva=new Letra(abecedario[i]);
          total.add(nueva);
      }
      int actual[]={0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      numeros=new ArrayList<Numero>();
      for(int j=0;j<actual.length;j++){
          
      }
  }
  
  
  
  
}