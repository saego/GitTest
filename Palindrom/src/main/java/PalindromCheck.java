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
        String word1;
            boolean palindrom = true;
        word1 = br.readLine();
        br.close();
        String word = word1.toLowerCase();
        char []letters = new char[word.length()];
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(input))){
            br1.read(letters, 0, letters.length);
        }
        catch (IOException ex){
        //    System.out.println("123" + ex.getMessage());
        }
        //String []letters = word.split("");
        for (char let:
             letters) {
            System.out.println(let);
        }
        if (word.length() != 5){
            throw new Not5LettersException("Please enter word which consists of 5 letters!");
        }
        else {
            for (int i = 0; i != (letters.length/2 + 1); i++){
                if (letters[i] != (letters[letters.length - 1 - i])){
                    palindrom = false;
                    break;
                }
            }
            if (palindrom){
                System.out.println(word1 + "  -  Is palindrom");
            }
            else {
                System.out.println(word1 + "  -  Isn't palindrom");
            }
        }
    return palindrom;
    }
}
