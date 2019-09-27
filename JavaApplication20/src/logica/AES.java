package logica;
import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * laita
 * @author Pablo Ampie
 */
public class AES {
    private ArrayList<Integer> numeros;
    private ArrayList<String> abecedario;
    private static SecretKeySpec secretKey;
    private ArrayList<Letra> subConjunto;
    private ArrayList<ArrayList<Letra>> subConjuntosTotales;
    

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
}