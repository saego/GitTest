import java.io.*;

/**
 Created by ${Ruslan} on 28.12.16.
 */
public class Abuse {
    public void dropAbuses(InputStream in, OutputStream out, String []abuse) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        OutputStreamWriter ow = new OutputStreamWriter(out);
        String line = br.readLine();
        String []words = line.split(" ");
        for (String word:
             words) {
            if (!word.equals(abuse[0])){
                ow.write(word);
            }
        }
    }
}

