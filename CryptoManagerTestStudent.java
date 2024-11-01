package application;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * This class represent test cases for each public method of 
 * the CryptoManager class
 * 
 * @author Kidus Yohanness
 * @version 10/31/2024
 */
public class CryptoManagerTestStudent {
    
    @Test
    // Test to check if a string is within the valid bounds
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO"));
    }

    @Test
    // Test Caesar encryption with a key of 3
    public void testEncryptCaesar() {
        String encrypted = CryptoManager.caesarEncryption("HELLO", 3);
        assertEquals("KHOOR", encrypted); // Expected result is "KHOOR"
    }

    @Test
    // Test Caesar decryption with a key of 3
    public void testDecryptCaesar() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3)); // Expect original string "HELLO"
    }

    @Test
    // Test Bellaso encryption using the key "BYE"
    public void testEncryptBellaso() {
        assertEquals("J^QN(", CryptoManager.bellasoEncryption("HELLO", "BYE")); // Expected result is "J^QN("
    }
    
    @Test
    // Test Bellaso decryption using the key "BYE"
    public void testDecryptBellaso() {
        assertEquals("HELLO", CryptoManager.bellasoDecryption("J^QN(", "BYE")); // Expect original string "HELLO"
    }
}