import java.io.IOException;

/**
 Created by ${Ruslan} on 13.01.17.
 */
public class StartPalindrom {
    public static void main(String []args) throws IOException {
        PalindromCheck check = new PalindromCheck();
        System.out.println("Input word");
        try {
        check.isPalindrom(System.in);
        }
        catch (Not5LettersException ex){
            System.out.println("Error: " + ex);
        }
    }
}
