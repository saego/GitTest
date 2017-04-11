import java.io.File;
import java.util.Scanner;

/**
 Created by Saego on 11.04.2017.
 */
public class Searcher {
    private String directory;
    private String extension;
    FileProp fileProp = new FileProp(directory, extension);
    private File searchDirectory;

    public boolean isExist(String directory){
        return (searchDirectory = new File(directory)).exists() && searchDirectory.isDirectory();
    }



    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input directory");
        String directory = scanner.nextLine();
        System.out.println("Input extension");
        String extensoin = scanner.nextLine();
        Searcher searcher = new Searcher();
    }
}
