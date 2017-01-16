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
        String originWord, word;
            boolean palindrom = true;
        originWord = br.readLine();
        br.close();
        word = originWord.toLowerCase();
        char []letters = word.toCharArray();
        if (letters.length != 5){
            throw new Not5LettersException("Please enter word which consists of 5 letters!");
        }
        else {
            for (int i = 0; i != (letters.length/2 + 1); i++){
                if (letters[i]  != (letters[letters.length - 1 - i])){
                    palindrom = false;
                    break;
                }
            }
            if (palindrom){
                System.out.println(originWord + "  -  Is palindrom");
            }
            else {
                System.out.println(originWord + "  -  Isn't palindrom");
            }
        }
    return palindrom;
    }
}
