import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 Created by ${Ruslan} on 13.01.17.
 */
class PalindromCheck {
    boolean isPalindrom(InputStream input) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String word;
            boolean palindrom = true;
        word = br.readLine();
        br.close();
        word = word.toLowerCase();
        String []letters = word.split("");
        if (letters.length != 5){
            throw new Not5LettersException("Please enter word which consists of 5 letters!");
        }
        else {
            for (int i = 0; i != (letters.length/2 + 1); i++){
                if (!letters[i].equals(letters[letters.length - 1 - i])){
                    palindrom = false;
                    break;
                }
            }
            if (palindrom){
                System.out.println(word + "  -  Is palindrom");
            }
            else {
                System.out.println(word + "  -  Isn't palindrom");
            }
        }
    return palindrom;
    }
}
