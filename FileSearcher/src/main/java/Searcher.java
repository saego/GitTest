import java.io.File;
import java.util.Scanner;

/**
 Created by Saego on 11.04.2017.
 */
public class Searcher {
    private String searchDirectory;
    private String extension;

    private Searcher(String searchDirectory, String extension) {
        this.searchDirectory = searchDirectory;
        this.extension = extension;
    }


    private boolean isExist(){
        File sDirectory;
        return (sDirectory = new File(this.searchDirectory)).exists() && sDirectory.isDirectory();
    }

    private void fileWalker(File file){
        //File file = new File(this.searchDirectory);
        File []folders = file.listFiles();
        assert folders != null;
        for (File folder:
             folders) {
            if (folder.isDirectory()){
                fileWalker(folder);
            }
            else {
                System.out.printf("File: [%s]", folder.getAbsolutePath());
            }
        }
    }

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input directory");
        String directory = scanner.nextLine();
        System.out.println("Input extension");
        String extension = scanner.nextLine();
        Searcher searcher = new Searcher(directory, extension);
        if (searcher.isExist()){
            searcher.fileWalker(new File(directory));
        }
        else {
            System.out.println("Directory wasn't found");
        }
    }
}
