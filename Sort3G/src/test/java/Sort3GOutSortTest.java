import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 Created by ${Ruslan} on 11.01.17.
 */
public class Sort3GOutSortTest {
        private Sort3GOutSort outSort = new Sort3GOutSort();
        private File source = new File("test.txt");
        private File destination = new File("testRes.txt");
        private File test = new File("test1.txt");
    @org.junit.Test
    public void sort() throws Exception {
        outSort.sort(source, destination);
        BufferedReader br1 = new BufferedReader(new FileReader(destination));
        BufferedReader br2 = new BufferedReader(new FileReader(test));
        String read, line = "null", testLine = "null";
        while ((read = br1.readLine()) != null){
            line = line.concat(read);
        }
        br1.close();
        while ((read =br2.readLine()) != null){
            testLine = testLine.concat(read);
        }
        br2.close();
        assertThat(line, is(testLine));
    }

}