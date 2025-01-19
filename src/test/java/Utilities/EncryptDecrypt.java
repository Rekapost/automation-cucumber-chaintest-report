package Utilities;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt{
    private static final String SECRET_KEY = "MySecretKey12345"; // 16 characters for AES-128

   
    // Encrypt a plain text using AES
    public static String encrypt(String strToEncrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");  
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt an encrypted text using AES
    public static String decrypt(String strToDecrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");  
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(strToDecrypt);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Generate a SecretKey for AES encryption
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // AES supports 128, 192, and 256-bit key sizes
        return keyGenerator.generateKey();
    }
/* 
    // Encrypt the text
    String encryptedPwd = encrypt("3admin3");
    System.out.println("Encrypted Text: " + encryptedPwd);

    // Decrypt the text
    String decryptedText = decrypt(encryptedText, secretKey);
    System.out.println("Decrypted Text: " + decryptedText);

    Original Text: Hello, AES Encryption!
    Encrypted Text: e1lUw83+K2+ndQURtGFlEw==
    Decrypted Text: Hello, AES Encryption!

    String key = "1234567890123456"; // 16 characters for a 128-bit key
    SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
*/ 
}