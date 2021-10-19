public class CryptoManager {
    private static final char LOWER_BOUND = ' ';
    private static final char UPPER_BOUND = '_';
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
 /**

 * @param plainText a string will be encrypted, if it is within the ASCII allowable bounds
 * @return true if all characters are within the allowable bounds, false if any character are outside
 */
   
 public static boolean stringInBounds (String plainText) {

    boolean boundary = true;
        for (int index = 0; index < plainText.length(); index++)
        {
            if (!(plainText.charAt(index) >= LOWER_BOUND && plainText.charAt(index) <= UPPER_BOUND))
                boundary = false;
        }
            return boundary;
 }
 /**
 * Encrypts a string according to the Caesar Cipher. The integer key specifies an offset
 
 * @param plainText an uppercase string will be encrypted.
 * @param key , this integer specifies the offset of each character
 * @return the encrypted string
 */
   
 public static String encryptCaesar(String plainText, int key)
 {

    String encryptedText = "";
    if (stringInBounds(plainText))
    {
        for (int index=0; index<plainText.length(); index++)
        {
            char thisChar = plainText.charAt(index);
            int encryptedCharint = ((int)thisChar+key);
                while (encryptedCharint > UPPER_BOUND)
                {
                    encryptedCharint -= RANGE;
                }
                    encryptedText += (char)encryptedCharint;
        }
    }
        return encryptedText;
 }
 /**
 * Encrypts a string according the Bellaso Cipher. Each character in plainText is offset
 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
 * to correspond to the length of plainText
 * @param plainText an uppercase string to be encrypted.
 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
 * @return the encrypted string
 */
   
 public static String encryptBellaso(String plainText, String bellasoStr)
 {
// throw new RuntimeException("method not implemented");
    String encryptedText = "";
    int bellasoStrLength = bellasoStr.length();
        for (int index = 0; index < plainText.length(); index++)
        {
            char thisChar = plainText.charAt(index);
            int encryptedCharint = ((int)thisChar+(int)bellasoStr.charAt(index%bellasoStrLength));
                while (encryptedCharint > (int)UPPER_BOUND)
                {
                encryptedCharint -= RANGE;
                }
            encryptedText += (char)encryptedCharint;
        }
        return encryptedText;
 }

 public static String decryptCaesar(String encryptedText, int key)
 {
;
    String decryptedText = "";
    for (int index =0; index < encryptedText.length(); index++)
    {
        char thisChar = encryptedText.charAt(index);
        int decryptedCharint = ((int)thisChar-key);
        while (decryptedCharint < LOWER_BOUND)
        {
            decryptedCharint += RANGE;
        }
        decryptedText += (char)decryptedCharint;
    }
    return decryptedText;
 }
 /** 
Decrypts a string with the Bellaso Cipher, the inverse of the encryptBellaso method.
@param encryptedText an uppercase string to be encrypted.
@param bellasoStr an uppercase string that specifies the offsets, character by character.
@return the decrypted string
 */
   
 public static String decryptBellaso(String encryptedText, String bellasoStr)
 {
 
    String decryptedText = "";
    int bellasoStrLength = bellasoStr.length();
        for (int index = 0; index < encryptedText.length(); index ++)
        {
            char thisChar = encryptedText.charAt(index);
            int decryptedCharint = ((int)thisChar-(int)bellasoStr.charAt(index%bellasoStrLength));
            while (decryptedCharint < (int)LOWER_BOUND)
            {
                decryptedCharint += RANGE;
            }
            decryptedText += (char)decryptedCharint;
        }
        return decryptedText;
    }
 }