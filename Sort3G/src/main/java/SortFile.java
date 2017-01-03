import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public interface SortFile {
    public void sort(File source, File destination) throws IOException;
}
