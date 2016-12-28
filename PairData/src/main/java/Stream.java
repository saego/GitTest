import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 Created by ${Ruslan} on 26.12.16.
 */
class Stream {
        boolean isNumber(InputStream in) throws IOException{
            boolean isDivByTwo = false;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String val = br.readLine();
                System.out.println(val);
                if (Integer.valueOf(val) % 2 == 0) {
                    isDivByTwo = true;
                }
                System.out.println(isDivByTwo);
            }
            catch (NumberFormatException io){
                System.out.println("Not correct format of number");
            }
                return isDivByTwo;
        }
}
