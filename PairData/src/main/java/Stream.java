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
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String val = br.readLine();
                System.out.println(val);
             //   String []res = val.split(" ");
            //for (String r:
            //     res) {
                 if (Integer.valueOf(val) % 2 == 0){
                   isDivByTwo = true;
            }
                    System.out.println(isDivByTwo);
                //}
            return isDivByTwo;
        }
}
