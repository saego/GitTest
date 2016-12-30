import java.io.*;

/**
 Created by ${Ruslan} on 28.12.16.
 */
class Abuse {
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        OutputStreamWriter ow = new OutputStreamWriter(out);
        String line = br.readLine();
        String []words = line.split(" ");
        for (String word:
             words) {
        boolean n = false;
            for (String ab:
                 abuse) {
                if (word.equals(ab)){
                    n = true;
                    break;
                }
            }
                if(!n) {
                    ow.write(word);
                    ow.write(" ");
                }
        }
        br.close();
        ow.close();
    }
}

