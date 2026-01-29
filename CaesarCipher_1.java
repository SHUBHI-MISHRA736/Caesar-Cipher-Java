import java.util.Scanner;

public class CaesarCipher_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the message to be encrypted
        System.out.println("Step 1: Enter the message to be encrypted:");
        String originalMessage = scanner.nextLine();

        // Step 2: Input the shift value from the user
        System.out.println("Step 2: Enter the shift value (an integer):");
        int shift = scanner.nextInt();

        // Encrypt the message using Caesar cipher with the user-provided shift value
        String encryptedMessage = encryptMessage(originalMessage, shift);
        System.out.println("Step 3: Encrypted message using Caesar cipher: " + encryptedMessage);

        // Decrypt the encrypted message using the same shift value
        String decryptedMessage = decryptMessage(encryptedMessage, shift);
        System.out.println("Step 4: Decrypted message from encrypted message: " + decryptedMessage);

        scanner.close();
    }

    // Encrypt the message using Caesar cipher with a specified shift value
    public static String encryptMessage(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                // Shift alphabetic characters by the specified number of positions for encryption
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char encryptedChar = (char) (((ch - base + shift) % 26) + base);
                encryptedMessage.append(encryptedChar);
            } else {
                // Preserve non-alphabetic characters
                encryptedMessage.append(ch);
            }
        }

        return encryptedMessage.toString();
    }

    // Decrypt the message (reverse Caesar cipher with a specified shift value)
    public static String decryptMessage(String encryptedMessage, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);
            if (Character.isLetter(ch)) {
                // Shift alphabetic characters back by the specified number of positions for decryption
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char decryptedChar = (char) (((ch - base - shift + 26) % 26) + base);
                decryptedMessage.append(decryptedChar);
            } else {
                // Preserve non-alphabetic characters
                decryptedMessage.append(ch);
            }
        }

        return decryptedMessage.toString();
    }
}
