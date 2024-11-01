package application;
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
	    // Loop through each character in the string
		for (int i = 0; i < plainText.length(); i++) {
	        // Get the current character
	        char testCharacter = plainText.charAt(i);
	        // Check if the character is out of the specified range
	        if (testCharacter < LOWER_RANGE || testCharacter > UPPER_RANGE) {
	            return false; // Return false if out of bounds
	        }
	    }
	    return true; // Return true if all characters are in bounds
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
	    // Check if the string is within bounds
		if (CryptoManager.isStringInBounds(plainText) == false) {
			return "The selected string is not in bounds, Try again.";
		}
	    // Initialize an empty string
		String encryptedString = "";
	    // Loop through each character in the plainText
		for (int i = 0; i < plainText.length(); i++) {
			// Get the current character to encrypt
			char charToEncrypt = plainText.charAt(i);
			// Shift the character by the key value
			charToEncrypt += key;
			// Adjust if it exceeds the upper range
			while (charToEncrypt > UPPER_RANGE) {
				charToEncrypt -= RANGE;
			}
			// Adjust if it goes below the lower range
			while (charToEncrypt < LOWER_RANGE) {
				charToEncrypt += RANGE;
			}
			// Append the encrypted character to the new string
			encryptedString += charToEncrypt;
		}
	    // Return the final encrypted string
		return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		// Check if the string is within bounds
			if (CryptoManager.isStringInBounds(plainText) == false) {
				return "The selected string is not in bounds, Try again.";
			}
		// Initialize an empty string
	    String encryptedText = ""; 
	    // Loop through each character in the plainText
	    for (int i = 0; i < plainText.length(); i++) {
	        // Get the current character to encrypt
	        char currentChar = plainText.charAt(i); 
	        // Calculate the encrypted character value using the Bellaso string
	        int encryptedCharValue = (int) currentChar + (int) bellasoStr.charAt(i % bellasoStr.length()); 

	        // Adjust if it exceeds the upper range
	        while (encryptedCharValue > UPPER_RANGE) {
	            encryptedCharValue -= RANGE; 
	        }

	        // Append the encrypted character to the new string
	        encryptedText += (char) encryptedCharValue; 
	    }

	    // Return the final encrypted string
	    return encryptedText; 
	}

	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
	    // Check if the encrypted string is within the allowed bounds
	    if (CryptoManager.isStringInBounds(encryptedText) == false) {
	        return "The selected string is not in bounds, Try again.";
	    }
	    // Initialize an empty string for the decrypted result
	    String decryptedString = "";
	    
	    // Loop through each character in the encryptedText
	    for (int i = 0; i < encryptedText.length(); i++) {
	        // Get the character to decrypt
	        char charToDecrypt = encryptedText.charAt(i);
	        // Subtract the key to decrypt the character
	        charToDecrypt -= key;
	        // Adjust if it exceeds the upper range
	        while (charToDecrypt > UPPER_RANGE) {
	            charToDecrypt -= RANGE;
	        }
	        // Append the decrypted character to the result string
	        decryptedString += charToDecrypt;
	    }
	    
	    // Return the final decrypted string
	    return decryptedString;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	    // Check if the string is within bounds
	    if (CryptoManager.isStringInBounds(encryptedText) == false) {
	        return "The selected string is not in bounds, Try again.";
	    }
	    
	    // Initialize an empty string for the decrypted result
	    String decryptedText = ""; 
	    
	    // Loop through each character in the encryptedText
	    for (int i = 0; i < encryptedText.length(); i++) {
	        // Get the encrypted character
	        char encryptedChar = encryptedText.charAt(i);
	        
	        // Decrypt the character using the Bellaso string
	        int decryptedChar = (int) encryptedChar - (int) bellasoStr.charAt(i % bellasoStr.length());
	        
	        // Adjust if it falls below the lower range
	        while (decryptedChar < LOWER_RANGE) {
	            decryptedChar += RANGE; 
	        }

	        // Append the decrypted character to the result string
	        decryptedText += (char) decryptedChar;
	    }

	    // Return the final decrypted string
	    return decryptedText;
	}
}
