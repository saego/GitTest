import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 Created by ${Ruslan} on 26.12.16.
 */
public class Stream {
        public boolean isNumber(InputStream in) throws IOException{
            boolean isDivByTwo = false;
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String val = br.readLine();
                System.out.println(val);
                if (Integer.valueOf(val) % 2 == 0){
                    isDivByTwo = true;
                }
            return isDivByTwo;
        }
}
